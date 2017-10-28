package com.example.benidict.car_shop.view.custom.util;


import android.support.design.widget.AppBarLayout;
import android.text.Editable;
import android.widget.EditText;

/**
 * Created by benidict on 24/10/2017.
 */

@SuppressWarnings("WeakerAccess")
public interface UtilsContract {

    interface View{
        void afterTextChanged(Editable editable);
        void isExpanded(boolean isExpand);
    }

    interface Presenter{
        boolean isNetworkConnected();
        void textWatcher(EditText editText);
        void customCollapseListener(AppBarLayout appBarLayout);
    }
}
