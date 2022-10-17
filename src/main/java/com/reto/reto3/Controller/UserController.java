package com.reto.reto3.Controller;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public Map<String, String> user(@AuthenticationPrincipal OAuth2User principal){
        //return principal.getAttributes();
        System.out.println(principal);        
        Map<String, String> map = Collections.singletonMap("name", principal.getAttribute("login"));
        return map;
        

    }
}


//https://compiler.javatpoint.com/opr/test.jsp?filename=CollectionsSingletonMapExample1