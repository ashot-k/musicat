import {NavLink} from "react-router-dom";

export const NavBar = () => {

    return (
        <div className={"nav-bar  rounded-bottom-3"}>
            <div className={"nav-link-container w-100"}>
                <div className={"logo-container d-flex justify-content-between"}>
                    <NavLink className={"logo display-5 text-decoration-none"} to={"/"}>Musicat</NavLink>
                    <div className={"nav-link-container gap-1"}>
                        <div className={"btn btn-outline-light"}>
                            <NavLink className={"h3 text-decoration-none"} to={"/"}>Login</NavLink>
                        </div>
                        <div className={"btn"}>
                            <NavLink className={"h3 text-decoration-none"} to={"/"}>Register</NavLink>
                        </div>
                    </div>
                </div>
                <div className={"nav-link-container justify-content-between"}>
                    <div className={"d-flex gap-1"}>
                        <NavLink className={"h3 text-decoration-none"} to={"/"}>Wishlist</NavLink>
                        <NavLink className={"h3 text-decoration-none"} to={"/"}>Contact</NavLink>
                        <NavLink className={"h3 text-decoration-none"} to={"/"}>Profile</NavLink>

                    </div>

                </div>
            </div>
        </div>
    )
}