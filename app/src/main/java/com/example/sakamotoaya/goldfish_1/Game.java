package com.example.sakamotoaya.goldfish_1;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {

    private TextView textView;
    public int count;
    public int totalCount;
    public int five;
    public int ran;
    public Button button;
    public Button ret;
    public int score;
    public boolean visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        count = 0;
        score = 0;
        visible = false;
        findViewById(R.id.imageView3).setVisibility(View.GONE);
        findViewById(R.id.ret).setVisibility(View.GONE);
        // ボタンを設定
        button = (Button)findViewById(R.id.tap);
        ret = (Button)findViewById(R.id.ret);



        // リスナーをボタンに登録
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visible==true) {
                    score+=5;
                }
            }
        });

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 10秒カウントダウンする
        new CountDownTimer(30000,1000){
            TextView count_txt = (TextView)findViewById(R.id.textView2);

            // カウントダウン処理
            public void onTick(long millisUntilFinished){
                count_txt.setText(millisUntilFinished/1000+"秒");
                if(count==0) {
                    Random rnd = new Random();
                    ran = rnd.nextInt(6);
                }
                if(count == ran) {
                    findViewById(R.id.imageView3).setVisibility(View.VISIBLE);
                    visible = true;
                }
                if(totalCount == five*5+ran+1) {
                    visible = false;
                    findViewById(R.id.imageView3).setVisibility(View.GONE);
                }
                if(count==5) {
                    five++;
                    count = 0;
                }
                count++;
                totalCount++;
            }
            // カウントが0になった時の処理
            public void onFinish(){
                count_txt.setText(score+"点");
                findViewById(R.id.ret).setVisibility(View.VISIBLE);
            }
        }.start();

    }

}