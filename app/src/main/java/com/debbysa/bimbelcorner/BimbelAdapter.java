package com.debbysa.bimbelcorner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BimbelAdapter extends RecyclerView.Adapter<BimbelAdapter.BimbelViewHolder> {

    private ArrayList<Bimbel> dataList;
    private Context context;

    public BimbelAdapter(ArrayList<Bimbel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    public BimbelAdapter(ArrayList<Bimbel> dataList) {
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public BimbelAdapter.BimbelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater
                .inflate(R.layout.item_bimbel, parent, false);
        return new BimbelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BimbelAdapter.BimbelViewHolder bimbelViewHolder, int i) {
        bimbelViewHolder.txtNama.setText(dataList.get(i).getNama());
        bimbelViewHolder.txtDeskripsi.setText(dataList.get(i).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class BimbelViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtDeskripsi;
        private ImageView image, imageFav;

        public BimbelViewHolder(@NonNull View itemView) {
            super ( itemView );
            txtNama = itemView.findViewById ( R.id.txt_nama );
            txtDeskripsi = itemView.findViewById ( R.id.txt_deskripsi );
            image = itemView.findViewById ( R.id.imageView );
        }
    }
}
