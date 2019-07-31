package com.example.tracks.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    public static  String BASE_URL= "https://jsonplaceholder.typicode.com/";
    private  static Retrofit sRetrofit= null;

    private static Retrofit getsRetrofit(){


        if(sRetrofit==null){
        sRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        }


        return sRetrofit;
    }
    public static Api getService(){

        return  getsRetrofit().create(Api.class);
    }
}