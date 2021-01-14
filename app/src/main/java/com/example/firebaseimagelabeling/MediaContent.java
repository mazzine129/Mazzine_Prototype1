package com.example.firebaseimagelabeling;

class MediaContent {
    Integer contentLogo;
    String contentName;
    String contentKey;


    public MediaContent(Integer contentLogo, String contentName, String contentKey) {
        this.contentLogo = contentLogo;
        this.contentName = contentName;
        this.contentKey = contentKey;
    }

    public Integer getContentLogo() {
        return contentLogo;
    }

    public String getContentName() {
        return contentName;
    }

    public String getContentKey() {return contentKey;}


}
