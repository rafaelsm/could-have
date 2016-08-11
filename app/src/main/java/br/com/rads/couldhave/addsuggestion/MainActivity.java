package br.com.rads.couldhave.addsuggestion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import br.com.rads.couldhave.BaseActivity;
import br.com.rads.couldhave.R;
import br.com.rads.couldhave.data.store.InMemorySuggestionRepository;
import br.com.rads.couldhave.domain.model.Suggestion;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_suggestion_fab)
    void addSuggestion() {
        startActivity(new Intent(MainActivity.this, AddSuggestionActivity.class));
    }

}
