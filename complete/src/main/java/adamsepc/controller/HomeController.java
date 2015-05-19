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
        modelMap.put("metaDescription", getMetaDescription(host, "Home"));
        modelMap.put("altImage", "EPC " + getLocation(host));
        if(fromContact) {
            modelMap.put("showContactMsg", true);
        }
        modelMap.put("sisterSites", getSisterSiteLinks(getLocation(host)));
        return new ModelAndView("index", modelMap);
    }

    @RequestMapping("/about.html")
    public ModelAndView about(@RequestHeader("host") String host, @RequestParam(required = false) boolean fromContact) {
        final ModelMap modelMap = new ModelMap();
        modelMap.put("location", getLocation(host));
        modelMap.put("metaDescription", getMetaDescription(host, "About Us"));
        modelMap.put("altImage", "EPC " + getLocation(host));
        if(fromContact) {
            modelMap.put("showContactMsg", true);
        }
        modelMap.put("sisterSites", getSisterSiteLinks(getLocation(host)));
        return new ModelAndView("about", modelMap);
    }

    @RequestMapping("/information.html")
    public ModelAndView information(@RequestHeader("host") String host, @RequestParam(required = false) boolean fromContact) {
        final ModelMap modelMap = new ModelMap();
        modelMap.put("location", getLocation(host));
        modelMap.put("metaDescription", getMetaDescription(host, "EPC Information"));
        modelMap.put("altImage", "EPC " + getLocation(host));
        if(fromContact) {
            modelMap.put("showContactMsg", true);
        }
        modelMap.put("sisterSites", getSisterSiteLinks(getLocation(host)));
        return new ModelAndView("information", modelMap);
    }

    @RequestMapping("/pricing.html")
    public ModelAndView pricing(@RequestHeader("host") String host, @RequestParam(required = false) boolean fromContact) {
        final ModelMap modelMap = new ModelMap();
        modelMap.put("location", getLocation(host));
        modelMap.put("metaDescription", getMetaDescription(host, "Pricing"));
        modelMap.put("altImage", "EPC " + getLocation(host));
        if(fromContact) {
            modelMap.put("showContactMsg", true);
        }
        modelMap.put("sisterSites", getSisterSiteLinks(getLocation(host)));
        return new ModelAndView("pricing", modelMap);
    }

    @RequestMapping("/contact.html")
    public ModelAndView contact(@RequestHeader("host") String host, @RequestParam(required = false) boolean fromContact) {
        final ModelMap modelMap = new ModelMap();
        modelMap.put("location", getLocation(host));
        modelMap.put("metaDescription", getMetaDescription(host, "Contact Us"));
        modelMap.put("altImage", "EPC " + getLocation(host));
        if(fromContact) {
            modelMap.put("showContactMsg", true);
        }
        modelMap.put("sisterSites", getSisterSiteLinks(getLocation(host)));
        return new ModelAndView("contact", modelMap);
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

    private String getMetaDescription(final String host, final String page) {
        return String.format("Adams EPC in %s - %s. Locally based, no hassle, friendly service at your convenience. An EPC for your property from just £40.", getLocation(host), page);
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
