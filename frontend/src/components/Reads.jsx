import { useState, useEffect } from "react";

function Read() {
  const BACKEND_URL = import.meta.env.VITE_BACKEND_URL;
  const [mangas, setMangas] = useState([]);

  useEffect(() => {
    const fetchMangas = async () => {
      try {
        const response = await fetch(`${BACKEND_URL}/reads`);
        if (!response.ok) throw new Error("Failed to fetch mangas");

        const data = await response.json();
        setMangas(data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchMangas();
  });

  return (
    <ol>
      {mangas
        .sort((a, b) => a.title.localeCompare(b.title))
        .map((m, i) => (
          <li key={i}>
            {m.title} - {m.hasAnime ? "🎥" : ""}
            <p>{m.genres?.sort((a, b) => a.localeCompare(b)).join(", ")}</p>
          </li>
        ))}
    </ol>
  );
}

export default Read;
