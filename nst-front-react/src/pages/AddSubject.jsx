import { useNavigate, useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

const AddSubject = () => {
  const { id } = useParams();
  const [nameInput, setNameInput] = useState("");
  const [ectsInput, setEctsInput] = useState("");
  const [studyProgramInput, setSPInput] = useState(0);
  const [semesterInput, setSemesterInput] = useState("");
  const [statusInput, setStatusInput] = useState("COMPULSORY");
  const [classHoursInput, setCHInput] = useState("");

  const [subjects, setSubjects] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      axios
        .get(`http://localhost:8080/api/subject/${id}`)
        .then((response) => {
          setNameInput(response.data.name);
          setEctsInput(response.data.ects);
          setSPInput(response.data.studyProgram);
          setSemesterInput(response.data.semester);
          setStatusInput(response.data.status);
          setCHInput(response.data.classHours);

          console.log(response);
        })
        .catch((error) => {
          console.error("Error while loading subject:", error);
        });
    }
  }, [id]);

  const [studyPrograms, setStudyPrograms] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/studyProgram/all")
      .then((response) => {
        setStudyPrograms(response.data);
        console.log(studyPrograms);
      })
      .catch((error) => {
        alert("Error while getting all the subjects.");
        console.log(error);
      });
  }, []);

  const handleSave = () => {
    if (
      nameInput.trim() === "" ||
      ectsInput < 1 ||
      classHoursInput < 1 ||
      studyProgramInput < 1
    ) {
      alert("Please enter valid data.");

      return;
    }

    if (id) {
      axios
        .put(`http://localhost:8080/api/subject/update/${id}`, {
          name: nameInput,
          ects: ectsInput,
          studyProgram: studyProgramInput,
          semester: semesterInput,
          status: statusInput,
          classHours: classHoursInput,
        })
        .then((response) => {
          console.log(response);
          alert("Subject has been updated.");

          navigate("/");
        })
        .catch((error) => {
          alert("Error while saving subject:", error);
        });
    } else {
      console.log(
        "Pre slanja: " +
          nameInput +
          " " +
          ectsInput +
          " " +
          statusInput +
          " " +
          studyProgramInput +
          " " +
          classHoursInput +
          " " +
          semesterInput
      );

      axios
        .post("http://localhost:8080/api/subject", {
          name: nameInput,
          ects: ectsInput,
          studyProgram: studyProgramInput,
          semester: semesterInput,
          status: statusInput,
          classHours: classHoursInput,
        })
        .then((response) => {
          console.log(response);
          alert("You've created a new subject.");

          navigate("/");
        })
        .catch((error) => {
          console.log(error);

          alert("Error while creating subject:", error);
        });
    }
  };

  const handleDelete = () => {
    axios
      .delete(`http://localhost:8080/api/subject/delete/${id}`)
      .then((response) => {
        console.log(response);
        alert("You've deleted the subject.");
        navigate("/");
      })
      .catch((error) => {
        alert("Error while deleting subject:", error);
      });
  };

  return (
    <div>
      <form>
        <div className="form-row">
          <div className="col">
            <label className="label-form" htmlFor="idInput">
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
            <label className="label-form" htmlFor="nameInput">
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
          <div className="col">
            <label className="label-form" htmlFor="ectsInput">
              ECTS
            </label>
            <input
              type="number"
              min="1"
              className="form-control"
              value={ectsInput}
              onChange={(e) => setEctsInput(Number(e.target.value))}
              id="ectsInput"
            />
          </div>

          <div className="col">
            <label className="label-form" htmlFor="studyProgramInput">
              Study Program
            </label>
            <select
              className="form-control"
              value={studyProgramInput}
              onChange={(e) => setSPInput(Number(e.target.value))}
              id="studyProgramInput"
            >
              <option value="">Choose a study program</option>
              {studyPrograms.map((program) => (
                <option key={program.id} value={program.id}>
                  {program.name}
                </option>
              ))}
            </select>
          </div>
        </div>

        <div className="form-row" style={{ marginTop: "20px" }}>
          <div className="col">
            <label className="label-form" htmlFor="semesterInput">
              Semester
            </label>
            <input
              type="number"
              min="1"
              className="form-control"
              value={semesterInput}
              onChange={(e) => setSemesterInput(Number(e.target.value))}
              id="semesterInput"
            />
          </div>

          <div className="col">
            <label className="label-form" htmlFor="classHoursInput">
              Class Hours
            </label>
            <input
              type="number"
              min="1"
              className="form-control"
              value={classHoursInput}
              onChange={(e) => setCHInput(Number(e.target.value))}
              id="classHoursInput"
            />
          </div>
        </div>
        <div className="col">
          <label className="label-form" htmlFor="statusInput">
            Status
          </label>
          <select
            className="form-control"
            value={statusInput}
            onChange={(e) => {
              setStatusInput(e.target.value);
            }}
            id="statusInput"
          >
            <option value="COMPULSORY">COMPULSORY</option>
            <option value="ELECTIVE">ELECTIVE</option>
          </select>
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
      <p className="text-center">
        Click on save to save subject or delete to delete it.
      </p>
    </div>
  );
};

export default AddSubject;
