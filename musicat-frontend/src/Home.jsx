import 'bootstrap/dist/css/bootstrap.min.css';
import './css/template.css'
import './css/nav-bar.css';
import './css/album-list.css'
import './css/card.scss'
import {useEffect, useState} from "react";
import {getAlbums, getArtist, getArtists} from "./MusicatAPI";
import {AlbumList} from "./components/AlbumList";
import {ArtistList} from "./components/ArtistList";

function Home() {
    const [albums, setAlbums] = useState(null);
    const [artists, setArtists] = useState(null);
    const [isPending, setIsPending] = useState(true);

    useEffect(() => {
        getAlbums()
            .then((response) => setAlbums(response.data.content))
            .catch((error) => console.log(error)).then(() => setIsPending(false));
        getArtists().then((response) => setArtists(response.data.content))
            .catch((error) => console.log(error)).then(() => setIsPending(false));
    }, []);

    return (
        <div className="content rounded-4 d-flex flex-column gap-5 align-items-center justify-content-center">
            {artists && <ArtistList artists={artists}/>
                || !isPending && !artists &&
                <h1 className={"display-3"}>Could not load Page</h1>
            }
            {albums && <AlbumList albums={albums}/>
                || !isPending && !albums &&
                <h1 className={"display-3"}>Could not load Page</h1>
            }

        </div>
    );
}

export default Home;
