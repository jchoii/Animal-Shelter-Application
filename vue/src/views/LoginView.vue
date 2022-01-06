<template>
<div>
  <div id="login" class="text-center">
    <h1>
      <img
        src="https://i.ibb.co/LP8ZpR2/Image-from-i-OS-10.png"
        alt="shelter logo"
        id="logo"
      />
    </h1>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering. Your volunteer application is pending approval.
      </div>
      <label for="username" class="sr-only">Username: </label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <div>
        <label for="password" class="sr-only">Password: </label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
      </div>
      <button type="submit">Sign in</button>
      <div> <br>
        <router-link :to="{ name: 'register' }">Need to apply?</router-link>
      </div>
    </form>
  </div>
    <img class= "bubble-banner" src="https://cdn10.bigcommerce.com/s-lzmxlzw/product_images/uploaded_images/banner_give.png" alt="bubble banner">
</div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
        isApproved: false
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            if(response.data.user.approved){
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            alert('Welcome! Thanks for volunteering with us!');
          }else{
            alert('Please wait for approval to access volunteer login.');
          }
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>
.text-center {
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 60vw;
  text-align: center;
  font-size: 120%;
  font-family: Asap;
  box-sizing: border-box;
  width: auto;
  position: relative;
  clear: both;
  background: white;
  background-image: -webkit-gradient(
    linear,
    left bottom,
    left top,
    color-stop(0.15, white),
    color-stop(1, #95c2fd)
  );
  background-image: -webkit-linear-gradient(bottom, #bee2ff 15%, white 100%);
  background-image: -moz-linear-gradient(bottom, #bee2ff 15%, white 100%);
  background-image: -ms-linear-gradient(bottom, #bee2ff 15%, white 100%);
  background-image: -o-linear-gradient(bottom, #bee2ff 15%, white 100%);
  background-image: linear-gradient(to top, #cbdfec 15%, white 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#95C2FD', endColorstr='#BEE2FF');
  border: white;
  -webkit-border-radius: 20px;
  -moz-border-radius: 20px;
  border-radius: 20px;
  -webkit-box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  box-shadow: inset 0 8px 5px rgba(255, 255, 255, 0.65),
    0 1px 2px rgba(0, 0, 0, 0.2);
  margin-bottom: 20px;
  margin-top: 20px;
  padding: 6px 20px;
  color: rgb(37, 47, 126);
  text-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
  word-wrap: break-word;
}

.bubble-banner{
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-top: 50px;
  margin-bottom: 20px;
  width: 30%;
}
</style>