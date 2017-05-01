package com.chentao.teachingapp.contracts;

import com.chentao.teachingapp.presenters.BasePresenter;
import com.chentao.teachingapp.ui.BaseView;

/**
 * Created by chentao on 17-4-20.
 */

public interface EditStdContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void insertStd(Long id , String name);

        void deleteStd(String name);

        void updateStd(String oldName , String newName);
    }
}
