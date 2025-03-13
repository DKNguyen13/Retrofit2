package vn.hcmute.retrofit2.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if(retrofit ==null){
            retrofit = new Retrofit.Builder()
                    //Duong dan API
                    .baseUrl("http://app.iotstar.vn:8081")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
