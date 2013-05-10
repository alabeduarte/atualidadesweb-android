package br.com.atualidadesweb.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import br.com.atualidadesweb.R;
import br.com.atualidadesweb.domain.News;
import br.com.atualidadesweb.services.NewsService;

import java.util.ArrayList;
import java.util.List;

public class TimeLineActivity extends Activity {

    private NewsService newsService;
    private List<String> items = new ArrayList<String>();
    private ListView listView;

    public TimeLineActivity(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.listView = (ListView)findViewById(R.id.news);
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
