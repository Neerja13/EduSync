import axios from "axios";

const url = "http://localhost:9921/seating_arrangement/class_room";

export const createClassRoom = (data) =>{
    return axios.post(`${url}/create/class_room`,data);
}

export const getClassRoom = (classNo)=>{
    return axios.get(`${url}/get/class_room/${classNo}`);
}

