import { Link } from "react-router-dom";

function Home() {
  return (
    <>
      <h1>Menu</h1>
      <nav
        style={{
          display: "grid",
          gridTemplateColumns: "repeat(3, minmax(0, 1fr))",
        }}
      >
        <Link to="/reads">Reads</Link>
        <Link to="/authors">Authors</Link>
        <Link to="/magazines">Magazines</Link>
      </nav>
    </>
  );
}

export default Home;
