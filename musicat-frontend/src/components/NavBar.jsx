import {NavLink} from "react-router-dom";

export const NavBar = () => {

    return (
        <div className={"nav-bar rounded-1"}>
            <div className={"nav-link-container"}>
                <NavLink className={"h3 text-decoration-none"} to={"/"}>Home</NavLink>
                <NavLink className={"h3 text-decoration-none"} to={"/"}>Wishlist</NavLink>
                <NavLink className={"h3 text-decoration-none"} to={"/"}>Contact</NavLink>
                <NavLink className={"h3 text-decoration-none"} to={"/"}>Profile</NavLink>
            </div>
            <div className={"nav-link-container justify-content-evenly"}>
                <div className={"btn btn-outline-light"}>
                    <NavLink className={"h3 text-decoration-none"} to={"/"}>Login</NavLink>
                </div>
                <div className={"btn btn-outline-light "}>
                    <NavLink className={"h3 text-decoration-none "} to={"/"}>Register</NavLink>
                </div>
            </div>
        </div>
    )
}