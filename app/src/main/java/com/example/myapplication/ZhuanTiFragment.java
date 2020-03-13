package com.example.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ZhuanTiAdapter;
import com.example.myapplication.baseBean.Bean;
import com.example.myapplication.per.NetPresenter;
import com.example.myapplication.v.MyView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanTiFragment extends Fragment implements MyView {


    private RecyclerView mMyRec;

    private List<Bean.DataBeanX.DataBean> list;
    private ZhuanTiAdapter zhuanTiAdapter;
    private NetPresenter netPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_zhu, container, false);
        netPresenter = new NetPresenter(this);
        netPresenter.getData();
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mMyRec = (RecyclerView) itemView.findViewById(R.id.MyRec);
        mMyRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        zhuanTiAdapter = new ZhuanTiAdapter(list);
        mMyRec.setAdapter(zhuanTiAdapter);
    }

    @Override
    public void setData(Bean bean) {
        List<Bean.DataBeanX.DataBean> data = bean.getData().getData();
        zhuanTiAdapter.initData(data);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
