package alnayzak.ict.ibraheem.scincehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class GiftDetailsARActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView mFlower;
    TextView mDescription,mSkills ,mST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gift_detail_ar);
        mToolbar = findViewById(R.id.toolbar_ar);
        mFlower = findViewById(R.id.ivImage_ar);
        mDescription = findViewById(R.id.tvDescription_ar);
        mSkills = findViewById(R.id.tvSkills_ar);
        mST = findViewById(R.id.STitle_ar);
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null && mBundle.getString(getString(R.string.skills)) != null) {
            mToolbar.setTitle(mBundle.getString(getString(R.string.title)));
            mFlower.setImageResource(mBundle.getInt(getString(R.string.image)));
            mDescription.setText(mBundle.getString(getString(R.string.description)));
            mSkills.setText(mBundle.getString(getString(R.string.skills)));
        }
        else if(mBundle != null){
            mToolbar.setTitle(mBundle.getString(getString(R.string.title)));
            mFlower.setImageResource(mBundle.getInt(getString(R.string.image)));
            mDescription.setText(mBundle.getString(getString(R.string.description)));
            mSkills.setVisibility(View.INVISIBLE);
            mST.setVisibility(View.INVISIBLE);
        }
    }
}