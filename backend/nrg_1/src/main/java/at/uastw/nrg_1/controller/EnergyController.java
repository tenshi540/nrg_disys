package at.uastw.nrg_1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
//xD

@RestController
@RequestMapping("/energy")
public class EnergyController {

    @GetMapping("/current")
    public String getCurrentEnergy() {
        return "Mock Current Energy %";
    }

    @GetMapping("/historical")
    public String getHistorical(@RequestParam String start, @RequestParam String end) {
        return "Mock Historical Data from " + start + " to " + end;
    }
}
