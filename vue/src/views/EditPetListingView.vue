<template>
  <div>
      <update-pet-listing></update-pet-listing>
  </div>
</template>

<script>
import UpdatePetListing from "../components/UpdatePetListing.vue"

export default{
  name: "edit-listing-page",
  components: { 
    UpdatePetListing 
    },
  }
</script>

<style>

</style>