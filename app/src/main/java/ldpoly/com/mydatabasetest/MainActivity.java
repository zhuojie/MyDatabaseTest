package ldpoly.com.mydatabasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MyDatabaseHelper helper;
    private SQLiteDatabase db;
    private ContentValues values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new MyDatabaseHelper(this,"BookStore",null,2);
        Button createDatabase = (Button) findViewById(R.id.creata_database);
        createDatabase.setOnClickListener(this);
        Button addDataBase = (Button) findViewById(R.id.add_database);
        addDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                values = new ContentValues();
                //组装第一条数据
                values.put("name","第一行android代码");
                values.put("author","郭霖");
                values.put("pages",570);
                values.put("price",79);
                db.insert("Book",null,values); // 这个方法是用来添加数据的
                //组装第二条数据
                values.put("category_name","java");
                values.put("category_code","zj");
                db.insert("Category",null,values);
                Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });
        Button update = (Button) findViewById(R.id.update_database);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                values = new ContentValues();
                values.put("price",30);
                db.update("Book",values,"name = ?",new String[]{"第一行android代码"});
            }
        });
    }
    @Override
    public void onClick(View v) {
        helper.getWritableDatabase();
    }
}
