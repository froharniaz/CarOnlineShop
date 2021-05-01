import axios from "axios";
const axiosClient = axios.create({
    baseURL : "http://localhost:3000/api"
})
export default{
    AddAccount(Account){
        return  axiosClient.post("/Account/AddAccount",Account);
    },
    getAllAccounts(){
        return axiosClient.get("/Account/allAccounts");
    },
    deleteById(AccountId){
        return axiosClient.delete(`/Account/${AccountId}/delete`);

    },
    getById(AccountId){
        return axiosClient.get(`/Account/${AccountId}`);
    },
    updateAccount(Account){
        return axiosClient.put("/Account/update",Account);
    }
}