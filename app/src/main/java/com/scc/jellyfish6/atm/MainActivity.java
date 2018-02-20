package com.scc.jellyfish6.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    boolean logan=false;
    public static final int FUNC_LOGIN=1;
    //String[] func={"balance check","business detail","The News","Investiment","Leave"}
    String[] func={"餘額查詢","交易明細","最新消息","投資理財","離開"};
    int[] icons={R.drawable.func_balance,R.drawable.func_history,R.drawable.func_news,R.drawable.func_finance,R.drawable.func_exit};

    //設計IconAdapter繼承BaseAdapter
    class IconAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }





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



        }
        ListView list=findViewById(R.id.list);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,func);
        list.setAdapter(adapter);
        //使用spinner
        Spinner notify=findViewById(R.id.notify_spinner);
        final ArrayAdapter<CharSequence> nAdapter=ArrayAdapter.createFromResource(this,R.array.notify_array,android.R.layout.simple_spinner_item);
        nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        notify.setAdapter(nAdapter);
        notify.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        Toast.makeText(MainActivity.this,nAdapter.getItem(position),Toast.LENGTH_LONG).show();;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );
        //使用gridView
        GridView grid=findViewById(R.id.grid);
        ArrayAdapter gAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,func);
        grid.setAdapter(gAdapter);
        grid.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch(position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                finish();
                break;
        }
    }
}
