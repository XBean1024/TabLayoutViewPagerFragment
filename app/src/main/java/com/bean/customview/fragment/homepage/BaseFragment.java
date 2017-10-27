package com.bean.customview.fragment.homepage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    private View mRootView;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (Activity) context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.home_fragment_layout,null);
        }
        return mRootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mRootView == null) {
            throw new NullPointerException("mRootView is null!");
        }
        initView(mRootView);
        bindData();
    }

    /** fragment 的根视图，用于实例化里面的控件
     * @param rootView  根视图
     */
    protected abstract void initView(View rootView);

    /**
     * 绑定数据
     */
    protected abstract void bindData();

}
