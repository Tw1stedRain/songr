package com.example.songr.controllers;

import com.example.songr.database.Album;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AlbumControllerTest {

    @Autowired
    AlbumController albumController;

    @Test
    public void testAlbumController() {
        List<Album> albums = (List<Album>) albumController.getAlbums();
        assertEquals(0, albums.size());
    }

}