import {useEffect, useState} from "react";
import "../css/admin-list.css"
import {getArtist, getTracks} from "../MusicatAPI";
function AlbumTable({albums}) {

    const [searchTerm, setSearchTerm] = useState("");
    const headers = (albums && albums.length > 0) ? Object.keys(albums[0]) : [];


    return (
        <div className="d-flex flex-column justify-content-center align-items-center">
            <div className="d-flex flex-row justify-content-end align-items-center gap-3 p-3">
                <button className="btn btn-success" type="button">Add new Entry</button>
                <label>Search:<input/></label>
            </div>
            {albums && albums.length > 0 &&
                <div className="table-container w-100">
                    <table className="table table-dark table-striped">
                        <tbody>
                        <tr>
                            <th>#</th>
                            {headers.map(heading => {
                                return <th key={heading}>{heading}</th>
                            })}

                            <th>Actions</th>
                        </tr>
                        {albums.map((album, index) => (
                            <tr key={index}>
                                <td>{index + 1}</td>
                                {headers.map(header => {
                                    if (header === 'imageUrl')
                                        return <td key={header}><img alt="Image Not Available"></img></td>
                                    else
                                        return <td key={header}>{album[header]}</td>
                                })}
                                <td>
                                    <div className="actions gap-3">
                                        <button className="btn btn-warning">Edit</button>
                                        <button className="btn btn-danger">Delete</button>
                                    </div>
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
                ||
                <h1>No Entries</h1>
            }
        </div>
    );
}

export default AlbumTable;