package com.example.benidict.car_shop.view.product;



import com.example.benidict.car_shop.api.CarShopApi;
import com.example.benidict.car_shop.data.WrapperResponse;
import com.example.benidict.car_shop.data.model.Car;

import java.util.List;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by benidict on 19/10/2017.
 */

@SuppressWarnings("WeakerAccess")
public class ProductPresenter implements ProductContract.Presenter{

    private ProductContract.View mView;
    private Retrofit retrofit;

    public ProductPresenter(ProductContract.View view, Retrofit retrofit){
        this.mView = view;
        this.retrofit = retrofit;
    }

    @Override
    public void getCar() {
            retrofit.create(CarShopApi.class).getCarList().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<WrapperResponse<List<Car>>>() {
                        @Override
                        public void onCompleted() {
                                mView.showComplete();
                        }

                        @Override
                        public void onError(Throwable e) {
                                mView.showError(e.getMessage(), e);
                        }

                        @Override
                        public void onNext(WrapperResponse<List<Car>> listWrapperResponse) {
                                mView.showCarList(listWrapperResponse.getData());
                        }
                    });
    }
}
