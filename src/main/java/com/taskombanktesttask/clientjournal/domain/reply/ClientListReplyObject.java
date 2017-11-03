package com.taskombanktesttask.clientjournal.domain.reply;

import com.taskombanktesttask.clientjournal.domain.dto.ClientDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Reply object for clients list request
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientListReplyObject {

    /**
     * Indicates is request successfully
     * processed with no errors
     */
    private boolean success;

    /**
     * If request finished with error
     * this field will contain error description.
     * Empty if response successful
     */
    private String errorMessage;

    /**
     * Response body with list of clients
     */
    private List<ClientDTO> responseData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<ClientDTO> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<ClientDTO> responseData) {
        this.responseData = responseData;
    }

}
