package com.david.model;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.List;

/**
 * Created by david on 26/04/2017.
 */

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_id")
    @SerializedName("_id")
    private Long id;

    @SerializedName("poster_path")
    private String posterPath;

    @Lob
    @Column
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("genre_ids")
    @ElementCollection
    @CollectionTable(name = "genre_ids")
    private List<Long> genreIds;

    @SerializedName("id")
    @Column(unique = true)
    private long originalId;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("original_language")
    private String originalLanguage;

    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath;

    private float popularity;

    @SerializedName("vote_count")
    private long voteCount;

    @SerializedName("vote_average")
    private float voteAverage;

    protected Movie () {}

    public Long getId() {
        return id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public long getOriginalId() {
        return originalId;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public float getPopularity() {
        return popularity;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

}
