package com.github.baranozoglu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/ozzy")
public class UnSecuredController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> sayOzzy() {
        return new ResponseEntity<>("Ozzy hello!", HttpStatus.OK);
    }
}
