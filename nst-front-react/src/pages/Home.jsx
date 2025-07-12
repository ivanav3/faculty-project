import { useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  const handleShowAllSP = () => {
    navigate("/showAllStudyPrograms");
  };
  const handleAddSP = () => {
    navigate("/addStudyProgram");
  };

  const handleShowAllSubjects = () => {
    navigate("/showAllSubjects");
  };
  const handleAddSubject = () => {
    navigate("/addSubject");
  };

  return (
    <div
      style={{
        padding: "20px",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
      }}
    >
      <h1 style={{ marginBottom: "50px" }}>Choose a task</h1>
      <div style={{ display: "flex", gap: "20px", marginBottom: "20px" }}>
        <button onClick={handleShowAllSP}>Show all study programs</button>
        <button onClick={handleAddSP}>Add a study program</button>
      </div>
      <div style={{ display: "flex", gap: "20px", marginBottom: "20px" }}>
        <button onClick={handleShowAllSubjects}>Show all subjects</button>
        <button onClick={handleAddSubject}>Add a subject</button>
      </div>
    </div>
  );
};

export default Home;
