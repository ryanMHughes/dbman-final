package uga.lroc.cs4370.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import uga.lroc.cs4370.models.ExpandedImage;
import uga.lroc.cs4370.services.ImageService;
import uga.lroc.cs4370.services.DatasetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ImageController {

    private final ImageService imageService;
    private final DatasetService datasetService;

    @Autowired
    public ImageController(ImageService imageService, DatasetService datasetService) {
        this.imageService = imageService;
         this.datasetService = datasetService;
    }

    @GetMapping("/{imageId}")
    public ModelAndView getImageDetails(@PathVariable String imageId) {
        ExpandedImage image = imageService.getImageById(imageId);

        ModelAndView mv = new ModelAndView("expanded_image_page");
        mv.addObject("image", image);
        return mv;
    }

   @PostMapping("/dataset/remove/{imageId}")
   @ResponseBody
   public ResponseEntity<String> removeImageFromDataset(@PathVariable String imageId) {
      datasetService.removeFromDataset(imageId);
      return ResponseEntity.ok("Image removed");
   }

   @PostMapping("/dataset/add/{imageId}")
   @ResponseBody
   public ResponseEntity<String> addImageToDataset(@PathVariable String imageId) {
      datasetService.addToDataset(imageId);
      return ResponseEntity.ok("Image added");
   }
}