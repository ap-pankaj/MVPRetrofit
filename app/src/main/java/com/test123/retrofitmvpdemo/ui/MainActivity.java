package com.test123.retrofitmvpdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.test123.retrofitmvpdemo.adapter.AnswersAdapter;
import com.test123.retrofitmvpdemo.contract.HomeContract;
import com.test123.retrofitmvpdemo.pojo.Item;
import com.test123.retrofitmvpdemo.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import test.test123.com.mytestapp.R;

public class MainActivity extends AppCompatActivity implements HomeContract.HomeView {

    private AnswersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private HomeContract.HomePresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new HomePresenter();
        mPresenter.attachView(this);

        initView();
        mPresenter.requestAnswers();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_answers);
        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(0));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void onAnswerDownloaded(List<Item> items) {
        mAdapter.updateAnswers(items);
        Log.d("MainActivity", "posts loaded from API");
    }

    @Override
    public void showProgress() {
        // show progress if any
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
