package br.com.rads.couldhave.domain.model;

/**
 * Created by Rafael on 7/25/16.
 */

public class Suggestion {

    private String name;
    private String description;

    public Suggestion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
