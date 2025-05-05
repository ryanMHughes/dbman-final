package uga.lroc.cs4370.controllers;

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

import uga.lroc.cs4370.services.UserService;
import uga.lroc.cs4370.services.DatasetService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

   private final UserService userService;
   private final DatasetService datasetService;

   @Autowired
   public ProfileController(UserService userService, DatasetService datasetService) {
      this.userService = userService;
      this.datasetService = datasetService;
   }

   @GetMapping
   public ModelAndView webpage(@RequestParam(name = "error", required = false) String error) {
      ModelAndView mv = new ModelAndView("profile_page");

      mv.addObject("user", userService.getLoggedInUser());
      mv.addObject("images", datasetService.getDataset());

      return mv;
   }


}
