package com.learning.telusko.bo;

import jakarta.persistence.*;

//pojo class
@Entity
@Table(name="vaccinedetails")
public class VaccineDetails {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "VaccineName")
    private String vaccineName;
    @Column(name = "VaccineCompany")
    private String vaccineCompany;
    @Column(name = "VaccineCost")
    private String vaccineCost;

    public VaccineDetails() {
        System.out.println("Vaccine details bean created");
    }

    public VaccineDetails(String vaccineName, String vaccineCompany, String vaccineCost) {

        this.vaccineName = vaccineName;
        this.vaccineCompany = vaccineCompany;
        this.vaccineCost = vaccineCost;
    }

    @Override
    public String toString() {
        return "VaccineDetails{" +
                "id=" + id +
                ", vaccineName='" + vaccineName + '\'' +
                ", vaccineCompany='" + vaccineCompany + '\'' +
                ", VaccineCost='" + vaccineCost + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineCompany() {
        return vaccineCompany;
    }

    public void setVaccineCompany(String vaccineCompany) {
        this.vaccineCompany = vaccineCompany;
    }

    public String getVaccineCost() {
        return vaccineCost;
    }

    public void setVaccineCost(String vaccineCost) {
        this.vaccineCost = vaccineCost;
    }
}
