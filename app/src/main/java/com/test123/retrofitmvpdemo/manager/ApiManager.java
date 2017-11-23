package com.test123.retrofitmvpdemo.manager;

import android.content.Context;


import com.test123.retrofitmvpdemo.api.PartnerService;
import com.test123.retrofitmvpdemo.pojo.SOAnswersResponse;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private PartnerService mPartnerService;
    private Retrofit mRetrofit;

    public void init(Context context) {
        initRetrofit();
        initServices();
    }

    private void initRetrofit() {
        final Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //Add any custom headers if required
                Request newRequest = chain.request().newBuilder()./*addHeader("User-Agent", getUserAgent()).*/build();
                return chain.proceed(newRequest);
            }
        };
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


    private void initServices() {
        mPartnerService = mRetrofit.create(PartnerService.class);
    }

    public void clear() {

    }

    public Call<SOAnswersResponse> getAnswers() {
        return mPartnerService.getAnswers();
    }

//    public Observable<PinCodeDTO> getPinCode(@NonNull String phone) {
//        return mPartnerService.getPinCode(phone);
//    }


}
