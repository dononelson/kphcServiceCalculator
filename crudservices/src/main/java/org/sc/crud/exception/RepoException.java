package org.sc.crud.exception;

public class RepoException extends Exception {
    /**
     * Generic exception
     */
    private static final long serialVersionUID = 1L;

    public RepoException(final String errorString) {
        super(errorString);
    }

    public RepoException() {
        super();
    }
}
