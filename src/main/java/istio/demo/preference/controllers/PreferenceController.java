package istio.demo.preference.controllers;

import istio.demo.preference.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreferenceController {
    private static final String PREFERENCE_VERSION = "PREFERENCE_V1";

    @Autowired
    private RecommendationService recommendationService;
    @GetMapping(value="/preference")
    public String getPreference() {
        String recommendation = recommendationService.getRecommendation();
        return PREFERENCE_VERSION + " => " + recommendation;
    }
}
