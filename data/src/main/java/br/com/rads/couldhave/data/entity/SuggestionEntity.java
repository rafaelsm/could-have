package br.com.rads.couldhave.data.entity;

import java.util.Date;

/**
 * Created by Rafael on 7/27/16.
 */

public class SuggestionEntity {

    private String name;
    private String description;
    private Date syncDate;

    public SuggestionEntity(String name) {
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

    public Date getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }
}
