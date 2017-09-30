package com.example.toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button firstbutton;
    private Button secondbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstbutton = (Button) findViewById(R.id.btnFirst);
        secondbutton = (Button) findViewById(R.id.btnSecond);

        firstbutton.setOnClickListener(this);
        secondbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFirst:
                Toast.makeText(this,"你点击的是:"+firstbutton.getText(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSecond:
                Toast.makeText(this,"你点击的是:"+secondbutton.getText(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
