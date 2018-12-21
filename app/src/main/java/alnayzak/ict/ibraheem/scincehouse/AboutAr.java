package alnayzak.ict.ibraheem.scincehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AboutAr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_ar);
        Button book_button_as = findViewById(R.id.book_tour_as_ar);
        book_button_as.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AboutAr.this,TourAR.class));
            }
        });
        Button gifts_button_as = findViewById(R.id.GShop_as_ar);
        gifts_button_as.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AboutAr.this,GiftsAr.class));
            }
        });
        Button contact_button_as = findViewById(R.id.Contact_US_as_ar);
        contact_button_as.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AboutAr.this,ContactAr.class));
            }
        });
        Button news_button_as = findViewById(R.id.Latest_news_as_ar);
        news_button_as.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(AboutAr.this,NewsARActivity.class));
            }
        });
    }
}