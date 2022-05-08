package com.example.lib.Repository;


import com.example.lib.Model.bill_model;
import com.example.lib.Model.googleAccount;
import com.example.lib.Model.jwt;
import com.example.lib.Model.loginRequest;
import com.example.lib.Model.product;
import com.example.lib.Model.userResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Methods {
    @GET("/home/getAll")
    Call<product[]> getProduct();

    @GET("/home/getImgByProduct")
    Call<String[]> getImgs(@Query("name")String name);

    @POST("home/getByCate")
    Call<product[]> getByCate(@Query("name") String name);

    @GET("home/find")
    Call<product[]> find(@Query("kw") String kw);

    @POST("home/getSameCate")
    Call<product[]> getSameCate(@Body product product);

    @GET("/account/save")
    Call<String> signup(
            @Query("username") String username,
            @Query("password") String password,
            @Query("fullName") String fullName,
            @Query("email") String email,
            @Query("address") String address,
            @Query("phone") String phone
    );
    @GET("/account/confirmSignUpToken")
    Call<String> confirmToken(
            @Query("username") String username,
            @Query("token") String token
    );

    @POST("/auth")
    Call<jwt> login(@Body loginRequest loginRequest);

    @GET("/account/getUser")
    Call<userResponse> getUser(
            @Query("jwt") String token
    );


    @POST("/bill/checkout")
    Call<String> checkout(
            @Body bill_model bill_model
    );

    @GET("/googleAccount/get")
    Call<googleAccount> googleGet(
            @Query("email") String email
    );

    @GET("/googleAccount/update")
    Call<String> googleUpdate(
            @Query("email") String email,
            @Query("phone") String phone,
            @Query("address") String address
    );
}
