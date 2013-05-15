package br.com.atualidadesweb.injection;

import br.com.atualidadesweb.services.NewsService;
import com.google.inject.Provider;

public class NewsServiceProvider implements Provider<NewsService> {
    @Override public NewsService get() { return new NewsService(); }
}
