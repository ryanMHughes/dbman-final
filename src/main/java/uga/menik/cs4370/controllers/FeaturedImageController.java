package uga.menik.cs4370.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.List;

import uga.menik.cs4370.services.FeaturedImageService;
import uga.menik.cs4370.models.FeaturedImage;

@Controller
public class FeaturedImageController {

	private final FeaturedImageService featuredImageService;

    @Autowired
    public FeaturedImageController(FeaturedImageService featuredImageService) {
        this.featuredImageService = featuredImageService;
    }

    @GetMapping("/featured_images")
    public ModelAndView showFeaturedImagesPage() {
        ModelAndView mv = new ModelAndView("featured_images_page");
	List<FeaturedImage> featured_images = featuredImageService.getAllFeaturedImages();
        mv.addObject("featured_images", featured_images);

        return mv;
    }

    @GetMapping("/featured_image_search")
    public ModelAndView searchFeaturedImages(
        @RequestParam("featured_image_month") String month,
        @RequestParam("featured_image_day") String day,
        @RequestParam("featured_image_year") String year) {

        List<FeaturedImage> featured_images = featuredImageService.findByDate(month, day, year);

        ModelAndView mv = new ModelAndView("featured_images_page");
        mv.addObject("featured_images", featured_images);
        return mv;
    }
}

