package com.example.as_multiplescreens_zad4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<String> itemsList = new ArrayList<>();
    private EditText etItem;
    private TextView tvItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etItem = findViewById(R.id.etItem);
        tvItemsList = findViewById(R.id.tvItemsList);

        findViewById(R.id.btnAdd).setOnClickListener(v -> addItem());
        findViewById(R.id.btnDraw).setOnClickListener(v -> drawItem());
    }

    private void addItem() {
        String text = etItem.getText().toString().trim();
        if (text.isEmpty()) {
            etItem.setError(getString(R.string.error_empty_input));
            return;
        }
        itemsList.add(text);
        etItem.setText("");
        refreshListDisplay();
    }

    private void refreshListDisplay() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itemsList.size(); i++) {
            sb.append(i + 1).append(". ").append(itemsList.get(i)).append("\n");
        }
        tvItemsList.setText(sb.toString());
    }

    private void drawItem() {
        if (itemsList.isEmpty()) {
            Toast.makeText(this, R.string.error_no_items, Toast.LENGTH_SHORT).show();
            return;
        }
        // Konwersja listy na zwykłą tablicę String[] do przekazania w Intent
        String[] itemsArray = itemsList.toArray(new String[0]);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ResultActivity.EXTRA_ITEMS, itemsArray);
        startActivity(intent);
    }
}