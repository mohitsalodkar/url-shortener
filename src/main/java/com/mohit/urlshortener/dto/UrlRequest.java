package com.mohit.urlshortener.dto;

public class UrlRequest {


private String originalUrl;

private String customCode;

public UrlRequest() {
}

public String getOriginalUrl() {
    return originalUrl;
}

public void setOriginalUrl(String originalUrl) {
    this.originalUrl = originalUrl;
}

public String getCustomCode() {
    return customCode;
}

public void setCustomCode(String customCode) {
    this.customCode = customCode;
}


}
