import { useNavigate } from "react-router-dom";

const OneSubject = ({ subject }) => {
  const navigate = useNavigate();

  const handleDetails = () => {
    navigate(`/addSubject/${subject.id}`);
  };

  return (
    <tr>
      <th scope="row" className="text-center">
        {subject.id}
      </th>
      <td className="text-center"> {subject.name}</td>
      <td className="text-center"> {subject.ects}</td>
      <td className="text-center"> {subject.studyProgram}</td>
      <td className="text-center"> {subject.semester}</td>
      <td className="text-center"> {subject.status}</td>
      <td className="text-center"> {subject.classHours}</td>

      <td className="text-center">
        <button onClick={handleDetails}>Details</button>
      </td>
    </tr>
  );
};

export default OneSubject;
