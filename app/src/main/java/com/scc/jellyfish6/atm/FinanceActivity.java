package com.scc.jellyfish6.atm;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class FinanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //從DB查資料Show 在ListView
        ListView list=findViewById(R.id.list);
        MyDBHelper helper=new MyDBHelper(this,"expanse.db",null,1);
        Cursor c=helper.getReadableDatabase().query(
                "exp",null,null,null,null,null,null
        );
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,android.R.layout.simple_expandable_list_item_2,c,
                new String[]{"details","amount"},
                new int[] {android.R.id.text1,android.R.id.text2},
                0);
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinanceActivity.this,AddActivity.class));
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });
    }

}
