package com.techelevator.model;

import java.util.Date;

public class Pet {
    private Long petId;
    private String petName;
    private String petType;
    private String petGender;
    private String petBreed;
    private Date petBirthdate;
    private String petDescription;
    private String petPhoto;
    private String petAdopterInfo;
    private Date petArrivalDate;
    private boolean petIsAdopted;

    public Pet() {
    }

    public Pet(Long petId, String petName, String petType, String petGender, String petBreed, Date petBirthdate, String petDescription, String petPhoto, Date petArrivalDate, boolean petIsAdopted) {
        this.petId = petId;
        this.petName = petName;
        this.petType = petType;
        this.petGender = petGender;
        this.petBreed = petBreed;
        this.petBirthdate = petBirthdate;
        this.petDescription = petDescription;
        this.petPhoto = petPhoto;
        this.petArrivalDate = petArrivalDate;
        this.petIsAdopted = petIsAdopted;
    }

    public Long getPetId() {
        return petId;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetType() {
        return petType;
    }

    public String getPetGender() {
        return petGender;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public Date getPetBirthdate() {
        return petBirthdate;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public String getPetPhoto() {
        return petPhoto;
    }

    public Date getPetArrivalDate() {
        return petArrivalDate;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public void setPetBirthdate(Date petBirthdate) {
        this.petBirthdate = petBirthdate;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto;
    }
    public void setPetArrivalDate(Date petArrivalDate){
        this.petArrivalDate = petArrivalDate;
    }

    public String getPetAdopterInfo() {
        return petAdopterInfo;
    }

    public void setPetAdopterInfo(String petAdopterInfo) {
        this.petAdopterInfo = petAdopterInfo;
    }

    public boolean isPetIsAdopted() {
        return petIsAdopted;
    }

    public void setPetIsAdopted(boolean petIsAdopted) {
        this.petIsAdopted = petIsAdopted;
    }
}