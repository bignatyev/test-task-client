package com.taskombanktesttask.clientjournal.domain.dto;

import com.taskombanktesttask.clientjournal.domain.models.DeleteClientModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteClientDTO {

    private int id;

    public DeleteClientDTO() {

    }

    public DeleteClientDTO(DeleteClientModel deleteClientModel) {
        this.id = deleteClientModel.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
