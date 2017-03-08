package com.domain.controller;


public enum ResultStatus {

    /**
     * Request was successfully processed
     */
    OK,

    /**
     * Tells some information to the client
     */
    INFO,

    /**
     * Some warning information
     */
    WARN,

    /**
     * An error occured while request was processed
     */
    ERROR;

}
