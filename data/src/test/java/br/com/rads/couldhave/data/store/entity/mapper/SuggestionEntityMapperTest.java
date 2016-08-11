package br.com.rads.couldhave.data.store.entity.mapper;

import org.junit.Before;
import org.junit.Test;

import br.com.rads.couldhave.data.entity.SuggestionEntity;
import br.com.rads.couldhave.data.entity.mapper.SuggestionEntityMapper;
import br.com.rads.couldhave.domain.model.Suggestion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Rafael on 8/4/16.
 */

public class SuggestionEntityMapperTest {

    private SuggestionEntityMapper mapper;
    private SuggestionEntity entity;
    private Suggestion businessModel;

    @Before
    public void setUp() throws Exception {

        mapper = new SuggestionEntityMapper();

        entity = new SuggestionEntity("entity");
        entity.setDescription("entity desc");

        businessModel = new Suggestion("business");
        businessModel.setDescription("business desc");
    }

    @Test
    public void testEntityToBusinessModel() throws Exception {
        Suggestion mappedSuggestion = mapper.toSuggestion(entity);
        assertNotNull(mappedSuggestion);
        assertEquals(mappedSuggestion.getName(), entity.getName());
        assertEquals(mappedSuggestion.getDescription(), entity.getDescription());
    }

    @Test
    public void testBusinessModelToEnttity() throws Exception {
        SuggestionEntity mappedEntitySuggestion = mapper.toEntity(businessModel);
        assertNotNull(mappedEntitySuggestion);
        assertEquals(mappedEntitySuggestion.getName(), businessModel.getName());
        assertEquals(mappedEntitySuggestion.getDescription(), businessModel.getDescription());
    }
}
