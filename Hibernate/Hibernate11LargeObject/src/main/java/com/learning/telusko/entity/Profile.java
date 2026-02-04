package com.learning.telusko.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.Arrays;

@Entity
public class Profile {

    @Id
    private Integer profileId;

    private String profileName;

    @Lob//large Object
    @Column(name="IMAGE", columnDefinition = "LONGBLOB")
    private byte[] image;// byte input stream

    @Lob
    @Column(name="DOC", columnDefinition = "LONGTEXT")
    private char[] charFile; // text file

    public Profile(){
        System.out.println("zero param constructor for hibernate");
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public char[] getCharFile() {
        return charFile;
    }

    public void setCharFile(char[] charFile) {
        this.charFile = charFile;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + profileId +
                ", profileName='" + profileName + '\'' +
                ", image=" + Arrays.toString(image) +
                ", charFile=" + Arrays.toString(charFile) +
                '}';
    }
}
