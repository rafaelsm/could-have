package br.com.rads.couldhave.domain.interactor;

/**
 * Created by Rafael on 7/27/16.
 */

public interface UseCase<Argument> {
    void execute(Argument arg);
}
