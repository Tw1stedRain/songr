# Album Controller

`getAlbums`
path: localhost:8080/albums/

- when run, returns all albums in the database

`getAlbum`
path: localhost:8080/albums/album/{id}

- when run, returns album of requested id

`createAlbum`
path: localhost:8080/albums/album

- when run, creates a new album, sends it to the database, and then returns the just created album

`updateAlbum`
path: localhost:8080/albums/album/{id}

- when run, updates the id requested album, and then returns the newly updated album

`deleteAlbum`
path: localhost:8080/albums/album/{id}

- when run, deletes the id requested album
