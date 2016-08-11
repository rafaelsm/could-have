package br.com.rads.couldhave.domain;

import org.junit.Before;
import org.junit.Test;

import br.com.rads.couldhave.domain.model.Suggestion;

import static org.junit.Assert.*;

/**
 * Created by Rafael on 7/25/16.
 */
public class SuggestionTest {

    private static final String SUGGESTION_NAME = "First suggestion";
    private static final String SUGGESTION_DESC = "Add more tests!";
    private Suggestion suggestion;

    @Before
    public void setUp() throws Exception {
        suggestion = new Suggestion(SUGGESTION_NAME);
    }

    @Test
    public void test_SuggestionName() throws Exception {
        assertEquals(suggestion.getName(), SUGGESTION_NAME);
    }

    @Test
    public void test_SuggestionDesc(){
        suggestion.setDescription(SUGGESTION_DESC);
        assertEquals(suggestion.getDescription(), SUGGESTION_DESC);
    }
}