insert into artist (id, description, members, name) values (1, 'Nondisplaced fracture of anterior wall of right acetabulum, subsequent encounter for fracture with nonunion', 'Robert Martinez', 10129);
insert into artist (id, description, members, name) values (2, 'Rheumatoid arthritis with rheumatoid factor of left ankle and foot without organ or systems involvement', 'Jane Smith', 10394);
insert into artist (id, description, members, name) values (3, 'Other juvenile arthritis, unspecified elbow', 'Sarah Thompson', 10590);
insert into artist (id, description, members, name) values (4, 'Sedative, hypnotic or anxiolytic dependence with withdrawal delirium', 'Sarah Thompson', 10772);
insert into artist (id, description, members, name) values (5, 'Toxic effect of venom of hornets, intentional self-harm, sequela', 'Jane Smith', 10347);

insert into album (id, title, artist_id, format, genre) values (1, 'AlbuRx', 1, 'VINYL', 'REGGAE');
insert into album (id, title, artist_id, format, genre) values (2, 'Paroxetine', 1, 'CD', 'BLUES');
insert into album (id, title, artist_id, format, genre) values (3, 'Slash Pine', 1, 'CD', 'REGGAE');
insert into album (id, title, artist_id, format, genre) values (4, 'Pindolol', 2, 'VINYL', 'REGGAE');
insert into album (id, title, artist_id, format, genre) values (5, 'Letrozole', 3, 'CASSETTE', 'ELECTRONIC');
insert into album (id, title, artist_id, format, genre) values (6, 'Hand Sanitizer', 5, 'VINYL', 'CLASSICAL');
insert into album (id, title, artist_id, format, genre) values (7, 'Immuno Fortifier', 4, 'VINYL', 'ROCK');
insert into album (id, title, artist_id, format, genre) values (8, 'Zoledronic acid', 3, 'VINYL', 'COUNTRY_ROCK');
insert into album (id, title, artist_id, format, genre) values (9, 'Sisal', 2, 'CASSETTE', 'ROCK');
insert into album (id, title, artist_id, format, genre) values (10, 'Kroger Value Aspirin', 5, 'CD', 'RAP');

insert into artist_albums (albums_id, artist_id) values (1, 1);
insert into artist_albums (albums_id, artist_id) values (2, 1);
insert into artist_albums (albums_id, artist_id) values (3, 1);
insert into artist_albums (albums_id, artist_id) values (4, 2);
insert into artist_albums (albums_id, artist_id) values (5, 3);
insert into artist_albums (albums_id, artist_id) values (6, 5);
insert into artist_albums (albums_id, artist_id) values (7, 4);
insert into artist_albums (albums_id, artist_id) values (8, 3);
insert into artist_albums (albums_id, artist_id) values (9, 2);
insert into artist_albums (albums_id, artist_id) values (10, 5);



insert into track (id, title, duration) values (1, 'eshovell0', 737);
insert into track (id, title, duration) values (2, 'mlentsch1', 68);
insert into track (id, title, duration) values (3, 'ctester2', 431);
insert into track (id, title, duration) values (4, 'jtansly3', 651);
insert into track (id, title, duration) values (5, 'rcathro4', 280);
insert into track (id, title, duration) values (6, 'esywell5', 287);
insert into track (id, title, duration) values (7, 'jcroal6', 296);
insert into track (id, title, duration) values (8, 'alulham7', 750);
insert into track (id, title, duration) values (9, 'pthurstan8', 620);
insert into track (id, title, duration) values (10, 'mgravy9', 670);
insert into track (id, title, duration) values (11, 'elippia', 397);
insert into track (id, title, duration) values (12, 'vpigdonb', 613);
insert into track (id, title, duration) values (13, 'nlarsenc', 418);
insert into track (id, title, duration) values (14, 'kpuddind', 123);
insert into track (id, title, duration) values (15, 'csainere', 354);
insert into track (id, title, duration) values (16, 'missettf', 578);
insert into track (id, title, duration) values (17, 'mangelog', 465);
insert into track (id, title, duration) values (18, 'acapelleh', 621);
insert into track (id, title, duration) values (19, 'mverlingi', 553);
insert into track (id, title, duration) values (20, 'gbuckinghamj', 422);
insert into track (id, title, duration) values (21, 'bfigginsk', 541);
insert into track (id, title, duration) values (22, 'shonnicottl', 333);
insert into track (id, title, duration) values (23, 'mgeertjem', 675);
insert into track (id, title, duration) values (24, 'mdowsen', 683);
insert into track (id, title, duration) values (25, 'wmadineo', 469);


insert into album_tracks (album_id, tracks_id) values (8, 1);
insert into album_tracks (album_id, tracks_id) values (2, 2);
insert into album_tracks (album_id, tracks_id) values (9, 3);
insert into album_tracks (album_id, tracks_id) values (5, 4);
insert into album_tracks (album_id, tracks_id) values (1, 5);
insert into album_tracks (album_id, tracks_id) values (3, 6);
insert into album_tracks (album_id, tracks_id) values (8, 7);
insert into album_tracks (album_id, tracks_id) values (6, 8);
insert into album_tracks (album_id, tracks_id) values (1, 9);
insert into album_tracks (album_id, tracks_id) values (6, 10);
insert into album_tracks (album_id, tracks_id) values (5, 11);
insert into album_tracks (album_id, tracks_id) values (3, 12);
insert into album_tracks (album_id, tracks_id) values (1, 13);
insert into album_tracks (album_id, tracks_id) values (5, 14);
insert into album_tracks (album_id, tracks_id) values (8, 15);
insert into album_tracks (album_id, tracks_id) values (8, 16);
insert into album_tracks (album_id, tracks_id) values (9, 17);
insert into album_tracks (album_id, tracks_id) values (5, 18);
insert into album_tracks (album_id, tracks_id) values (6, 19);
insert into album_tracks (album_id, tracks_id) values (2, 20);
insert into album_tracks (album_id, tracks_id) values (7, 21);
insert into album_tracks (album_id, tracks_id) values (6, 22);
insert into album_tracks (album_id, tracks_id) values (9, 23);
insert into album_tracks (album_id, tracks_id) values (4, 24);
insert into album_tracks (album_id, tracks_id) values (7, 25);




select setval('album_seq',  (SELECT MAX(id) FROM album));
select setval('artist_seq',  (SELECT MAX(id) FROM artist));
select setval('track_seq',  (SELECT MAX(id) FROM track));