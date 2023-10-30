// src/main/java/com/example/notifblocker2/MainActivity.java
package com.example.notifblocker2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextKeywords;
    private Button buttonToggleService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextKeywords = findViewById(R.id.edit_text_keywords);
        buttonToggleService = findViewById(R.id.button_toggle_service);

        final MyNotificationBlockerService notificationBlockerService = new MyNotificationBlockerService();

        buttonToggleService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keywords = editTextKeywords.getText().toString();
                notificationBlockerService.setKeywords(keywords);

                Intent intent = new Intent(MainActivity.this, MyNotificationBlockerService.class);
                startService(intent);
            }
        });
    }
}
