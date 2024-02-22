
import {ArtistCard} from "./ArtistCard";

export function ArtistList({artists}) {
    return (
        <div className={"w-100"}>
            <h1 className={"h1 content-title"}>Artists</h1>
            <hr/>
            <div className={"d-flex flex-row justify-content-center flex-wrap gap-4"}>
                {artists.map((artist) => <ArtistCard artist={artist}/>)}
            </div>
        </div>
    )
}
