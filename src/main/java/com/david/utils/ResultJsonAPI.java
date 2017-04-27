package com.david.utils;

import com.david.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by david on 26/04/2017.
 */
public class ResultJsonAPI {

    private Long page;
    private List<Movie> results;

    public Long getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }

}
