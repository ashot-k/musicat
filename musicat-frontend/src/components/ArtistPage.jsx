import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {getAlbum, getArtist, getArtistAlbums, getTracks} from "../MusicatAPI";
import {AlbumList} from "./AlbumList";
import {ArtistInfo} from "./ArtistInfo";
import '../css/artist-page.css'

export const ArtistPage = ({artist}) => {
    const params = useParams();
    const [artistInfo, setArtistInfo] = useState(null);
    const [artistAlbums, setArtistAlbums] = useState(null);
    const [isPending, setIsPending] = useState(true);

    useEffect(() => {
        getArtist(params.artistId)
            .then((response) => setArtistInfo(response.data))
            .catch((error)=> console.log(error)).then(()=>setIsPending(false));
        getArtistAlbums(params.artistId)
            .then((response) => setArtistAlbums(response.data))
            .catch((error)=> console.log(error));
    }, []);
    return(
        <div className="rounded-4 d-flex flex-column gap-5  justify-content-center">
            {artistInfo && <ArtistInfo artist={artistInfo}/>}
            {artistAlbums && <AlbumList albums={artistAlbums}/>}
        </div>
    )
}