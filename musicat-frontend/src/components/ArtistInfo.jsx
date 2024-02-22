export const ArtistInfo = ({artist}) => {

    return (
        <div className={"artist-info w-100 d-flex flex-column gap-4"}>
            <div className={"artist-page-img-container d-flex w-100"}>
                <img className={"artist-page-img"}
                     src={"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTeXxYjRCi6Cu8jzZV0Zvg2ymAsZ4Ouz_ur-mgF8to0mOKpn76YwdGlxnqy7ETCt7h_twFe"}
                     alt={"Not image available"}/>
            </div>
            <div className={"artist-details w-100 d-flex flex-column gap-2"}>
                <h1 className={"h1 content-title"}>{artist.name}</h1>
                <p>{artist.description}</p>
                <span className={"additional-info"}>Members: {artist.members}</span>
            </div>
        </div>
    )
}