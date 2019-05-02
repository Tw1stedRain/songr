package com.example.songr.database;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue
    public long id;

    @ManyToOne
    public Album album;


    public String title;
    public int length;
    public int trackNumber;

}
