create table if not exists user (
    userId int auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    primary key (userId),
    unique (username),
    constraint userName_min_length check (char_length(trim(userName)) >= 2),
    constraint firstName_min_length check (char_length(trim(firstName)) >= 2),
    constraint lastName_min_length check (char_length(trim(lastName)) >= 2)
);

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

CREATE TABLE FeaturedImages (
    featured_image_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(40) NOT NULL PRIMARY KEY,
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

CREATE TABLE Dataset (
  userId INT NOT NULL,
  image_id VARCHAR(40) NOT NULL,
  FOREIGN KEY (userId) REFERENCES user(userId),
  FOREIGN KEY (image_id) REFERENCES Images(image_id)
  ADD CONSTRAINT unique_user_image UNIQUE (userId, image_id);
)