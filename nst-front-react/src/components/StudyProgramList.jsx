import React, { useEffect, useState } from "react";
import { getAllStudyPrograms } from "../db/StudyProgram";
import { deleteStudyProgram } from "../db/StudyProgram";
const StudyProgramList = () => {
  const [studyPrograms, setStudyPrograms] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const data = await getAllStudyPrograms();
      setStudyPrograms(data);
    };
    fetchData();
  }, []);

  const handleDelete = async (id) => {
    await deleteStudyProgram(id);
    const updatedPrograms = studyPrograms.filter(
      (program) => program.id !== id
    );
    setStudyPrograms(updatedPrograms);
  };

  return (
    <div>
      <h2>Lista studijskih programa</h2>
      <ul>
        {studyPrograms.map((program) => (
          <li key={program.id}>
            {program.name}{" "}
            <button onClick={() => handleDelete(program.id)}>Obriši</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default StudyProgramList;
