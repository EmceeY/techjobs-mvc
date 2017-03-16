package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @RequestMapping(value = "values")
        public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

            if (searchType.equals("All")) {

                ArrayList<HashMap<String, String>> jobs = (JobData.findByValue(searchTerm));

                model.addAttribute("title", "All Jobs");

                model.addAttribute("jobs", jobs);

                model.addAttribute("columns", ListController.columnChoices);

                return "search-jobs";

        }
            else{

                ArrayList<HashMap<String, String>> items = (JobData.findByColumnAndValue(searchType, searchTerm));

                model.addAttribute("title", searchType);

                model.addAttribute("items", items);

                model.addAttribute("columns", ListController.columnChoices);

                return "search-column";
            }

        // TODO #1 - Create handler to process search request and display results
    }
}
