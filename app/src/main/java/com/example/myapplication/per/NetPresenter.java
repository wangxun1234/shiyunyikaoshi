package com.example.myapplication.per;

import android.view.View;

import com.example.myapplication.MainActivity;
import com.example.myapplication.ZhuanTiFragment;
import com.example.myapplication.baseBean.Bean;
import com.example.myapplication.m.NetCallBack;
import com.example.myapplication.m.NetModle;
import com.example.myapplication.v.MyView;

public class NetPresenter implements NetCallBack {
    private NetModle netModle;
    private MyView view;

    public NetPresenter(ZhuanTiFragment view) {
        this.view = (MyView) view;
        netModle = new NetModle();
    }

    @Override
    public void Secoss(Bean bean) {
        view.setData(bean);
    }

    @Override
    public void Faid(String str) {
view.showToast(str);
    }
    public void getData() {
        netModle.getData(this);
    }
}
