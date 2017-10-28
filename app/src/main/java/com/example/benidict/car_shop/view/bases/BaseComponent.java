package com.example.benidict.car_shop.view.bases;


import com.example.benidict.car_shop.view.custom.module.LayoutModule;
import com.example.benidict.car_shop.view.custom.util.UtilsModule;
import com.example.benidict.car_shop.view.product.ProductComponent;
import com.example.benidict.car_shop.view.product.ProductModule;

/**
 * Created by benidict on 19/10/2017.
 */

public interface BaseComponent {
    ProductComponent plus(ProductModule productModule, UtilsModule utilsModule,
                          LayoutModule layoutModule);
}
