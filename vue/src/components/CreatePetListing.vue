<template>
  <div>
    <form v-on:submit.prevent="addNewPet" class="text-center">
      <h1>
        <img
          src="https://i.ibb.co/LP8ZpR2/Image-from-i-OS-10.png"
          alt="shelter logo"
          id="logo"
        />
      </h1>
      <h1>Add Pet Listing</h1>
      <div class="input-list">
        <div class="name-input">
          <label for="name">Name: </label>
          <input type="text" name="petName" v-model="pet.petName" />
        </div>
        <div class="species-input">
          <label for="species">Species: </label>
          <select name="petType" id="species-select" v-model="pet.petType">
            <option value="Dog">Dog</option>
            <option value="Cat">Cat</option>
            <option value="Other">Other</option>
          </select>
        </div>
        <div class="gender-input">
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
        <div class="breed-input">
          <label for="breed">Breed: </label>
          <input type="text" name="petBreed" v-model="pet.petBreed" />
        </div>
        <div class="birthdate-input">
          <label for="birthdate">Birthdate: </label>
          <input type="date" name="petBirthdate" v-model="pet.petBirthdate" />
        </div>
        <div class="description-input">
          <label for="description">Description: </label>
          <input
            type="text"
            name="petDescription"
            v-model="pet.petDescription"
          />
        </div>
        <div class="photo-input">
          <label for="photo">Photo URL: </label>
          <input type="text" name="petPhoto" v-model="pet.petPhoto" />
        </div>
      </div>
      <div>
        <button id="add-pet-button">Add Pet</button>
      </div>
    </form>
    <img
      class="bubble-banner"
      src="https://cdn10.bigcommerce.com/s-lzmxlzw/product_images/uploaded_images/banner_give.png"
      alt="bubble banner"
    />
  </div>
</template>

<script>
import petService from "@/services/PetService";
export default {
  name: "add-pet",
  data() {
    return {
      pet: {
        petName: "",
        petType: "",
        petGender: "",
        petBreed: "",
        petBirthdate: "",
        petDescription: "",
        petPhoto: "",
      },
    };
  },
  methods: {
    addNewPet() {
      this.pet.petPhoto = this.parseURL(this.pet.petPhoto);
      petService.addNewPet(this.pet).then((response) => {
        console.log(response.status + "   response status");
        if (response.status === 201) {
          this.$router.push({ name: `${this.pet.petType}s` });
        }
      });
    },
    parseURL(url){
      let imageName = url.substring(url.lastIndexOf("/") + 1);
      return imageName;
    }
  },
};
</script>

<style>
.input-list {
  text-align: left;
  display: inline-block;
}
#add-pet-button {
  text-align: center;
}
</style>