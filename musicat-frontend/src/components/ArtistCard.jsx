import {Link} from "react-router-dom";

export const ArtistCard = ({artist}) => {
    return (
        <Link key={artist.id} className={"card d-flex flex-column gap-3 align-items-center rounded-2"}
              to={"/artist/" + artist.id}>
            <div className={"image-container"}>
                <img className="card-image rounded-1"
                     src=""
                     alt="Card image cap"/>
            </div>
            <div className="card-body flex-column d-flex align-items-center w-100">
                <h4 className="h4 card-title text-center">{artist.name}</h4>
            </div>
        </Link>
    )
}
