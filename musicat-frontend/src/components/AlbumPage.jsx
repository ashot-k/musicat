import {Link, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {getAlbum, getTracks} from "../MusicatAPI";
import '../css/album-page.css'

export const AlbumPage = () => {
    const params = useParams();
    const [albumInfo, setAlbumInfo] = useState(null);
    const [albumTracks, setAlbumTracks] = useState(null);
    const [isPending, setIsPending] = useState(true);

    useEffect(() => {
        getAlbum(params.albumId)
            .then((response) => setAlbumInfo(response.data))
            .catch((error) => console.log(error)).then(() => setIsPending(false));
        getTracks(params.albumId)
            .then((response) => setAlbumTracks(response.data))
            .catch((error) => console.log(error));
    }, []);

    function secondsToMinutes(seconds) {
        let minutes = parseInt(seconds / 60);
        const remaining = seconds % 60;
        if (remaining < 10) {
            minutes = minutes + ":0" + remaining;
        } else
            minutes = minutes + ":" + remaining;
        return minutes;
    }

    function capitalizeFirst(str) {
        let newStr = str.substring(0, 1).toUpperCase();
        return newStr = newStr + str.substring(1).toLowerCase();
    }

    return (
        <div className={"rounded-4 d-flex flex-column  justify-content-center"}>
            {albumInfo && !albumInfo.error &&
                <div className={"w-100 d-flex flex-column gap-4 align-items-start"}>
                    <img src={albumInfo.imageURL} className={"album-image"} alt={"Image not available"}></img>
                    <h1 className={"h1 content-title"}>{albumInfo.title}</h1>
                    <div>
                        <h4 className={"h4"}>Artist: <Link
                            to={"/artist/" + albumInfo.artist}>{albumInfo.artistName}</Link></h4>
                        <h4 className={"h4"}>Genre: {capitalizeFirst(albumInfo.genre)}</h4>
                        <h4 className={"h4"}>Format: {capitalizeFirst(albumInfo.format)}</h4>
                    </div>
                    <div>
                        <br/>
                        {albumTracks && albumTracks.length > 0 && <table className={"rounded-4 shadow-lg"}>
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Title</th>
                                <th>Duration</th>
                            </tr>
                            </thead>
                            <tbody>
                            {albumTracks.map((track, idx) => {
                                    return <tr className={"track"}>
                                        <td>{idx + 1}</td>
                                        <td>{track.title}</td>
                                        <td>{secondsToMinutes(track.duration)}</td>
                                    </tr>
                                })}
                            </tbody>
                        </table>}
                    </div>
                </div>
                ||
                !isPending &&
                <div>
                    <h1 className={"h1"}>Could not load album info</h1>
                </div>
            }
        </div>
    )
}