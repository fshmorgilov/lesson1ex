package com.example.fshmo.lesson1excercise;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasterActivity extends AppCompatActivity {
    private List<Button> buttons = new ArrayList<>();
    private static final String LTAG = EasterActivity.class.getName();

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, EasterActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp);
        buttons.add((Button) findViewById(R.id.playBtn1));
        buttons.add((Button) findViewById(R.id.playBtn2));
        buttons.add((Button) findViewById(R.id.playBtn3));
        buttons.add((Button) findViewById(R.id.playBtn4));
        buttons.add((Button) findViewById(R.id.playBtn5));
        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(LTAG, "Button pressed");
                    randomizeColors();
                }
            });
        }
    }

    private void randomizeColors() {
        for (Button button : buttons) {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            button.setBackgroundColor(color);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
            params.weight = rnd.nextInt(10);
            button.setLayoutParams(params);
        }
    }


}
