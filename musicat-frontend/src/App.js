import 'bootstrap/dist/css/bootstrap.min.css';
import './css/template.css'
import './css/nav-bar.css';
import AlbumList from "./components/AlbumList";
import {useEffect, useState} from "react";
import {getAlbums, getArtist} from "./MusicatAPI";

function App() {
    const [albums, setAlbums] = useState(null);

    useEffect(() => {
        getAlbums().then((response) => setAlbums(response.data.content));
    }, []);

    return (
        <div className="App d-flex flex-column align-items-center justify-content-center">
            <div className={"nav-bar"}>

            </div>
            <div className={"content"}>
                <h1 className={"h1"}>Albums</h1>
                {albums && <AlbumList albums={albums}/>}
            </div>
        </div>
    );

}

export default App;
