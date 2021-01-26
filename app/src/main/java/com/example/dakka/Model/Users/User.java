package com.example.dakka.Model.Users;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id_user")
    private String id;
    @SerializedName("nama_user")
    private String nama;
    @SerializedName("password")
    private String password;
    @SerializedName("foto_user")
    private String foto;


    public User(String id, String nama, String password, String foto) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public User() {
    }

}
