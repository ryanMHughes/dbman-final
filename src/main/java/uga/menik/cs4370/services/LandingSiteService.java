package uga.menik.cs4370.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uga.menik.cs4370.models.ExpandedImage;
import uga.menik.cs4370.models.Image;
import uga.menik.cs4370.models.LandingSite;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class LandingSiteService {

    private final DataSource dataSource;

   @Autowired
   public LandingSiteService(DataSource dataSource) {
      this.dataSource = dataSource;
   }

   public List<LandingSite> searchByName(String siteName) {
      String sql = "SELECT landing_site_name, mission, description FROM LandingSites WHERE landing_site_name LIKE ?";
      List<LandingSite> sites = new ArrayList<>();

      try (Connection conn = dataSource.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

         stmt.setString(1, "%" + siteName + "%");
         ResultSet rs = stmt.executeQuery();

         while (rs.next()) {
            sites.add(new LandingSite(
               rs.getString("landing_site_name"),
               rs.getString("description"),
               rs.getString("mission")
            ));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return sites;
   }

   public List<LandingSite> getAllLandingSites() {
      String sql = "SELECT landing_site_name, mission, description FROM LandingSites";
      List<LandingSite> sites = new ArrayList<>();

      try (Connection conn = dataSource.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

         ResultSet rs = stmt.executeQuery();

         while (rs.next()) {
            sites.add(new LandingSite(
               rs.getString("landing_site_name"),
               rs.getString("description"),
               rs.getString("mission")
            ));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return sites;
   }

   public LandingSite getLandingSiteByName(String name) {
      System.out.println(name);
        String sql = "SELECT * FROM LandingSites WHERE landing_site_name = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new LandingSite(
                            rs.getString("landing_site_name"),
                            rs.getString("description"),
                            rs.getString("mission"),
                            rs.getInt("bounding_box_id")
                    );
                } else {
                    throw new RuntimeException("Landing site not found: " + name);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Database error fetching landing site: " + e.getMessage(), e);
        }
    }


}