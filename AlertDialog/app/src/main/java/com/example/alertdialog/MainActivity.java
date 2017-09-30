package com.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button btnDialog;
    private Button btnDialogLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定义按钮
        btnDialog = (Button) findViewById(R.id.btnShowDialog);
        btnDialog.setOnClickListener(new ClickEvent());
        btnDialogLayout = (Button) findViewById(R.id.btnShowDialogLayout);
        btnDialogLayout.setOnClickListener(new ClickEvent());
    }
    //处理点击事件
    private class ClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == btnDialog)
                showDialog(MainActivity.this);
            else if (v == btnDialogLayout)
                showDialogLayout(MainActivity.this);
        }
    }

    //显示基于layout的dialog
    private void showDialogLayout(Context context) {
        LayoutInflater inflater = LayoutInflater.from(this);
        final View textEntryView = inflater.inflate(R.layout.alertdialog,null);
        final EditText editInput = (EditText) textEntryView.findViewById(R.id.etInput);
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Title");
        builder.setView(textEntryView);
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setTitle(editInput.getText());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setTitle("");
            }
        });
        builder.show();
    }
    //显示基本的dialog内容
    private void showDialog(MainActivity mainActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("标题");
        builder.setMessage("消息内容");

        builder.setNeutralButton("Button1", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setTitle("点击了对话框上的Button1");
            }
        });
        builder.setNegativeButton("Button2", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setTitle("点击了对话框上的Button2");
            }
        });
        builder.setPositiveButton("Button3", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setTitle("点击了对话框上的Button3");
            }
        });
        builder.show();
    }
}
