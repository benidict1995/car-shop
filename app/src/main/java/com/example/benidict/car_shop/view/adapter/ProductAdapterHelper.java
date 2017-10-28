package com.example.benidict.car_shop.view.adapter;


import com.example.benidict.car_shop.data.model.Car;

import java.util.List;

/**
 * Created by benidict on 19/10/2017.
 */

@SuppressWarnings("WeakerAccess")
public interface ProductAdapterHelper {
    void addAllCars(List<Car> cars);
    void addCar(Car car);
    void clearData();
    void getFilterCar(List<Car> cars);
    void doFilterCar(String car);
    void changeLayout(int choose);
    void showToastMessage(String message);
}
