package uga.lroc.cs4370.models;

public class LandingSite {
   public String name;
   public String description;
   public String mission;
   public int bounding_box_id;
   public double minLat;
   public double minLong;
   public double maxLat;
   public double maxLong;

   public LandingSite(String name, String description, String mission) {
      this.name = name;
      this.description = description;
      this.mission = mission;
   }

   public LandingSite(String name, String description, String mission, int bounding_box_id) {
      this.name = name;
      this.description = description;
      this.mission = mission;
      this.bounding_box_id = bounding_box_id;
   }


    
}
