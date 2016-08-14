package br.com.rads.couldhave.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import br.com.rads.couldhave.BaseActivity;
import br.com.rads.couldhave.R;
import br.com.rads.couldhave.addsuggestion.AddSuggestionActivity;
import br.com.rads.couldhave.constants.Extra;
import br.com.rads.couldhave.domain.model.Suggestion;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private static final int ADD_SUGGESTION_REQUEST_CODE = 1111;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private SuggestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupList();

    }

    private void setupList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SuggestionAdapter(new ArrayList<Suggestion>());
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.add_suggestion_fab)
    void addSuggestion() {
        startActivityForResult(new Intent(MainActivity.this, AddSuggestionActivity.class), ADD_SUGGESTION_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == ADD_SUGGESTION_REQUEST_CODE) {
                adapter.add((Suggestion) data.getSerializableExtra(Extra.ADD_SUGGESTION));
            }
        }
    }
}
