<template>
  <div class="home">
    <h1>
      <img
        src="https://i.ibb.co/LP8ZpR2/Image-from-i-OS-10.png"
        alt="shelter logo"
        id="logo"
      />
    </h1>

    <div class="well-display">
      <div class="well">
        <router-link v-bind:to="{ name: 'Dogs' }">
          <img
            src="https://www.montgomerycountymd.gov/animalservices/Resources/Images/dogicon.png"
            alt="dog icon"
          />
          <div class="well-text">VIEW DOGS</div>
        </router-link>
      </div>
      <div class="well">
        <router-link v-bind:to="{ name: 'Cats' }">
          <img
            src="https://www.montgomerycountymd.gov/animalservices/Resources/Images/caticon.png"
            alt="cat icon"
          />
          <div class="well-text">VIEW CATS</div>
        </router-link>
      </div>
      <div class="well">
        <router-link v-bind:to="{ name: 'Others' }">
          <img
            src="https://www.montgomerycountymd.gov/animalservices/Resources/Images/othericon.png"
            alt="other pets icon"
          />
          <div class="well-text">VIEW OTHERS</div>
        </router-link>
      </div>
    </div>

    <div class="grid">
      <div>
      <img
        src="https://i.ibb.co/ZHjzmQc/dog-and-cat-banner-new.png"
        alt="shelter banner"
        border="0"
        id="banner"
      /></div>
      <div class="description">
        <h2 id="home-tagline">Welcome to the Family!</h2>
        <h4 id="home-h4">
          With hundreds of animals coming through our doors each year, Green
          Animal Shelter provides a safe place for dogs, cats, and small animals
          to stay while they wait for their forever families. We have a live
          release rate of over 90% and are very proud of our excellent volunteer
          program and the wonderful animal-loving community we're a part of!
          Thanks to the support provided by the valuable time of our volunteers
          and generous donations from the community, we have helped give happy
          homes to over 2,000 pets to date.
        </h4>
        <p id="home-p">
          Want to get involved?
          <a href="/register" class="linkedin">Join our volunteer program!</a>
          <br /> <br>
          Interested in adopting a new furr-ever friend? Visit us in person or
          browse our list of available pets online and contact us to learn more!
        </p>
      </div>
      <div id="sidebar" class="description">
        <h4>CONTACT US</h4>
        <p>
          (200) 867-5309 <br /> <br>
          greenshelter@adopt.com <br /> <br>
          2901 Osceola Pkwy <br />
          Bay Lake, FL 34747
        </p>
        <h4>HOURS</h4>
        <p>
          Mon - Sat: 9AM - 7PM <br />
          Sun: 10AM - 5PM <br />
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style>
h1 {
  text-align: center;
  margin-top: 5px;
  margin-bottom: 2px;
  display: flex;
  justify-content: center;
}
#logo {
  width: 20%;
  height: auto;
}
div.well-display {
  display: flex;
  justify-content: center;
  width: 100%;
  text-align: center;
  margin: 0.75rem;
  font-weight: bold;
  font-family: "Nunito Sans", sans-serif;
}
div.well {
  margin: 40px;
  margin-top: 10px;
  margin-bottom: 10px;
}
.well-text {
  text-decoration: none;
  color: #7e6037;
}
#banner {
  width: 550px;
  height: auto;
  border-radius: 15px;
  margin-top: 10px;
}
.grid{
  display: grid;
  grid-template-columns: 1.5fr 2fr 1fr;
  align-items: center;
  justify-items: center;
}
#home-tagline{
  font-size: 30px;
  color: rgb(37, 47, 126);
}
#home-h4{
  font-size: 19px;
  color: rgb(37, 47, 126);
}
#home-p{
  font-size: 17px;
  color: rgb(37, 47, 126);
}
#sidebar{
  font-size: 120%;
  color:rgb(122, 93, 54);
}
.description{
  background-color: rgba(143, 184, 221, 0.26);
  border-radius: 15px;
  padding: 20px;
}
</style>