import {Link} from "react-router-dom";

export const AlbumCard = ({album}) => {
    return (
        <div key={album.id} className={"card d-flex flex-column align-items-center rounded-2"}>
            <Link to={"/album/" + album.id}>
                <div className={"image-container"}>
                    <img className="card-image rounded-1"
                         src=""
                         alt="Card image cap"/>
                </div>
            </Link>
            <div className="card-body d-flex flex-column gap-3 justify-content-between w-100">
                <Link to={"/album/" + album.id} className={"text-decoration-none"}>
                    <h5 className="h5 card-title">{album.title}</h5>
                    <p className="card-text">
                        by <Link to={"/artist/" + album.artist}>{album.artistName}</Link>
                    </p>
                </Link>
                <div className={"p-1 d-flex justify-content-start"}>
                    <button className={"buy-btn btn btn-outline-light"} onClick={() => console.log()}>Shop</button>
                </div>
            </div>
        </div>

    )
}
