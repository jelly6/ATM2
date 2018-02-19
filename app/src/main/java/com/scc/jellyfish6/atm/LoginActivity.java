package com.scc.jellyfish6.atm;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }
    public void login(View v ){
        EditText userid=findViewById(R.id.userid);
        EditText password=findViewById(R.id.pwd);
        String id=userid.getText().toString();
        String pwd=password.getText().toString();
        if(id.equals("Jelly")&& pwd.equals("1234")){//登入成功
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID",id);
            getIntent().putExtra("LOGIN_PWD",pwd);
            setResult(RESULT_OK,getIntent());
            finish();
             }else{//登入失敗
            new AlertDialog.Builder(this)
                    .setTitle("Atm")
                    .setMessage("登入失敗")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
    public void cancel(View v){

    }
}
