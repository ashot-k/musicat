const musicatURL = "http://192.168.1.80:8080/api";
const albumsURL = musicatURL + "/album";
const artistURL = musicatURL + "/artist";
function tracksURL(id){
    return albumsURL + "/" + id + "/tracks"
}

export {musicatURL, albumsURL, artistURL, tracksURL};