package com.tacademy.sampleapplicationcomponent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    TextView messageView;
    EditText inputResultView;

    public final static String EXTRA_KEYWORD = "keyword";
    public final static String EXTRA_AGE = "age";
    public final static String RESULT_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        messageView = (TextView)findViewById(R.id.text_message);
        inputResultView = (EditText)findViewById(R.id.edit_input_result);

        Intent intent = getIntent();
        String text = intent.getStringExtra(EXTRA_KEYWORD);
        int age = intent.getIntExtra(EXTRA_AGE, 0);
        // 뒤에 default 값을 정의할 수 있다. (값이 넘어오지 않을 경우 0으로 초기화)
        // String은 default 값을 정의하지 않아도 자동으로 null로 처리됨.

        messageView.setText(text + ", " + age);

        Button btn = (Button)findViewById(R.id.btn_finish);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = inputResultView.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(RESULT_MESSAGE, result);
                setResult(Activity.RESULT_OK, intent); // 매개변수 차례대로 onActivityResult의 resultCode, data
                finish();
            }
        });
    }
}
