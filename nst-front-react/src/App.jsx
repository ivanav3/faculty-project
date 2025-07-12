import Navbar from "./components/Navbar";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import ShowAllSubjects from "./pages/ShowAllSubjects";
import ShowAllStudyPrograms from "./pages/ShowAllStudyPrograms";
import AddSubject from "./pages/AddSubject";
import AddStudyProgram from "./pages/AddStudyProgram";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/showAllSubjects" element={<ShowAllSubjects />}></Route>
          <Route
            path="/showAllStudyPrograms"
            element={<ShowAllStudyPrograms />}
          ></Route>
          <Route path="/addSubject/:id?" element={<AddSubject />}></Route>
          <Route
            path="/addStudyProgram/:id?"
            element={<AddStudyProgram element={false} />}
          ></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
