package uga.menik.cs4370.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uga.menik.cs4370.models.ExpandedImage;
import uga.menik.cs4370.models.Image;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    private final DataSource dataSource;

    @Autowired
    public ImageService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ExpandedImage getImageById(String imageId) {
        String sql = "SELECT * FROM Images WHERE image_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, imageId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ExpandedImage(
                        rs.getString("image_id"),
                        rs.getString("url"),
                        rs.getString("Product"),
                        rs.getString("Pds_dataset_name"),
                        rs.getString("Pds_volume_name"),
                        rs.getString("Instrument_host"),
                        rs.getString("Instrument"),
                        rs.getString("Original_product"),
                        rs.getString("Product_version"),
                        rs.getString("Mission_phase_name"),
                        rs.getString("Rationale_desc"),
                        rs.getInt("Data_quality"),
                        rs.getString("Nac_preroll_start_time"),
                        rs.getString("Start_time"),
                        rs.getString("Stop_time"),
                        rs.getInt("Spacecraft_clock_partition"),
                        rs.getString("Nac_spacecraft_clock_preroll_count"),
                        rs.getString("Spacecraft_clock_start_count"),
                        rs.getString("Spacecraft_clock_stop_count"),
                        rs.getString("Target_name"),
                        rs.getInt("Orbit_number"),
                        rs.getDouble("Slew_angle"),
                        rs.getString("Lro_node_crossing"),
                        rs.getString("Lro_flight_direction"),
                        rs.getDouble("Nac_line_exposure_duration"),
                        rs.getString("Nac_frame"),
                        rs.getInt("Nac_dac_reset"),
                        rs.getInt("Nac_channel_a_offset"),
                        rs.getInt("Nac_channel_b_offset"),
                        rs.getInt("Instrument_mode_code"),
                        rs.getInt("Compand_select_code"),
                        rs.getBoolean("Mode_compression"),
                        rs.getBoolean("Mode_test"),
                        rs.getDouble("Nac_temperature_scs"),
                        rs.getDouble("Nac_temperature_fpa"),
                        rs.getDouble("Nac_temperature_fpga"),
                        rs.getDouble("Nac_temperature_telescope"),
                        rs.getInt("Image_lines"),
                        rs.getInt("Line_samples"),
                        rs.getInt("Sample_bits"),
                        rs.getDouble("Scaled_pixel_width"),
                        rs.getDouble("Scaled_pixel_height"),
                        rs.getDouble("Resolution"),
                        rs.getDouble("Emission_angle"),
                        rs.getDouble("Incidence_angle"),
                        rs.getDouble("Phase_angle"),
                        rs.getDouble("North_azimuth"),
                        rs.getDouble("Sub_solar_azimuth"),
                        rs.getDouble("Sub_solar_latitude"),
                        rs.getDouble("Sub_solar_longitude"),
                        rs.getDouble("Sub_spacecraft_latitude"),
                        rs.getDouble("Sub_spacecraft_longitude"),
                        rs.getDouble("Solar_distance"),
                        rs.getDouble("Solar_longitude"),
                        rs.getDouble("Center_latitude"),
                        rs.getDouble("Center_longitude"),
                        rs.getDouble("Upper_right_latitude"),
                        rs.getDouble("Upper_right_longitude"),
                        rs.getDouble("Lower_right_latitude"),
                        rs.getDouble("Lower_right_longitude"),
                        rs.getDouble("Lower_left_latitude"),
                        rs.getDouble("Lower_left_longitude"),
                        rs.getDouble("Upper_left_latitude"),
                        rs.getDouble("Upper_left_longitude"),
                        rs.getDouble("Spacecraft_altitude"),
                        rs.getDouble("Target_center_distance")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Image> searchImages(
            Double minEmissionAngle, Double maxEmissionAngle,
            Double minIncidenceAngle, Double maxIncidenceAngle,
            Integer minOrbitNumber, Integer maxOrbitNumber,
            Double minSlewAngle, Double maxSlewAngle,
            String minStartTime, String maxStartTime,
            String minStopTime, String maxStopTime,
            Double upperRightLatitude, Double upperRightLongitude,
            Double upperLeftLatitude, Double upperLeftLongitude,
            Double lowerLeftLatitude, Double lowerLeftLongitude,
            Double lowerRightLatitude, Double lowerRightLongitude,
            Double minSubSolarAzimuth, Double maxSubSolarAzimuth,
            Double minSubSolarLatitude, Double maxSubSolarLatitude,
            Double minSubSolarLongitude, Double maxSubSolarLongitude
    ) {
        List<Image> images = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT image_id, Pds_volume_name, Orbit_number, Start_time, url FROM Images WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (minEmissionAngle != null) {
            sql.append(" AND Emission_angle >= ?");
            params.add(minEmissionAngle);
        }
        if (maxEmissionAngle != null) {
            sql.append(" AND Emission_angle <= ?");
            params.add(maxEmissionAngle);
        }
        if (minIncidenceAngle != null) {
            sql.append(" AND Incidence_angle >= ?");
            params.add(minIncidenceAngle);
        }
        if (maxIncidenceAngle != null) {
            sql.append(" AND Incidence_angle <= ?");
            params.add(maxIncidenceAngle);
        }
        if (minOrbitNumber != null) {
            sql.append(" AND Orbit_number >= ?");
            params.add(minOrbitNumber);
        }
        if (maxOrbitNumber != null) {
            sql.append(" AND Orbit_number <= ?");
            params.add(maxOrbitNumber);
        }
        if (minSlewAngle != null) {
            sql.append(" AND Slew_angle >= ?");
            params.add(minSlewAngle);
        }
        if (maxSlewAngle != null) {
            sql.append(" AND Slew_angle <= ?");
            params.add(maxSlewAngle);
        }
        if (minStartTime != null && !minStartTime.isEmpty()) {
            sql.append(" AND Start_time >= ?");
            params.add(minStartTime);
        }
        if (maxStartTime != null && !maxStartTime.isEmpty()) {
            sql.append(" AND Start_time <= ?");
            params.add(maxStartTime);
        }
        if (minStopTime != null && !minStopTime.isEmpty()) {
            sql.append(" AND Stop_time >= ?");
            params.add(minStopTime);
        }
        if (maxStopTime != null && !maxStopTime.isEmpty()) {
            sql.append(" AND Stop_time <= ?");
            params.add(maxStopTime);
        }
        if (upperRightLatitude != null) {
            sql.append(" AND Upper_right_latitude <= ?");
            params.add(upperRightLatitude);
        }
        if (upperRightLongitude != null) {
            sql.append(" AND Upper_right_longitude <= ?");
            params.add(upperRightLongitude);
        }
        if (upperLeftLatitude != null) {
            sql.append(" AND Upper_left_latitude >= ?");
            params.add(upperLeftLatitude);
        }
        if (upperLeftLongitude != null) {
            sql.append(" AND Upper_left_longitude >= ?");
            params.add(upperLeftLongitude);
        }
        if (lowerLeftLatitude != null) {
            sql.append(" AND Lower_left_latitude >= ?");
            params.add(lowerLeftLatitude);
        }
        if (lowerLeftLongitude != null) {
            sql.append(" AND Lower_left_longitude >= ?");
            params.add(lowerLeftLongitude);
        }
        if (lowerRightLatitude != null) {
            sql.append(" AND Lower_right_latitude <= ?");
            params.add(lowerRightLatitude);
        }
        if (lowerRightLongitude != null) {
            sql.append(" AND Lower_right_longitude <= ?");
            params.add(lowerRightLongitude);
        }
        if (minSubSolarAzimuth != null) {
            sql.append(" AND Sub_solar_azimuth >= ?");
            params.add(minSubSolarAzimuth);
        }
        if (maxSubSolarAzimuth != null) {
            sql.append(" AND Sub_solar_azimuth <= ?");
            params.add(maxSubSolarAzimuth);
        }
        if (minSubSolarLatitude != null) {
            sql.append(" AND Sub_solar_latitude >= ?");
            params.add(minSubSolarLatitude);
        }
        if (maxSubSolarLatitude != null) {
            sql.append(" AND Sub_solar_latitude <= ?");
            params.add(maxSubSolarLatitude);
        }
        if (minSubSolarLongitude != null) {
            sql.append(" AND Sub_solar_longitude >= ?");
            params.add(minSubSolarLongitude);
        }
        if (maxSubSolarLongitude != null) {
            sql.append(" AND Sub_solar_longitude <= ?");
            params.add(maxSubSolarLongitude);
        }

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

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
                  images.add(img);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return images;
    }
}