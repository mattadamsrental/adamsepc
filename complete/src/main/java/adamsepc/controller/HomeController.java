package adamsepc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public ModelAndView index(@RequestHeader("host") String host, @RequestParam(required = false) boolean fromContact) {
        final ModelMap modelMap = new ModelMap();
        modelMap.put("location", getLocation(host));
        modelMap.put("metaDescription", getMetaDescription(host));
        modelMap.put("altImage", "EPC " + getLocation(host));
        if(fromContact) {
            modelMap.put("showContactMsg", true);
        }
        return new ModelAndView("index", modelMap);
    }

    private String getMetaDescription(final String host) {
        return String.format("EPC in %s - Low cost EPC for your %s property from Adams EPC. An EPC is" +
                " required for all properies being sold or rented out. Get an EPC now for your property " +
                "in the %s area from Adams EPC; locally based with a friendly and personal service.", getLocation(host), getLocation(host), getLocation(host));
    }

    private String getLocation(final String host) {
        if(host.contains("Daventry")) {
            return "Daventry";
        } else if(host.contains("Rugby")) {
            return "Rugby";
        } else if(host.contains("Towcester")) {
            return "Towcester";
        } else if(host.contains("Northampton")) {
            return "Northampton";
        } else if(host.contains("Banbury")) {
            return "Banbury";
        }
        return "Daventry";
    }
}
