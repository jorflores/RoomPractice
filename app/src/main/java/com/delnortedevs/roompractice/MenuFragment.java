package com.delnortedevs.roompractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {

    NavController navController = null;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        Button buttonCreate = view.findViewById(R.id.btn_create);
        Button buttonRead = view.findViewById(R.id.btn_read);
        Button buttonUpdate = view.findViewById(R.id.btn_update);
        Button buttonDelete = view.findViewById(R.id.btn_delete);


        buttonCreate.setOnClickListener(view1 -> {
            navController.navigate(R.id.action_menuFragment_to_createFragment);
        });

        buttonRead.setOnClickListener(view1 -> {
            navController.navigate(R.id.action_menuFragment_to_readFragment);
        });





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
}