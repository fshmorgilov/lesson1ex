package com.example.fshmo.lesson1excercise;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class MainActivity extends AppCompatActivity {

    private static final String LTAG = MainActivity.class.getName();
    private static final String KEY_SOMETHING = "SOMETHING";

    private Button previewBtn;
    private EditText editText;
    private Button playBtn;
//    public static final String KEY_TEXT = "KEY_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        previewBtn = findViewById(R.id.preview_btn);
        playBtn = findViewById(R.id.play_game_btn);

        previewBtn.setOnClickListener(v -> {
            final String entered = editText.getText().toString().trim();
            if (!entered.isEmpty()) {
                Log.i(LTAG, entered);
                showText("Showing your text");
                PreviewActivity.start(MainActivity.this, entered);
            } else {
                showText("Enter text");
            }
        });
        if (playBtn != null) {
            playBtn.setOnClickListener(v -> {
                Log.i(LTAG, "PlayBtn pressed");
                EasterActivity.start(MainActivity.this);
            });
        }
    }

    private void showText(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
    }
}
