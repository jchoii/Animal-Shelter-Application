import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:8080"
// });

export default {

getAllUsers(){
    return axios.get('/listOfUsers')
},

getApprovedUsers(){
    return axios.get('/approved')
},

getPendingUsers(){
    return axios.get('/pending')
},

approvePending(id){
    return axios.put(`/approveUser/${id}`)
},

rejectPending(id){
    return axios.put(`/rejectUser/${id}`)
},

getUserById(id) {
    return axios.get(`/users/${id}`);
}
}