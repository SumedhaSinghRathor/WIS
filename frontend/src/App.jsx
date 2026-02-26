import { Routes, Route } from "react-router-dom";
import Reads from "./components/Reads";
import Magazines from "./components/Magazines";
import Authors from "./components/Authors";

function App() {
  return (
    <Routes>
      <Route path="/reads" element={<Reads />} />
      <Route path="/magazines" element={<Magazines />} />
      <Route path="/authors" element={<Authors />} />
    </Routes>
  );
}

export default App;
