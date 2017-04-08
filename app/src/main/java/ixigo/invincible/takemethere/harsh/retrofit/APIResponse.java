package ixigo.invincible.takemethere.harsh.retrofit;

import okhttp3.Headers;

public class APIResponse<T> {

    private int responseCode;
    private T response;
    private Headers headers;

    public APIResponse(int responseCode, T response) {
        super();
        this.responseCode = responseCode;
        this.response = response;
    }

    public APIResponse(int responseCode, T response, Headers headers) {
        super();
        this.responseCode = responseCode;
        this.response = response;
        this.headers = headers;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T responseString) {
        this.response = responseString;
    }

    public Headers getHeaderParams() {
        return headers;
    }

    public void setHeaderParams(Headers header) {
        this.headers = header;
    }

}
