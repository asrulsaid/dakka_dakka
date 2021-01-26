package com.example.dakka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dakka.API.APIReq;
import com.example.dakka.API.RetroServer;
import com.example.dakka.Adapter.WisataAdapter;
import com.example.dakka.Model.Wisata.ResponseModel;
import com.example.dakka.Model.Wisata.Wisata;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListWisata extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView rv_wisata;
    private WisataAdapter wisataAdapter;
    private MutableLiveData<ArrayList<Wisata>> wisataList = new MutableLiveData<ArrayList<com.example.dakka.Model.Wisata.Wisata>>();
    private APIReq apiReq = RetroServer.getClient().create(APIReq.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);

        String kategori_wisata = getIntent().getStringExtra("kategori");
        toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Wisata "+ kategori_wisata);

        rv_wisata = findViewById(R.id.rv_wisata);
        rv_wisata.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        wisataAdapter = new WisataAdapter(this);
        wisataAdapter.notifyDataSetChanged();
        rv_wisata.setAdapter(wisataAdapter);

        ambilData(kategori_wisata);
    }

    public void ambilData(String kategori){
        Call<ResponseModel> wisataArray = apiReq.selectAll(kategori);
        wisataArray.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Log.d("hello", "onResponse: "+response.body().getResults());
                ArrayList<com.example.dakka.Model.Wisata.Wisata> wisata = response.body().getResults();
                wisataList.postValue(wisata);
                wisataAdapter.setData(wisata);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(ListWisata.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}