package com.example.benidict.car_shop.api;

import com.example.benidict.car_shop.data.WrapperResponse;
import com.example.benidict.car_shop.data.model.Car;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by benidict on 27/10/2017.
 */

public interface CarShopApi {
    @GET("59ee3b1d3300000e00b5c8ad")
    Observable<WrapperResponse<List<Car>>> getCarList();
}
