package com.wkrzywiec.medium.periodicquotes.retrofit;

import com.wkrzywiec.medium.periodicquotes.model.ChuckNorrisJoke;
import retrofit2.http.GET;
import rx.Observable;

public interface ChuckNorrisJokesApi {

    @GET("/jokes/random")
    Observable<ChuckNorrisJoke> randomJoke();
}
