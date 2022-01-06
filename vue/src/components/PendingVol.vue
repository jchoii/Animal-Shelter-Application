<template>
  <div class="text-center">
    <h1>
      <img
        src="https://i.ibb.co/LP8ZpR2/Image-from-i-OS-10.png"
        alt="shelter logo"
        id="logo"
      />
    </h1>
    <table id = "user-list">
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Phone Number</th>
          <th>Email Address</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in pendingUsers" v-bind:key="user.id">
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.phone }}</td>
          <td>{{ user.email }}</td>
          <td><button v-on:click="approve(user.id)">Approve</button><button v-on:click="decline(user.id)">Decline</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import userService from "@/services/UserService.js";

export default {
  name: "pending-users-list",
  data() {
    return {
      pendingUsers: [
        {
          firstName: "",
          lastName: "",
          phone: "",
          email: "",
        },
      ],
    };
  },
  created() {
    userService.getPendingUsers().then((response) => {
      this.pendingUsers = response.data;
    });
  },
  methods: {
    approve(id) {
        userService
        .approvePending(id)
        .then((response) => {
          if (response.status === 200) {
            this.$router.go();
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg =
              "Error updating user. Response was: " + error.response.statusText;
          } else if (error.request) {
            this.errorMsg = "Error updating user. Server could not be reached.";
          } else {
            this.errorMsg = "Error updating user. Could not create request";
          }
        });
    },
    decline(id) {
      userService
        .rejectPending(id)
        .then((response) => {
          if (response.status === 200) {
            this.$router.go();
          }
        })
        .catch((error) => {
          //if it fails then we should set the error message
          if (error.response) {
            this.errorMsg =
              "Error updating user. Response was: " + error.response.statusText;
          } else if (error.request) {
            this.errorMsg = "Error updating user. Server could not be reached.";
          } else {
            this.errorMsg = "Error updating user. Could not create request";
          }
        });
    },
  },
};
</script>

<style>
</style>