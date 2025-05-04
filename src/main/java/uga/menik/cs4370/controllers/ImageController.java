package uga.menik.cs4370.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import uga.menik.cs4370.models.ExpandedImage;
import uga.menik.cs4370.services.ImageService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{imageId}")
    public ModelAndView getImageDetails(@PathVariable String imageId) {
        ExpandedImage image = imageService.getImageById(imageId);

        ModelAndView mv = new ModelAndView("expanded_image_page");
        mv.addObject("image", image);
        return mv;
    }
}