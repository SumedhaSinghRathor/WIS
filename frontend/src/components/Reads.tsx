import { useState, useEffect } from "react";

function Reads() {
  interface Reads {
    author: Object;
    demographic: String;
    genres: String[];
    hasAnime: boolean;
    id: Object;
    imgLink: String;
    magazine: Object[];
    title: String;
  }

  const BACKEND_URL = import.meta.env.VITE_BACKEND_URL;
  const [mangas, setMangas] = useState<Reads[]>([]);

  useEffect(() => {
    const fetchMangas = async () => {
      try {
        const response = await fetch(`${BACKEND_URL}/reads`);
        if (!response.ok) throw new Error("Failed to fetch mangas");

        const data: Reads[] = await response.json();
        setMangas(data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchMangas();
  }, []);

  return (
    <ol>
      {mangas.map((m, i) => (
        <li key={i}>
          {m.title} - {m.hasAnime ? "🎥" : ""}
          <p>
            {m.genres
              ?.slice()
              .sort((a, b) => a.localeCompare(b))
              .join(", ")}
          </p>
        </li>
      ))}
    </ol>
  );
}

export default Reads;
