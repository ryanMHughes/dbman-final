package uga.lroc.cs4370.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uga.lroc.cs4370.models.Image;
import uga.lroc.cs4370.models.User;

import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatasetService {

   private final DataSource dataSource;
   private final UserService userService;

   @Autowired
   public DatasetService(DataSource dataSource, UserService userService) {
      this.userService = userService;
      this.dataSource = dataSource;
   }

   public List<Image> getDataset() {
      User user = userService.getLoggedInUser();
      String sql = "SELECT i.image_id, i.Pds_volume_name, i.Orbit_number, i.Start_time, i.url FROM Dataset d, Images i WHERE d.userId = ? AND i.image_id = d.image_id";
      List<Image> images = new ArrayList<>();

      try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
         stmt.setString(1, user.userId);

         try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
               if (rs.getString("image_id").isEmpty() || rs.getString("image_id") == null) {
                  continue;
               }
               Image img = new Image(
                        rs.getString("image_id"),
                        rs.getString("Pds_volume_name"),
                        rs.getInt("Orbit_number"),
                        rs.getString("Start_time"),
                        rs.getString("url")
               );
               img.addable = false;
               images.add(img);
               }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return images;
   }

   public void addToDataset(String imageId) {
      User user = userService.getLoggedInUser();

      String checkSql = "SELECT 1 FROM Dataset WHERE userId = ? AND image_id = ?";
      String insertSql = "INSERT INTO Dataset (userId, image_id) VALUES (?, ?)";

      try (Connection conn = dataSource.getConnection();
            PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

         checkStmt.setString(1, user.userId);
         checkStmt.setString(2, imageId);

         try (ResultSet rs = checkStmt.executeQuery()) {
               if (rs.next()) {
                  return;
               }
         }

         try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
               insertStmt.setString(1, user.userId);
               insertStmt.setString(2, imageId);
               insertStmt.executeUpdate();
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
 

   public void removeFromDataset(String imageId) {
      User user = userService.getLoggedInUser();
      String sql = "DELETE FROM Dataset WHERE userId = ? AND image_id = ?";

      try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

         stmt.setString(1, user.userId);
         stmt.setString(2, imageId);
         stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
