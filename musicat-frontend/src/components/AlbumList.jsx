import {Link} from "react-router-dom";

function AlbumList({albums}) {
    return (
        <div className={"d-flex flex-row gap-2 "}>
            {albums.map((album) =>
                <Link className={"album rounded-2  w-100"} to={"/album/" + album.id}>
                    <div className="card-body flex-column d-flex justify-content-center align-items-center">
                        <img className="card-img-top album-image rounded-1"
                             src="https://upload.wikimedia.org/wikipedia/en/4/45/Blackwaterpark.jpg"
                             alt="Card image cap"/>
                        <hr/>
                        <h5 className="card-title">{album.title}</h5>
                        <p className="card-text">by {album.artistName}</p>
                    </div>
                </Link>
            )}
        </div>
    )
}

export default AlbumList;