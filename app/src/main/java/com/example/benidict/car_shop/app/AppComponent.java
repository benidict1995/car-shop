package com.example.benidict.car_shop.app;

import android.app.Application;
import android.content.Context;

import com.example.benidict.car_shop.di.module.NetworkModule;
import com.example.benidict.car_shop.view.bases.BaseComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by benidict on 27/10/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent extends BaseComponent{
    Application application();
    Context context();
}
