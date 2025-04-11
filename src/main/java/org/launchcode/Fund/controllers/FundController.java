package org.launchcode.Fund.controllers;
import org.launchcode.Fund.data.AssetClassRepository;
import org.launchcode.Fund.data.FundRepository;
import org.launchcode.Fund.models.AssetClass;
import org.launchcode.Fund.models.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


//With Repository
@Controller
@RequestMapping("assetclass")
public String FundController {

//we want Springboot to manage the class- dependency injection
@Autowired
private FundRepository fundRepository;

@Autowired
private AssetClassRepository assetClassRepository;


@GetMapping
public String displayAllFunds(@RequestParam(required=false) Integer assetClassId, Model model){

    if(assetClassid == null){
        model.addAttribute("title", "All Asset Classes");
        model.addAttribute("assetClasses", fundRepository.findAll());
    }	else {
    //it may or maynot return value if there's no matching values.
        Optional<AssetClass> result = assetClassRepository.findById(assetClassId);
        if (result.isEmpty()){
            model.addAttribute("ttile", "Invalid Asset Class ID:" + assetClassId);
		} else {
    AssetClass assetClass = result.get();
		model.addAttribute("title", "Fund in Asset Class:" + assetClass.getName());
        model.addAttribute("assetClasses", assetClass.getFund());
        }
    }
    return "funds/index";

@GetMapping("create")
public String displayCreateFundForm(Model, model) {
    model.addAttribute("title", "Create Asset Class");
    model.addAttribute(new Fund());
    model.addAttribute("assetCalsses", assetClassRepository.findAll());
    return "funds/create";
}

//when this handler is called, its subclass is also called.
@PostMapping("create")
public String processCreateFundForm(@ModelAttribute @Valid Fund newFund, Errors errors, Model model) {
    if(errors.hasErrors()){
        model.addAttribute("title", "Create Fund");
        return "funds/create";
    }

    FundRepository.save(newFund);
    return "redirect:";
}


@GetMapping("delete")
public String displayDeleteFundform(Model, model) {
    model.addAttribute("title", "Delete Fund");
    model.addAttribute("assetClasses", fundRepository.findAll());
    return "funds/delete";
}

@PostMapping("delete")
public String processDeleteFundForm(@RequestParam(required=false) int[] fundIds) {

    if(fundIds != null){
        for(int id: fundIds){
            FundRepository.deleteById(id);
        }
    }
    return "redirect";
}

}}