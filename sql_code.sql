CREATE TABLE Images (
    image_id VARCHAR(40) NOT NULL PRIMARY KEY,
    url VARCHAR(100),
    Product VARCHAR(20),
    Pds_dataset_name VARCHAR(30),
    Pds_volume_name VARCHAR(20),
    Instrument_host VARCHAR(3),
    Instrument CHAR(4),
    Original_product VARCHAR(20),
    Product_version VARCHAR(5),
    Mission_phase_name VARCHAR(15),
    Rationale_desc VARCHAR(40),
    Data_quality INT,
    Nac_preroll_start_time DATE,
    Start_time DATE,
    Stop_time DATE,
    Spacecraft_clock_partition INT,
    Nac_spacecraft_clock_preroll_count VARCHAR(30),
    Spacecraft_clock_start_count VARCHAR(30),
    Spacecraft_clock_stop_count VARCHAR(30),
    Target_name VARCHAR(10),
    Orbit_number INT,
    Slew_angle DECIMAL(10,7),
    Lro_node_crossing VARCHAR(3),
    Lro_flight_direction VARCHAR(3),
    Nac_line_exposure_duration DECIMAL(10,7),
    Nac_frame VARCHAR(20),
    Nac_dac_reset INT,
    Nac_channel_a_offset INT,
    Nac_channel_b_offset INT,
    Instrument_mode_code INT,
    Compand_select_code INT,
    Mode_compression BOOL,
    Mode_test BOOL,
    Nac_temperature_scs DECIMAL(6,3),
    Nac_temperature_fpa DECIMAL(6,3),
    Nac_temperature_fpga DECIMAL(6,3),
    Nac_temperature_telescope DECIMAL(6,3),
    Image_lines INT,
    Line_samples INT,
    Sample_bits INT,
    Scaled_pixel_width DECIMAL(5,3),
    Scaled_pixel_height DECIMAL(5,3), 
    Resolution DECIMAL(10,9), 
    Emission_angle DECIMAL(5,2),
    Incidence_angle DECIMAL(5,2),
    Phase_angle DECIMAL(5,2),
    North_azimuth DECIMAL(5,2),
    Sub_solar_azimuth DECIMAL(5,2),
    Sub_solar_latitude DECIMAL(5,2),
    Sub_solar_longitude DECIMAL(5,2),
    Sub_spacecraft_latitude DECIMAL(5,2),
    Sub_spacecraft_longitude DECIMAL(5,2),
    Solar_distance DECIMAL(12,1),
    Solar_longitude DECIMAL(5,2),
    Center_latitude DECIMAL(5,2),
    Center_longitude DECIMAL(5,2),
    Upper_right_latitude DECIMAL(5,2),
    Upper_right_longitude DECIMAL(5,2),
    Lower_right_latitude DECIMAL(5,2),
    Lower_right_longitude DECIMAL(5,2),
    Lower_left_latitude DECIMAL(5,2),
    Lower_left_longitude DECIMAL(5,2),
    Upper_left_latitude DECIMAL(5,2),
    Upper_left_longitude DECIMAL(5,2),
    Spacecraft_altitude DECIMAL(7,3),
    Target_center_distance DECIMAL(6,2)
);

