import {NavBar} from "./components/NavBar";
import Footer from "./components/Footer";
import React from "react";

export function Template ({content}) {
  return (
      <div className={"d-flex flex-column gap-3"}>
          <NavBar/>
          <div className={"content"}>{content}</div>
          <Footer/>
      </div>
  )
}
