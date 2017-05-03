package com.david.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by david on 02/05/2017.
 */

@Entity
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

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

    public Role(String name) {
        this.name = name;
    }

    protected Role() {}

    @Override
    public String getAuthority() {
        return this.name;
    }
}
