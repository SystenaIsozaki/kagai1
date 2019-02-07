package com.example.systena.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.toastbutton);
        button.setOnClickListener (new View.OnClickListener(){
            public void  onClick(View v){
                if (v == button){
                    Toast toast = Toast.makeText(MainActivity.this,"HELLO!",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
