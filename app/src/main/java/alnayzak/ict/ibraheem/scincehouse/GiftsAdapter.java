package alnayzak.ict.ibraheem.scincehouse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class GiftsAdapter extends RecyclerView.Adapter<GiftViewHolder> {

    private Context mContext;
    private List<GiftData> mGiftList;

    GiftsAdapter(Context mContext, List<GiftData> mGiftList) {
        this.mContext = mContext;
        this.mGiftList = mGiftList;
    }

    @Override
    public GiftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item, parent, false);
        return new GiftViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final GiftViewHolder holder, int position) {
        holder.mImage.setImageResource(mGiftList.get(position).getGiftImage());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, GiftDetailsActivity.class);
                mIntent.putExtra("Title", mGiftList.get(holder.getAdapterPosition()).getGiftName());
                mIntent.putExtra("Skills", mGiftList.get(holder.getAdapterPosition()).getGiftMain());
                mIntent.putExtra("Description", mGiftList.get(holder.getAdapterPosition()).getGiftDescription());
                mIntent.putExtra("Image", mGiftList.get(holder.getAdapterPosition()).getGiftImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGiftList.size();
    }
}

class GiftViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    CardView mCardView;

    GiftViewHolder(View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.ivImage);
        mCardView = itemView.findViewById(R.id.cardview);
    }
}