package uga.menik.cs4370.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uga.menik.cs4370.models.Image;
import uga.menik.cs4370.services.ImageService;

import java.util.List;

@Controller
public class SearchController {

    private final ImageService imageService;

    @Autowired
    public SearchController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/search")
    public ModelAndView searchImages(
            @RequestParam(required = false) Double min_emission_angle,
            @RequestParam(required = false) Double max_emission_angle,
            @RequestParam(required = false) Double min_incidence_angle,
            @RequestParam(required = false) Double max_incidence_angle,
            @RequestParam(required = false) Integer min_orbit_number,
            @RequestParam(required = false) Integer max_orbit_number,
            @RequestParam(required = false) Double min_slew_angle,
            @RequestParam(required = false) Double max_slew_angle,
            @RequestParam(required = false) String min_start_time,
            @RequestParam(required = false) String max_start_time,
            @RequestParam(required = false) String min_stop_time,
            @RequestParam(required = false) String max_stop_time,
            @RequestParam(required = false) Double min_lat,
            @RequestParam(required = false) Double max_lat,
            @RequestParam(required = false) Double min_lon,
            @RequestParam(required = false) Double max_lon,
            // advanced parameters (example)
            @RequestParam(required = false) Double min_sub_solar_azimuth,
            @RequestParam(required = false) Double max_sub_solar_azimuth,
            @RequestParam(required = false) Double min_sub_solar_latitude,
            @RequestParam(required = false) Double max_sub_solar_latitude,
            @RequestParam(required = false) Double min_sub_solar_longitude,
            @RequestParam(required = false) Double max_sub_solar_longitude
    ) {
        ModelAndView mv = new ModelAndView("search_page");

        // Add all input values back to template for repopulation
        mv.addObject("min_lat", min_lat != null ? min_lat : "");
        mv.addObject("max_lat", max_lat != null ? max_lat : "");
        mv.addObject("min_lon", min_lon != null ? min_lon : "");
        mv.addObject("max_lon", max_lon != null ? max_lon : "");

        mv.addObject("min_start_time", min_start_time != null ? min_start_time : "");
        mv.addObject("max_start_time", max_start_time != null ? max_start_time : "");
        mv.addObject("min_stop_time", min_stop_time != null ? min_stop_time : "");
        mv.addObject("max_stop_time", max_stop_time != null ? max_stop_time : "");
        mv.addObject("min_sub_solar_azimuth", min_sub_solar_azimuth != null ? min_sub_solar_azimuth : "");
        mv.addObject("max_sub_solar_azimuth", max_sub_solar_azimuth != null ? max_sub_solar_azimuth : "");
        mv.addObject("min_sub_solar_latitude", min_sub_solar_latitude != null ? min_sub_solar_latitude : "");
        mv.addObject("max_sub_solar_latitude", max_sub_solar_latitude != null ? max_sub_solar_latitude : "");
        mv.addObject("min_sub_solar_longitude", min_sub_solar_longitude != null ? min_sub_solar_longitude : "");
        mv.addObject("max_sub_solar_longitude", max_sub_solar_longitude != null ? max_sub_solar_longitude : "");
        mv.addObject("min_emission_angle", min_emission_angle != null ? min_emission_angle : "");
        mv.addObject("max_emission_angle", max_emission_angle != null ? max_emission_angle : "");
        mv.addObject("min_incidence_angle", min_incidence_angle != null ? min_incidence_angle : "");
        mv.addObject("max_incidence_angle", max_incidence_angle != null ? max_incidence_angle : "");
        mv.addObject("min_orbit_number", min_orbit_number != null ? min_orbit_number : "");
        mv.addObject("max_orbit_number", max_orbit_number != null ? max_orbit_number : "");
        mv.addObject("min_slew_angle", min_slew_angle != null ? min_slew_angle : "");
        mv.addObject("max_slew_angle", max_slew_angle != null ? max_slew_angle : "");

        
        // Call ImageService to get results
        List<Image> images = imageService.searchImages(
                min_emission_angle, max_emission_angle,
                min_incidence_angle, max_incidence_angle,
                min_orbit_number, max_orbit_number,
                min_slew_angle, max_slew_angle,
                min_start_time, max_start_time,
                min_stop_time, max_stop_time,
                min_lat, max_lat,
                min_lon, max_lon,
                min_sub_solar_azimuth, max_sub_solar_azimuth,
                min_sub_solar_latitude, max_sub_solar_latitude,
                min_sub_solar_longitude, max_sub_solar_longitude
        );

        mv.addObject("images", images);
        return mv;
    }
}