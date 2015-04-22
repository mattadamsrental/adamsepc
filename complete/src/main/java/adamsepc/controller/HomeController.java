package adamsepc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
        modelMap.put("sisterSites", getSisterSiteLinks(getLocation(host)));
        return new ModelAndView("index", modelMap);
    }

    private Map<String, String> getSisterSiteLinks(final String location) {
        final Map<String,String> sisterSites = new HashMap<>();
        sisterSites.put("Daventry", "www.lowcostepcdaventry.co.uk");
        sisterSites.put("Northampton", "www.lowcostepcnorthampton.co.uk");
        sisterSites.put("Towcester", "www.lowcostepctowcester.co.uk");
        sisterSites.put("Banbury", "www.lowcostepcbanbury.co.uk");
        sisterSites.put("Rugby", "www.lowcostepcrugby.co.uk");
        sisterSites.remove(location);
        return sisterSites;
    }

    private String getMetaDescription(final String host) {
        return String.format("EPC in %s - Low cost EPC for your property from Adams EPC.  Get an EPC now for your property " +
                "from Adams EPC; locally based with a friendly and personal service.", getLocation(host));
    }

    private String getLocation(final String host) {
        if(host.contains("Daventry")) {
            return "daventry";
        } else if(host.contains("rugby")) {
            return "Rugby";
        } else if(host.contains("towcester")) {
            return "Towcester";
        } else if(host.contains("northampton")) {
            return "Northampton";
        } else if(host.contains("banbury")) {
            return "Banbury";
        }
        return "Daventry";
    }
}
