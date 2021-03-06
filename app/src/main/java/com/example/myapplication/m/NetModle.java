package com.example.myapplication.m;


import androidx.lifecycle.Observer;

import com.example.myapplication.api.ApiService;
import com.example.myapplication.baseBean.Bean;
import com.example.myapplication.per.NetPresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetModle {
    public void getData(final NetPresenter netPresenter) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Bean> observable = apiService.initData();


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        netPresenter.Secoss(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        netPresenter.Faid(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
