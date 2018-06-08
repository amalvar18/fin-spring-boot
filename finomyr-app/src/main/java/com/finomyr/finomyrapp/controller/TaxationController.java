package com.finomyr.finomyrapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finomyr.finomyrapp.model.Taxation;
import com.finomyr.finomyrapp.tax.service.TaxationService;

@RestController
@RequestMapping(value = "/taxation")
public class TaxationController {

    @Autowired
    private TaxationService taxationService;

    @RequestMapping(value = "/search")
    public List<Taxation> taxationSearchByName(@RequestParam String name) {
        System.out.println("In search() >> Name Param: " + name);
        return taxationService.findByNameContainsAndActive(name);
    }

}
