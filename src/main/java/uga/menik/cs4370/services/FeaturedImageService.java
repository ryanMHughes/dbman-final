package uga.menik.cs4370.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import uga.menik.cs4370.models.FeaturedImage;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeaturedImageService {

    private final DataSource dataSource;

    @Autowired
    public FeaturedImageService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<FeaturedImage> getAllFeaturedImages() {
        String sql = "SELECT title, feature_date, image_id, description FROM FeaturedImages";
        List<FeaturedImage> images = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                images.add(new FeaturedImage(
                    rs.getString("title"),
                    rs.getString("feature_date"),
                    rs.getString("image_id"),
                    rs.getString("description")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace(); // replace with logger if needed
        }

        return images;
    }

    public List<FeaturedImage> findByDate(String month, String day, String year) {
        String dateString = String.format("%s-%02d-%02d", year, Integer.parseInt(month), Integer.parseInt(day));
        String sql = "SELECT title, feature_date, image_id, description FROM FeaturedImages WHERE feature_date = ?";
        List<FeaturedImage> images = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dateString);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    images.add(new FeaturedImage(
                        rs.getString("title"),
                        rs.getString("feature_date"),
                        rs.getString("image_id"),
                        rs.getString("description")
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // replace with logger if needed
        }

        return images;
    }
}

