package br.com.atualidadesweb.activities;

import android.app.Application;
import android.content.Context;
import android.os.Vibrator;
import android.widget.ListView;
import br.com.atualidadesweb.R;
import br.com.atualidadesweb.domain.News;
import br.com.atualidadesweb.services.NewsService;
import com.google.inject.AbstractModule;
import com.google.inject.util.Modules;
import com.xtremelabs.robolectric.RobolectricTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;

import java.util.Arrays;

import static org.junit.Assert.*;
import  static org.mockito.MockitoAnnotations.*;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
public class TimeLineActivityTest {
    @Mock Application application;
    @Mock Context context;

    @Mock News aNews;
    @Mock NewsService newsService;

    @Before
    public void setUp() {
        initMocks(this);
        when(aNews.getTitle()).thenReturn("A some news");
        when(newsService.getNews()).thenReturn(Arrays.asList(aNews));

        when(context.getApplicationContext()).thenReturn(application);
        when(application.getApplicationContext()).thenReturn(application);

        RoboGuice.setBaseApplicationInjector(application, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(application)).with(new MyTestModule()));
    }

    @After
    public void tearDown() {
        RoboGuice.util.reset();
    }

    @Test
    public void shouldRenderListOfNews() {
        final TimeLineActivity timeLineActivity = RoboGuice.getInjector(context).getInstance(TimeLineActivity.class);
        timeLineActivity.onCreate(null);

        ListView listView = (ListView) timeLineActivity.findViewById(R.id.news);
        assertEquals(1, listView.getAdapter().getCount());
    }

    public class MyTestModule extends AbstractModule {
        @Override protected void configure() { bind(NewsService.class).toInstance(newsService); }
    }
}
