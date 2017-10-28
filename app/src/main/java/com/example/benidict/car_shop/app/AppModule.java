package com.example.benidict.car_shop.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by benidict on 27/10/2017.
 */

@Module
@SuppressWarnings("WeakerAccess")
public class AppModule {

    private Application mApplication;

    public AppModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return mApplication;
    }
}
