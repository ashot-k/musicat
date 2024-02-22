import React from 'react';
import ReactDOM from 'react-dom/client';
import Home from './Home';

import {createBrowserRouter, RouterProvider, Routes} from 'react-router-dom';
import {ErrorPage} from "./components/ErrorPage";
import {AlbumPage} from "./components/AlbumPage";
import {NavBar} from "./components/NavBar";
import {ArtistPage} from "./components/ArtistPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <div className={"d-flex flex-column gap-3 align-items-center"}><NavBar/><Home/></div>,
        errorElement: <ErrorPage/>
    },
    {
        path: "/album/:albumId",
        element: <div className={"d-flex flex-column gap-3 align-items-center"}><NavBar/><AlbumPage/> </div>,
        errorElement: <ErrorPage/>
    },
    {
        path: "/artist/:artistId",
        element: <div className={"d-flex flex-column gap-3 align-items-center"}><NavBar/><ArtistPage/> </div>,
        errorElement: <ErrorPage/>
    }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>
);