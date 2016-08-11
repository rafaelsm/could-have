package br.com.rads.couldhave.domain.interactor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.rads.couldhave.domain.model.Suggestion;
import br.com.rads.couldhave.domain.datasource.SuggestionRepository;

/**
 * Created by Rafael on 8/1/16.
 */

public class AddSuggestionUseCaseTest {

    private static final Suggestion suggestion = new Suggestion("suggestion mock");

    @Mock
    SuggestionRepository suggestionRepository;

    private AddSuggestionUseCase useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase = new AddSuggestionUseCase(suggestionRepository);
    }

    @Test
    public void testAddSuggestion() throws Exception{
        useCase.execute(suggestion);
        Mockito.verify(suggestionRepository).saveSuggestion(suggestion);
    }

    @Test
    public void testSuggestionNameCannotBeEmpty() throws Exception {
        assertEmptySuggestionFail(null);
        assertEmptySuggestionFail(new Suggestion(null));
        assertEmptySuggestionFail(new Suggestion(""));
        assertEmptySuggestionFail(new Suggestion("   "));
    }

    private void assertEmptySuggestionFail(Suggestion suggestion) {
        try {
            useCase.execute(suggestion);
            Assert.fail();
        } catch (IllegalArgumentException e){
            Mockito.verifyZeroInteractions(suggestionRepository);
        }
    }

}
