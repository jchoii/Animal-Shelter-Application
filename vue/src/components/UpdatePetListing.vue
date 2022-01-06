<template>
  <form v-on:submit.prevent class="text-center">
    <h1>
      <img
        src="https://i.ibb.co/LP8ZpR2/Image-from-i-OS-10.png"
        alt="shelter logo"
        id="logo"
      />
    </h1>
    <h1>Update Pet Listing</h1>
    <div class="input-list">
    <div class="field">
      <label for="petName">Name: </label>
      <input name="Name" type="text" v-model="pet.petName" />
    </div>
    <div class="field">
      <label for="petPhoto">Photo: </label>
      <input name="Photo" type="text" v-model="pet.petPhoto" />
    </div>
    <div class="field">
      <label for="gender">Sex: </label>
        <input
          type="radio"
          name="petGender"
          v-model="pet.petGender"
          value="M"
        /><label for="male">Male</label>
        <input
          type="radio"
          name="petGender"
          v-model="pet.petGender"
          value="F"
        />
        <label for="female">Female</label>
        </div>
    <div class="field">
      <label for="petBreed">Breed: </label>
      <input name="Breed" type="text" v-model="pet.petBreed" />
    </div>
    <div class="field">
      <label for="petBirthdate">Birthdate: </label>
      <input name="Birthdate" type="text" v-model="pet.petBirthdate" />
    </div>
    <div class="field">
      <label for="petArrivalDate">Arrival Date: </label>
      <input name="Arrival Date" type="text" v-model="pet.petArrivalDate" />
    </div>
    <div class="field">
      <label for="petDescription">Description: </label>
      <textarea name="Description" type="text" v-model="pet.petDescription" />
    </div>
    <div class="field">
      <label for="markAdopted">Adopted </label>
      <input
        name="Mark Adopted"
        type="checkbox"
        v-model="pet.petIsAdopted"
      />
    </div>
    <div class="field">
      <label for="AdopterInfo">Adopter Info: </label>
      <textarea name="Adopter" type="text" v-model="pet.petAdopterInfo" />
    </div>
    </div>
    <div class="actions">
      <button id="add-pet-button" type="submit" v-on:click="updatePetListing">Submit</button>
    </div>
  </form>
</template>

<script>
import petService from "@/services/PetService";
export default {
  name: "update-listing",
  data() {
    return {
      pet: {
        petName: "",
        petPhoto: "",
        petGender: "",
        petBreed: "",
        petBirthdate: "",
        petArrivalDate: "",
        petDescription: "",
        petAdopterInfo: "",
        petIsAdopted: false,
        petType: "",
      },
    };
  },
  created() {
    petService.getPetById(this.$route.params.id).then((response) => {
      this.pet = response.data;
    });
  },
  methods: {
    updatePetListing() {
      petService
        .updatePet(this.pet)
        .then((response) => {
          console.log(response);
          if (response.status === 200) {
            this.$router.push({ name: `${this.pet.petType}s` });
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg =
              "Error updating pet. Response was: " + error.response.statusText;
          } else if (error.request) {
            this.errorMsg = "Error updating pet. Server could not be reached.";
          } else {
            this.errorMsg = "Error updating pet. Could not create request";
          }
        });
    },
  },
};
</script>

<style>
h1 {
  margin-bottom: 20px;
  color: rgb(49, 63, 165)
}
</style>