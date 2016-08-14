package br.com.rads.couldhave.addsuggestion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rads.couldhave.BaseActivity;
import br.com.rads.couldhave.constants.Extra;
import br.com.rads.couldhave.R;
import br.com.rads.couldhave.data.store.RepositoryProvider;
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

        actionListener = new AddSuggestionPresenter(RepositoryProvider.provideRepository(), this);
    }

    @OnClick(R.id.add_suggestion_button)
    public void addSuggestion() {
        String suggestionName = addSuggestionEditText.getText().toString();
        if (!suggestionName.isEmpty()) {
            actionListener.addSuggestion(suggestionName, null);
        }
    }

    @Override
    public void successAddingSuggestion(Suggestion suggestion) {
        Toast.makeText(this, "Suggestion " + suggestion.getName() + " added with success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra(Extra.ADD_SUGGESTION, suggestion);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void failAddingSuggestion() {
        Toast.makeText(this, "Fail adding suggestion", Toast.LENGTH_SHORT).show();
    }
}
