package com.example.gridlayout;


import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private GridLayout gridLayout;
    private ImageView imageView1, imageView2,imageView3, imageView4;
    private TextView textView1, textView2,textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        gridLayout = findViewById(R.id.gridLayout);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        // Set images and text
        imageView1.setImageResource(R.drawable.ic_launcher_background);
        imageView2.setImageResource(R.drawable.ic_launcher_background);
        imageView3.setImageResource(R.drawable.ic_launcher_background);
        imageView4.setImageResource(R.drawable.ic_launcher_background);
        textView1.setText("Grid Item 1");
        textView2.setText("Grid Item 2");
        textView3.setText("Grid Item 3");
        textView4.setText("Grid Item 4");
    }
}
