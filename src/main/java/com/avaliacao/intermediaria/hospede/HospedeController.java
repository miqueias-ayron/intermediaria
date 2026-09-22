package com.avaliacao.intermediaria.hospede;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @GetMapping("/Hospedes")
    public ArrayList<Hospede> getHospedes() {
        return hospedeService.getHospedes();
    }

    @PostMapping("/Hospedes")
    public Hospede addHospede(@RequestBody Hospede Hospede) {
        return hospedeService.addHospede(Hospede);
    }

    @PutMapping("/Hospedes/{id}")
    public Hospede editHospede(@PathVariable String id, @RequestBody Hospede Hospede) {
        return hospedeService.editHospede(id, Hospede);
    }

    @GetMapping("/Hospedes/{id}")
    public Hospede getHospede(@PathVariable String id) {
        return hospedeService.getHospede(id);
    }

    @DeleteMapping("/Hospedes/{id}")
    public void deleteHospede(@PathVariable String id) {
        hospedeService.deleteHospede(id);
    }

}
