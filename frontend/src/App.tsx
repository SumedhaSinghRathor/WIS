import { Routes, Route } from "react-router-dom";
import Reads from "./components/Reads";
import Authors from "./components/Authors";
import Magazines from "./components/Magazines";
import Home from "./components/Home";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/reads" element={<Reads />} />
      <Route path="/authors" element={<Authors />} />
      <Route path="/magazines" element={<Magazines />} />
    </Routes>
  );
}

export default App;
