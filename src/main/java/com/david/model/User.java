package com.david.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by david on 28/04/2017.
 */

@Entity
@Table(name = "[user]")
@SuppressWarnings("unused")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String user_name;

    private String password;

    @ElementCollection
    @CollectionTable(name = "user_favorite_movie")
    private Set<Long> favorites_movies;

    private boolean administrator;

    public User(String name, String user_name, String password) {
        this.name = name;
        this.user_name = user_name;
        this.password = password;
    }

    protected User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Long> getFavorites_movies() {
        return favorites_movies;
    }

    public void setFavorites_movies(Set<Long> favorites_movies) {
        this.favorites_movies = favorites_movies;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
