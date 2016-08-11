package br.com.rads.couldhave.addsuggestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.rads.couldhave.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddSuggestionActivity extends AppCompatActivity {

    @BindView(R.id.add_suggestion_title_edit_text)
    EditText addSuggestionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_suggestion);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_suggestion_button)
    public void addSuggestion(){
        int minDigits = 3;
        if (addSuggestionEditText.getText().length() > minDigits) {
            finish();
        }
    }
}
