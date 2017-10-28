package com.example.benidict.car_shop.view.bases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by benidict on 19/10/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayout());
        ButterKnife.bind(this);
        initDaggerComponent();
        initView();
    }

    protected abstract int getResLayout();
    public void initDaggerComponent(){}
    public void initView(){}


    public void showToastMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
