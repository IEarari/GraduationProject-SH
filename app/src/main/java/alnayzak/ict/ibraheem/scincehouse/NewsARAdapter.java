package alnayzak.ict.ibraheem.scincehouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsARAdapter extends ArrayAdapter<News> {

    public NewsARAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_ar_news, parent, false);

        News currentNews = getItem(position);
        TextView titleView = convertView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitolo());
        titleView.setSelected(true);
        TextView datePublishedView = convertView.findViewById(R.id.data);
        datePublishedView.setText(formatDate(currentNews.getdatapubblicata()));

        return convertView;
    }

    private String formatDate(String stringDate) {

        String formattedDate = stringDate.substring(0, stringDate.indexOf('T')) + ", " +
                stringDate.substring(stringDate.indexOf('T') + 1, stringDate.length() - 1);

        return formattedDate;
    }
}
