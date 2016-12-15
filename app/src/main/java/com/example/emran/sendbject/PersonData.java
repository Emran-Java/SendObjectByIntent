package com.example.emran.sendbject;

import java.io.Serializable;

/**
 * Created by emran on 11/9/2015.
 */
public class PersonData implements Serializable {


    private String name;
    private String id;

    public PersonData(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
