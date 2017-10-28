package com.example.benidict.car_shop.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by benidict on 27/10/2017.
 */

@SuppressWarnings("WeakerAccess")
public class Car implements Parcelable{
    private String vehicle_id;
    private String vehicle_name;
    private String vehicle_brand;
    private String vehicle_price;
    private String vehicle_image;

    public Car(String vehicle_id, String vehicle_name, String vehicle_brand,
               String vehicle_price, String vehicle_image){
        this.vehicle_id = vehicle_id;
        this.vehicle_name = vehicle_name;
        this.vehicle_brand = vehicle_brand;
        this.vehicle_price = vehicle_price;
        this.vehicle_image = vehicle_image;
    }

    public Car(Parcel in){
        vehicle_id = in.readString();
        vehicle_name = in.readString();
        vehicle_brand = in.readString();
        vehicle_price = in.readString();
        vehicle_image = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(vehicle_id);
        dest.writeString(vehicle_name);
        dest.writeString(vehicle_brand);
        dest.writeString(vehicle_price);
        dest.writeString(vehicle_image);
    }

    public String getVehicle_brand() {
        return vehicle_brand;
    }

    public String getVehicle_price() {
        return vehicle_price;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public String getVehicle_image() {
        return vehicle_image;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_price(String vehicle_price) {
        this.vehicle_price = vehicle_price;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public void setVehicle_image(String vehicle_image) {
        this.vehicle_image = vehicle_image;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public void setVehicle_brand(String vehicle_brand) {
        this.vehicle_brand = vehicle_brand;
    }
}
