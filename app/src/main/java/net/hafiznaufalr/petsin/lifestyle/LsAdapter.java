package net.hafiznaufalr.petsin.lifestyle;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import net.hafiznaufalr.petsin.R;
import net.hafiznaufalr.petsin.events.EventModel;

import java.util.ArrayList;

public class LsAdapter extends RecyclerView.Adapter<net.hafiznaufalr.petsin.lifestyle.LsAdapter.ViewHolder> {

    ArrayList<LsModel> hotelList;
    net.hafiznaufalr.petsin.lifestyle.LsAdapter.IHotelAdapter mIHotelAdapter;



    public LsAdapter(Context context, ArrayList<LsModel> hotelList) {
        this.hotelList = hotelList;
        mIHotelAdapter = (net.hafiznaufalr.petsin.lifestyle.LsAdapter.IHotelAdapter) context;
    }

    @Override
    public net.hafiznaufalr.petsin.lifestyle.LsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        net.hafiznaufalr.petsin.lifestyle.LsAdapter.ViewHolder vh = new net.hafiznaufalr.petsin.lifestyle.LsAdapter.ViewHolder(V);
        return vh;


    }

    @Override
    public void onBindViewHolder(net.hafiznaufalr.petsin.lifestyle.LsAdapter.ViewHolder holder, int position) {
        LsModel hotel = hotelList.get(position);

        holder.tvDeskripsi.setText(hotel.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(hotel.foto));




    }

    @Override
    public int getItemCount() {
        if (hotelList != null)
            return hotelList.size();
        return 0;
    }

    public interface IHotelAdapter {
        void doClick(int pos);

        void doFav(int pos);

        void doShare(int pos);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;
        ImageButton ibFav;
        ImageButton ibShare;



        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doClick(getAdapterPosition());
                }
            });





        }
    }


}
