package uga.menik.cs4370.models;

public class FeaturedImage {
    private String title;
    private String feature_date;
    private String image_id;
    private String description;

    public FeaturedImage(String title, String feature_date, String image_id, String description) {
        this.title = title;
        this.feature_date = feature_date;
        this.image_id = image_id;
        this.description = description;
    }
}

