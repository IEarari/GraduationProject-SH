package alnayzak.ict.ibraheem.scincehouse;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static alnayzak.ict.ibraheem.scincehouse.NewsActivity.LOG_TAG;


public class QueryUtils {


    private QueryUtils() {
    }

    public static List<News> fetchNewsData(String requestUrl) {

        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
            Log.e(LOG_TAG, jsonResponse);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        ArrayList<News> news = extractNews(jsonResponse);

        return news;
    }

    private static ArrayList<News> extractNews(String newsJSON) {
        ArrayList<News> news = new ArrayList<>();

        try {
            JSONArray newsArray = new JSONObject(newsJSON).getJSONArray("items");
            String title = "", datePublished = "", url = "";
            for (int i = 0; i < newsArray.length(); i++) {
                try {
                    if (newsArray.getJSONObject(i).has("title"))
                        title = newsArray.getJSONObject(i).getString("title");
                    if (newsArray.getJSONObject(i).has("published"))
                        datePublished = newsArray.getJSONObject(i).getString("published");
                    if (newsArray.getJSONObject(i).has("url"))
                        url = newsArray.getJSONObject(i).getString("url");
                    news.add(new News(title, datePublished, url));
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Problem 1");
                }
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Problem !");
        }
        return news;
    }


    private static URL createUrl(String stringUrl) {

        URL url;

        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException exception) {
            Log.e(LOG_TAG, "Error with creating URL", exception);
            return null;
        }

        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the news JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder output = new StringBuilder();

        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();

            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

}