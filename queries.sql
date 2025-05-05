-- Query used to authenticate a user by username on login
-- URL path: /login (POST)
SELECT * FROM user WHERE username = ?;

-- Query used to register a new user account
-- URL path: /register (POST)
INSERT INTO user (username, password, firstName, lastName) VALUES (?, ?, ?, ?);

-- Query to get all featured images for the featured images page
-- URL path: /featured_images (GET)
SELECT title, feature_date, image_id, description FROM FeaturedImages;

-- Query to get featured images by specific date (year-month-day)
-- URL path: /featured_image_search (GET)
SELECT title, feature_date, image_id, description FROM FeaturedImages WHERE feature_date = ?;

-- Query to get details for a specific image by its image_id
-- URL path: /image/{imageId} (GET)
SELECT * FROM Images WHERE image_id = ?;

-- Query to search images by multiple filters including angles, orbit, date ranges, and bounding box coordinates
-- URL path: /search (GET)
SELECT i.image_id, i.Pds_volume_name, i.Orbit_number, i.Start_time, i.url,
       CASE WHEN d.image_id IS NULL THEN TRUE ELSE FALSE END AS addable
FROM Images i
JOIN BoundingBox b ON i.bounding_box_id = b.bounding_box_id
LEFT JOIN Dataset d ON i.image_id = d.image_id
WHERE 1=1
-- (dynamic filters added depending on user input);

-- Query to get all images in the user’s dataset
-- URL path: /dataset (GET)
SELECT i.image_id, i.Pds_volume_name, i.Orbit_number, i.Start_time, i.url
FROM Dataset d, Images i
WHERE d.userId = ? AND i.image_id = d.image_id;

-- Query to check if an image is already in the user’s dataset before inserting
-- URL path: /dataset/add (POST)
SELECT 1 FROM Dataset WHERE userId = ? AND image_id = ?;

-- Query to add an image to the user’s dataset
-- URL path: /dataset/add (POST)
INSERT INTO Dataset (userId, image_id) VALUES (?, ?);

-- Query to remove an image from the user’s dataset
-- URL path: /dataset/remove (POST)
DELETE FROM Dataset WHERE userId = ? AND image_id = ?;

-- Query to retrieve all landing sites
-- URL path: /landing_sites (GET)
SELECT landing_site_name, mission, description FROM LandingSites;

-- Query to search landing sites by name (partial match)
-- URL path: /landing_sites/search (GET)
SELECT landing_site_name, mission, description FROM LandingSites WHERE landing_site_name LIKE ?;

-- Query to get full details of a landing site by exact name
-- URL path: /landing_sites/{name} (GET)
SELECT * FROM LandingSites WHERE landing_site_name = ?;

-- Query to find all images whose bounding boxes intersect with a selected landing site’s bounding box
-- URL path: /landing_sites/{name}/intersecting_images (GET)
SELECT DISTINCT i.*
FROM BoundingBox target
JOIN BoundingBox b ON
    b.bounding_box_id != target.bounding_box_id
    AND b.min_lat <= target.max_lat
    AND b.max_lat >= target.min_lat
    AND b.min_long <= target.max_long
    AND b.max_long >= target.min_long
JOIN Images i ON i.bounding_box_id = b.bounding_box_id
WHERE target.bounding_box_id = ?;

