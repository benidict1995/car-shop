package com.example.benidict.car_shop.data;

/**
 * Created by benidict on 27/10/2017.
 */

public class WrapperResponse<T> {
    private boolean status;
    private String message;
    private String code;
    private T data;

    public WrapperResponse(String message, String code, T data, boolean status){
        this.message = message;
        this.code = code;
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "WrapperRersponse={" +
                "code= " + code +'\'' +
                "message= " + message + '\'' +
                "status= " + status + '\'' +
                "data= " + data + '\'' +
                " }";
    }
}
