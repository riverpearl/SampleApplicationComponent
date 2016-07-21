package com.tacademy.sampleapplicationcomponent;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Button btn = (Button)findViewById(R.id.btn_one);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                OneFragment one = new OneFragment();
                ft.replace(R.id.container, one);
                ft.commit();
            }
        });

        btn = (Button)findViewById(R.id.btn_two);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                TwoFragment two = new TwoFragment();
                ft.replace(R.id.container, two);
                ft.commit();
            }
        });
    }
}
