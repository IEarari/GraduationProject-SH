package alnayzak.ict.ibraheem.scincehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    public static String TAG = "NewsActivity";

    private RecyclerView recyclerView;
    private ArrayList<News> newsList;
    private NewsAdapter NewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = findViewById(R.id.recycler);
        newsList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        for (int z = 0; z < 3; z++) {
            DatabaseReference myRef = database.getReference(String.valueOf(R.string.dbref)).child(String.valueOf(z)).child(String.valueOf(R.string.dbengref));

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    newsList.add(new News(value));
                    NewsAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Log.w(TAG, String.valueOf(R.string.faildfirebasedb), error.toException());
                }
            });
        }
        NewsAdapter = new NewsAdapter(this, newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(NewsAdapter);
    }
}
