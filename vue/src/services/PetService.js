import axios from 'axios';

// const axios =axios.create({
//     baseURL: "http://localhost:8080"
// });

export default {

    getDogList() {
        return axios.get('/dogs');
    },

    getCatList() {
        return axios.get('/cats');
    },

    getOthersList() {
        return axios.get('/others');
    },
 
    addNewPet(pet){
        return axios.post('/addPet', pet);
    },

    updatePet(pet){
        return axios.put(`/updatePet/${pet.petId}`, pet);
    },

    getPetById(petId) {
        return axios.get(`/pets/${petId}`);
    }

}