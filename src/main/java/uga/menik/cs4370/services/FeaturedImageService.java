package uga.menik.cs4360.services;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Service;
import uga.menik.cs4370.models.FeaturedImage;

import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.sql.DataSource;

@Service
public class FeaturedImageService {
    // dataSource enables talking to the database.
    private final DataSource dataSource;

    @Autowired
    public FeaturedImageService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<FeaturedImage> getAllFeaturedImages() {

    }

    public List<FeaturedImage> findByDate(
        String month, 
        String day,
        String year
    ) {

    }

}
