package net.hafiznaufalr.petsin.store.store3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import net.hafiznaufalr.petsin.R;
import net.hafiznaufalr.petsin.store.store1.Detail1;

import java.util.ArrayList;
import java.util.HashMap;

public class Store3 extends AppCompatActivity {

    GridView grdProduct;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store3);

        grdProduct = findViewById(R.id.grdProduct);
        setProduct();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Aksesoris Hewan");


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void setProduct() {

        for (int i = 1; i <= 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("price",  "Rp " + String.valueOf(i) + "0.000");
            map.put("seller",  "Hafiz Petshop");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.adapter_store3,
                new String[] { "price", "seller" },
                new int[] { R.id.txtPrice, R.id.txtSeller });

        grdProduct.setAdapter(simpleAdapter);
        grdProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(net.hafiznaufalr.petsin.store.store3.Store3.this, Detail3.class));
            }
        });
    }

}

