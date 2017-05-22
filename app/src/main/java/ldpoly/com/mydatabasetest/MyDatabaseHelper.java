package ldpoly.com.mydatabasetest;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper{
    private Context mycontext;
    public static final String CREATE_BOOK = "create table Book("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text)";
    public static final String CREATE_CATEGORY = "create table Category("
            +"id integer primary key autoincrement,"
            +"category_code integer,"
            +"category_name text)";
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {   // 这个是创建数据库用的
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mycontext,"数据库添加成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  //这个方法是更新数据库用的
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
