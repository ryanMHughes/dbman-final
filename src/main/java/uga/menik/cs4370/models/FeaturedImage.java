package uga.menik.cs4370.models;

public class FeaturedImage {
    private String title;
    private String date;
    private String url;
    private String description;

    public FeaturedImage(String title, String date, String url, String description) {
        this.title = title;
        this.date = date;
        this.url = url;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getUrl() { return url; }
    public String getDescription() { return description; }
}

