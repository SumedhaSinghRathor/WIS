import { Routes, Route } from "react-router-dom";
import Reads from "./components/Reads";
import Authors from "./components/Authors";
import Magazines from "./components/Magazines";

function App() {
  return (
    <Routes>
      <Route path="/reads" element={<Reads />} />
      <Route path="/authors" element={<Authors />} />
      <Route path="/magazines" element={<Magazines />} />
    </Routes>
  );
}

export default App;
