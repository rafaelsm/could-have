package br.com.rads.couldhave.addsuggestion;

import br.com.rads.couldhave.domain.model.Suggestion;

/**
 * Created by Rafael on 8/4/16.
 */

public interface AddSuggestionContract {

    interface View{
        void showSuggestions();
        void updateSuggestionList(Suggestion newSuggestion);
    }

    interface UserAction{
        void addSuggestion(String name, String description);
    }

}
