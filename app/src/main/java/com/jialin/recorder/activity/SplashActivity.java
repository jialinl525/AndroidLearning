package com.jialin.recorder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.jialin.recorder.R;
import com.jialin.recorder.util.SuperDateUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;


public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView copyrightView = findViewById(R.id.copyright);
        copyrightView.setText(getString(R.string.copyright, SuperDateUtil.currentYear()));
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);


        //列好所有我们需要的权限
        List<String> perList = new ArrayList<>();
        perList.add(Manifest.permission.CAMERA);
        perList.add(Manifest.permission.BODY_SENSORS);
        perList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        //开始请求权限
        requestPermission(perList);

    }

    @Override
    public void throwPermissionResults(String permissionName, boolean isSuccess) {
        super.throwPermissionResults(permissionName, isSuccess);
        //拿到相应的权限，以及授权结果
        switch (permissionName) {
            case Manifest.permission.CAMERA:
                Log.d("fxHou", "CAMERA授权结果：" + isSuccess);
                break;
            case Manifest.permission.BODY_SENSORS:
                Log.d("fxHou", "BODY_SENSORS授权结果：" + isSuccess);
                break;
            case Manifest.permission.READ_EXTERNAL_STORAGE:
                Log.d("fxHou", "READ_EXTERNAL_STORAGE授权结果：" + isSuccess);
                break;
        }
    }
}

