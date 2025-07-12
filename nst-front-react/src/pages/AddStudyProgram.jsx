import { useNavigate, useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

const AddStudyProgram = () => {
  const { id } = useParams();
  const [studyProgram, setStudyProgram] = useState({ name: "", subjects: [] });
  const [nameInput, setNameInput] = useState("");
  const [subjects, setSubjects] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      axios
        .get(`http://localhost:8080/api/studyProgram/${id}`)
        .then((response) => {
          setStudyProgram(response.data);
          setNameInput(response.data.name);
          setSubjects(response.data.subjects);

          console.log(response);
        })
        .catch((error) => {
          console.error("Error while loading study program:", error);
        });
    }
  }, [id]);

  const handleSave = () => {
    if (nameInput.trim() === "") {
      alert("Please enter a name for the study program.");
      return;
    }
    setStudyProgram({ name: nameInput, subjects: [] });
    console.log(studyProgram.name);
    if (id) {
      axios
        .put(`http://localhost:8080/api/studyProgram/update/${id}`, {
          name: nameInput,
        })
        .then((response) => {
          console.log(response);
          alert("Study program has been updated.");

          navigate("/");
        })
        .catch((error) => {
          alert("Error while saving study program:", error);
        });
    } else {
      axios
        .post("http://localhost:8080/api/studyProgram", {
          name: nameInput,
          subjects: [],
        })
        .then((response) => {
          console.log(response);
          alert("You've created a new study program.");

          navigate("/");
        })
        .catch((error) => {
          console.log(studyProgram.name);
          alert("Error while creating study program:", error.details);
        });
    }
  };

  const handleDelete = () => {
    axios
      .delete(`http://localhost:8080/api/studyProgram/delete/${id}`)
      .then((response) => {
        console.log(response);
        alert("You've deleted the study program.");
        navigate("/");
      })
      .catch((error) => {
        alert("Error while deleting study program:", error);
      });
  };

  return (
    <div>
      <form>
        <div className="form-row">
          <div className="col">
            <label
              style={{
                display: "block",
                textAlign: "center",
                margin: "0 auto",
                width: "fit-content",
              }}
              htmlFor="idInput"
            >
              ID
            </label>
            <input
              type="text"
              value={id || undefined}
              disabled
              className="form-control"
              id="idInput"
            />
          </div>
          <div className="col">
            <label
              style={{
                display: "block",
                textAlign: "center",
                margin: "0 auto",
                width: "fit-content",
              }}
              htmlFor="nameInput"
            >
              Name
            </label>
            <input
              type="text"
              className="form-control"
              value={nameInput}
              onChange={(e) => setNameInput(e.target.value)}
              id="nameInput"
            />
          </div>
        </div>
        <div className="form-row" style={{ marginTop: "20px" }}>
          <div className="col text-center">
            <button type="button" onClick={handleSave}>
              Save
            </button>
          </div>
          <div className="col text-center">
            <button type="button" onClick={handleDelete}>
              Delete
            </button>
          </div>
        </div>
      </form>

      <div style={{ marginBottom: "10px" }}> </div>
      {subjects.length > 0 ? (
        <table className="table table-hover">
          <thead>
            <tr>
              <th className="text-center">Id</th>
              <th className="text-center">Name</th>
              <th className="text-center">ECTS</th>
              <th className="text-center">Study program</th>
              <th className="text-center">Semester</th>
              <th className="text-center">Status</th>
              <th className="text-center">Class hours</th>
            </tr>
          </thead>
          <tbody>
            {subjects.map((subject, index) => (
              <tr key={index}>
                <td className="text-center">{subject.id}</td>
                <td className="text-center">{subject.name}</td>
                <td className="text-center">{subject.ects}</td>
                <td className="text-center">{subject.studyProgram}</td>
                <td className="text-center">{subject.semester}</td>
                <td className="text-center">{subject.status}</td>
                <td className="text-center">{subject.classHours}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="text-center">
          Click on save to save study program or delete to delete it.
        </p>
      )}
    </div>
  );
};

export default AddStudyProgram;
