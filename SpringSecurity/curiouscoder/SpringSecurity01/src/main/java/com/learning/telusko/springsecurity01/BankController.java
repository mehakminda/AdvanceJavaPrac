package com.learning.telusko.springsecurity01;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    @PostMapping("/debit")
    public String debit(){
        return "Money deducted";
    }

    @GetMapping("/getCsrf")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
}

/**
 * Spring security by default adds csrf protection to state changing api's(post, put, delete)
 *
 * post/put.. request needs: csrf token + sessionid
 * this csrf token is not stored in cookies and sent automatically.
 *
 * How to get a csrf token:
 * 1. using an endpoint
 * 2. html form
 * 3. in js code
 *
 *
 *
 * We start by understanding a real browser-based CSRF attack scenario, where a malicious website
 * tricks a logged-in user’s browser into sending authenticated requests without their knowledge.
 * Then, step by step, we break down how Spring Security protects your application by validating
 * CSRF tokens and blocking unauthorized state-changing requests.
 */