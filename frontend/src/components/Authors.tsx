import { useState, useEffect } from "react";

function Authors() {
  interface Authors {
    id: Object;
    imgLink: String | null;
    name: String;
    reads: Object[];
  }

  const BACKEND_URL = import.meta.env.VITE_BACKEND_URL;
  const [authors, setAuthors] = useState<Authors[]>([]);

  useEffect(() => {
    const fetchAuthors = async () => {
      try {
        const response = await fetch(`${BACKEND_URL}/authors`);
        if (!response.ok) throw new Error("Failed to fetch authors");

        const data = await response.json();
        setAuthors(data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchAuthors();
  });

  return (
    <ol>
      {authors
        .sort((a, b) => a.name.localeCompare(b.name))
        .map((a, i) => (
          <li key={i}>{a.name}</li>
        ))}
    </ol>
  );
}

export default Authors;
