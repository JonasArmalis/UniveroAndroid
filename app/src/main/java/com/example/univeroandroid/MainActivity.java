package com.example.univeroandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btnChangeText = findViewById(R.id.btnChangeText);
        Button btnChangeColor = findViewById(R.id.btnChangeColor);
        Button btnChangeBackground = findViewById(R.id.btnChangeBackground);

        // expression lambdas + strings.xml
        btnChangeText.setOnClickListener(v -> tvMessage.setText("welcome to my application"));

        btnChangeColor.setOnClickListener(
                v -> tvMessage.setTextColor(
                        ContextCompat.getColor(this, android.R.color.holo_blue_bright)
                )
        );

        btnChangeBackground.setOnClickListener(
                v -> tvMessage.setBackgroundColor(
                        ContextCompat.getColor(this, android.R.color.holo_green_light)
                )
        );
        // Comment for revert
    }
}