import axios from "axios";
const axiosClient = axios.create({
    baseURL : "http://localhost:3000/api"
})
export default{
    AddToyota(Toyota){
      return  axiosClient.post("/Toyota/add",Toyota);
    },
    getAllToyotas(){
        return axiosClient.get("/Toyota/allToyota");
    },
    deleteById(ToyotaId){
        return axiosClient.delete(`/Toyota/${ToyotaId}/delete`);

    },
    getById(ToyotaId){
        return axiosClient.get(`/toyota/${ToyotaId}`);
    },
    updateToyota(Toyota){
        return axiosClient.put("/Toyota/update",Toyota);
    }
}