package br.com.rads.couldhave.data.store;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import br.com.rads.couldhave.data.entity.SuggestionEntity;
import br.com.rads.couldhave.domain.model.Suggestion;

import static org.junit.Assert.*;

/**
 * Created by Rafael on 7/27/16.
 */
public class InMemorySuggestionRepositoryTest {

    @Mock
    InMemorySuggestionRepository mockedInMemorySuggestionEntityStore;

    private InMemorySuggestionRepository inMemorySuggestionEntityStore;

    private static List<Suggestion> MOCKED_LIST = Lists.newArrayList(
            new Suggestion("suggestion 1"),
            new Suggestion("suggestion 2"),
            new Suggestion("suggestion 3")
    );

    private static Suggestion MOCKED_SUGGESTION = new Suggestion("single mocked suggestion");

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        inMemorySuggestionEntityStore = InMemorySuggestionRepository.getInstance();
    }

    @Test
    public void getAllSuggestions() throws Exception {
        Mockito.when(mockedInMemorySuggestionEntityStore.getAllSuggestions()).thenReturn(MOCKED_LIST);
        assertNotNull(mockedInMemorySuggestionEntityStore.getAllSuggestions());
    }

    @Test
    public void addAndRemoveSuggestion() {
        inMemorySuggestionEntityStore.saveSuggestion(MOCKED_SUGGESTION);
        assertEquals(1, inMemorySuggestionEntityStore.getAllSuggestions().size());

        inMemorySuggestionEntityStore.removeSuggestion(MOCKED_SUGGESTION);
        assertEquals(false, inMemorySuggestionEntityStore.getAllSuggestions().contains(MOCKED_SUGGESTION));
    }

}