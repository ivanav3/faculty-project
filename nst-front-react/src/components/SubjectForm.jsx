// src/components/SubjectForm.js
import React, { useState, useEffect } from "react";
import { createSubject, updateSubject, getSubjectById } from "../db/Subject";

const SubjectForm = ({ id, setId }) => {
  const [name, setName] = useState("");
  const [code, setCode] = useState("");

  useEffect(() => {
    if (id) {
      const fetchSubject = async () => {
        const subject = await getSubjectById(id);
        setName(subject.name);
        setCode(subject.code);
      };
      fetchSubject();
    } else {
      setName("");
      setCode("");
    }
  }, [id]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const subject = { name, code };

    if (id) {
      await updateSubject(id, subject);
    } else {
      await createSubject(subject);
    }

    setId(null);
    setName("");
    setCode("");
  };

  return (
    <div>
      <h2>{id ? "Ažuriraj predmet" : "Dodaj predmet"}</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Naziv predmeta"
          required
        />
        <input
          type="text"
          value={code}
          onChange={(e) => setCode(e.target.value)}
          placeholder="Šifra predmeta"
          required
        />
        <button type="submit">{id ? "Ažuriraj" : "Dodaj"}</button>
      </form>
    </div>
  );
};

export default SubjectForm;
