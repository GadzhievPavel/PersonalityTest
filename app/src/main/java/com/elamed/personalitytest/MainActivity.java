package com.elamed.personalitytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AdapterTestingRecyclerView adapterTestingRecyclerView;
    private RecyclerView recyclerView;
    private Button button;
    //test
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<String> strings10 = new ArrayList<>();
    int I = 0;
    int STEP = 10;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for test
        for(int i = 0; i<100;i++){
            strings.add("Question  "+ i+"?");
        }

        for(int i =I ;i<STEP;i++){
            strings10.add(strings.get(i));
            I=i;
        }
        // for test

        recyclerView = findViewById(R.id.recycler_view);
        button=findViewById(R.id.next);
        adapterTestingRecyclerView = new AdapterTestingRecyclerView(getApplicationContext(),strings10);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapterTestingRecyclerView);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.next:
                for(int i=0; i < STEP;i++){
                    I++;
                    strings10.set(i,strings.get(I));
                    adapterTestingRecyclerView.notifyItemChanged(i);
                }
                break;
        }
    }


}