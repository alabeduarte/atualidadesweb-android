package br.com.atualidadesweb.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import br.com.atualidadesweb.R;
import br.com.atualidadesweb.domain.News;
import br.com.atualidadesweb.services.NewsService;
import com.google.inject.Inject;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.main)
public class TimeLineActivity extends RoboActivity {

    @Inject protected NewsService newsService;
    @InjectView(R.id.news) private ListView listView;

    private List<String> items = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.listView.setAdapter(this.createAdapter());
        List<News> news = this.newsService.getNews();
        for (News aNews: news) {
            this.items.add(aNews.getTitle());
        }
    }

    private BaseAdapter createAdapter() {
        BaseAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.items);
        adapter.notifyDataSetChanged();
        return adapter;
    }
}
