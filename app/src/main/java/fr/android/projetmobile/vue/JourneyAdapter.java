package fr.android.projetmobile.vue;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.android.projetmobile.R;
import fr.android.projetmobile.model.Journey;
import fr.android.projetmobile.outils.JourneyOpenHelper;

public class JourneyAdapter extends RecyclerView.Adapter<JourneyAdapter.JourneyViewHolder> {

    private final List<Journey> journeyList;
    private final JourneyOpenHelper journeyOpenHelper;

    public JourneyAdapter(List<Journey> journeyList, JourneyOpenHelper journeyOpenHelper) {

        this.journeyList = journeyList;
        this.journeyOpenHelper = journeyOpenHelper;
    }

    @NonNull
    @Override
    public JourneyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.journey_item, parent, false);
        return new JourneyViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull JourneyViewHolder holder, int position) {
        Journey journey = journeyList.get(position);
        holder.title.setText(journey.getTitle());
        holder.budget.setText(String.valueOf(journey.getBudget()));
        holder.description.setText(journey.getDescription());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journeyOpenHelper.deleteJourney(journey);
                journeyList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, journeyList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return journeyList.size();
    }


    public static class JourneyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView budget;
        public TextView description;
        public Button deleteButton;

        public JourneyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.Title);
            budget = view.findViewById(R.id.Budget);
            description = view.findViewById(R.id.Description);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
