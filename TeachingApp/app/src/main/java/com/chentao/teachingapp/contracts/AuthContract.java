package com.chentao.teachingapp.contracts;

import com.chentao.teachingapp.presenters.BasePresenter;
import com.chentao.teachingapp.ui.BaseView;

/**
 * Created by chentao on 17-4-21.
 */

public class AuthContract {
    interface IAuthView extends BaseView<IAuthPresenter> {
        void showTips(String tips);

        void setSubmitButtonEnabled(boolean enabled);

        void toMainActivity();

        void setSendMsgCountDown(Long seconds,boolean isFinish);

        void setLoginLayout();

        void setRegisterLayout();

        void setBindPhoneLayout();

        void setForgetPasswordLayout();

        void setChangePhoneLayout();

        void setDefaultAccount(String account);

        void setTitle(String title);

        void setLoadingStatus(boolean isLoading);

        void isToSyncViolationCars();
    }

    interface IAuthPresenter extends BasePresenter {
        void onAccountChange(String account);

        void onPasswordChange(String pwd);

        void onPasswordConfirmChange(String pwdChange);

        void onMsgCodeChange(String msg);

        void register();

        void unregister();

        void submit();

        void sendMsg();

        void syncViolationCars();
    }
}
