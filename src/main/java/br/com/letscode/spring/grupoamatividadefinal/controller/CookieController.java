package br.com.letscode.spring.grupoamatividadefinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    public String setCookie(HttpServletResponse response, String name) {

        this.deleteCookie(response);
        // create a cookie
        Cookie cookie = new Cookie("username", name);
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/"); // global cookie accessible every where
        //add cookie to response
        response.addCookie(cookie);

        return "redirect:/index";
    }

    @GetMapping("/delete-username")
    public String deleteCookie(HttpServletResponse response) {

        // create a cookie
        Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        //add cookie to response
        response.addCookie(cookie);

        return "redirect:/login";
    }
}