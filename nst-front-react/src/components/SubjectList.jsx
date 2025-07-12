import React, { useEffect, useState } from "react";
import { getAllSubjects } from "../db/Subject";
import { deleteSubject } from "../db/Subject";

const SubjectList = ({ setId }) => {
  const [subjects, setSubjects] = useState([]);

  useEffect(() => {
    const fetchSubjects = async () => {
      const data = await getAllSubjects();
      setSubjects(data);
    };
    fetchSubjects();
  }, []);

  const handleDelete = async (id) => {
    await deleteSubject(id);
    setSubjects(subjects.filter((subject) => subject.id !== id));
  };

  return (
    <div>
      <h2>Lista predmeta</h2>
      <ul>
        {subjects.map((subject) => (
          <li key={subject.id}>
            {subject.name}{" "}
            <button onClick={() => setId(subject.id)}>Ažuriraj</button>{" "}
            <button onClick={() => handleDelete(subject.id)}>Obriši</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SubjectList;
