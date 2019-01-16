package alnayzak.ict.ibraheem.scincehouse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }

    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context c, List<News> list) {
        this.context = c;
        newsList = list;
    }


    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_news, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int i) {
        News n = newsList.get(i);
        viewHolder.title.setText(n.getTitle());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
