package com.scc.jellyfish6.atm;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText edDate;
    private EditText edDetail;
    private EditText edAmount;
    private Button b_add;
    private MyDBHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        findViews();
        helper = new MyDBHelper(this,"expanse.db",null,1);


    }

    private void findViews() {
        edDate = findViewById(R.id.edDate);
        edDetail = findViewById(R.id.edDetail);
        edAmount = findViewById(R.id.edAmount);
        b_add = findViewById(R.id.b_add);
    }
    public void add(View v){
        //findViews();
        String cdate= edDate.getText().toString();
        //Toast.makeText(this,cdate+"成功",Toast.LENGTH_LONG).show();
        String details=edDetail.getText().toString();
        //Toast.makeText(this,details+"成功",Toast.LENGTH_LONG).show();
        int amount=Integer.parseInt(edAmount.getText().toString());
        //Toast.makeText(this,amount+"成功",Toast.LENGTH_LONG).show();

        ContentValues values=new ContentValues();
        values.put("cdate", cdate);
        values.put("details",details);
        values.put("amount",amount);
        long id=helper.getWritableDatabase().insert("exp",null,values);
        //Toast.makeText(this,id+"ADD成功",Toast.LENGTH_LONG).show();
        Log.d("ADD",id+"");

    }
}
