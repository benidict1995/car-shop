package com.example.benidict.car_shop.view.product;

import android.content.Context;


import com.example.benidict.car_shop.di.scope.ActivityScope;
import com.example.benidict.car_shop.view.adapter.ProductAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by benidict on 19/10/2017.
 */

@Module
@SuppressWarnings("WeakerAccess")
public class ProductModule {

    private ProductContract.View mView;

    public ProductModule(ProductContract.View view){
        this.mView = view;
    }

    @Provides
    @ActivityScope
    ProductContract.View provideProductContractView(){
        return mView;
    }

    @Provides
    @ActivityScope
    ProductAdapter provideProductAdapter(Context context){
        return new ProductAdapter(context);
    }

    @Provides
    @ActivityScope
    ProductPresenter provideProductPresenter(Retrofit retrofit){
        return new ProductPresenter(mView, retrofit);
    }

}
