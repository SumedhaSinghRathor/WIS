import { useState, useEffect } from "react";

function Magazines() {
  const BACKEND_URL = import.meta.env.VITE_BACKEND_URL;
  const [magazines, setMagazines] = useState([]);

  useEffect(() => {
    const fetchMagazines = async () => {
      try {
        const response = await fetch(`${BACKEND_URL}/magazines`);
        if (!response.ok) throw new Error("Failed to fetch magazines");

        const data = await response.json();
        setMagazines(data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchMagazines();
  });

  console.log(magazines);

  return (
    <ol>
      {magazines
        .sort((a, b) => a.reads.length - b.reads.length)
        .map((m, i) => (
          <li key={i}>
            {m.magazineTitle} - {m.reads.length} serializations
          </li>
        ))}
    </ol>
  );
}

export default Magazines;
