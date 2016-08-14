package br.com.rads.couldhave.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import br.com.rads.couldhave.R;
import br.com.rads.couldhave.domain.model.Suggestion;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rafael on 8/11/16.
 */

public class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.ViewHolder> {

    private List<Suggestion> suggestions;

    public SuggestionAdapter(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public SuggestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_suggestion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SuggestionAdapter.ViewHolder holder, int position) {
        Suggestion suggestion = suggestions.get(position);
        holder.title.setText(suggestion.getName());
    }

    @Override
    public int getItemCount() {
        return suggestions.size();
    }

    public void add(Suggestion suggestion) {
        suggestions.add(0,suggestion);
        notifyItemChanged(0);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.suggestion_title_text_view)
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
