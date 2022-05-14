package org.joey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: JoeyShelby
 * @date: 2022-05-14 08:56
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }
}
