package homework.bdqn.com.sqlitesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by liteng on 2016/5/22.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "User.db";
    //数据库版本必须大于零
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "book_list";

    SQLiteDatabase database = null;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // 获取到数据库对象
        database = getReadableDatabase();
    }

    /**
     * 数据库创建时调用,一般用于创建数据库表和一些初始化操作
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder builder = new StringBuilder();
        builder.append("create table ").
                append(TABLE_NAME).
                append("(id integer primary key ,bookName text,bookPrice double,bookAuthor text);");
        db.execSQL(builder.toString());
    }

    /**
     * 数据库更新时调用
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertBySQL() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(TABLE_NAME).append("(id,bookName,bookPrice,bookAuthor) values (1,'第一行代码',10.0,'郭霖')");
        database.execSQL(sql.toString());
    }


}
