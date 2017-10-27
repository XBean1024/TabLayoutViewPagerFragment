package com.bean.customview.fragment.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bean.customview.R;

/**
 * auther   : bean
 * on       : 2017/10/26
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function :
 */

public class HomeFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.home_fragment_layout,null);
        }
        return mRootView;
    }
    /**
     * 绑定数据
     */
    @Override
    protected void bindData() {

    }
}
