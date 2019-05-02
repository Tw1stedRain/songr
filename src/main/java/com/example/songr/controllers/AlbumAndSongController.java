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
@RequestMapping("/albumShop")
public class AlbumAndSongController {

    @Autowired
    SongRepo repo;

    @Autowired
    AlbumRepo albumRepo;

    // list songs
    @GetMapping
    public String getSongs(Model model) {
        List<Song> songs = repo.findAll();
        List<Album> albums = albumRepo.findAll();

        model.addAttribute("songs", songs);
        model.addAttribute("albums", albums);

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

        return new RedirectView("/albumShop");
    }

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
            return "song";
        }
        throw new AlbumNotFoundExecption();
    }

    // stretch goal
//    @PostMapping("/update")
//    public RedirectView updateSong(){}
}
