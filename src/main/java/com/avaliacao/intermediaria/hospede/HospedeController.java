package com.avaliacao.intermediaria.hospede;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @GetMapping("/hospedes")
    public ArrayList<Hospede> getHospedes() {
        return hospedeService.getHospedes();
    }

    @PostMapping("/hospedes")
    public Hospede addHospede(@RequestBody Hospede Hospede) {
        return hospedeService.addHospede(Hospede);
    }

    @PutMapping("/hospedes/{id}")
    public Hospede editHospede(@PathVariable String id, @RequestBody Hospede Hospede) {
        return hospedeService.editHospede(id, Hospede);
    }

    @GetMapping("/hospedes/{id}")
    public Hospede getHospede(@PathVariable String id) {
        return hospedeService.getHospede(id);
    }

    @DeleteMapping("/hospedes/{id}")
    public void deleteHospede(@PathVariable String id) {
        hospedeService.deleteHospede(id);
    }

}
