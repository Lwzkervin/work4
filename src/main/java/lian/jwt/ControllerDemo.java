package lian.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lian.jwt.*;
import lian.user.*;

@RestController
public class ControllerDemo {

    @Autowired
    private JwtKit jwtKit;

    @RequestMapping("/getJwtToken")
    public String getJwtToken(HttpServletRequest request) {
        User user = new User();
        user.setUsername("连文桢");
        String token = jwtKit.generateToken(user);
        return token;
    }

    @RequestMapping("/parseJwtToken")
    public String parseJwtToken(HttpServletRequest request) {

        return "解析成功";
    }
}

