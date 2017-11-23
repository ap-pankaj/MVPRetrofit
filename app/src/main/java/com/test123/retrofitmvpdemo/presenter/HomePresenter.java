package com.test123.retrofitmvpdemo.presenter;

import android.util.Log;

import com.test123.retrofitmvpdemo.App;
import com.test123.retrofitmvpdemo.contract.HomeContract;
import com.test123.retrofitmvpdemo.pojo.SOAnswersResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by pankaj on 23/11/17.
 */

public class HomePresenter implements HomeContract.HomePresenter {
    HomeContract.HomeView mView;

    @Override
    public void attachView(HomeContract.HomeView view) {
        this.mView = view;
    }

    @Override
    public void detachView() {

    }

    //
    @Override
    public void requestAnswers() {
        App.getApiManager().getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, retrofit2.Response<SOAnswersResponse> response) {
                if (response.isSuccessful()) {
                    if (null != mView) {
                        mView.onAnswerDownloaded(response.body().getItems());
                    }
                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");

            }
        });
    }

    @Override
    public void cleanUp() {

    }
}
