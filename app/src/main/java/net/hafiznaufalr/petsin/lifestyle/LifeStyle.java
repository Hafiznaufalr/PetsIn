package net.hafiznaufalr.petsin.lifestyle;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import net.hafiznaufalr.petsin.R;
import net.hafiznaufalr.petsin.events.EventAdapter;
import net.hafiznaufalr.petsin.events.EventModel;
import net.hafiznaufalr.petsin.events.EventsDetail;

import java.util.ArrayList;

public class LifeStyle extends AppCompatActivity implements LsAdapter.IHotelAdapter {

    Button btn_navigasi;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String masjid_agung_demak = "-7.975203, 112.661867"; // koordinat


    public static final String HOTEL = "hotel";
    public static final int REQUEST_CODE_ADD = 88;
    public static final int REQUEST_CODE_EDIT = 99;

    int itemPos;

    ArrayList<LsModel> mList = new ArrayList<>();
    LsAdapter mAdapter;
    ArrayList<LsModel> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_style);

        // menyamakan variable pada layout activity_main.xml


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new LsAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {
            LsModel hotel = (LsModel) data.getSerializableExtra(HOTEL);
            mList.add(hotel);
            if (isFiltered) mListAll.add(hotel);
            doFilter(mQuery);


        } else if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK) {
            LsModel hotel = (LsModel) data.getSerializableExtra(HOTEL);
            mList.remove(itemPos);
            if (isFiltered) mListAll.remove(mListMapFilter.get(itemPos).intValue());
            mList.add(itemPos, hotel);
            if (isFiltered) mListAll.add(mListMapFilter.get(itemPos), hotel);
            mAdapter.notifyDataSetChanged();
        }


    }
    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.placess);
        String[] arDeskripsi = resources.getStringArray(R.array.place_descc);
        String[] arDetail = resources.getStringArray(R.array.place_detailss);
        String[] arLokasi = resources.getStringArray(R.array.place_locationss);

        TypedArray a = resources.obtainTypedArray(R.array.places_picturee);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);

            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new LsModel(arJudul[i], arDeskripsi[i], arDetail[i], arLokasi[i], arFoto[i]));

        }
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        mQuery = newText.toLowerCase();
                        doFilter(mQuery);
                        return true;
                    }
                });


        return true;
    }

    private void doFilter(String mQuery) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;

        }
        mList.clear();
        if (mQuery == null || mQuery.isEmpty()) {
            mList.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                LsModel hotel = mListAll.get(i);
                if (hotel.judul.toLowerCase().contains(mQuery) ||
                        hotel.deskripsi.toLowerCase().contains(mQuery) ||
                        hotel.lokasi.toLowerCase().contains(mQuery)) {
                    mList.add(hotel);
                    mListMapFilter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, LifeStyleDetail.class);
        intent.putExtra(HOTEL, mList.get(pos));
        startActivity(intent);

    }


    @Override
    public void doFav(int pos) {



    }

    @Override
    public void doShare(int pos) {

    }


}

