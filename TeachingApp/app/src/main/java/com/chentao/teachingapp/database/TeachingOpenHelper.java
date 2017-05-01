package com.chentao.teachingapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.chentao.teachingapp.dao.gen.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Created by chentao on 17-4-20.
 */

public class TeachingOpenHelper extends DaoMaster.DevOpenHelper {

    public TeachingOpenHelper(Context context, String name) {
        super(context, name);
    }

    public TeachingOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
