package com.example.dakka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

public class Dashboard extends AppCompatActivity {

    FloatingActionButton bahari, pertanian, cagar_alam;

    private int[] mImages = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        CarouselView carouselView = findViewById(R.id.carouselnya);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(((position, imageView) -> {
            imageView.setImageResource(mImages[position]);
        }));

        bahari = findViewById(R.id.bahari);
        bahari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ListWisata.class);
                intent.putExtra("kategori", "Bahari");
                startActivity(intent);
            }
        });

        pertanian = findViewById(R.id.pertanian);
        pertanian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ListWisata.class);
                intent.putExtra("kategori", "Pertanian");
                startActivity(intent);
            }
        });

        cagar_alam = findViewById(R.id.cagar_alam);
        cagar_alam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ListWisata.class);
                intent.putExtra("kategori", "Cagar Alam");
                startActivity(intent);
            }
        });
    }

}