import OneStudyProgram from "../components/OneStudyProgram";
import { useState, useEffect } from "react";
import axios from "axios";

const ShowAllStudyPrograms = () => {
  const [studyPrograms, setStudyPrograms] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/studyProgram/all")
      .then((response) => {
        setStudyPrograms(response.data);
        console.log(studyPrograms);
      })
      .catch((error) => {
        alert("An error occurred. Please try again.");
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
              Choose
            </th>
          </tr>
        </thead>
        <tbody>
          {studyPrograms.map((studyProgram) => (
            <OneStudyProgram
              key={studyProgram.id}
              studyProgram={studyProgram}
            />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ShowAllStudyPrograms;
