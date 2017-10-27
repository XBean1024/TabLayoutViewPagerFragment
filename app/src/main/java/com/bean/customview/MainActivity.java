package com.bean.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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
import com.bean.customview.fragment.homepage.MIneFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.container_fragment)
    FrameLayout mContainerFragment;
    @BindView(R.id.home_page)
    RadioButton mHomePage;
    @BindView(R.id.find_page)
    RadioButton mFindPage;
    @BindView(R.id.info_page)
    RadioButton mInfoPage;
    @BindView(R.id.mine_page)
    RadioButton mMinePage;
    @BindView(R.id.radio_group)
    RadioGroup mRadioGroup;
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;
    private List<BaseFragment> mFragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRadioGroup.check(R.id.home_page);
        mRadioGroup.setOnCheckedChangeListener(this);
        initFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container_fragment, new HomeFragment());
        transaction.commit();
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new InfoFragment());
        mFragments.add(new MIneFragment());
    }

    @OnClick({R.id.find_page, R.id.info_page, R.id.mine_page, R.id.radio_group})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.find_page:
                break;
            case R.id.info_page:
                break;
            case R.id.mine_page:
                break;
            case R.id.radio_group:
                break;
        }
    }

    /**
     * <p>Called when the checked radio button has changed. When the
     * selection is cleared, checkedId is -1.</p>
     *
     * @param group     the group in which the checked radio button has changed
     * @param checkedId the unique identifier of the newly checked radio button
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.home_page:
                Toast.makeText(this, "首页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.find_page:
                Toast.makeText(this, "发现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.info_page:
                Toast.makeText(this, "消息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_page:
                Toast.makeText(this, "我的", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
