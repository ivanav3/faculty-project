import OneSubject from "../components/OneSubject";
import { useState, useEffect } from "react";
import axios from "axios";

const ShowAllSubjects = () => {
  const [subjects, setSubjects] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/subject/all")
      .then((response) => {
        setSubjects(response.data);
        console.log(subjects);
      })
      .catch((error) => {
        alert("Error while getting all the subjects.");
        console.log(error);
      });
  }, []);

  return (
    <div>
      <table className="table table-hover">
        <thead className="text-center">
          <tr>
            <th scope="col" className="text-center">
              ID
            </th>
            <th scope="col" className="text-center">
              Name
            </th>
            <th scope="col" className="text-center">
              ECTS
            </th>
            <th scope="col" className="text-center">
              Study program (ID)
            </th>
            <th scope="col" className="text-center">
              Semester
            </th>
            <th scope="col" className="text-center">
              Status
            </th>
            <th scope="col" className="text-center">
              Class hours
            </th>
          </tr>
        </thead>
        <tbody>
          {subjects.map((subject) => (
            <OneSubject key={subject.id} subject={subject} />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ShowAllSubjects;
