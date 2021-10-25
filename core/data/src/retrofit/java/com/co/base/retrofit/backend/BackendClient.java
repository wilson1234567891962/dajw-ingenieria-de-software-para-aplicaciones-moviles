package com.co.base.retrofit.backend;

import com.co.data.BuildConfig;
import com.co.retrofit.data.remote.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kotlin.Function;
import kotlin.Unit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendClient {

    private static Retrofit retrofit = null;
    private static Api api;

    public static Retrofit  initClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if(retrofit == null ){
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public static String callApi(Function<Unit> function) {

        // api= initClient().create(Api.class);
        // api.getExampleTest();
        return "";
    }

    public static Api api(Class<Api> instance) {
        api = retrofit.create(instance);
       return api;
    }
}
