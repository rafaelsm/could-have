package br.com.rads.couldhave.data.store;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Rafael on 8/10/16.
 */
public class RepositoryProviderTest {

    @Test
    public void testProvideRepository() throws Exception {
        assertNotNull(RepositoryProvider.provideRepository());
    }
}