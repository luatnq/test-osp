package com.osp.testwebservice.exception;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(String exception) {
        super(exception);
    }

}
