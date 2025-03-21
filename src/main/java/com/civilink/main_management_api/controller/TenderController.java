package com.civilink.main_management_api.controller;

import com.civilink.main_management_api.dto.TenderRequest;
import com.civilink.main_management_api.util.Task;
import com.civilink.main_management_api.util.Tender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tender")
@CrossOrigin ("*")
public class TenderController {

    @PostMapping("/add-tender")
    public void addTender(@RequestBody TenderRequest tenderRequest) {
        System.out.println("Adding task: " + tenderRequest.getName()+": "+""+tenderRequest.getOpenDate()+"" +tenderRequest.getCloseDate()+""+tenderRequest.getProgress()+""+tenderRequest.getDependencies());
    }

    @GetMapping
    public List<Tender> getTenders(){
        List<Tender> tenders = new ArrayList<>();
        tenders.add(new Tender("1234" , "amal","2025-03-20","2025-03-25", "20",""));
        tenders.add(new Tender("1211" , "aaaa","2025-03-20","2025-03-26", "20","1234"));
        return tenders;
    }
}
