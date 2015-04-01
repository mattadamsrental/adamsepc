package adamsepc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public ModelAndView index(@RequestParam(required = false) boolean fromContact) {
        final ModelMap modelMap = new ModelMap();
        modelMap.put("location", "Daventry");
        if(fromContact) {
            modelMap.put("showContactMsg", true);
        }
        return new ModelAndView("index", modelMap);
    }
    
}
