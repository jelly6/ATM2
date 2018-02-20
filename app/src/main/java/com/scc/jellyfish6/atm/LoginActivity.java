package com.scc.jellyfish6.atm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private String id;
    private String pwd;
    private EditText userid;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        SharedPreferences setting=getSharedPreferences("atm",MODE_PRIVATE);
        userid.setText(setting.getString("Pref_User","").toString());




    }
    public void login(View v ){
        findViews();
        id = userid.getText().toString();
        pwd = password.getText().toString();
        if(id.equals("Jelly")&& pwd.equals("1234")){//登入成功
            SharedPreferences setting= getSharedPreferences("atm",MODE_PRIVATE);
            setting.edit()
                    .putString("Pref_User", id)
                    .commit();
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID", id);
            getIntent().putExtra("LOGIN_PWD", pwd);
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

    private void findViews() {
        userid = findViewById(R.id.userid);
        password = findViewById(R.id.pwd);
    }

    public void cancel(View v){

    }
}
