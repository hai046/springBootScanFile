package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {


    @RequestMapping("/test")
    public String apkList3(Model model) {
        return "test";
    }


}
