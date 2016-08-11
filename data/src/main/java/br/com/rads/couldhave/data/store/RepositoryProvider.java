package br.com.rads.couldhave.data.store;

import br.com.rads.couldhave.domain.datasource.SuggestionRepository;

/**
 * Created by Rafael on 8/10/16.
 */

public class RepositoryProvider {

    public static SuggestionRepository provideRepository(){
        return InMemorySuggestionRepository.getInstance();
    }

}
