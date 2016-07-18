package com.tacademy.sampleapplicationcomponent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputView;
    TextView resultView;

    private final static int RC_OTHER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputView = (EditText)findViewById(R.id.edit_input);
        resultView = (TextView)findViewById(R.id.text_result);
        Button btn = (Button)findViewById(R.id.btn_other);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                String input = inputView.getText().toString();
                //intent.putExtra(OtherActivity.EXTRA_KEYWORD, input);
                //intent.putExtra(OtherActivity.EXTRA_AGE, 42);

                MyData data = new MyData();
                data.keyword = input;
                data.age = 42;
                intent.putExtra(OtherActivity.EXTRA_MY_DATA, data);

                startActivityForResult(intent, RC_OTHER); // 여기서의 intent = onActivityResult의 requestCode
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_OTHER) {
            if (resultCode == Activity.RESULT_OK) {
                String text = data.getStringExtra(OtherActivity.RESULT_MESSAGE);
                resultView.setText(text);
            }
            else Toast.makeText(this, "Result Canceled", Toast.LENGTH_SHORT).show();
        }
    }
}
