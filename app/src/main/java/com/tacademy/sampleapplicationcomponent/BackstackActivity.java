package com.tacademy.sampleapplicationcomponent;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BackstackActivity extends AppCompatActivity {

    String[] items = {"one", "two", "three"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack);

        if (savedInstanceState == null) {
            MessageFragment mf = MessageFragment.newInstance("base");
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mf).commit();
        }

        Button btn = (Button)findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count < items.length) {
                    MessageFragment mf = MessageFragment.newInstance(items[count]);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, mf).addToBackStack("entry" + count).commit();
                }
            }
        });

        btn = (Button)findViewById(R.id.btn_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count > 0) getSupportFragmentManager().popBackStack();
            }
        }); // 안드로이드의 back key를 눌러도 popBackStack()으로 동작

        btn = (Button)findViewById(R.id.btn_empty);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE); // Stack Clear
            }
        });
    }
}
