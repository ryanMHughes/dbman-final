package uga.lroc.cs4370.controllers;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.ResultSet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

import java.util.ArrayList;

@Controller
@RequestMapping
public class HomeController {

    private final DataSource dataSource;

    @Autowired
    public HomeController(
	DataSource dataSource
    ) {
	this.dataSource = dataSource;
    }


    @GetMapping
    public ModelAndView webpage(@RequestParam(name = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView("home_page");

        return mv;
    }

}
