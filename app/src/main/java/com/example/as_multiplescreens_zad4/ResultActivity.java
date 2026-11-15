package com.example.as_multiplescreens_zad4;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_ITEMS = "com.example.losowywybor.ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvWinner = findViewById(R.id.tvWinner);

        // Odbieranie tablicy napisów przekazanej przez Intent
        String[] items = getIntent().getStringArrayExtra(EXTRA_ITEMS);

        if (items != null && items.length > 0) {
            String chosen = items[new Random().nextInt(items.length)];
            tvWinner.setText(chosen);
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}