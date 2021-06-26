package com.paul623.android.wearos.tomatoclock;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者:created by 巴塞罗那的余晖 on 2019/7/10 21：58
 * 邮箱:zhubaoluo@outlook.com
 * 不会写BUG的程序猿不是好程序猿，嘤嘤嘤
 */
//用来封装一些简单的SharedPreference操作
public class MySharedPreference {
    private Context context;
    private String dataBaseName;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public void deleteIntData(String dataName)
    {
        editor.remove(dataName);
        editor.apply();
    }
    public MySharedPreference(Context context, String dataBaseName)
    {
        this.context=context;
        this.dataBaseName=dataBaseName;
        sharedPreferences=context.getSharedPreferences(dataBaseName,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void deleteAllData()
    {
        editor.clear();
        editor.commit();
    }
    public void saveIntData(String DataName, Integer data)
    {
        editor.putInt(DataName,data);
        editor.apply();
    }
    public void saveStringData(String DataName, String data)
    {
        editor.putString(DataName,data);
        editor.apply();
    }
    public void saveBooleanData(String DataName, Boolean data)
    {
        editor.putBoolean(DataName,data);
        editor.apply();
    }
    public void saveFloatData(String DataName, Float data)
    {
        editor.putFloat(DataName,data);
        editor.apply();
    }
    public Integer getIntData(String DataName)
    {
        return sharedPreferences.getInt(DataName,1);
    }
    public String getStringData(String DataName)
    {
        return sharedPreferences.getString(DataName,"");
    }
    public String getStringData(String DataName,String def)
    {
        return sharedPreferences.getString(DataName,def);
    }
    public Boolean getBooleanData(String DataName)
    {
        return sharedPreferences.getBoolean(DataName,false);
    }
    public Float getFloatData(String DataName)
    {
        return sharedPreferences.getFloat(DataName,-1);
    }
    public Float getFloatData(String DataName,float def)
    {
        return sharedPreferences.getFloat(DataName,def);
    }
    public Integer getIntData(String DataName,Integer def)
    {
        return sharedPreferences.getInt(DataName,def);
    }
    public Boolean getBooleanData(String DataName,Boolean def)
    {
        return sharedPreferences.getBoolean(DataName,def);
    }
    public static void saveIntData(Context context, String DataBaseName, String DataName, Integer data)
    {
        SharedPreferences sp=context.getSharedPreferences(DataBaseName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1=sp.edit();
        editor1.putInt(DataName,data);
        editor1.apply();
    }
    public void saveStringData(Context context, String DataBaseName, String DataName, String data)
    {
        SharedPreferences sp=context.getSharedPreferences(DataBaseName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1=sp.edit();
        editor1.putString(DataName,data);
        editor1.apply();
    }
    public void saveBooleanData(Context context, String DataBaseName, String DataName, Boolean data)
    {
        SharedPreferences sp=context.getSharedPreferences(DataBaseName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1=sp.edit();
        editor1.putBoolean(DataName,data);
        editor1.apply();
    }
    public void saveFloatData(Context context, String DataBaseName, String DataName, Float data)
    {
        SharedPreferences sp=context.getSharedPreferences(DataBaseName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1=sp.edit();
        editor1.putFloat(DataName,data);
        editor1.apply();
    }

}
