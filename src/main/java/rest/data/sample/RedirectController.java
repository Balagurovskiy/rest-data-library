package rest.data.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
	/*
	 * The index() method returns the index string, 
	 * which is resolved to index.ftl view. 
	 * The view is located in the src/main/resources/templates directory.
	*/
    @GetMapping(value= {"/", "/library"})
    public String index(){
        return "index";
    }
}
