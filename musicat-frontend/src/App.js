import 'bootstrap/dist/css/bootstrap.min.css';
import './css/template.css'
import './css/nav-bar.css';
import AlbumList from "./components/AlbumList";
import {useEffect, useState} from "react";
import {getAlbums, getArtist} from "./MusicatAPI";

function App() {
   // setAlbums(albums.data.content)
    const [albums, setAlbums] = useState(null);
    useEffect(() => {
        getAlbums().then((albumsResponse) => {
            const albumPromises = albumsResponse.data.content.map((albumKey) => {
                return getArtist(albumKey.artist).then((response) => {
                    albumKey.artistName = response.data.name;
                    return albumKey;
                });
            });

            Promise.all(albumPromises)
                .then((updatedAlbums) => {
                    setAlbums(updatedAlbums);
                })
                .catch((error) => {
                    console.error('Error updating albums:', error);
                });
        });
    }, []);
   /* useEffect(() => {
        getAlbums().then((albums) => {
            for (const albumsKey of albums.data.content) {
                getArtist(albumsKey.artist).then((response) => {
                    albumsKey.artistName = response.data.name;
                    setAlbums(albums.data.content);
                    console.log("called");
                });
            }
        });


    }, []);*/
    function setArtistNames(){

    }
    return (
        <div className="App">
            {albums && <AlbumList albums={albums}/>}
        </div>
    );

}

export default App;
