package uga.menik.cs4370.models;

public class Image {
    private String image_id;
    private String Pds_volume_name;
    private int Orbit_number;
    private String Start_time;
    private String url;

    public Image(String image_id, String Pds_volume_name, int Orbit_number, String Start_time, String url) {
        this.image_id = image_id;
        this.Pds_volume_name = Pds_volume_name;
        this.Orbit_number = Orbit_number;
        this.Start_time = Start_time;
        this.url = url;
    }

    public String getImageName() { return image_id; }
    public String getImageType() { return Pds_volume_name; }
    public int getOrbitNumber() { return Orbit_number; }
    public String getAcquisitionTime() { return Start_time; }
    public String getUrl() { return url; }
}
