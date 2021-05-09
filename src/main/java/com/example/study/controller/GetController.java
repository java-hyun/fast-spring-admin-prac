package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

// localhost;8080/api
@RestController
@RequestMapping("/api")
public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {
        return "Hi getMehod";
    }

    // 파라미터 받기
    //localhost:8080/api/getParameter?id=1234&password=abcd
//    @GetMapping("/getParameter")
//    public String getParameter(@RequestParam String id, @RequestParam String password) {
//        System.out.println("id : " + id);
//        System.out.println("password : " + password);
//
//        return id + password;
//    }

    // 파라미터 받기
    // 127.0.0.1:8080/api/getParameter?id=1234&password=abcd
    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pwd) {
        String password = "12341234";
        System.out.println("id : " + id);
        System.out.println("password : " + pwd);
        return id + password;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // 객체를 리턴하면 json으로 반환 한다.
        return searchParam;
    }


}


