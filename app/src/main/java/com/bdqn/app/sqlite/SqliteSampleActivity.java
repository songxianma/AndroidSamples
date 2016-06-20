package com.bdqn.app.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bdqn.app.R;
import com.bdqn.app.sqlite.databases.DBHelper;
import com.bdqn.app.sqlite.entity.User;
import com.bdqn.app.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;



public class SqliteSampleActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_sample);
        createDB();
    }

    /**
     * 创建数据库
     */
    public void createDB(View view) {
        createDB();
    }

    /**
     * 创建数据库表
     */
    public void createDBTable(View view) {
        createTable(DBHelper.TABLE_NAME);
    }

    /**
     * 往数据库表插入数据
     *
     * @param view
     */
    public void insert(View view) {
        if (DBHelper.getHelper().isTableExist(DBHelper.TABLE_NAME)) {
            DBHelper.getHelper().insert();
//            DBHelper.getHelper().insertWithSQL();
        }
    }

    /**
     * 删除数据
     *
     * @param view
     */
    public void delete(View view) {
//        DBHelper.getHelper().deleteBySQL();
        DBHelper.getHelper().delete();
    }

    /**
     * 修改数据
     *
     * @param view
     */
    public void update(View view) {
//       DBHelper.getHelper().updateBySQL();
        DBHelper.getHelper().update();
    }


    private SQLiteDatabase getDb() {
        mDatabase = openOrCreateDatabase(DBHelper.DB_NAME, Context.MODE_PRIVATE, null);
        mDatabase.setVersion(DBHelper.DB_VERSION);
        return mDatabase;
    }

    private void createDB() {
        mDatabase = DBHelper.getHelper().getReadableDatabase();
    }

    /**
     * 创建数据库表
     *
     * @param tableName
     */
    private void createTable(String tableName) {
        if (DBHelper.getHelper().isTableExist(tableName)) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("create table ").append(tableName).append("(_id integer primary key autoincrement, name text, age integer,address text)");
        mDatabase.execSQL(builder.toString());
    }


    /**
     * 查询
     */
    public void query(View view) {
//        DBHelper.getHelper().queryDataBySql();
//        DBHelper.getHelper().queryDataBySql1();
//        DBHelper.getHelper().query();
        DBHelper.getHelper().queryAll();
    }


}
