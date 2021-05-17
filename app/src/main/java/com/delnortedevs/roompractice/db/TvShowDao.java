package com.delnortedevs.roompractice.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TvShowDao {

    @Query("Select * FROM TvShow where name = :name")
    Single<TvShow> SearchByName(String name);

    @Query("Select * FROM TvShow where name like :name")
    List<TvShow> SearchByNameMT(String name);

    @Insert
    Single<Long> insertTvShow(TvShow tvShow);

    @Insert
    Long insertTvShowMT(TvShow tvShow);

    @Update
    Completable updateTvShow(TvShow... tvShows);

    @Update
    int updateTvShowMT(TvShow... tvShows);


    @Delete
    Completable deleteTvShow(TvShow... tvShows);


    @Delete
    int deleteTvShowMT(TvShow... tvShows);

}
