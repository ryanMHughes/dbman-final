package uga.menik.cs4370.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class LandingSiteController {

    @GetMapping("/landing_sites")
    public ModelAndView showLandingSitesPage() {
        return new ModelAndView("landing_sites_page");
    }

    @GetMapping("/landing_site_search")
    public ModelAndView searchLandingSites(
            @RequestParam("site_name") String siteName) {

        // TODO: Replace with actual logic from LandingSiteService
        // List<LandingSite> sites = landingSiteService.searchByName(siteName);

        ModelAndView mv = new ModelAndView("landing_sites_page");
        // mv.addObject("landingSites", sites);
        return mv;
    }
}

