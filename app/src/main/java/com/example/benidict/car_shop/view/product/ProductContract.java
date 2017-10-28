package com.example.benidict.car_shop.view.product;


import com.example.benidict.car_shop.data.model.Car;

import java.util.List;

/**
 * Created by benidict on 19/10/2017.
 */

@SuppressWarnings("WeakerAccess")
public interface ProductContract {

    interface View{
            void filterData();
            void showError(String message, Throwable e);
            void showComplete();
            void showCarList(List<Car> cars);
            void visibilityOnOff(int progressbar, int retrylayout, int recycler);
    }

    interface Presenter{
            void getCar();
    }

}
