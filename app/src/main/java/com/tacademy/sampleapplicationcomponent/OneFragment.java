package com.tacademy.sampleapplicationcomponent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    public OneFragment() {
        // Required empty public constructor
    }

    EditText inputView;
    TextView messageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_one, container, false);
        // 윗줄보다 아랫줄처럼 해서 view를 return 시켜주는 게 더 좋음
        View view = inflater.inflate(R.layout.fragment_one, container, false); // 이렇게 해서 view를 return 시켜주는 게 더 좋음
        inputView = (EditText)view.findViewById(R.id.edit_input);
        messageView = (TextView)view.findViewById(R.id.text_message);
        Button btn = (Button)view.findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageView.setText(inputView.getText().toString());
            }
        });

        return view;
    }

}
