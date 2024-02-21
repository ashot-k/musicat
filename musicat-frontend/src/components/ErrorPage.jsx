import {Link} from "react-router-dom";

export const ErrorPage = () => {
  return (
      <div className={"p-4"}>
          <h1>ERROR 404 PAGE NOT FOUND</h1>
          <Link className={"btn btn-secondary"} to={"/"}>Return to Homepage</Link>
      </div>
  )
}