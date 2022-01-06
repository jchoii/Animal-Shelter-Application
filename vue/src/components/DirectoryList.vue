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
        <tr v-for="user in approvedUsers" v-bind:key="user.id">
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.phone }}</td>
          <td>{{ user.email }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import userService from "@/services/UserService.js";

export default {
  name: "approved-users-list",
  data() {
    return {
      approvedUsers: [
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
    userService.getApprovedUsers().then((response) => {
      this.approvedUsers = response.data;
    });
  },
  methods: {},
};
</script>

<style>
#user-list{
  margin-left: auto;
  margin-right: auto;
}
table {
  border-collapse: separate;
  border-spacing: 15px 0;
}
td{
  padding: 4px;
}
</style>