package com.yfz.login_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 作者：游丰泽
 * 简介：简单的登陆注册页面，代码清晰简介便于理解。
 * Android需求与交流请加wx：yfz_oom
 */
public class RegisterActivity extends AppCompatActivity {
    private EditText mEdtAccount,mEdtPassword,mEdtPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialView();
    }

    private void initialView(){
        mEdtAccount=findViewById(R.id.edtAccount);
        mEdtPassword=findViewById(R.id.edtPassword);
        mEdtPasswordConfirm=findViewById(R.id.edtPasswordConfirm);
    }


    /**
     * 点击注册按钮-进行注册-将账号和密码储存到sp中
     * @param view
     */
    public void doRegister(View view) {
        String userAccount=mEdtAccount.getText().toString(); //输入的账号
        String userPassword=mEdtPassword.getText().toString(); //输入的密码
        String userPasswordConfirm=mEdtPasswordConfirm.getText().toString(); //再次输入的确认密码
        if(userAccount.length()==0){
            Toast.makeText(this,"账号不可为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPassword.length()==0){
            Toast.makeText(this,"密码不可为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPasswordConfirm.length()==0){
            Toast.makeText(this,"再次输入确认密码不可为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if( ! userPassword.equals(userPasswordConfirm)){
            Toast.makeText(this,"两次输入密码不一致",Toast.LENGTH_SHORT).show();
            return;
        }

        SPUtil.saveUserDataInSharePreference(this,userAccount,userPassword);

        Toast.makeText(this,"注册成功，返回",Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);

    }

}