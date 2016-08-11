package br.com.rads.couldhave.domain.datasource;

import java.util.List;

import br.com.rads.couldhave.domain.model.Suggestion;

/**
 * Created by Rafael on 7/27/16.
 */

public interface SuggestionRepository {
    List<Suggestion> getAllSuggestions();
    void saveSuggestion(Suggestion suggestion);
    void removeSuggestion(Suggestion suggestion);
}
