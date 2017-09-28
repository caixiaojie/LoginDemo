package com.fskj.logindemo;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.fskj.logindemo.view.BottomDialog;
import com.fskj.logindemo.view.LoginDialog;
import com.fskj.logindemo.view.MessageConfirmDialog;

public class MainActivity extends AppCompatActivity {
    private int screenWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnLogin(View view) {
        final LoginDialog dialog = new LoginDialog(MainActivity.this);
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                dialog.dismiss();
            }
        }).start();
    }

    public void confirmDialog(View view) {
        final MessageConfirmDialog selfDialog    = new MessageConfirmDialog(MainActivity.this);
        selfDialog.setTitle("提示");
        selfDialog.setMessage("确定退出应用?");
        selfDialog.setYesOnclickListener("确定", new MessageConfirmDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                Toast.makeText(MainActivity.this,"点击了--确定--按钮",Toast.LENGTH_LONG).show();
                selfDialog.dismiss();
            }
        });
        selfDialog.setNoOnclickListener("取消", new MessageConfirmDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                Toast.makeText(MainActivity.this,"点击了--取消--按钮",Toast.LENGTH_LONG).show();
                selfDialog.dismiss();
            }
        });
        selfDialog.show();
    }

    public void bottomDialog(View view) {
        BottomDialog bottomDialog = new BottomDialog(this, R.layout.dialog_bottom_layout, new int[]{R.id.pick_photo_album, R.id.pick_photo_camera, R.id.pick_photo_cancel});
        bottomDialog.show();
        bottomDialog.setOnBottomMenuItemClickListener(new BottomDialog.OnBottomMenuItemClickListener() {
            @Override
            public void onBottomMenuItemClick(BottomDialog dialog, View view) {
                switch (view.getId()){
                    case R.id.pick_photo_album:
                        Toast.makeText(MainActivity.this,"从相册选取",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pick_photo_camera:
                        Toast.makeText(MainActivity.this,"拍照",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
