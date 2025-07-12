import axios from "axios";

const BASE_URL = "http://localhost:8080/api/subject";

export const createSubject = async (subject) => {
  try {
    await axios.post(BASE_URL, subject);
  } catch (error) {
    console.error("Error while saving subject", error);
  }
};

export const getAllSubjects = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/all`);
    return response.data;
  } catch (error) {
    console.error("Error while getting all the subjects", error);
  }
};

export const getSubjectById = async (id) => {
  try {
    const response = await axios.get(`${BASE_URL}/${id}`);
    return response.data;
  } catch (error) {
    console.error("Error while getting subject", error);
  }
};

export const deleteSubject = async (id) => {
  try {
    await axios.delete(`${BASE_URL}/delete/${id}`);
  } catch (error) {
    console.error("Error while deleting subject", error);
  }
};

export const updateSubject = async (id, subject) => {
  try {
    await axios.put(`${BASE_URL}/update/${id}`, subject);
  } catch (error) {
    console.error("Error while updating subject", error);
  }
};
