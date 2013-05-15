package br.com.atualidadesweb.injection;

import br.com.atualidadesweb.services.NewsService;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class AtualidadesWebModule extends AbstractModule {
    @Override protected void configure() {
        bind(NewsService.class).toProvider(NewsServiceProvider.class).in(Singleton.class);
    }
}
