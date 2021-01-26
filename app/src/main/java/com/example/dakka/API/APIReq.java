package com.example.dakka.API;

import com.example.dakka.Model.Users.ResponModel;
import com.example.dakka.Model.Wisata.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIReq {
    @FormUrlEncoded
    @POST("selectall.php")
    Call<ResponseModel>selectAll(
            @Field("kategori")String kategori
    );
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponModel>login(
            @Field("username")String username,
            @Field("password")String password
    );

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseModel> insertData(
            @Field("judul_buku")String judul_buku,
            @Field("penulis")String penulis,
            @Field("penerbit")String penerbit,
            @Field("sinopsis") String sinopsis,
            @Field("fileUpload") String cover
    );
    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> hapusData(
            @Field("id") int id,
            @Field("cover") String cover
    );
    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> editData(
            @Field("id")int id,
            @Field("judul_buku")String judul_buku,
            @Field("penulis")String penulis,
            @Field("penerbit")String penerbit,
            @Field("sinopsis") String sinopsis,
            @Field("fileUpload") String cover,
            @Field("cover_lama") String coverLama
    );

}
