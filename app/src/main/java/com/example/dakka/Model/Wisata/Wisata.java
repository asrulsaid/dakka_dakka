package com.example.dakka.Model.Wisata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Wisata implements Parcelable {
    @SerializedName("id_wisata")
    private int id_wisata;
    @SerializedName("nama_wisata")
    private String nama_wisata;
    @SerializedName("kategori_wisata")
    private String kategori_wisata;
    @SerializedName("deskripsi_wisata")
    private String deskripsi_wisata;
    @SerializedName("foto_wisata")
    private String foto_wisata;

    protected Wisata(Parcel in) {
        id_wisata = in.readInt();
        nama_wisata = in.readString();
        kategori_wisata = in.readString();
        deskripsi_wisata = in.readString();
        foto_wisata = in.readString();
    }
    public Wisata(){

    }

    public static final Creator<Wisata> CREATOR = new Creator<Wisata>() {
        @Override
        public Wisata createFromParcel(Parcel in) {
            return new Wisata(in);
        }

        @Override
        public Wisata[] newArray(int size) {
            return new Wisata[size];
        }
    };

    public int getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(int id_wisata) {
        this.id_wisata = id_wisata;
    }

    public String getNama_wisata() {
        return nama_wisata;
    }

    public void setNama_wisata(String nama_wisata) {
        this.nama_wisata = nama_wisata;
    }

    public String getKategori_wisata() {
        return kategori_wisata;
    }

    public void setKategori_wisata(String kategori_wisata) {
        this.kategori_wisata = kategori_wisata;
    }

    public String getDeskripsi_wisata() {
        return deskripsi_wisata;
    }

    public void setDeskripsi_wisata(String deskripsi_wisata) {
        this.deskripsi_wisata = deskripsi_wisata;
    }

    public String getFoto_wisata() {
        return foto_wisata;
    }

    public void setFoto_wisata(String foto_wisata) {
        this.foto_wisata = foto_wisata;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_wisata);
        parcel.writeString(nama_wisata);
        parcel.writeString(kategori_wisata);
        parcel.writeString(deskripsi_wisata);
        parcel.writeString(foto_wisata);
    }
}
