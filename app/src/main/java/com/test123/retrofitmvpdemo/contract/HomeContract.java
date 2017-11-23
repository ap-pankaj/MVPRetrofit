package com.test123.retrofitmvpdemo.contract;


import com.test123.retrofitmvpdemo.pojo.Item;

import java.util.List;

/**
 * Created by pankaj on 23/11/17.
 */

public class HomeContract {

    public interface HomePresenter {

        void attachView(HomeView view);

        void detachView();

        void requestAnswers();

        void cleanUp();

        // methods for different tasks on presenter
    }

    public interface HomeView {

        void onAnswerDownloaded(List<Item> items);

        void showProgress();

    }
}
