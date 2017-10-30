package com.hva.robingraaf.carwash.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.hva.robingraaf.carwash.Activity.ProgramDetailsActivity;
import com.hva.robingraaf.carwash.R;
import com.hva.robingraaf.carwash.Object.WashProgram;

import java.util.List;

/**
 * Created by Robin on 15-10-2017.
 */

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder> {

    private Context context;
    public List<WashProgram> listWashProgram;

    public ProgramAdapter(Context context, List<WashProgram> listWashProgram) {
        this.context = context;
        this.listWashProgram = listWashProgram;
    }

    @Override
    public int getItemCount() {
        return listWashProgram.size();
    }

    private WashProgram getItem(int pos) {
        return listWashProgram.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return listWashProgram.get(pos).getmProgramImage();
    }

    public void updateList(List<WashProgram> newlist) {
        listWashProgram.clear();
        listWashProgram.addAll(newlist);
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProgramViewHolder holder, final int position) {
        holder.populateRow(getItem(position));
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView programImage;

        public ProgramViewHolder(View view) {
            super(view);
            programImage = (ImageView) itemView.findViewById(R.id.programImageView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Go to info", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, ProgramDetailsActivity.class);
            WashProgram selectedProgram = getItem(getAdapterPosition());
            intent.putExtra("selectedProgram", selectedProgram);
            context.startActivity(intent);
        }

        public void populateRow(WashProgram program) {
            programImage.setImageResource(program.getmProgramImage());
        }
    }

}