LOAD DATA INFILE '/var/lib/mysql-files/data.csv'
IGNORE INTO TABLE Images
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n'
(
  @image_id,
  @url,
  @product,
  @pds_dataset_name,
  @pds_volume_name,
  @instrument_host,
  @instrument,
  @original_product,
  @product_version,
  @mission_phase_name,
  @rationale_desc,
  @data_quality,
  @nac_preroll_start_time,
  @start_time,
  @stop_time,
  @spacecraft_clock_partition,
  @nac_spacecraft_clock_preroll_count,
  @spacecraft_clock_start_count,
  @spacecraft_clock_stop_count,
  @target_name,
  @orbit_number,
  @slew_angle,
  @lro_node_crossing,
  @lro_flight_direction,
  @nac_line_exposure_duration,
  @nac_frame,
  @nac_dac_reset,
  @nac_channel_a_offset,
  @nac_channel_b_offset,
  @instrument_mode_code,
  @compand_select_code,
  @mode_compression_str,
  @mode_test_str,
  @nac_temperature_scs,
  @nac_temperature_fpa,
  @nac_temperature_fpga,
  @nac_temperature_telescope,
  @image_lines,
  @line_samples,
  @sample_bits,
  @scaled_pixel_width_str,
  @scaled_pixel_height_str,
  @resolution,
  @emission_angle,
  @incidence_angle,
  @phase_angle,
  @north_azimuth,
  @sub_solar_azimuth,
  @sub_solar_latitude,
  @sub_solar_longitude,
  @sub_spacecraft_latitude,
  @sub_spacecraft_longitude,
  @solar_distance,
  @solar_longitude,
  @center_latitude,
  @center_longitude,
  @upper_right_latitude,
  @upper_right_longitude,
  @lower_right_latitude,
  @lower_right_longitude,
  @lower_left_latitude,
  @lower_left_longitude,
  @upper_left_latitude,
  @upper_left_longitude,
  @spacecraft_altitude,
  @target_center_distance
)
SET
  image_id = NULLIF(@image_id, 'NULL'),
  url                          = NULLIF(@url, 'NULL'),
  product                      = NULLIF(@product, 'NULL'),
  pds_dataset_name             = NULLIF(@pds_dataset_name, 'NULL'),
  pds_volume_name              = NULLIF(@pds_volume_name, 'NULL'),
  instrument_host              = NULLIF(@instrument_host, 'NULL'),
  instrument                   = NULLIF(@instrument, 'NULL'),
  original_product             = NULLIF(@original_product, 'NULL'),
  product_version              = NULLIF(@product_version, 'NULL'),
  mission_phase_name           = NULLIF(@mission_phase_name, 'NULL'),
  rationale_desc               = NULLIF(@rationale_desc, 'NULL'),
  data_quality                 = NULLIF(@data_quality, 'NULL'),         
  nac_preroll_start_time       = NULLIF(@nac_preroll_start_time, 'NULL'),
  start_time                   = NULLIF(@start_time, 'NULL'),
  stop_time                    = NULLIF(@stop_time, 'NULL'),
  spacecraft_clock_partition   = NULLIF(@spacecraft_clock_partition, 'NULL'),
  nac_spacecraft_clock_preroll_count   = NULLIF(@nac_spacecraft_clock_preroll_count, 'NULL'),
  spacecraft_clock_start_count = NULLIF(@spacecraft_clock_start_count, 'NULL'),
  spacecraft_clock_stop_count  = NULLIF(@spacecraft_clock_stop_count, 'NULL'),
  target_name                  = NULLIF(@target_name, 'NULL'),
  orbit_number                 = NULLIF(@orbit_number, 'NULL'),        
  slew_angle                   = NULLIF(@slew_angle, 'NULL'),          
  lro_node_crossing            = NULLIF(@lro_node_crossing, 'NULL'),   
  lro_flight_direction         = NULLIF(@lro_flight_direction, 'NULL'),
  nac_line_exposure_duration   = NULLIF(@nac_line_exposure_duration, 'NULL'),
  nac_frame                    = NULLIF(@nac_frame, 'NULL'),
  nac_dac_reset                = NULLIF(@nac_dac_reset, 'NULL'),
  nac_channel_a_offset         = NULLIF(@nac_channel_a_offset, 'NULL'),
  nac_channel_b_offset         = NULLIF(@nac_channel_b_offset, 'NULL'),
  instrument_mode_code         = NULLIF(@instrument_mode_code, 'NULL'),
  compand_select_code          = NULLIF(@compand_select_code, 'NULL'),
  mode_compression             = NULLIF(@mode_compression_str, 'NULL'),
  mode_test                    = NULLIF(@mode_test_str, 'NULL'),
  nac_temperature_scs          = NULLIF(@nac_temperature_scs, 'NULL'),
  nac_temperature_fpa          = NULLIF(@nac_temperature_fpa, 'NULL'),
  nac_temperature_fpga         = NULLIF(@nac_temperature_fpga, 'NULL'),
  nac_temperature_telescope    = NULLIF(@nac_temperature_telescope, 'NULL'),
  image_lines                  = NULLIF(@image_lines, 'NULL'),
  line_samples                 = NULLIF(@line_samples, 'NULL'),
  sample_bits                  = NULLIF(@sample_bits, 'NULL'),
  scaled_pixel_width           = NULLIF(@scaled_pixel_width_str, 'NULL'),
  scaled_pixel_height          = NULLIF(@scaled_pixel_height_str, 'NULL'),
  resolution                   = NULLIF(@resolution, 'NULL'),
  emission_angle               = NULLIF(@emission_angle, 'NULL'),
  incidence_angle              = NULLIF(@incidence_angle, 'NULL'),
  phase_angle                  = NULLIF(@phase_angle, 'NULL'),
  north_azimuth                = NULLIF(@north_azimuth, 'NULL'),
  sub_solar_azimuth            = NULLIF(@sub_solar_azimuth, 'NULL'),
  sub_solar_latitude           = NULLIF(@sub_solar_latitude, 'NULL'),
  sub_solar_longitude          = NULLIF(@sub_solar_longitude, 'NULL'),
  sub_spacecraft_latitude      = NULLIF(@sub_spacecraft_latitude, 'NULL'),
  sub_spacecraft_longitude     = NULLIF(@sub_spacecraft_longitude, 'NULL'),
  solar_distance               = NULLIF(@solar_distance, 'NULL'),
  solar_longitude              = NULLIF(@solar_longitude, 'NULL'),
  center_latitude              = NULLIF(@center_latitude, 'NULL'),
  center_longitude             = NULLIF(@center_longitude, 'NULL'),
  upper_right_latitude         = NULLIF(@upper_right_latitude, 'NULL'),
  upper_right_longitude        = NULLIF(@upper_right_longitude, 'NULL'),
  lower_right_latitude         = NULLIF(@lower_right_latitude, 'NULL'),
  lower_right_longitude        = NULLIF(@lower_right_longitude, 'NULL'),
  lower_left_latitude          = NULLIF(@lower_left_latitude, 'NULL'),
  lower_left_longitude         = NULLIF(@lower_left_longitude, 'NULL'),
  upper_left_latitude          = NULLIF(@upper_left_latitude, 'NULL'),
  upper_left_longitude         = NULLIF(@upper_left_longitude, 'NULL'),
  spacecraft_altitude          = NULLIF(@spacecraft_altitude, 'NULL'),
  target_center_distance       = NULLIF(@target_center_distance, 'NULL');

