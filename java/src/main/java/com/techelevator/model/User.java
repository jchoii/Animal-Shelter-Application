package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   private Long id;
   private String username;
   @JsonIgnore
   private String password;
   @JsonIgnore
   private boolean activated;
   private Set<Authority> authorities = new HashSet<>();
   private String firstName;
   private String lastName;
   private String email;
   private String phone;
   private boolean isApproved;
   private boolean isRejected;
   private boolean newUser;


   public User() { }

   public User(Long id, String username, String password, String authorities, boolean isApproved, boolean isRejected) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.activated = true;
      this.isApproved = false;
      this.isRejected = false;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
     return isApproved ? authorities : new HashSet<>();
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getEmail() {
      return email;
   }

   public String getPhone() {
      return phone;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public boolean isApproved() {
      return isApproved;
   }

   public void setApproved(boolean approved) {
      this.isApproved = approved;
   }

   public boolean isRejected() {
      return isRejected;
   }

   public void setRejected(boolean rejected) {
      this.isRejected = rejected;
   }
   public boolean isNewUser() {
      return newUser;
   }

   public void setNewUser(boolean newUser) {
      this.newUser = newUser;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }
}
