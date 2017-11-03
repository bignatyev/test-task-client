package com.taskombanktesttask.clientjournal.domain.dto;

import com.taskombanktesttask.clientjournal.domain.models.ClientModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public ClientDTO() {

    }

    public ClientDTO (ClientModel clientModel) {

        this.id = clientModel.getId();
        this.firstName = clientModel.getFirstName();
        this.lastName = clientModel.getLastName();
        this.email = clientModel.getEmail();
        this.phone = clientModel.getPhone();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