CREATE TABLE FeaturedImages (
    featured_image_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(40) NOT NULL,
    description TEXT NOT NULL,
    feature_date DATE NOT NULL,
    image_id VARCHAR(40) NOT NULL,
    FOREIGN KEY (image_id) REFERENCES Images(image_id)
);

CREATE TABLE BoundingBox (
    bounding_box_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    min_lat DOUBLE NOT NULL,
    min_long DOUBLE NOT NULL,
    max_lat DOUBLE NOT NULL,
    max_long DOUBLE NOT NULL
);

CREATE TABLE LandingSites (
    landing_site_name VARCHAR(40) NOT NULL PRIMARY KEY,
    description TEXT NOT NULL,
    mission TEXT NOT NULL,
    bounding_box_id INT NOT NULL,
    FOREIGN KEY (bounding_box_id) REFERENCES BoundingBox(bounding_box_id)
);

-- The following portion just updates the image table to add the bounding box id
ALTER TABLE Images
ADD COLUMN bounding_box_id INT,
ADD FOREIGN KEY (bounding_box_id) REFERENCES BoundingBox(bounding_box_id);

INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
SELECT
    LEAST(upper_right_latitude, lower_right_latitude, lower_left_latitude, upper_left_latitude),
    LEAST(upper_right_longitude, lower_right_longitude, lower_left_longitude, upper_left_longitude),
    GREATEST(upper_right_latitude, lower_right_latitude, lower_left_latitude, upper_left_latitude),
    GREATEST(upper_right_longitude, lower_right_longitude, lower_left_longitude, upper_left_longitude)
FROM Images
WHERE upper_right_latitude IS NOT NULL
  AND lower_right_latitude IS NOT NULL
  AND lower_left_latitude IS NOT NULL
  AND upper_left_latitude IS NOT NULL
  AND upper_right_longitude IS NOT NULL
  AND lower_right_longitude IS NOT NULL
  AND lower_left_longitude IS NOT NULL
  AND upper_left_longitude IS NOT NULL;



UPDATE Images i
JOIN (
    SELECT b.bounding_box_id, img.image_id
    FROM BoundingBox b
    JOIN (
        SELECT image_id, ROW_NUMBER() OVER () AS rownum
        FROM Images
    ) img ON b.bounding_box_id = img.rownum
) bbmap ON i.image_id = bbmap.image_id
SET i.bounding_box_id = bbmap.bounding_box_id;

