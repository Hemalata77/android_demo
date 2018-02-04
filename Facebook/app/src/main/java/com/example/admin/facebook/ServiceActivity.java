package com.example.admin.facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ServiceActivity extends AppCompatActivity {


    Button fbbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        /*fbbtn = findViewById(R.id.fbbtn);

        fbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, BackgroundService1.class);
                startActivity(intent);
            }
        });*/
    }
}
