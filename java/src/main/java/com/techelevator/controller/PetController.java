package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Pet;
import com.techelevator.model.User;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class PetController {
    private UserDao userDao;
    private PetDao petDao;

    public PetController(UserDao userDao, PetDao petDao) {
        this.userDao = userDao;
        this.petDao = petDao;
    }

    @RequestMapping(path = "/dogs", method = RequestMethod.GET)
    public List<Pet> getDogs() {
        return petDao.getDogs();
    }

    @RequestMapping(path = "/cats", method = RequestMethod.GET)
    public List<Pet> getCats() {
        return petDao.getCats();
    }

    @RequestMapping(path = "/others", method = RequestMethod.GET)
    public List<Pet> getOthers() {
        return petDao.getOthers();
    }

    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable Long petId) {
        return petDao.getPetById(petId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addPet", method = RequestMethod.POST)
    public Pet createPet(@RequestBody Pet pet) {
        return petDao.createPet(pet);
    }

    @RequestMapping(path = "/updatePet/{petId}", method = RequestMethod.PUT)
    public Pet updatePet(@RequestBody Pet pet, @PathVariable Long petId) {
        return petDao.updatePet(pet, petId);
    }

}



