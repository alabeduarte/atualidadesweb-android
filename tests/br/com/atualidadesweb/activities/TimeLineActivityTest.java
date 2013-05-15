package br.com.atualidadesweb.activities;


import android.widget.ListView;
import br.com.atualidadesweb.R;
import br.com.atualidadesweb.domain.News;
import br.com.atualidadesweb.injection.InjectedTestRunner;
import br.com.atualidadesweb.injection.TestGuiceModule;
import br.com.atualidadesweb.services.NewsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(InjectedTestRunner.class)
public class TimeLineActivityTest {
    @Mock NewsService newsServiceMock;
    TimeLineActivity timeLineActivity;

    @Before
    public void setUp() {
        initMocks(this);
        TestGuiceModule module = new TestGuiceModule();
        module.addBinding(NewsService.class, newsServiceMock);
        TestGuiceModule.setUp(this, module);
    }

    @After
    public void tearDown() {
        TestGuiceModule.tearDown();
    }

    @Test
    public void shouldRenderListOfNews() {
        when(this.newsServiceMock.getNews()).thenReturn(Arrays.asList(new News()));

        this.timeLineActivity = new TimeLineActivity();
        this.timeLineActivity.onCreate(null);

        ListView listView = (ListView) this.timeLineActivity.findViewById(R.id.news);
        assertEquals(1, listView.getAdapter().getCount());
    }

}
