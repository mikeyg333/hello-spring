package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='lang'>" +
                    "<option value='eng'>English</option>" +
                    "<option value='spa'>Spanish</option>" +
                    "<option value='fre'>French</option>" +
                    "<option value='ger'>German</option>" +
                    "<option value='kor'>Korean</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public static String createMessage(HttpServletRequest request) {

        String name = request.getParameter("name");
        String lang = request.getParameter("lang");

        if (lang.equals("eng")) {
            return "Hello " + name + "!";
        } else if (lang.equals("spa")) {
            return "Hola " + name + "!";
        } else if (lang.equals("fre")) {
            return "Bonjour " + name + "!";
        } else if (lang.equals("ger")) {
            return "Guten tag " + name + "!";
        } else if (lang.equals("kor")) {
            return "Ahn-young-ha-se-yo " + name + "!";
        } else
            return "Hello " + name + "!";
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }

}