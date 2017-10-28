package com.example.benidict.car_shop.app;

import android.app.Application;

import com.example.benidict.car_shop.di.module.NetworkModule;

/**
 * Created by benidict on 27/10/2017.
 */

public class App extends Application{

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("http://www.mocky.io/v2/"))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

}
