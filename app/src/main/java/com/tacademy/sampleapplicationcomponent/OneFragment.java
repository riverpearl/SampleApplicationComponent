package com.tacademy.sampleapplicationcomponent;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    public interface OnMessageCallBack {
        public void displayMessage(String message);
    }

    OnMessageCallBack callBack;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnMessageCallBack)
            callBack = (OnMessageCallBack)context;
    }

    private static final String KEY_INPUT = "input";

    public static OneFragment newInstance(String input) {
        OneFragment fragment = new OneFragment();
        Bundle b = new Bundle();
        b.putString(KEY_INPUT, input);
        fragment.setArguments(b);
        return fragment;
    }

    public OneFragment() {
        // Required empty public constructor
    }

    String inputText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();

        if (b != null)
            inputText = b.getString(KEY_INPUT);
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
        inputView.setText(inputText);
        messageView = (TextView)view.findViewById(R.id.text_message);

        Button btn = (Button)view.findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageView.setText(inputView.getText().toString());

                if (callBack != null)
                    callBack.displayMessage(inputView.getText().toString());
            }
        });

        return view;
    }

}
