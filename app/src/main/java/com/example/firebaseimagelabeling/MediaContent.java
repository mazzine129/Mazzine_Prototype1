package com.example.firebaseimagelabeling;

class MediaContent {
    Integer contentLogo;
    String contentName;


    public MediaContent(Integer contentLogo, String contentName) {
        this.contentLogo = contentLogo;
        this.contentName = contentName;
    }

    public Integer getContentLogo() {
        return contentLogo;
    }

    public String getContentName() {
        return contentName;
    }


}
