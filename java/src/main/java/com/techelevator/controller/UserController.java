package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Pet;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private UserDao userDao;
    private PetDao petDao;

    public UserController(UserDao userDao, PetDao petDao) {
        this.userDao = userDao;
        this.petDao = petDao;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @RequestMapping(path = "/listOfUsers", method = RequestMethod.GET)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @RequestMapping(path = "/approved", method = RequestMethod.GET)
    public List<User> findAllApproved() {
        return userDao.findAllApproved();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @RequestMapping(path = "/pending", method = RequestMethod.GET)
    public List<User> findAllPending() {
        return userDao.findAllPending();
    }

    @RequestMapping(path = "/approveUser/{id}", method = RequestMethod.PUT)
    public User updateIsApproved(@PathVariable Long id) {
        return userDao.updateIsApproved(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/rejectUser/{id}", method = RequestMethod.PUT)
    public User updateIsRejected(@PathVariable Long id) {
        return userDao.updateIsRejected(id);
    }

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long userId) {
        return userDao.getUserById(userId);
    }

    @RequestMapping(path = "/newUser/{id}", method = RequestMethod.PUT)
    public User updateNewUser(@PathVariable Long id) {return userDao.updateNewUser(id);}
}