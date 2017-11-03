package com.taskombanktesttask.clientjournal.domain.reply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Used for replies with no result body
 * from client api (create, update and delete client).
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NoResultReplyObject {

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

}
