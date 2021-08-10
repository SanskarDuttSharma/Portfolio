package com.example.porfolioapp.cv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.porfolioapp.R;

import java.util.ArrayList;
import java.util.List;


public class CVFragment extends Fragment {


    RecyclerView RvCv;
    CVAdapter adapter;
    List<CVItem> items;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RvCv = view.findViewById(R.id.recycleview_cv);


        //create a list of cv item
        items = new ArrayList<>();
        items.add(new CVItem("Higher Education:",getString(R.string.college_name)));
        items.add(new CVItem("Senior Secondary Education:",getString(R.string.senior_secondary)));
        items.add(new CVItem("Secondary Education:",getString(R.string.secondary_education)));

        adapter = new CVAdapter(items);

        RvCv.setLayoutManager(new LinearLayoutManager(getContext()));
        RvCv.setAdapter(adapter);


    }



    public CVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cv, container, false);
    }
}