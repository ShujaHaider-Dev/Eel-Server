package com.shuja.EelServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MicroserviceController {
    private MicroserviceHandler handler;
    Logger logger = LoggerFactory.getLogger(MicroserviceController.class);

    public MicroserviceController(MicroserviceHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/register/{msname}/{lang}")
    public String register(@PathVariable String msname, @PathVariable String lang) {
        Microservice mservice = new Microservice(msname, lang);
        logger.info("Microservice registered with name: " + msname + ", coded in " + lang);
        handler.add(mservice);
        return "redirect:/";
    }

    @GetMapping("/deregister/{index}")
    public String deregister(@PathVariable int index) {
        logger.info("Microservice deregistered with index " + index);
        handler.deregister(index);
        return "redirect:/";
    }

    @GetMapping("/")
    public String all_services(Model model) {
        model.addAttribute("registered", handler.registered());
        return "page";
    }
}
