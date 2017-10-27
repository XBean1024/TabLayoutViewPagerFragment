package com.bean.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bean.customview.fragment.homepage.BaseFragment;
import com.bean.customview.fragment.homepage.FindFragment;
import com.bean.customview.fragment.homepage.HomeFragment;
import com.bean.customview.fragment.homepage.InfoFragment;
import com.bean.customview.fragment.homepage.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.radio_group)
    RadioGroup mRadioGroup;
    private List<BaseFragment> mFragments;
    private int position;
    private  final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        ButterKnife.bind(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        ((RadioButton)(mRadioGroup.getChildAt(0))).setChecked(true);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new InfoFragment());
        mFragments.add(new MineFragment());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.home_page:
                position = 0;
                break;
            case R.id.find_page:
                position = 1;
                break;
            case R.id.info_page:
                position = 2;
                break;
            case R.id.mine_page:
                position = 3;
                break;
            default:
                position = 0;
                break;
        }
        switchFragment(position);
    }

    private void switchFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BaseFragment fragment = mFragments.get(position);
        if (!fragment.isAdded()) {
            transaction.add(R.id.container_fragment, fragment);
        }
        Log.i(TAG, "switchFragment: "+position+"=="+fragment.isVisible());
        if (fragment.isVisible()) {
            return;
        }

        for (int i = 0; i < mFragments.size(); i++) {
            if (i != position) {
                transaction.hide(mFragments.get(i));
            }else {
                transaction.show(fragment);
            }
        }
        transaction.commit();
    }
}
