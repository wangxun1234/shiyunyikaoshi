package com.example.myapplication.api;


import com.example.myapplication.baseBean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiService {
    String BaseUrl="https://cdwan.cn/";

    @GET("api/topic/list")
    Observable<Bean> initData();
}
