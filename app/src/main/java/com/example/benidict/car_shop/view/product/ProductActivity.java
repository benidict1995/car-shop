package com.example.benidict.car_shop.view.product;

import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.benidict.car_shop.R;
import com.example.benidict.car_shop.app.App;
import com.example.benidict.car_shop.data.model.Car;
import com.example.benidict.car_shop.view.adapter.ProductAdapter;
import com.example.benidict.car_shop.view.bases.BaseActivity;
import com.example.benidict.car_shop.view.custom.module.LayoutModule;
import com.example.benidict.car_shop.view.custom.util.UtilsContract;
import com.example.benidict.car_shop.view.custom.util.UtilsModule;
import com.example.benidict.car_shop.view.custom.util.UtilsPresenter;

import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by benidict on 19/10/2017.
 */

public class ProductActivity extends BaseActivity
    implements ProductContract.View, UtilsContract.View{

    @BindView(R.id.recycler_view)
    RecyclerView product_recycler;

    @BindView(R.id.product_progressbar)
    ProgressBar product_progressbar;

    @BindView(R.id.retry_layout)
    LinearLayout retry_layout;

    @BindView(R.id.ll_background)
    LinearLayout ll_background;

    @BindView(R.id.err_title)
    TextView err_title;

    @BindView(R.id.btn_retry)
    ImageButton btn_retry;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.cardview_header)
    AppBarLayout cardview_header;

    @BindView(R.id.et_search)
    EditText et_filter;

    @Inject
    ProductAdapter productAdapter;

    @Inject
    LinearLayoutManager layoutManager;

    @Inject
    GridLayoutManager gridLayoutManager;

    @Inject
    ProductPresenter presenter;

    @Inject
    UtilsPresenter utilsPresenter;

    private boolean isGrid;


    @Override
    protected int getResLayout() {
        return R.layout.product_activity;
    }

    @Override
    public void initDaggerComponent() {
        ((App)getApplication()).getAppComponent().plus(new ProductModule(this),
                new UtilsModule(this), new LayoutModule())
        .inject(this);
    }

    @Override
    public void initView() {
        presenter.getCar();
        setSupportActionBar(toolbar);
        setToolbar();
        setUpAdapter();
        filterData();
    }


    private void setToolbar(){
        toolbar.setLogo(ContextCompat.getDrawable(this, R.mipmap.ic_launcher_round));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        utilsPresenter.customCollapseListener(cardview_header);
    }

    private void setUpAdapter(){
        if (isGrid){
            product_recycler.setLayoutManager(gridLayoutManager);

        }else{
            product_recycler.setLayoutManager(layoutManager);
        }
        product_recycler.setAdapter(productAdapter);
    }

     @OnClick(R.id.btn_retry)
     public void clickRetry(){
            visibilityOnOff(0,8,0);
            presenter.getCar();
     }



    @Override
    public void showError(String message, Throwable e) {
        showToastMessage(getString(R.string.download_data_failed));
        productAdapter.clearData();
        if (!utilsPresenter.isNetworkConnected()){
            visibilityOnOff(8,0,8);
            err_title.setText(getApplicationContext().getString(R.string.err_no_internet));
        }
        else if (e instanceof TimeoutException){
            visibilityOnOff(8,0,8);
            err_title.setText(getApplicationContext().getString(R.string.err_timeout));
        }else{
            visibilityOnOff(8,0,8);
            err_title.setText(getApplicationContext().getString(R.string.err_msg_unknown));
        }
    }

    /**
     * // 0 = visible , 4 = invisible, 8 = gone
     * @param progressbar it serve visibility value for progressbar
     * @param retrylayout it serve visibility value for layout
     * @param recycler it server visibility value for recycler view
    **/

    @Override
    public void visibilityOnOff(int progressbar, int retrylayout, int recycler) {
        product_progressbar.setVisibility(progressbar);
        retry_layout.setVisibility(retrylayout);
        product_recycler.setVisibility(recycler);
    }

    @Override
    public void showComplete() {
        visibilityOnOff(8,8,0);
        showToastMessage(getApplicationContext().getString(R.string.download_data));
    }

    @Override
    public void filterData() {
        utilsPresenter.textWatcher(et_filter);
    }

    @Override
    public void afterTextChanged(Editable editable) {
        productAdapter.doFilterCar(editable.toString());
    }

    @Override
    public void isExpanded(boolean isExpand) {
        if (isExpand){
            ll_background.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBackground));
        }else{
            ll_background.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryToolbar));
        }
    }

    @Override
    public void showCarList(List<Car> cars) {
        productAdapter.addAllCars(cars);
    }

    @Override
    public void showToastMessage(String message) {
        super.showToastMessage(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_adapter_view:

                 if (isGrid){
                     isGrid = false;
                     setUpAdapter();
                     productAdapter.changeLayout(0);
                     item.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_view_list_black_24dp));
                 }else{
                     isGrid = true;
                     setUpAdapter();
                     productAdapter.changeLayout(1);
                     item.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_grid_on_black_24dp));
                 }
                break;
            case R.id.action_refresh:
                presenter.getCar();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
