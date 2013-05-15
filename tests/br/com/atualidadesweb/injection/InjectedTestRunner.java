package br.com.atualidadesweb.injection;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.runners.model.InitializationError;

import static roboguice.RoboGuice.getInjector;

public class InjectedTestRunner extends RobolectricTestRunner {
    public InjectedTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override public void prepareTest(Object test) {
        getInjector(Robolectric.application).injectMembers(test);
    }
}
