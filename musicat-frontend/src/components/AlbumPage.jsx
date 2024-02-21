import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {getAlbum, getTracks} from "../MusicatAPI";

export const AlbumPage = () => {
    const params = useParams();
    const [albumInfo, setAlbumInfo] = useState(null);
    const [albumTracks, setAlbumTracks] = useState(null);
    useEffect(() => {
        getAlbum(params.albumId).then((response) => setAlbumInfo(response.data));
        getTracks(params.albumId).then((response) => setAlbumTracks(response.data))
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
       let newStr = str.substring(0,1).toUpperCase();
      return  newStr = newStr + str.substring(1).toLowerCase();
    }

    return (
        <div className={"p-4"}>
            {albumInfo && !albumInfo.error &&
                <div className={"d-flex flex-column gap-3 justify-content-center align-items-start"}>
                    <h1 className={"h1"}>{albumInfo.title}</h1>
                    <hr className={"w-100"}/>
                    <div>
                        <h4 className={"h4"}>Artist: {albumInfo.artistName}</h4>
                        <h4 className={"h4"}>Genre: {capitalizeFirst(albumInfo.genre)}</h4>
                        <h4 className={"h4"}>Format: {capitalizeFirst(albumInfo.format)}</h4>
                    </div>
                    <div className={"w-75"}>
                        <h3 className={"h3"}>Tracks</h3>
                        <table className={"table table-dark"}>
                            <thead className={"table-secondary"}>
                            <tr>
                                <th>#</th>
                                <th>Title</th>
                                <th>Duration</th>
                            </tr>
                            </thead>
                            <tbody>
                            {albumTracks
                                && albumTracks.map((track, idx) => {
                                    return <tr>
                                        <td>{idx + 1}</td>
                                        <td>{track.title}</td>
                                        <td>{secondsToMinutes(track.duration)}</td>
                                    </tr>
                                })}
                            </tbody>
                        </table>
                    </div>
                </div> ||

                <div>
                    <h1 className={"h1"}>Album does not exist</h1>
                </div>
            }
        </div>
    )
}