package br.com.rads.couldhave.data.store;

import java.util.ArrayList;
import java.util.List;

import br.com.rads.couldhave.data.entity.SuggestionEntity;
import br.com.rads.couldhave.data.entity.mapper.SuggestionEntityMapper;
import br.com.rads.couldhave.domain.model.Suggestion;
import br.com.rads.couldhave.domain.datasource.SuggestionRepository;

/**
 * Created by Rafael on 7/27/16.
 */

public class InMemorySuggestionRepository implements SuggestionRepository {

    private SuggestionEntityMapper entityMapper;
    private List<SuggestionEntity> suggestions;

    public InMemorySuggestionRepository() {
        this.entityMapper = new SuggestionEntityMapper();
        this.suggestions = new ArrayList<>();
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        return entityMapper.toSuggestion(suggestions);
    }

    @Override
    public void saveSuggestion(Suggestion suggestion) {
        suggestions.add(entityMapper.toEntity(suggestion));
    }

    @Override
    public void removeSuggestion(Suggestion suggestion) {
        suggestions.remove(entityMapper.toEntity(suggestion));
    }

}
