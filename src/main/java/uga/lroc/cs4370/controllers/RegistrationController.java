package uga.lroc.cs4370.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import uga.lroc.cs4370.services.UserService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView webpage(@RequestParam(name = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView("registration_page");

        mv.addObject("errorMessage", error);

        return mv;
    }

    @PostMapping
    public String register(@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("passwordRepeat") String passwordRepeat,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) throws UnsupportedEncodingException {
        if (password.trim().length() < 3) {
            String message = URLEncoder.encode("Passwords should have at least 3 nonempty letters.", "UTF-8");
            return "redirect:/register?error=" + message;
        }

        if (!password.equals(passwordRepeat)) {
            String message = URLEncoder.encode("Passwords do not match.", "UTF-8");
            return "redirect:/register?error=" + message;
        }

        try {
            boolean registrationSuccess = userService.registerUser(username,
                    password, firstName, lastName);
            if (registrationSuccess) {
                return "redirect:/login";
            } else {
                String message = URLEncoder
                        .encode("Registration failed. Please try again.", "UTF-8");
                return "redirect:/register?error=" + message;
            }
        } catch (Exception e) {
            String message = URLEncoder
                    .encode("An error occurred: " + e.getMessage(), "UTF-8");
            return "redirect:/register?error=" + message;
        }
    }

}
