package com.chentao.teachingapp.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;

import com.chentao.teachingapp.TeachingApp;
import com.chentao.teachingapp.ui.fragments.base.BaseFragment;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * Created by chentao on 17-4-20.
 */

public abstract class BaseActivity extends RxAppCompatActivity{

    private Unbinder mUnbinder;
    public TeachingApp teachingApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initConfigBeforeSetContentView();
        if (getLayoutResource() != 0)
            setContentView(getLayoutResource());
        initDataAfterSetContentView();
        initViewAfterSetContentView();
    }

    protected abstract int getLayoutResource();

    protected abstract int getFragmentContentId();

    protected abstract void initViewAfterSetContentView();

    /**
     * 该方法在初始化各个控件之前调用
     */
    protected void initDataAfterSetContentView() {
        mUnbinder = ButterKnife.bind(this);
        teachingApp = (TeachingApp) getApplicationContext();
    }

    /**
     * 设置布局之前调用该方法，如果具体Activity需要在setContentView之前配置，实现该方法
     */
    protected void initConfigBeforeSetContentView() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//        PushManager.getInstance(this).onAppStart();

//        StatusBarUtils.setStatusBarDark(this, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    public void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    public void replaceFragment(BaseFragment fragment) {
        if (null != fragment) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //add by lw 2016.09.23
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onResume(this);
    }
}
