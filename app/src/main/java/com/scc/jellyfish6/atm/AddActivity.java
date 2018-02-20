package com.scc.jellyfish6.atm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText edDate;
    private EditText edDetail;
    private EditText edAmount;
    private Button b_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        findViews();

    }

    private void findViews() {
        edDate = findViewById(R.id.edDate);
        edDetail = findViewById(R.id.edDetail);
        edAmount = findViewById(R.id.edAmount);
        b_add = findViewById(R.id.b_add);
    }
    public void add(View v){

    }
}
