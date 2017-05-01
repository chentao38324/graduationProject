package com.chentao.teachingapp.ui.fragments.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chentao.teachingapp.ui.BaseActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chentao on 17-4-20.
 */

public abstract class BaseFragment extends Fragment {
    protected View rootView;
    private Unbinder mUnbinder;
    protected BaseActivity mActivity;


    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment);
        }
    }

    protected void replaceFragment(BaseFragment fragment){
        if (null != fragment){
            getHoldingActivity().replaceFragment(fragment);
        }
    }

    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart(getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
//        MobclickAgent.onPageEnd(getClass().getSimpleName());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutResource(), container, false);
            mUnbinder = ButterKnife.bind(this, rootView);
            onInitViews();
        }

        ViewGroup parentView = (ViewGroup) rootView.getParent();
        if (parentView != null)
            parentView.removeView(rootView);

        return rootView;
    }

    protected abstract int getLayoutResource();

    protected abstract void onInitViews();

    public String getName() {
        return BaseFragment.class.getName();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mUnbinder){
            mUnbinder.unbind();
        }
//        AutoApp.getAppContext().refWatcher.watch(this);
    }
}