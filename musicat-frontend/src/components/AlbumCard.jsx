import {Link} from "react-router-dom";
export const AlbumCard = ({album}) => {
  return(
      <Link key={album.id} className={"card d-flex flex-column align-items-center rounded-1"}
            to={"/album/" + album.id}>
          <div className={"image-container"}>
              <img className="card-image rounded-1"
                   src="https://upload.wikimedia.org/wikipedia/en/4/45/Blackwaterpark.jpg"
                   alt="Card image cap"/>
          </div>
          <div className="card-body flex-column  d-flex align-items-start w-100">
              <h5 className="card-title">{album.title}</h5>
              <p className="card-text">
                  by <Link to={"/artist/" + album.artist}> {album.artistName}</Link>
              </p>
          </div>
      </Link>
  )
}
