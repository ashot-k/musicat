import React from 'react';
import ReactDOM from 'react-dom/client';
import Home from './Home';

import './css/template.css'
import {createBrowserRouter, RouterProvider, Routes} from 'react-router-dom';
import {ErrorPage} from "./components/ErrorPage";
import {AlbumPage} from "./components/AlbumPage";
import {ArtistPage} from "./components/ArtistPage";
import {Template} from "./Template";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Template content={<Home/>}></Template>,
        errorElement: <ErrorPage/>
    },
    {
        path: "/album/:albumId",
        element: <Template content={<AlbumPage/>}></Template>,
        errorElement: <ErrorPage/>
    },
    {
        path: "/artist/:artistId",
        element: <Template content={<ArtistPage/>}></Template>,
        errorElement: <ErrorPage/>
    }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>
);