package com.delnortedevs.roompractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.delnortedevs.roompractice.db.TvShow;
import com.delnortedevs.roompractice.db.appDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ReadFragment extends Fragment {

    private appDatabase database;
    TvShow tempshow;

    public ReadFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        database = appDatabase.getInstance(getActivity());
        EditText buscarNombre;
        Button  button_buscar,button_update, button_delete;


        buscarNombre = view.findViewById(R.id.editText_buscaNombreShow);
        button_buscar= view.findViewById(R.id.btn_buscarShow);
        button_update = view.findViewById(R.id.btn_update);
        button_delete = view.findViewById(R.id.btn_delete);

        EditText nombre,categoria,score;


        nombre = view.findViewById(R.id.editText_ShowName);
        categoria = view.findViewById(R.id.editText_Category);
        score = view.findViewById(R.id.editText_Score);

        button_buscar.setOnClickListener(view1 -> {

            String nombreShow = buscarNombre.getText().toString();

            List<TvShow> show = database.getTvShowDao().SearchByNameMT("%"+nombreShow + "%");
            String foo = "";

            if (show.size() >0 ) {
                TvShow firstShow = show.get(0);
                tempshow = firstShow;
                nombre.setText(firstShow.getName());
                categoria.setText(firstShow.getCategory());
                score.setText( String.valueOf(firstShow.getScore()));
            }

        });


        button_update.setOnClickListener(view1 -> {

            String showName = nombre.getText().toString();
            String category =categoria.getText().toString();
            Integer tvscore = Integer.parseInt(score.getText().toString());

            TvShow show = new TvShow(showName,category,tvscore);
            show.setShow_id(tempshow.getShow_id());

            int update = database.getTvShowDao().updateTvShowMT(show);

            int foo = update;

            //updateTvShowMT


        });


        button_delete.setOnClickListener(view1 -> {

            TvShow show = tempshow;

            int delete = database.getTvShowDao().deleteTvShowMT(show);


        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read, container, false);
    }
}