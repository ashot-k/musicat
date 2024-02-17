import axios from "axios";
import {albumsURL, artistURL, musicatURL, tracksURL} from "./URLs";

function getAlbums() {
    return axios.get(albumsURL).catch((error) => console.log(error));
}

function getTracks(id) {
    return axios.get(tracksURL(id)).catch((error)=> console.log(error));
}
function getArtist(id) {
    return axios.get(artistURL + "/" + id).catch((error)=> console.log(error));
}


export {getAlbums, getArtist, getTracks};