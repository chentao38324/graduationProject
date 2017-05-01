package com.chentao.teachingapp.database;

import android.database.sqlite.SQLiteDatabase;

import com.chentao.teachingapp.TeachingApp;
import com.chentao.teachingapp.dao.gen.DaoMaster;
import com.chentao.teachingapp.dao.gen.DaoSession;

/**
 * Created by chentao on 17-4-20.
 */

public class DBManager {

    private final static String DB_NAME = "TeachingDB";
    private volatile static DBManager mInstance;
    private TeachingApp mTeachingApp;
    private static DaoSession mDaoSession;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster master;

    private DBManager(TeachingApp app) {
        mTeachingApp = app;
        helper = new TeachingOpenHelper(app, DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        master = new DaoMaster(db);
        mDaoSession = master.newSession();
    }

    public static DBManager init(TeachingApp app) {
        if (null == mInstance) {
            synchronized (DBManager.class) {
                if (null == mInstance) {
                    mInstance = new DBManager(app);
                }
            }
        }
        return mInstance;
    }

    public static DaoSession getDaoSession() {
        return mDaoSession;
    }

    /**
     * 关闭数据连接
     */
    public void close() {
        if (helper != null) {
            helper.close();
        }
    }
}
