import axios from "axios";
const axiosClient = axios.create({
    baseURL : "http://localhost:3000/api"
})
export default{
    AddJeep(Jeep){
      return  axiosClient.post("/Jeep/add",Jeep);
    },
    getAllJeeps(){
        return axiosClient.get("/jeep/allJeep");
    },
    deleteById(JeepId){
        return axiosClient.delete(`/Jeep/${JeepId}/delete`);

    },
    getById(JeepId){
        return axiosClient.get(`/Jeep/${JeepId}`);
    },
    updateJeep(Jeep){
        return axiosClient.put("/Jeep/update",Jeep);
    }
}