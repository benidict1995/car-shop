package com.example.benidict.car_shop.view.custom.util;

import android.content.Context;


import com.example.benidict.car_shop.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by benidict on 24/10/2017.
 */

@Module
@SuppressWarnings("WeakerAccess")
public class UtilsModule {

    private UtilsContract.View mView;

    public UtilsModule(UtilsContract.View view){
        this.mView = view;
    }

    @Provides
    @ActivityScope
    UtilsPresenter provideUtilsPresenter(Context context){
        return new UtilsPresenter(mView, context);
    }

}
