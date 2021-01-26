package com.example.dakka.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.dakka.API.APIReq;
import com.example.dakka.API.RetroServer;
import com.example.dakka.DetailWisata;
import com.example.dakka.ListWisata;
import com.example.dakka.MainActivity;
import com.example.dakka.Model.Wisata.Wisata;
import com.example.dakka.Model.Wisata.ResponseModel;
import com.example.dakka.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {
    private ArrayList<Wisata>wisata= new ArrayList<>();
    private Context context;
    public WisataAdapter(Context context){
        this.context = context;
    }
    public void setData(ArrayList<Wisata> Allbooks){
        wisata.clear();
        this.wisata = Allbooks;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wisata,parent,false);
        return new WisataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WisataViewHolder holder, int position) {
        holder.bind(wisata.get(position));
    }

    @Override
    public int getItemCount() {
        return wisata.size();
    }

    public class WisataViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto_wisata;
        private TextView nama_wisata;
        private TextView deskripsi;
        public WisataViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_wisata =itemView.findViewById(R.id.tv_nama_wisata);
            foto_wisata = itemView.findViewById(R.id.foto_wisata);
            deskripsi = itemView.findViewById(R.id.tv_deskripsi);
        }
        public void bind(Wisata wisata){
            String imageUrl = "http://192.168.42.57/dakka/images/"+wisata.getFoto_wisata();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailWisata.class);
                    context.startActivity(intent);
                }
            });

            nama_wisata.setText(wisata.getNama_wisata());
            deskripsi.setText(wisata.getDeskripsi_wisata());
            Glide.with(context)
                    .load(imageUrl)
                    .centerCrop()
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(foto_wisata);
        }
    }
}
