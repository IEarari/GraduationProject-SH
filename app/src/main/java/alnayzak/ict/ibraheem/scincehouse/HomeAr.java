package alnayzak.ict.ibraheem.scincehouse;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeAr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ar);
        Button toEng = findViewById(R.id.toEng);
        toEng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeAr.this, Home.class));
                HomeAr.this.finish();
            }
        });
        Button book_button = findViewById(R.id.book_ar);
        book_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeAr.this, TourAR.class));
            }
        });
        Button about_button = findViewById(R.id.about_ar);
        about_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeAr.this, AboutAr.class));
            }
        });
        Button gifts_button = findViewById(R.id.gifts_ar);
        gifts_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeAr.this, GiftsAr.class));
            }
        });
        Button contact_button = findViewById(R.id.contact_ar);
        contact_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomeAr.this, ContactAr.class));
            }
        });
        Button news_button = findViewById(R.id.news_ar);
        news_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(HomeAr.this, NewsARActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage(getText(R.string.questionar))
                .setNegativeButton(getText(R.string.stayar), null)
                .setPositiveButton(getText(R.string.exitar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        HomeAr.super.onBackPressed();
                    }
                }).create().show();
    }
}