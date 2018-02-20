package com.scc.jellyfish6.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    boolean logan=false;
    public static final int FUNC_LOGIN=1;
    //String[] func={"balance check","business detail","The News","Investiment","Leave"}
    String[] func={"餘額查詢","交易明細","最新消息","投資理財","離開"};
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_xml,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==FUNC_LOGIN){
            if(resultCode==RESULT_OK){
                String id=data.getStringExtra("LOGIN_USERID");
                String pwd=data.getStringExtra("LOGIN_PWD");
                Log.d("RESULT",id+"/"+pwd);
            }else{
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!logan){
            //如果未登入,則開啟登入Ａctivity
            Intent intent=new Intent(this,LoginActivity.class);
            //startActivity(intent);
            startActivityForResult(intent,FUNC_LOGIN);
            ListView list=findViewById(R.id.list);
            ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,func);
            list.setAdapter(adapter);


        }
    }
}
