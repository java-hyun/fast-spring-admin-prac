package com.example.study.controller;
import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// localhost:8080/api
@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping(value="/post")
    public SearchParam postMethod2(@RequestBody SearchParam searchParam){
        System.out.println("post check");
        return searchParam;
    }

    @PostMapping(value="/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }
}

