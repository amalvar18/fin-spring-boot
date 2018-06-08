package com.finomyr.finomyrapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finomyr.finomyrapp.enums.AssetClass;
import com.finomyr.finomyrapp.model.InvestmentType;

/**
 * @author amalvar
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /*@Autowired
    private TaxationRepository taxationRepository;*/

    /*public AdminController(TaxationRepository taxationRepository) {
        this.taxationRepository = taxationRepository;
    }*/

    @RequestMapping()
    public ModelAndView adminhome() {
        System.out.println("In AdminController::adminhome()");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/adminhome");
        modelAndView.addObject("pageTitle", "Manage");
        modelAndView.addObject(new InvestmentType());
        modelAndView.addObject("assetClassList", AssetClass.values());
        return modelAndView;
    }
    /*@RequestMapping("/taxation")
    public Set<Taxation> allTaxation() {
        return taxationRepository.findByAssetClassAndActiveTrue("Equity");
    }*/

}
