package br.com.rads.couldhave.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.rads.couldhave.data.entity.SuggestionEntity;
import br.com.rads.couldhave.domain.model.Suggestion;

/**
 * Created by Rafael on 8/3/16.
 */

public class SuggestionEntityMapper {

    public SuggestionEntity toEntity(Suggestion suggestion) {
        SuggestionEntity suggestionEntity = new SuggestionEntity(suggestion.getName());
        suggestionEntity.setDescription(suggestion.getDescription());
        return suggestionEntity;
    }

    public List<Suggestion> toSuggestion(List<SuggestionEntity> entities){
        List<Suggestion> suggestions = new ArrayList<>();
        for (SuggestionEntity entity : entities) {
            suggestions.add(toSuggestion(entity));
        }
        return suggestions;
    }

    public Suggestion toSuggestion(SuggestionEntity entity) {
        Suggestion suggestion = new Suggestion(entity.getName());
        suggestion.setDescription(entity.getDescription());
        return suggestion;
    }
}
