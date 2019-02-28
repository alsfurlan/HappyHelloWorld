package com.example.happyhelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button sayHelloButton;
    private TextView helloPhrase;
    private EditText name;
    private ImageView happyFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayHelloButton = (Button) findViewById(R.id.sayHelloButton);
        sayHelloButton.setOnClickListener(sayHelloOnClick());

        helloPhrase = (TextView) findViewById(R.id.helloPhrase);

        name = (EditText) findViewById(R.id.name);
        name.setOnKeyListener(sayHelloOnEnter());

        happyFace = (ImageView) findViewById(R.id.happyFace);
    }

    private View.OnKeyListener sayHelloOnEnter() {
        return new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER) {
                    happyHelloWorld();
                }
                return false;
            }
        };
    }

    private View.OnClickListener sayHelloOnClick() {
        return new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                happyHelloWorld();
            }
        };
    }

    private void happyHelloWorld() {
        helloPhrase.setText("Hello world, ".concat(name.getText().toString().replace("\n", "").concat("!")));
        name.setText(name.getText().toString().replace("\n",""));
        happyFace.setVisibility(View.VISIBLE);
        name.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }
}
