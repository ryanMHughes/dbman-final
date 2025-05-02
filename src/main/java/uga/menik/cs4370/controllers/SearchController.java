package uga.menik.cs4370.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @GetMapping("/search")
    public ModelAndView showSearchPage() {
        return new ModelAndView("search_page");
    }

    // Example: add more mappings here if needed for search results
}

