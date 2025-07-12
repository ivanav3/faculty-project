import axios from "axios";

const BASE_URL = "http://localhost:8080/api/studyProgram";

export const createStudyProgram = async (studyProgram) => {
  try {
    await axios.post(BASE_URL, studyProgram);
  } catch (error) {
    console.error("Error while saving study program", error);
  }
};

export const getAllStudyPrograms = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/all`);
    return response.data;
  } catch (error) {
    console.error("Error while getting all study programs", error);
  }
};

export const getStudyProgramById = async (id) => {
  try {
    const response = await axios.get(`${BASE_URL}/${id}`);
    return response.data;
  } catch (error) {
    console.error("Error while getting study program", error);
  }
};

export const deleteStudyProgram = async (id) => {
  try {
    await axios.delete(`${BASE_URL}/delete/${id}`);
  } catch (error) {
    console.error("Error while deleting study program", error);
  }
};

export const updateStudyProgram = async (id, studyProgram) => {
  try {
    await axios.put(`${BASE_URL}/update/${id}`, studyProgram);
  } catch (error) {
    console.error("Error while updating study program", error);
  }
};
