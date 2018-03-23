package com.codyfjm.androidlib.net;

/**
 * author：codyfjm on 18/3/22
 * email：CodyFeng@lansion.cn
 * company:MIDONG TECHENOLOGY
 * Copyright © 2018 MIDONG TECHENOLOGY All rights reserved.
 */
public class Response {
    private boolean error;
    private int errorType;//1为cookie失效
    private String errorMessage;
    private String result;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