-- The following inserts data into the landing sites table, collected from QuickMap. I made the descriptions.
-- Nobile rim 1
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-85.89749, 31.64367, -84.94760, 43.20664);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Nobile Rim 1', 'Artemis III candidate site near Nobile crater, with high illumination and access to permanently shadowed regions.', 'Artemis III Candidate Landing Region (2024)', @bbox_id);

-- Nobile rim 2
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-84.40465, 54.46178, -83.50158, 63.02425);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Nobile Rim 2', 'Secondary Artemis III site near Nobile crater, offering diverse terrain and scientific potential.', 'Artemis III Candidate Landing Region (2024)', @bbox_id);

-- Mons Mouton
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-85.78834, 27.28799, -85.06330, 36.36658);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Mons Mouton', 'Large mountain massif at the lunar south pole, named for NASA engineer Melba Mouton, considered for Artemis III.', 'Artemis III Candidate Landing Region (2024)', @bbox_id);

-- de Gerlache Rim 2
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-88.65999, 282.52881, -87.78529, 310.60129);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('de Gerlache Rim 2', 'Candidate Artemis III site near de Gerlache crater rim, featuring permanently shadowed areas and water ice potential.', 'Artemis III Candidate Landing Region (2024)', @bbox_id);

-- Mons Mouton Plateau
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-85.75564, 15.49417, -82.84671, 46.61204);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Mons Mouton Plateau', 'Elevated plateau region adjacent to Mons Mouton, offering scientific access to diverse south polar geology.', 'Artemis III Candidate Landing Region (2024)', @bbox_id);

-- Slater Plain
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-87.62216, 116.56720, -86.70324, 134.99761);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Slater Plain', 'Relatively flat lunar south polar plain, potential Artemis III site with access to nearby shadowed areas.', 'Artemis III Candidate Landing Region (2024)', @bbox_id);

-- Peak Near Cabeus B
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-84.06005, 287.52647, -83.20950, 295.20011);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Peak Near Cabeus B', 'Artemis III candidate site near Cabeus B crater, offering illumination and proximity to water ice-rich shadowed zones.', 'Artemis III Candidate Landing Region (2024)', @bbox_id);

-- Haworth
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-87.39353, 325.01815, -86.11240, 347.63822);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Haworth', 'Region near Haworth crater, identified as a promising south polar Artemis III landing site for long-term exploration.', 'Artemis III Candidate Landing Region (2024)', @bbox_id);



-- Endurance-A
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-87.39353, 325.01815, -86.11240, 347.63822);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Endurance-A Landing Site & Site H', 'Exploration site for the Endurance mission, focused on long-duration surface operations at the lunar south pole.', 'Endurance', @bbox_id);


-- US Flag
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (20.19177, 30.77195, 20.19178, 30.77196);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Apollo 17 Landing Site', 'Apollo 17 landing site location where astronauts placed the US flag in Taurus-Littrow Valley.', 'Apollo 17', @bbox_id);

-- Rover (apollo 17)
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (20.18973, 30.77680, 20.18974, 30.77681);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Apollo 17 Rover Ending Site', 'Apollo 17 lunar rover final parking spot near Taurus-Littrow Valley landing site.', 'Apollo 17', @bbox_id);

-- US Flag
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-8.97295, 15.50072, -8.97296, 15.50073);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Apollo 16 Landing Site', 'Apollo 16 landing site where astronauts planted the US flag in the Descartes Highlands.', 'Apollo 16', @bbox_id);

-- Rover (apollo 16)
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-8.97286, 15.50369, -8.97287, 15.50370);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Apollo 16 Rover Ending Site', 'Apollo 16 lunar rover location in the Descartes Highlands landing area.', 'Apollo 16', @bbox_id);

-- Central station (apollo 14)
INSERT INTO BoundingBox (min_lat, min_long, max_lat, max_long)
VALUES (-3.64431, 342.52234, -3.64432, 342.52235);
SET @bbox_id = LAST_INSERT_ID();
INSERT INTO LandingSites (landing_site_name, description, mission, bounding_box_id)
VALUES ('Apollo 14 Central Station', 'Apollo 14 central station, part of the ALSEP scientific instrument package on the Moon.', 'Apollo 14', @bbox_id);