package alnayzak.ict.ibraheem.scincehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GiftsAr extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<GiftData> mGiftsList;
    GiftData mGiftsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(GiftsAr.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mGiftsList = new ArrayList<>();
        mGiftsData = new GiftData(R.drawable.hoppers,getString(R.string.hoppersar), getString(R.string.hoppersardesc), getString(R.string.hoppersarmain));
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.enis,getString(R.string.enistinear),getString(R.string.enisardesc) ,null);
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.sciencemem,getString(R.string.scmemar), getString(R.string.scmemardesc),getString(R.string.scmemarmain));
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.tquest,getString(R.string.tqstar), getString(R.string.tquestardesc), getString(R.string.tquestarmain));
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.challange,getString(R.string.chlngar), getString(R.string.chlngardesc),getString(R.string.chlngarmain));
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.badir,getString(R.string.bdrar),getString(R.string.badirardesc),getString(R.string.badirarmain));
        mGiftsList.add(mGiftsData);
        GiftsARAdapter myAdapter = new GiftsARAdapter(GiftsAr.this, mGiftsList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
