package alnayzak.ict.ibraheem.scincehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class Gifts extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<GiftData> mGiftsList;
    GiftData mGiftsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(Gifts.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mGiftsList = new ArrayList<>();
        mGiftsData = new GiftData(R.drawable.hoppers,getString(R.string.hoppers), getString(R.string.hopper_desc), getString(R.string.hopper_main));
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.enis,getString(R.string.enistine), getString(R.string.enis),"");
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.sciencemem,getString(R.string.sciencemem), getString(R.string.smd),getString(R.string.smm));
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.tquest,getString(R.string.tkwest), getString(R.string.tqd), getString(R.string.tqm));
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.challange,getString(R.string.chlng), getString(R.string.cyd),getString(R.string.cym));
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.badir,getString(R.string.thnk),getString(R.string.badird),getString(R.string.badirm));
        mGiftsList.add(mGiftsData);
        GiftsAdapter myAdapter = new GiftsAdapter(Gifts.this, mGiftsList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
