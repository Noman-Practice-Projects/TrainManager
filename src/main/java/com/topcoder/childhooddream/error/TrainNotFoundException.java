package com.topcoder.childhooddream.error;

/**
 * The type Train not found exception.
 */
public class TrainNotFoundException extends RuntimeException {
    
    
    public TrainNotFoundException() {
    
    }

    /**
     * Instantiates a new Train not found exception.
     *
     * @param message the message
     */
    public TrainNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Train not found exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public TrainNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Train not found exception.
     *
     * @param cause the cause
     */
    public TrainNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Train not found exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected TrainNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
