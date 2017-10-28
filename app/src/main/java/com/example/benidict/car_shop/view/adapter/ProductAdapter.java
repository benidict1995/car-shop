package com.example.benidict.car_shop.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.benidict.car_shop.R;
import com.example.benidict.car_shop.data.model.Car;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by benidict on 19/10/2017.
 */

@SuppressWarnings("WeakerAccess")
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> implements
    ProductAdapterHelper{

    private List<Car> carList, filterList;
    private Context context;
    private Car car;
    private int choose;
    private static final int LIST = 0;
    private static final int GRID = 1;

    public ProductAdapter(Context context){
        this.context = context;
        carList = new ArrayList<>();
        filterList = new ArrayList<>();
        filterList = carList;
    }

    @Override
    public void changeLayout(int choose) {
        this.choose = choose;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.car_img)
        ImageView car_image;
        @BindView(R.id.car_name)
        AppCompatTextView car_name;
        @BindView(R.id.car_brand)
        TextView car_brand;
        @BindView(R.id.car_price)
        TextView car_price;
        @BindView(R.id.btn_view)
        Button btn_view;
        @BindView(R.id.btn_buy)
        Button btn_buy;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            btn_buy.setOnClickListener(this);
            btn_view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            car = carList.get(pos);
            switch (v.getId()){
                case R.id.btn_buy:
                    showToastMessage("Product Name: " + car.getVehicle_name());
                    break;
                case R.id.btn_view:
                    showToastMessage("Product Price: " + car.getVehicle_price());
                    break;
            }
        }
    }

    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == GRID){
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_grid, parent, false));
        }else{
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_list, parent, false));
        }

    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    @Override
    public void onBindViewHolder(final ProductAdapter.ViewHolder holder, int position) {
        car = carList.get(position);

        holder.car_name.setText(car.getVehicle_name());
        holder.car_brand.setText(car.getVehicle_brand());
        holder.car_price.setText(car.getVehicle_price());
        loadCarImage(car.getVehicle_image())
                .into(holder.car_image);

    }

    @Override
    public int getItemViewType(int position) {
        if (choose == GRID){
            return GRID;
        }else{
            return LIST;
        }
    }

    /**
     * @param cars get list of car from the activity or view
    **/
    @Override
    public void addAllCars(List<Car> cars) {
        for (Car car: cars){
            addCar(car);
        }

    }

    @Override
    public void addCar(Car car) {
        carList.add(car);
        notifyItemChanged(carList.size());
    }

    @Override
    public void clearData() {
        int size = carList.size();
        carList.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public void getFilterCar(List<Car> cars) {
        this.carList = cars;
        notifyDataSetChanged();
    }

    @Override
    public void doFilterCar(String car) {
          List<Car> filterDataCar = new ArrayList<>();
          for (Car cars : filterList){
                if (cars.getVehicle_name().toLowerCase().contains(car.toLowerCase()) ||
                        cars.getVehicle_brand().toLowerCase().contains(car.toLowerCase())){
                    filterDataCar.add(cars);
                }
          }
          getFilterCar(filterDataCar);
    }


    private DrawableRequestBuilder<String> loadCarImage(@NonNull String url){
        return Glide
                .with(context)
                .load(url)
                .placeholder(R.drawable.ic_image_black_24dp)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .crossFade();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


}
