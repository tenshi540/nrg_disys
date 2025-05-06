package at.uastw.nrg_1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
//xD

import at.uastw.nrg_1.repository.UsageStatRepository;

import java.util.List;

@RestController
@RequestMapping("/energy")
public class EnergyController {

     private final UsageStatRepository usageStatRepository;

    public EnergyController(UsageStatRepository usageStatRepository) {
        this.usageStatRepository = usageStatRepository;
    }

    @GetMapping("/current")
    public String getCurrentEnergy() {
        return "Mock Current Energy %";
    }

    @GetMapping("/historical")
    public String getHistorical(@RequestParam String start, @RequestParam String end) {
        return "Mock Historical Data from " + start + " to " + end;
    }

    @GetMapping("/all")
    public List<UsageStat> getEnergy() {
        return usageStatRepository.findAll();
    }
    }