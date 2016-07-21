package com.tacademy.sampleapplicationcomponent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FragmentActivity extends AppCompatActivity implements OneFragment.OnMessageCallBack {
    // 콜백 인터페이스를 상속받고 메소드를 재정의하면 OtherFragmentActivity는 같은 fragment 참조해도 다르게 동작함

    private static final String TAG_ONE = "one";
    private static final String TAG_TWO = "two";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Button btn = (Button)findViewById(R.id.btn_one);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAG_ONE);
                if (old == null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    //OneFragment one = new OneFragment();
                    OneFragment one = OneFragment.newInstance("hahaha");
                    ft.replace(R.id.container, one, TAG_ONE);
                    ft.commit();
                }

            }
        });

        btn = (Button)findViewById(R.id.btn_two);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment old = getSupportFragmentManager().findFragmentByTag(TAG_TWO);
                if (old == null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    TwoFragment two = new TwoFragment();
                    ft.replace(R.id.container, two, TAG_TWO);
                    ft.commit();
                }
            }
        });

        btn = (Button)findViewById(R.id.btn_other);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentActivity.this, OtherFragmentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, "message : " + message, Toast.LENGTH_SHORT).show();
    }
}
