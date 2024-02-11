import logo from './logo.svg';
import './App.css';
import {useState} from "react";

function App() {
    const [file, setFile] = useState(null);
    console.log(file);
    return (
        <div className="App">
            <input type="file" id="upload" accept="audio/*"  onChange={(e) => {
                const file = e.target.files[0];
                const fileUrl = URL.createObjectURL(file);
                setFile(fileUrl)
            }}/>
            {file && <audio id="audio" controls>
                <source src={file} id="src"/>
            </audio>}
        </div>
    );
}

export default App;
