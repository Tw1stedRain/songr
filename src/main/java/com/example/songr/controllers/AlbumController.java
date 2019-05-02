package com.example.songr.controllers;

import com.example.songr.database.Album;
import com.example.songr.exceptions.AlbumNotFoundExecption;
import com.example.songr.database.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumRepo repo;

    @GetMapping("/")
    public Iterable<Album> getAlbums() {
        //creating an album
        Album album = new Album();
        album.title = "The Fantastic Bob";
        album.artist = "Bob the Fantastic";
        album.songCount = 5;
        album.length = 924;
        album.imageUrl = "https://pixnio.com/free-images/2017/09/26/2017-09-26-09-25-10-825x825.jpg";

        this.repo.save(album);

        Iterable<Album> albums = this.repo.findAll();
        return albums;
    }

    @GetMapping("/album/{id}")
    public Album getAlbum(
            @PathVariable Long id
    ) {
        Optional<Album> album = this.repo.findById(id);
        if (album.isPresent()) {
            return album.get();
        } else {
            throw new AlbumNotFoundExecption();
        }
    }

    @PostMapping("/album")
    public Album createAlbum(
            @RequestBody Album album
    ) {
        album = this.repo.save(album);

        return album;
    }

    @PutMapping("/album/{id}")
    public Album updateAlbum(
            @PathVariable Long id,
            @RequestBody Album album
    ) {
        Optional<Album> repoAlbum = this.repo.findById(id);

        if (repoAlbum.isPresent()) {
            Album foundAlbum = repoAlbum.get();

            foundAlbum.title = album.title;
            foundAlbum.artist = album.artist;
            foundAlbum.songCount = album.songCount;
            foundAlbum.length = album.length;
            album.imageUrl = album.imageUrl;

            foundAlbum = this.repo.save(foundAlbum);
            return foundAlbum;
        }
        throw new AlbumNotFoundExecption();
    }

    // note to self: if doesn't work; stretch goal. ok
    @DeleteMapping("/album/{id}")
    public void deleteAlbum(
            @PathVariable Long id
    ) {
        this.repo.deleteById(id);
    }
}
