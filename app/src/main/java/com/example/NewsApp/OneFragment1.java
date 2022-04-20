package com.example.NewsApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OneFragment1 extends Fragment {

    Integer[] imageList = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4, R.drawable.photo5, R.drawable.photo6};
    String[] smallDescription = {"A Holy Week procession ...", "Couple say goodbye at ...", "A boy in the ruins of ...", "A leaping tiger and migrating ..."};
    String[] newsSource = {"9NEWS", "7NEWS", "ABC NEWS", "THE AGE"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one1, container, false);




        return view;
    }
}