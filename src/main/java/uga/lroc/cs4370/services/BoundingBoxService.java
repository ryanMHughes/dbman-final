package uga.lroc.cs4370.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uga.lroc.cs4370.models.Image;
import uga.lroc.cs4370.models.LandingSite;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

@Service
public class BoundingBoxService {

    @Autowired
    private DataSource dataSource;

    public List<Image> getImagesIntersectingLandingSite(LandingSite site) {
        List<Image> images = new ArrayList<>();

        String sql = """
            SELECT DISTINCT i.*
            FROM BoundingBox target
            JOIN BoundingBox b ON
                b.bounding_box_id != target.bounding_box_id
                AND b.min_lat <= target.max_lat
                AND b.max_lat >= target.min_lat
                AND b.min_long <= target.max_long
                AND b.max_long >= target.min_long
            JOIN Images i ON i.bounding_box_id = b.bounding_box_id
            WHERE target.bounding_box_id = ?
        """;

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, site.bounding_box_id);

            try (var rs = stmt.executeQuery()) {
                while (rs.next()) {
                    images.add(new Image(
                        rs.getString("image_id"),
                        rs.getString("Pds_volume_name"),
                        rs.getInt("Orbit_number"),
                        rs.getString("Start_time"),
                        rs.getString("url")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching intersecting images: " + e.getMessage(), e);
        }

        return images;
    }

}
