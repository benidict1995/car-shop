package com.example.benidict.car_shop.view.custom.module;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;


import com.example.benidict.car_shop.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by benidict on 25/10/2017.
 */

@Module
public class LayoutModule {

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(Context context){
        return new LinearLayoutManager(context);
    }


    @Provides
    @ActivityScope
    GridLayoutManager provideGridLayoutManager(Context context){
        return new GridLayoutManager(context, 2);
    }



}
