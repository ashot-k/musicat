import {Link} from "react-router-dom";

export const ArtistCard = ({artist}) => {
    return (
        <Link key={artist.id} className={"card flex-column  d-flex align-items-center  rounded-4"}
              to={"/artist/" + artist.id}>
            <div className={"image-container"}>
                <img className="card-image rounded-1"
                     src=""
                     alt="Card image cap"/>
            </div>
            <div className="card-body flex-column d-flex align-items-start w-100">
                <h5 className="display-6 card-title">{artist.name}</h5>
            </div>
        </Link>
    )
}
