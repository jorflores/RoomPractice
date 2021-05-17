package com.delnortedevs.roompractice;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.delnortedevs.roompractice.db.TvShow;
import com.delnortedevs.roompractice.db.appDatabase;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class CreateFragment extends Fragment {

    private appDatabase database;

    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        database = appDatabase.getInstance(getActivity());


        EditText tvshowname,tvcategory,tvscore;
        Button btnAddTvshow;

        tvshowname = view.findViewById(R.id.editText_TvShowName);
        tvcategory = view.findViewById(R.id.editText_Category);
        tvscore = view.findViewById(R.id.editText_Score);

        btnAddTvshow = view.findViewById(R.id.btn_addTvShow);


        btnAddTvshow.setOnClickListener(view1 -> {

            String showName = tvshowname.getText().toString();
            String category =tvcategory.getText().toString();
            Integer score = Integer.parseInt(tvscore.getText().toString());

            TvShow show = new TvShow(showName,category,score);
            String foo = "";


          Long id =   database.getTvShowDao().insertTvShowMT(show);

        //    Observable.fromCallable(() -> database.getTvShowDao().insertTvShow())

    /*database.getTvShowDao().insertTvShow(show).subscribeOn(Schedulers.io()).subscribe(newshow -> {

            }, throwable -> {
                Log.i("error", throwable.toString());
            });*/


         Toast.makeText(getActivity(), "New Show added: " , Toast.LENGTH_SHORT).show();


        });





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false);
    }
}