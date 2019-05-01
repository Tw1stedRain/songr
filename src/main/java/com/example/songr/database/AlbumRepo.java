package com.example.songr.database;

import com.example.songr.database.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepo extends CrudRepository<Album, Long> {
}
