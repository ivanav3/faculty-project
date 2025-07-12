import React, { useState, useEffect } from "react";
import {
  createStudyProgram,
  updateStudyProgram,
  getStudyProgramById,
} from "../db/StudyProgram";

const StudyProgramForm = ({ id, setId }) => {
  const [name, setName] = useState("");

  useEffect(() => {
    if (id) {
      const fetchProgram = async () => {
        const program = await getStudyProgramById(id);
        setName(program.name);
      };
      fetchProgram();
    }
  }, [id]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const studyProgram = { name };

    if (id) {
      await updateStudyProgram(id, studyProgram);
    } else {
      await createStudyProgram(studyProgram);
    }

    setId(null);
    setName("");
  };

  return (
    <div>
      <h2>{id ? "Ažuriraj studijski program" : "Dodaj studijski program"}</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Naziv programa"
          required
        />
        <button type="submit">{id ? "Ažuriraj" : "Dodaj"}</button>
      </form>
    </div>
  );
};

export default StudyProgramForm;
