
import React from "react"
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import CreateClassRoom from "./component/CreateClassRoom";
import GetClassRoom from "./component/GetClassRoom";

function App() {
  

  return (
    <>
      <Router>
        <Routes>
        <Route path="/" element={<h1>Welcome to ClassRoom Manager</h1>} />
        <Route path="/create" element={<CreateClassRoom />} />
        <Route path="/get" element={<GetClassRoom />} />
        </Routes>
      </Router>
    </>
  )
}

export default App
