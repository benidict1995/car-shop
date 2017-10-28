package com.example.benidict.car_shop.view.product;

import com.example.benidict.car_shop.di.scope.ActivityScope;
import com.example.benidict.car_shop.view.custom.module.LayoutModule;
import com.example.benidict.car_shop.view.custom.util.UtilsModule;

import dagger.Subcomponent;

/**
 * Created by benidict on 19/10/2017.
 */

@ActivityScope
@Subcomponent(modules = {ProductModule.class, UtilsModule.class, LayoutModule.class})
public interface ProductComponent {
    void inject(ProductActivity productActivity);
}
