package mre.spring.facture.exception;

import java.util.Date;

public class ErrorDetails {
    private Date dayDate;
    private String message;
    private String details;

    public ErrorDetails(Date dayDate, String message, String details) {
        super();
        this.dayDate = dayDate;
        this.message = message;
        this.details = details;
    }

}