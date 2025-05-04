package uga.menik.cs4370.controllers;

import uga.menik.cs4370.models.LandingSite;
import uga.menik.cs4370.services.LandingSiteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import uga.menik.cs4370.models.Image;
import uga.menik.cs4370.services.BoundingBoxService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.List;

@Controller
public class LandingSiteController {

    private final LandingSiteService landingSiteService;
    private final BoundingBoxService boundingBoxService;

    @Autowired
    public LandingSiteController(LandingSiteService landingSiteService, BoundingBoxService boundingBoxService) {
        this.landingSiteService = landingSiteService;
        this.boundingBoxService = boundingBoxService;
    }

    @GetMapping("/landing_sites")
    public ModelAndView showLandingSitesPage() {
        ModelAndView mv = new ModelAndView("landing_sites_page");
        List<LandingSite> landingSites = landingSiteService.getAllLandingSites();
        mv.addObject("landingSites", landingSites);

        return mv;
    }

    @GetMapping("/landing_site_search")
    public ModelAndView searchLandingSites(
            @RequestParam("site_name") String siteName) {

        // TODO: Replace with actual logic from LandingSiteService
        List<LandingSite> sites = landingSiteService.searchByName(siteName);

        ModelAndView mv = new ModelAndView("landing_sites_page");
        mv.addObject("landingSites", sites);
        return mv;
    }
    
    @GetMapping("/landing_sites/{name}")
    public ModelAndView getLandingSite(@PathVariable String name) {
        LandingSite landingSite = landingSiteService.getLandingSiteByName(name);
        // Get all images whose bounding boxes intersect with this landing site’s bounding box
        List<Image> images = boundingBoxService.getImagesIntersectingLandingSite(landingSite);

        ModelAndView mv = new ModelAndView("expanded_landing_site_page");
        mv.addObject("landingSite", landingSite);
        mv.addObject("images", images);

        return mv;
    }
}

