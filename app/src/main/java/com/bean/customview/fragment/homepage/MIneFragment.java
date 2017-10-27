package com.bean.customview.fragment.homepage;

import android.view.LayoutInflater;
import android.view.View;

import com.bean.customview.R;

/**
 * auther   : bean
 * on       : 2017/10/27
 * QQ       : 596928539
 * github   : https://github.com/Xbean1024
 * function :
 */

public class MineFragment extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.mine_fragment_layout,null);
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
