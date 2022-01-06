<template>
  <div>
      <create-pet-listing></create-pet-listing>
  </div>
</template>

<script>
import CreatePetListing from '@/components/CreatePetListing.vue'
export default {
    name: 'add-pet-view',
    components: {
        CreatePetListing
    }

}
</script>


<style>

</style>