package com.example.dipankar.singletondip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dipankar.singletondip.model.BubbleWrap;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private BubbleWrap bubbleWrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bubbleWrap = BubbleWrap.getInstance();
        // getInstance function one Instance that the bubbleWrap class is generating
        setupAddMoreButton();
        setupPopActivityButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void setupAddMoreButton() {
        Button btn = findViewById(R.id.AddButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bubbleWrap.addMoreBubbles();
                updateUI();
            }
        });
    }

    private void setupPopActivityButton() {
        Button btn = findViewById(R.id.btnStartPopping);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, PopActivity.class);
                startActivity(intent);

            }
        });
    }
    private void updateUI(){
        TextView tv = findViewById(R.id.lbLbubbleWrap);
        String msg = String.format(
                Locale.getDefault(),
                "%d bubbles left!",
                bubbleWrap.getNumBubbles());
        tv.setText(msg);
    }

}

