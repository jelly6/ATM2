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
        //MyDBHelper helper=new MyDBHelper(this,"expanse.db",null,1);
        MyDBHelper helper=MyDBHelper.getInstance(this);
        Cursor c=helper.getReadableDatabase().query(
                "exp",null,null,null,null,null,null
        );
        //客制化ListView
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.finance_row,c,
                new String[]{"_id","cdate","details","amount"},
                new int[] {R.id.item_id,R.id.item_cdate,R.id.item_details,R.id.item_amount},
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
