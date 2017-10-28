package com.example.benidict.car_shop.view.custom.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.design.widget.AppBarLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by benidict on 24/10/2017.
 */

@SuppressWarnings("WeakerAccess")
public class UtilsPresenter implements UtilsContract.Presenter{

    private Context context;
    private UtilsContract.View mView;

    public UtilsPresenter(UtilsContract.View view, Context context){
        this.context = context;
        this.mView = view;
    }

    @Override
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void textWatcher(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mView.afterTextChanged(s);
            }
        });
    }

    @Override
    public void customCollapseListener(AppBarLayout appBarLayout) {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
                {
                    //  Collapsed
                    mView.isExpanded(false);
                }
                else
                {
                    //Expanded
                    mView.isExpanded(true);
                }
            }
        });
    }
}
