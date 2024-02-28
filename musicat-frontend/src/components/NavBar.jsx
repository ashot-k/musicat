import {NavLink} from "react-router-dom";
import '../css/nav-bar.css'
import InputGroupText from "react-bootstrap/InputGroupText";

export const NavBar = () => {
    return (
        <div className={"nav-bar  rounded-bottom-3"}>
            <div className={"logo-container d-flex justify-content-between align-items-center"}>
                <NavLink className={"logo h1 text-decoration-none"} to={"/"}>Musicat</NavLink>
                <div className={"nav-link-container search-box gap-2"}>
                    <input className={"form-control search-input"} placeholder={"Enter artist, album or song..."} type={"text"}/>
                    <div className={"btn btn-outline-light search-btn"}>
                        <NavLink className={"h3 text-decoration-none"} to={"/"}>Search</NavLink>
                    </div>
                </div>
            </div>
            <div className={"nav-link-container"}>
                <div className={"d-flex gap-1"}>
                    <NavLink className={"h4 text-decoration-none"} to={"/"}>Profile</NavLink>
                    <NavLink className={"h4 text-decoration-none"} to={"/"}>Wishlist</NavLink>
                    <NavLink className={"h4 text-decoration-none"} to={"/"}>Contact</NavLink>
                </div>
                <div className={"d-flex gap-1 auth-btn-container"}>
                    <div className={"btn btn-outline-light"}>
                        <NavLink className={"h3 text-decoration-none"} to={"/"}>Login</NavLink>
                    </div>
                    <div className={"btn"}>
                        <NavLink className={"h3 text-decoration-none"} to={"/"}>Register</NavLink>
                    </div>
                </div>
            </div>
        </div>
    )
}