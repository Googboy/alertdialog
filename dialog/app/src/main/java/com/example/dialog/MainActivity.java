package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
    //private Button button;使用方式2的话需要定义

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSimple).setOnClickListener(new ClickEvent());//这是方式1
        //这是匹配方式2写法
        //button = (Button) findViewById(R.id.btnSimple);
        //button.setOnClickListener(new ClickEvent());
    }

    private class ClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //方式1：
            switch (v.getId()){
                case R.id.btnSimple:
                    showDialog(MainActivity.this);
            }
            //方式2:
            /*if (v == button)
                showDialog(MainActivity.this);
                */
        }
    }

    private void showDialog(MainActivity mainActivity) {
        ImageView imageview = new ImageView(mainActivity);
        imageview.setImageResource(R.mipmap.ic_launcher);
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("图片框");
        builder.setView(imageview);
        builder.setPositiveButton("确定",null).show();
        //builder.setTitle("请选择:");
                                  //builder.setMessage("请输入:");
                                  //builder.setMessage("确定吗?");
                                  //builder.setView(new EditText(MainActivity.this));
                                  //builder.setPositiveButton("确定",null);
                                  //builder.setNegativeButton("取消",null);
                                  //builder.show();

       /* builder.setSingleChoiceItems(new String[]{"选项1", "选项2", "选项3", "选项4"}, 0, new DialogInterface.OnClickListener() {//这个地方的数字的作用是默认选择第一个选项
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setPositiveButton("确定",null).setNegativeButton("取消",null).show();*/

    }
}
