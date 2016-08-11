package br.com.rads.couldhave.addsuggestion;

import br.com.rads.couldhave.domain.datasource.SuggestionRepository;
import br.com.rads.couldhave.domain.interactor.AddSuggestionUseCase;
import br.com.rads.couldhave.domain.model.Suggestion;

/**
 * Created by Rafael on 8/4/16.
 */

public class AddSuggestionPresenter implements AddSuggestionContract.UserAction {

    private AddSuggestionUseCase useCase;
    private AddSuggestionContract.View addSuggestionView;

    public AddSuggestionPresenter(SuggestionRepository repository,
                                  AddSuggestionContract.View addSuggestionView) {
        this.addSuggestionView = addSuggestionView;
        useCase = new AddSuggestionUseCase(repository);
    }

    @Override
    public void addSuggestion(String name, String description) {
        Suggestion suggestion = new Suggestion(name);
        suggestion.setDescription(description);
        useCase.execute(suggestion);
        addSuggestionView.successAddingSuggestion(suggestion);
    }
}
