package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> getDogs() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE pet_type ILIKE('Dog') AND is_adopted = FALSE";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Pet pet = mapRowToPet(results);
            pets.add(pet);
        }
        return pets;
    }

    @Override
    public List<Pet> getCats() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE pet_type ILIKE('Cat') AND is_adopted = FALSE";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Pet pet = mapRowToPet(results);
            pets.add(pet);
        }
        return pets;
    }

    @Override
    public List<Pet> getOthers() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE pet_type != 'Dog' AND pet_type != 'Cat' AND is_adopted = FALSE";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Pet pet = mapRowToPet(results);
            pets.add(pet);
        }
        return pets;
    }

    @Override
    public Pet getPetById(Long petId) {
        Pet pet = null;
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        if (results.next()) {
            pet = mapRowToPet(results);
        }
        return pet;
    }

    @Override
    public Pet createPet(Pet pet) {
        String sql = "INSERT INTO pets (pet_name, pet_type, pet_gender, pet_breed, pet_birthdate, pet_description, pet_photo, adopter_info)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id";
        Long newPet = jdbcTemplate.queryForObject(sql, Long.class, pet.getPetName(), pet.getPetType(), pet.getPetGender(),
                pet.getPetBreed(), pet.getPetBirthdate(), pet.getPetDescription(), pet.getPetPhoto(), pet.getPetAdopterInfo());
        return getPetById(newPet);
    }

    @Override
    public Pet updatePet(Pet pet, Long petId) {
        Pet result = pet;
        String sql = "UPDATE pets " +
                     "SET pet_name = ?, " +
                     "pet_type = ?, " +
                     "pet_gender = ?, " +
                     "pet_breed = ?, " +
                     "pet_birthdate = ?, " +
                     "arrival_date = ?, " +
                     "pet_description = ?, " +
                     "pet_photo = ?, " +
                     "is_adopted = ?, " +
                     "adopter_info = ? " +
                     "WHERE pet_id = ?; ";
        jdbcTemplate.update(sql, pet.getPetName(),
                pet.getPetType(),
                pet.getPetGender(),
                pet.getPetBreed(),
                pet.getPetBirthdate(),
                pet.getPetArrivalDate(),
                pet.getPetDescription(),
                pet.getPetPhoto(),
                pet.isPetIsAdopted(),
                pet.getPetAdopterInfo() ,
                petId);
        return result;
    }

    private Pet mapRowToPet(SqlRowSet rs) {
        Pet pet = new Pet();
        pet.setPetId(rs.getLong("pet_id"));
        pet.setPetName(rs.getString("pet_name"));
        pet.setPetType(rs.getString("pet_type"));
        pet.setPetGender(rs.getString("pet_gender"));
        pet.setPetBreed(rs.getString("pet_breed"));
        pet.setPetBirthdate(rs.getDate("pet_birthdate"));
        pet.setPetArrivalDate(rs.getDate("arrival_date"));
        pet.setPetDescription(rs.getString("pet_description"));
        pet.setPetPhoto(rs.getString("pet_photo"));
        pet.setPetAdopterInfo(rs.getString("adopter_info"));
        return pet;
    }
}

