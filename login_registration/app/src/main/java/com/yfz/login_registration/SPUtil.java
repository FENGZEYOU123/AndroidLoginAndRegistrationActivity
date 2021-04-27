package com.yfz.login_registration;

import android.app.Activity;
import android.content.SharedPreferences;

public class SPUtil {
    public static void saveUserDataInSharePreference(Activity activity,String account,String password){
        SharedPreferences sharedPreferences = activity.getSharedPreferences("userData", activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(account, password); //key-账号 对应 value-密码
        editor.apply();
    }
    public static String getUserPassword(Activity activity,String account){
        SharedPreferences sharedPreferences = activity.getSharedPreferences("userData", activity.MODE_PRIVATE);
        return sharedPreferences.getString(account,null); //通过key获取对应的密码
    }
}
