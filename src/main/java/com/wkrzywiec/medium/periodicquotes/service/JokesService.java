package com.wkrzywiec.medium.periodicquotes.service;

import com.wkrzywiec.medium.periodicquotes.model.ChuckNorrisJoke;
import com.wkrzywiec.medium.periodicquotes.model.ChuckNorrisJokeValue;
import com.wkrzywiec.medium.periodicquotes.retrofit.ChuckNorrisJokesApi;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

@Service
public class JokesService {

    private ChuckNorrisJokesApi chuckNorrisJokesApi;

    JokesService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.icndb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        chuckNorrisJokesApi = retrofit.create(ChuckNorrisJokesApi.class);
    }

    public Observable<String> getRandomChuckNorrisJoke(){

        return chuckNorrisJokesApi.randomJoke()
                .map(ChuckNorrisJoke::getValue)
                .map(ChuckNorrisJokeValue::getJoke);

    }
}
