package com.elamed.personalitytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterTestingRecyclerView extends RecyclerView.Adapter<AdapterTestingRecyclerView.MyViewHolder> {

    private ArrayList<String> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterTestingRecyclerView(Context context, ArrayList<String> list){
        this.context = context;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_rating,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.question.setText(list.get(position));
        holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                holder.score.setText(String.valueOf(convertSeekBarToString(seekBar.getProgress())));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        SeekBar seekBar;
        TextView question;
        TextView score;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            seekBar = itemView.findViewById(R.id.seek_bar);
            question = itemView.findViewById(R.id.question);
            score = itemView.findViewById(R.id.score);
        }
    }

    private String convertSeekBarToString(int i){
        String s="";
        switch (String.valueOf(i)){
            case "0":
                s = "Нет";
                break;
            case "1":
                s = "Скорее нет";
                break;
            case "2":
                s = "Нейтрально";
                break;
            case "3":
                s = "Скорее да";
                break;
            case "4":
                s = "Да";
                break;
        }
        return s;
    }
}
