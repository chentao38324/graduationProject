package com.chentao.teachingapp.presenters;

import com.chentao.teachingapp.contracts.EditStdContract;
import com.chentao.teachingapp.dao.gen.StudentDao;
import com.chentao.teachingapp.database.DBManager;
import com.chentao.teachingapp.entities.Student;

/**
 * Created by chentao on 17-4-20.
 */

public class EditStdPresenter implements EditStdContract.Presenter {

    @Override
    public void start() {

    }

    @Override
    public void insertStd(Long id, String name) {
        StudentDao studentDao = DBManager.getDaoSession().getStudentDao();
        Student std = new Student(id,name);
        studentDao.insert(std);
    }

    @Override
    public void deleteStd(String name) {

    }

    @Override
    public void updateStd(String oldName, String newName) {

    }
}
