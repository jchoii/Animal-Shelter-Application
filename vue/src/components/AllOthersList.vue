<template>
  <div class="other-card">
    <h1>
      <img
        src="https://i.ibb.co/LP8ZpR2/Image-from-i-OS-10.png"
        alt="shelter logo"
        id="logo"
      />
    </h1>
    <div class="pet-card" v-for="other in others" v-bind:key="other.petId">
      <h2 class="pet-name">{{ other.petName }}</h2>
      <h3 class="pet-id">Pet ID: {{ other.petId }}</h3>
      <img v-bind:src="'/assets/' + other.petPhoto" alt="other photo" id="pet-photo" />
      <h3 class="pet-gender">Sex: {{ other.petGender }}</h3>
      <h3 class="pet-breed">Breed: {{ other.petBreed }}</h3>
      <h3 class="pet-birthdate">Birthdate: {{ other.petBirthdate }}</h3>
      <h3 class="arrival-date">Arrival Date: {{other.petArrivalDate}}</h3>
      <h3 class="length-of-stay">Length of Stay: <span>{{ showLengthOfStay(other) }} days</span> </h3>
      <h4 class="pet-description">{{ other.petDescription }}</h4>
      <button v-if="$store.state.user.authorities" v-on:click= "onUpdate(other.petId)">Update</button>
    </div>
  </div>
</template>

<script>
import petService from "@/services/PetService";
import moment from "moment";

export default {
  name: "others-list",
  data() {
    return {
      others: [],
    };
  },
  created() {
    petService.getOthersList().then((response) => {
      this.others = response.data;
    });
  },
  methods: {
    onUpdate(petId){
      this.$router.push({name: 'editListing', params: {id: petId}})
  },
  showLengthOfStay(other){
    let given = moment(other.petArrivalDate);
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

.pet-description {
  margin: 20px;
}
.other-card {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

.other-card .pet-name {
  font-size: 1.5rem;
}

.other-card .pet-id {
  font-size: 1rem;
}
</style>