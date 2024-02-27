import axios from "axios";
import {albumsURL, artistURL, musicatURL, tracksURL} from "./URLs";
import {ErrorPage} from "./components/ErrorPage";

function getAlbums() {
    return axios.get(albumsURL).catch((error) => console.log(error));
}

function getAlbum(id) {
    return axios.get(albumsURL + "/" + id).catch((error) =>  console.log(error));
}

function getAlbumImage(id) {
    return axios.get(albumsURL + "/" + id + "/image").catch((error) =>  console.log(error));
}

function getTracks(id) {
    return axios.get(tracksURL(id)).catch((error)=> console.log(error));
}
function getArtist(id) {
    return axios.get(artistURL + "/" + id).catch((error)=> console.log(error));
}
function getArtists() {
    return axios.get(artistURL).catch((error)=> console.log(error));
}
function getArtistAlbums(id){
    return axios.get(artistURL + "/" + id + "/albums").catch((error)=> console.log(error));
}

export {getAlbums, getAlbum, getAlbumImage, getArtist, getArtists, getArtistAlbums, getTracks};