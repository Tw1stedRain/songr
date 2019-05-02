package com.example.songr.controllers;


import com.example.songr.database.Album;
import com.example.songr.database.AlbumRepo;
import com.example.songr.database.Song;
import com.example.songr.database.SongRepo;
import com.example.songr.exceptions.AlbumNotFoundExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    SongRepo repo;

    @Autowired
    AlbumRepo albumRepo;

    // get all songs
    @GetMapping
    public String getSongs(Model model) {

        List<Song> songs = this.repo.findAll();

        model.addAttribute("songs", songs);

        return "songs";
    }

    // create a song
    @PostMapping("/create")
    public RedirectView createSong(
            @RequestParam String title,
            @RequestParam int length,
            @RequestParam int trackNumber
    ) {
        Song song = new Song();
        song.title = title;
        song.length = length;
        song.trackNumber = trackNumber;

        song = repo.save(song);

        return new RedirectView("/songs");

    }

    // get a song
    @GetMapping("/song/{id}")
    public String getSong(
            @PathVariable Long id,
            Model model
    ) {

        Optional<Song> foundSong = repo.findById(id);

        if (foundSong.isPresent()) {
            List<Album> albums = albumRepo.findAll();
            model.addAttribute("albums", albums);
            model.addAttribute("song", foundSong.get());
            return "songs";
        } else {
            throw new AlbumNotFoundExecption();
        }
    }

    // update a song
    // note to self: if doesn't work; stretch goal. ok
    @PostMapping("/update")
    public RedirectView updateSong(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam int length,
            @RequestParam int trackNumber,
            @RequestParam long album
    ) {
        Optional<Song> foundSong = repo.findById(id);

        Optional<Album> foundAlbum = albumRepo.findById(album);

        if (foundSong.isPresent() && foundAlbum.isPresent()) {
            Song song = foundSong.get();
            Album local = foundAlbum.get();
            song.title = title;
            song.length = length;
            song.trackNumber = trackNumber;
            song.album = local;
            song = repo.save(song);
        } else {
            throw new AlbumNotFoundExecption();
        }
        return new RedirectView("/songs");
    }


    // delete a song
    // note to self: if doesn't work; stretch goal. ok

    @DeleteMapping("/song/{id}")
    public void deleteSong(
            @PathVariable Long id
    ) {
        this.repo.deleteById(id);
    }

}
