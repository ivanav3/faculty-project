import { useNavigate } from "react-router-dom";

const OneStudyProgram = ({ studyProgram }) => {
  const navigate = useNavigate();

  const handleDetails = () => {
    navigate(`/addStudyProgram/${studyProgram.id}`);
  };

  return (
    <tr>
      <th scope="row" className="text-center">
        {studyProgram.id}
      </th>
      <td className="text-center"> {studyProgram.name}</td>
      <td className="text-center">
        <button onClick={handleDetails}>Details</button>
      </td>
    </tr>
  );
};

export default OneStudyProgram;
