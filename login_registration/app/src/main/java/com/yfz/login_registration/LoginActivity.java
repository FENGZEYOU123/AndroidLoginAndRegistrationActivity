package com.yfz.login_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 作者：游丰泽
 * 简介：简单的登陆注册页面，代码清晰简介便于理解。
 * Android需求与交流请加wx：yfz_oom
 */
public class LoginActivity extends AppCompatActivity {
    private EditText mEdtAccount,mEdtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialView();
    }

    private void initialView(){
        mEdtAccount=findViewById(R.id.edtAccount);
        mEdtPassword=findViewById(R.id.edtPassword);
    }

    /**
     * 点击注册按钮-前往注册页面
     * @param view
     */
    public void goToRegisterActivity(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent); //跳转到注册页面
    }

    /**
     * 点击登陆按钮-比对账号密码是否一致
     * @param view
     */
    public void doLogin(View view) {
        String userAccount=mEdtAccount.getText().toString(); //输入的账号
        String userInputPassword= mEdtPassword.getText().toString(); //输入的密码
        String userPassword = SPUtil.getUserPassword(this,mEdtAccount.getText().toString());//从sp储存中以账号作为key，取出对应的value(密码)
        if(userAccount.length()==0){ //没有输入账号
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }
        if(userInputPassword.length()==0){ //没有输入密码
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPassword==null){  //如果没有对应的账号
            Toast.makeText(this, "账号不存在", Toast.LENGTH_SHORT).show();
            return;
        }
      if(userPassword.equals(userInputPassword)){ //比对输入的密码，和储存的密码是否一致
          Toast.makeText(this, "密码一致，登陆成功", Toast.LENGTH_SHORT).show();
          Intent intent=new Intent(this,UserActivity.class);
          startActivity(intent);
      }else {
          Toast.makeText(this, "密码不一致，登陆失败", Toast.LENGTH_SHORT).show();
      }
    }
}