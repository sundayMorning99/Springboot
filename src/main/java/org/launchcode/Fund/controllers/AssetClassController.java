package org.launchcode.Fund.controllers;

import ch.qos.logback.core.model.Model;
import org.launchcode.Fund.models.AssetClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequestMapping("assetclass")
public String AssetClassController {

    //we want Springboot to manage the class- dependency injection
    @Autowired
    private FundRepository fundRepository;

    @Autowired
    private AssetClassRepository assetClassRepository;


    @GetMapping
    public String displayAllAssetClasses(@RequestParam(required=false) Integer assetClassId, Model model){

        if(assetClassid == null)
            model.addAttribute("title", "All Asset Classes");
        model.addAttribute("assetClasses", AssetClassRepository.findAll());
        } else {
        //it may or maynot return value if there's no matching values.
        Optional<AssetClass> result = AssetClassRepository.findById(assetClassId);
            if (result.isEmpty()){
                model.addAttribute("ttile", "Invalid Asset Class ID:" + assetClassId);
            } else {
                AssetClass assetClass = result.get();
                model.addAttribute("title", "Fund in Asset Class:" + assetClass.getName());
                model.addAttribute("assetClasses", assetClass.getFund());
            }
        }
        return "assetclass/index";

    @GetMapping("create")
    public String displayCreateFundForm(Model model) {
        model.addAttribute("title", "Create Asset Class");
        model.addAttribute(new AssetClass());
        model.addAttribute("assetCalss", assetClassRepository.findAll());
        return "assetclass/create";
    }

    //when this handler is called, its subclass is also called.
    @PostMapping("create")
    public String processCreateFundForm(@ModelAttribute @Valid AssetClass newAssetClass, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create New Asset Class");
            model.addAttribute("errorMsg", "Bad data!")
            return "assetclass/create";
        }
        FundRepository.save(newAssetClass);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteFundform(Model model) {
        model.addAttribute("title", "Delete Funds");
        model.addAttribute("assetClasses", fundRepository.findAll());
        return "assetclass/delete";
    }

    @PostMapping("delete")
    public String processDeleteFundForm(@RequestParam(required=false) int[] assetClassIds) {

        if(assetClassids != null){
            for(int id: assetClassIds){
                fundRepository.deleteById(id);
            }
        }
        return "redirect";
}


}

