import React from 'react';
import ReactDOM from 'react-dom/client';
import Home from './Home';

import {createBrowserRouter, RouterProvider} from 'react-router-dom';
import {ErrorPage} from "./components/ErrorPage";
import {AlbumPage} from "./components/AlbumPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Home/>,
       errorElement: <ErrorPage/>,
    },
    {
        path:"/album/:albumId",
        element:<AlbumPage/>,
        errorElement:<ErrorPage/>
    }

]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode >
      <RouterProvider  router={router}/>
  </React.StrictMode>
);