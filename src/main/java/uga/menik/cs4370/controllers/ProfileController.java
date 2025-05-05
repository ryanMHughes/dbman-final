package uga.menik.cs4370.controllers;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import uga.menik.cs4370.services.UserService;
import uga.menik.cs4370.services.DatasetService;

/**
 * This is the controler that handles /profile URL.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    // UserService has user profile and registration related functions.
   private final UserService userService;
   private final DatasetService datasetService;

    /**
     * See notes in AuthInterceptor.java regarding how this works 
     * through dependency injection and inversion of control.
     */
   @Autowired
   public ProfileController(UserService userService, DatasetService datasetService) {
      this.userService = userService;
      this.datasetService = datasetService;
   }

   @GetMapping
   public ModelAndView webpage(@RequestParam(name = "error", required = false) String error) {
      // See notes on ModelAndView in BookmarksController.java.
      ModelAndView mv = new ModelAndView("profile_page");

      mv.addObject("user", userService.getLoggedInUser());
      mv.addObject("images", datasetService.getDataset());

      return mv;
   }


}
