package br.com.rads.couldhave.addsuggestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rads.couldhave.BaseActivity;
import br.com.rads.couldhave.R;
import br.com.rads.couldhave.data.store.InMemorySuggestionRepository;
import br.com.rads.couldhave.data.store.RepositoryProvider;
import br.com.rads.couldhave.domain.interactor.AddSuggestionUseCase;
import br.com.rads.couldhave.domain.model.Suggestion;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddSuggestionActivity extends BaseActivity implements AddSuggestionContract.View {

    private AddSuggestionContract.UserAction actionListener;

    @BindView(R.id.add_suggestion_title_edit_text)
    EditText addSuggestionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_suggestion);
        ButterKnife.bind(this);

        actionListener = new AddSuggestionPresenter(RepositoryProvider.provideRepository(),this);
    }

    @OnClick(R.id.add_suggestion_button)
    public void addSuggestion() {
        String suggestionName = addSuggestionEditText.getText().toString();
        if (!suggestionName.isEmpty()) {
            actionListener.addSuggestion(suggestionName,null);
        }
    }

    @Override
    public void successAddingSuggestion(Suggestion suggestion) {
        //TODO: deliver result to previous activity
        Toast.makeText(this, "Suggestion " + suggestion.getName() + " added with success", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void failAddingSuggestion() {
        Toast.makeText(this, "Fail adding suggestion", Toast.LENGTH_SHORT).show();
    }
}
