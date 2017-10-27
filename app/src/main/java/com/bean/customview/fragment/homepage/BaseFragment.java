package com.bean.customview.fragment.homepage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bean.customview.R;

/**
 * auther   : bean
 * on       : 2017/10/26
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function : 首页fragment 的基础类
 */

public abstract class BaseFragment extends Fragment {
    protected Activity mMainActivity;
    protected View mRootView;
    private  final String TAG = getClass().getSimpleName();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (Activity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return   initView(inflater);
    }

    protected abstract View initView(LayoutInflater inflater);


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mRootView == null) {
            throw new NullPointerException("mRootView is null!");
        }

        bindData();
    }

    /**
     * 绑定数据
     */
    protected abstract void bindData();

}
