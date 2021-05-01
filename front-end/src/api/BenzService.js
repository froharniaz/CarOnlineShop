



import axios from "axios";
const axiosClient = axios.create({
    baseURL : "http://localhost:3000/api"
})
export default{
    AddBenz(Benz){
      return  axiosClient.post("/benz/AddBenz",Benz);
    },
    getAllBenzs(){
        return axiosClient.get("/benz/allBenz");
    },
    deleteById(BenzId){
        return axiosClient.delete(`/benz/${BenzId}/delete`);

    },
    getById(BenzId){
        return axiosClient.get(`/benz/${BenzId}`);
    },
    updateBenz(Benz){
        return axiosClient.put("/benz/update",Benz);
    }
}