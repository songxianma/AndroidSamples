package com.bdqn.app.sqlite.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bdqn.app.App;
import com.bdqn.app.sqlite.entity.User;
import com.bdqn.app.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teng on 2016/5/16.
 */

public class DBHelper extends SQLiteOpenHelper {
    //数据库的版本号必须要大于1
    public final static int DB_VERSION = 1;
    //数据库的名称
    public final static String DB_NAME = "user.db";
    //数据库表名
    public final static String TABLE_NAME = "userInfo";

    public static DBHelper helper = null;
    public SQLiteDatabase mDatabase;

    public static DBHelper getHelper() {
        if (helper == null) {
            helper = new DBHelper(App.getContext());
        }
        return helper;
    }


    /**
     * 通过SQLiteOpenerHelper创建数据库表，
     * <p/>
     * getWritableDatabase 与 getReadableDatabase 的区别
     * <p/>
     * getWritableDatabase取得的实例不是仅仅具有写的功能，而是同时具有读和写的功能
     * 同样的，getReadableDatabase 取得的实例也是具对数据库进行读和写的功能
     * 两者的区别在于
     * getWritableDatabase取得的实例是以读写的方式打开数据库，如果打开的数据库磁盘满了，此时只能读不能写，此时调用了getWritableDatabase的实例，那么将会发生错误（异常）
     * getReadableDatabase取得的实例是先调用getWritableDatabase以读写的方式打开数据库，如果数据库的磁盘满了，此时返回打开失败，继而用getReadableDatabase的实例以只读的方式去打开数据库
     */
    private DBHelper(Context context) {
        //调用父类方法创建数据库,CusorFactory 一般为空，使用默认的
        //CursorFactory对象，用来构造查询完毕时返回的Cursor的子类对象，为null时使用默认的CursorFactory构造。
        super(context, DB_NAME, null, DB_VERSION);
        //获取数据库对象。
        mDatabase = getReadableDatabase();
//        mDatabase = getWritableDatabase();
    }


    /**
     * 数据库第一次创建时调用，我们在这里执行一些数据库表的创建，初始化等操作
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableUser(db);
    }

    /**
     * 当数据库更新时调用，我们可以在升级时执行数据库修改；比如修改表，删除表，添加表等。
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            dropTableUser(db);
            createTableUser(db);
        }
    }

    public void createTableUser(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(_id integer primary key autoincrement ,NAME TEXT,AGE INT,ADDRESS TEXT);";
        db.execSQL(sql);
    }

    public void dropTableUser(SQLiteDatabase db) {
        String sql = "drop table if exists " + TABLE_NAME;
        db.execSQL(sql);
    }


    /**
     * 查看是否存在某个数据库表
     * <p/>
     * sqlite_master: SQLite数据库都有一个叫 SQLITE_MASTER 的表， 它定义数据库的模式,这个表是只读的
     *
     * @param tableName
     * @return
     */
    public boolean isTableExist(String tableName) {
        String sql = "SELECT COUNT(*) AS c FROM sqlite_master WHERE type='table' AND name='" + tableName + "'";
        Cursor cursor = mDatabase.rawQuery(sql, null);
        if (cursor.moveToNext()) {
            int count = cursor.getInt(0);
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用SQL 实现插入
     */
    public void insertWithSQL() {
        mDatabase.beginTransaction(); // 开始事务
        try {
            for (int i = 0; i < 10; i++) {
                StringBuilder sql = new StringBuilder();
                sql.append("insert into " + DBHelper.TABLE_NAME + "(name,age,address) values(")
                        .append(" '张三'").append(",")
                        .append("20").append(",")
                        .append("'火星" + i + "号'")
                        .append(" );");
                mDatabase.execSQL(sql.toString());
            }
            mDatabase.setTransactionSuccessful();//数据库操作成功，如果不成功，则回滚到执行之初
        } finally {
            mDatabase.endTransaction();// 结束事务
        }
    }

    /**
     * 使用 ContentValues 实现插入数据
     */
    public void insert() {
        ContentValues values = new ContentValues();
        values.put("name", "张三");
        values.put("age", 20);
        values.put("address", "火星1号");
        mDatabase.insert(DBHelper.TABLE_NAME, null, values);
    }


    /**
     * 使用SQL 语句删除数据
     */
    public void deleteBySQL() {
        StringBuilder builder = new StringBuilder();
        builder.append(" delete from ").append(DBHelper.TABLE_NAME).append(" where _id = ?");
        String[] bindArgs = {"1"};
        mDatabase.execSQL(builder.toString(), bindArgs);

        LogUtils.e(builder.toString());
    }

    /**
     * 使用Android 提供的delete 方法
     *
     * @return
     */
    public int delete() {
        //where子句
        String whereClause = "_id = ?";
        //where字句里的里占位符的值
        String[] whereArgs = {"1"};
        int affectedRows = mDatabase.delete(DBHelper.TABLE_NAME, whereClause, whereArgs);
        return affectedRows;
    }


    /**
     * 使用SQL修改数据
     */
    public void updateBySQL() {
        StringBuilder builder = new StringBuilder();
        builder.append("update ").append(DBHelper.TABLE_NAME).append(" set name=?,age=?,address=? where _id=?;");
        Object[] bindArgs = {"赵六", 13, "水星1号", 5};
        mDatabase.execSQL(builder.toString(), bindArgs);
    }

    /**
     * 使用Android 提供的update方法修改数据
     */
    public void update() {
        ContentValues values = new ContentValues();
        values.put("name", "钱八");
        values.put("age", 15);
        values.put("address", "水星2号");
        String whereClause = "_id=?";
        String[] whereArgs = {"4"};
        mDatabase.update(DBHelper.TABLE_NAME, values, whereClause, whereArgs);
    }


    /**
     * 使用 SQL 实现查询所有数据
     */
    public void queryDataBySql() {
        StringBuilder builder = new StringBuilder();
        builder.append(" select * from ").append(DBHelper.TABLE_NAME);
        Cursor cursor = mDatabase.rawQuery(builder.toString(), null);

        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            User user = new User(name, age, address);
            users.add(user);
        }

        LogUtils.e(users + "");
        cursor.close();
    }

    /**
     * 使用 SQL 实现查询某条数据
     */
    public void queryDataBySql1() {
        StringBuilder builder = new StringBuilder();
        builder.append(" select name,age,address from ").append(DBHelper.TABLE_NAME).append(" where _id = ?");
        String[] selectArgs = {"1"};
        Cursor cursor = mDatabase.rawQuery(builder.toString(), selectArgs);

        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            User user = new User(name, age, address);
            users.add(user);
        }

        LogUtils.e(users + "");
        cursor.close();
    }


    /**
     * 使用Android提供的 query 方法 ，实现查询所有数据
     */
    public void queryAll() {
        Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            int age = cursor.getInt(cursor.getColumnIndex("AGE"));
            String address = cursor.getString(cursor.getColumnIndex("ADDRESS"));
            User user = new User(name, age, address);
            users.add(user);
        }

        LogUtils.e(users + "");
        cursor.close();
    }

    /**
     * 使用Android提供的 query 方法 ，实现查询某条数据
     */
    public void query() {

        //想要查询的那些列
        String[] columns = {"name", "age", "address"};
        //where条件
        String selection = "_id=?";
        //where 条件中 '?'的替代值
        String[] selectionArgs = {"1"};
        Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            User user = new User(name, age, address);
            users.add(user);
        }

        LogUtils.e(users + "");
        cursor.close();
    }

}
