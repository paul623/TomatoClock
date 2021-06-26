package com.paul623.android.wearos.tomatoclock;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.paul623.android.wearos.tomatoclock.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

import static android.os.VibrationEffect.DEFAULT_AMPLITUDE;

public class MainActivity extends Activity  {

    private TextView tv_time,tv_hint;
    private Button btn_start;
    private ActivityMainBinding binding;
    //番茄钟
    private int MINUTE = 24;
    private int SECOND = 60;
    boolean flag,tag;
    Timer timer;
    TimerTask timerTask;
    int x;
    private MySharedPreference ms;
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                timeCount(); //跳转到timeCount()方法
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initAndBindView();
        requestPremission();
    }


    private void initAndBindView(){
        btn_start=binding.btnStart;
        tv_time=binding.clockTime;
        tv_hint=binding.clockHint;

        ms=new MySharedPreference(MainActivity.this, MyOrders.TOOLBOX_DATABASE_NAME);
        x=ms.getIntData(MyOrders.TOOLBOX_DATABASE_TOMATO_NUMBER,0);
        tv_hint.setText("您累计得到了"+x+"个番茄");
        tv_time.setText("25:00"); //设置TextView文本内容
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==false)
                {
                    callVibrate();
                    calcTimer(); //跳转到calcTimer()方法
                    btn_start.setText("停止");
                    tv_hint.setText(WordsHelper.getWordsByTime());
                    flag=true;
                }
                else
                {
                    tv_time.setText("25:00"); //设置TextView文本内容
                    btn_start.setText("开始种番茄！");
                    tv_hint.setText("您累计得到了"+x+"个番茄");
                    flag=false;
                    timer.cancel();
                    timer=null;
                    timerTask.cancel();
                    timerTask=null;
                    MINUTE = 24;
                    SECOND=60;
                    if(tag)
                    {
                        tag=false;
                        x=x+1;
                        tv_hint.setText("您累计得到了"+x+"个番茄");
                        ms.saveIntData(MyOrders.TOOLBOX_DATABASE_TOMATO_NUMBER,x);
                    }
                }


            }
        }); //为btn_start按钮注册监听器
        flag=false;
        tag=false;
    }
    private void timeCount(){
        if(MINUTE>=0){
            SECOND--;
            String minute = String.valueOf(MINUTE);
            String second = String.valueOf(SECOND);

            if(SECOND>=0){
                if(SECOND<10){
                    second = "0"+second;
                }
                if(MINUTE<10){
                    minute = "0"+minute;
                }
                tv_time.setText(minute+":"+second);
            }else{
                SECOND = 60;
                MINUTE--;
            }

        }else{
            callVibrate();
            tv_time.setText("种植成功");
            btn_start.setText("继续~");
            tag=true;

        }
    } //timeCount()

    private void calcTimer(){
        //声明定时器
        timer = new Timer(){};
        //声明定时任务
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what=1;
                myHandler.sendMessage(msg);
            }
        };
        //启动定时器
        timer.schedule(timerTask, 1000, 1000);

    }

    private void callVibrate(){
        Vibrator vibrator = (Vibrator)this.getSystemService(this.VIBRATOR_SERVICE);
        vibrator.vibrate(VibrationEffect.createOneShot(1000,DEFAULT_AMPLITUDE));
    }
    private void requestPremission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.VIBRATE}, 1);
    }
}