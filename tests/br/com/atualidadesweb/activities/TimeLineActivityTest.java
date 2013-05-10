package br.com.atualidadesweb.activities;

import android.widget.ListView;
import br.com.atualidadesweb.R;
import br.com.atualidadesweb.domain.News;
import br.com.atualidadesweb.services.NewsService;
import com.xtremelabs.robolectric.RobolectricTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.*;
import  static org.mockito.MockitoAnnotations.*;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
public class TimeLineActivityTest {

    @Mock private News aNews;
    @Mock private NewsService newsService;

    private TimeLineActivity timeLineActivity;

    @Before
    public void setUp() {
        initMocks(this);
        when(aNews.getTitle()).thenReturn("A some news");
        when(newsService.getNews()).thenReturn(Arrays.asList(aNews));

        timeLineActivity = new TimeLineActivity(newsService);
        timeLineActivity.onCreate(null);
    }

    @Test
    public void shouldRenderListOfNews() {
        ListView listView = (ListView) timeLineActivity.findViewById(R.id.news);

        assertEquals(1, listView.getAdapter().getCount());
    }
}
