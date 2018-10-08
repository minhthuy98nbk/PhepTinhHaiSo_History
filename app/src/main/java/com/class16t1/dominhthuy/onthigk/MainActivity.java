package com.class16t1.dominhthuy.onthigk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> history;
    android.widget.ListView LW;

    private EditText edtA, edtB;
    private TextView edtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        history = new ArrayList<String>();

        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);
        edtResult = findViewById(R.id.edt_result);
    }

    public void show_history (){
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,history);
        LW = findViewById(R.id.history);
        LW.setAdapter(adapter);
    }

    public boolean check (String s){
        if (s.equals("")==true) return false;
        for(int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) == false) return false;
        }
        return true;
    }

    public void btnCong (View v){
        if ( check(edtA.getText().toString())==false || check(edtB.getText().toString())==false ){
            Toast.makeText(MainActivity.this,"Dữ liệu sai",Toast.LENGTH_LONG).show();
            return;
        }
        int a = Integer.parseInt(edtA.getText().toString());
        int b = Integer.parseInt(edtB.getText().toString());
        edtResult.setText(a+b+"");
        history.add(a + " + " + b + " = " + (a+b));
        show_history();

    }

    public void btnTru (View v){
        if ( check(edtA.getText().toString())==false || check(edtB.getText().toString())==false ) {
            Toast.makeText(MainActivity.this, "Dữ liệu sai", Toast.LENGTH_LONG).show();
            return;
        }
        int a = Integer.parseInt(edtA.getText().toString());
        int b = Integer.parseInt(edtB.getText().toString());
        edtResult.setText(a-b+"");
        history.add(a + " - " + b + " = " + (a-b));
        show_history();
    }

    public void btnNhan (View v){
        if ( check(edtA.getText().toString())==false || check(edtB.getText().toString())==false ){
            Toast.makeText(MainActivity.this,"Dữ liệu sai",Toast.LENGTH_LONG).show();
            return;
        }
        int a = Integer.parseInt(edtA.getText().toString());
        int b = Integer.parseInt(edtB.getText().toString());
        edtResult.setText(a*b+"");
        history.add(a + " * " + b + " = " + (a*b));
        show_history();
    }

    public void btnChia (View v){
        if ( check(edtA.getText().toString())==false || check(edtB.getText().toString())==false ){
            Toast.makeText(MainActivity.this,"Dữ liệu sai",Toast.LENGTH_LONG).show();
            return;
        }
        int a = Integer.parseInt(edtA.getText().toString());
        int b = Integer.parseInt(edtB.getText().toString());
        edtResult.setText(a/b+"");
        history.add(a + " / " + b + " = " + (a/b));
        show_history();
    }
    public void btnClear (View v){
        edtA.setText("");
        edtB.setText("");
    }
}
