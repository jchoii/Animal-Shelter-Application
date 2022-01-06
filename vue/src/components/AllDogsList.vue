<template>
  <div class="dog-card">
    <h1>
      <img
        src="https://i.ibb.co/LP8ZpR2/Image-from-i-OS-10.png"
        alt="shelter logo"
        id="logo"
      />
    </h1>
    <div class="pet-card" v-for="dog in dogs" v-bind:key="dog.petId">
      <h2 class="pet-name">{{ dog.petName }}</h2>
      <h3 class="pet-id">Pet ID: {{ dog.petId }}</h3>
      <img v-bind:src="'/assets/' + dog.petPhoto" alt="dog photo" id="pet-photo" />
      <h3 class="pet-gender">Sex: {{ dog.petGender }}</h3>
      <h3 class="pet-breed">Breed: {{ dog.petBreed }}</h3>
      <h3 class="pet-birthdate">Birthdate: {{ dog.petBirthdate }}</h3>
      <h3 class="arrival-date">Arrival Date: {{ dog.petArrivalDate }}</h3>
      <h3 class="length-of-stay">Length of Stay: <span>{{ showLengthOfStay(dog) }} days</span> </h3>
      <h4 class="pet-description">{{ dog.petDescription }}</h4>
      <button v-if="$store.state.user.authorities" v-on:click= "onUpdate(dog.petId)">Update</button>
    </div>
  </div>
</template>

<script>
import petService from "@/services/PetService.js";
import moment from "moment";

export default {
  name: "dogs-list",
  data() {
    return {
      dogs: [],
    };
  },
  created() {
    petService.getDogList().then((response) => {
      this.dogs = response.data;
    });
  },
methods:{
  onUpdate(petId){
    this.$router.push({name:'editListing', params: {id: petId}})
  },
  showLengthOfStay(dog){
    let given = moment(dog.petArrivalDate);
    let current = moment().startOf('day');
    console.log(given);
    console.log(current);
    return Math.floor(moment.duration(current.diff(given)).asDays());
  }
}
};
</script>

<style>
#pet-photo {
  width: 75%;
  height: auto;
  border-radius: 15px;
}
.pet-card {
  border: 2px solid rgb(145, 123, 77);
  border-radius: 15px;
  border-width: 3px;
  width: 250px;
  height: 800px;
  margin: 20px;
  text-align: center;
  background-color: rgba(143, 185, 221, 0.315);
  color: rgb(49, 63, 165);
}

.pet-description {
  margin: 20px;
}
.dog-card {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

.dog-card .pet-name {
  font-size: 1.5rem;
}

.dog-card .pet-id {
  font-size: 1rem;
}
</style>