<template>
<div>
  <div id="register" class="text-center">
    <h1>
      <img
        src="https://i.ibb.co/LP8ZpR2/Image-from-i-OS-10.png"
        alt="shelter logo"
        id="logo"
      />
    </h1>
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Apply to be a volunteer!</h1>
      <div class="input-list">
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
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
      /> <br>
      <label for="password" class="sr-only">Password: </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <br />
      <label for="firstName" class="sr-only">First Name: </label>
      <input
        type="text"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        v-model="user.firstname"
        required
        autofocus
      /> <br>
      <label for="lastName" class="sr-only">Last Name: </label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        v-model="user.lastname"
        required
        autofocus
      />
      <br />
      <label for="email" class="sr-only">Email: </label>
      <input
        type="text"
        id="email"
        class="form-control"
        placeholder="Email"
        v-model="user.email"
        required
        autofocus
      /> <br>
      <label for="phoneNumber" class="sr-only">Phone Number: </label>
      <input
        type="text"
        id="phoneNumber"
        class="form-control"
        placeholder="Phone Number"
        v-model="user.phone"
        required
        autofocus
      />
      <br />
      </div> <br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Apply
      </button> <br>
      <br />
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
    </form>
  </div>
   <img class= "bubble-banner" src="https://cdn10.bigcommerce.com/s-lzmxlzw/product_images/uploaded_images/banner_give.png" alt="bubble banner">
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
        firstname: "",
        lastname: "",
        email: "",
        phone: ""
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style></style>
