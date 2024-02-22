import {Link} from "react-router-dom";
import {AlbumCard} from "./AlbumCard";
import '../css/album-page.css'

export function AlbumList({albums}) {
    return (
        <div className={"w-100"}>
            <h1 className={"h1 content-title"}>Albums</h1>
            <hr/>
            <div className={"d-flex flex-row justify-content-center flex-wrap gap-4"}>
                {albums.map((album) => <AlbumCard album={album}/>)}
            </div>
        </div>
    )
}
