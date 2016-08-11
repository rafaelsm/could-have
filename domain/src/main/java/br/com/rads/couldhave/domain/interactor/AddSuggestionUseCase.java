package br.com.rads.couldhave.domain.interactor;

import br.com.rads.couldhave.domain.model.Suggestion;
import br.com.rads.couldhave.domain.datasource.SuggestionRepository;

public class AddSuggestionUseCase implements UseCase<Suggestion>{

    private SuggestionRepository dataSource;

    public AddSuggestionUseCase(SuggestionRepository dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void execute(Suggestion suggestion) {
        if (suggestion == null || suggestion.getName() == null || suggestion.getName().trim().isEmpty()){
            throw new IllegalArgumentException("Suggestion name cannot be empty");
        }
        dataSource.saveSuggestion(suggestion);
    }
}
