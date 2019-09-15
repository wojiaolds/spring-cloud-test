package com.lds.boot.rediscache.controller;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 17:54 2019/9/8
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 17:54 2019/9/8
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("name","SpringBootFavicon");
        return "index";
    }

}
