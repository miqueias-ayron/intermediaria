package com.avaliacao.intermediaria.quarto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping("/quartos")
    public ArrayList<Quarto> getQuartos() {
        return quartoService.getQuartos();
    }

    @PostMapping("/quartos")
    public Quarto addQuarto(@RequestBody Quarto quarto) {
        return quartoService.addQuarto(quarto);
    }

    @PutMapping("/quartos/{id}")
    public Quarto editQuarto(@PathVariable String id, @RequestBody Quarto quarto) {
        return quartoService.editQuarto(id, quarto);
    }

    @GetMapping("/quartos/{id}")
    public Quarto getQuarto(@PathVariable String id) {
        return quartoService.getQuarto(id);
    }

    @DeleteMapping("/quartos/{id}")
    public void deleteQuarto(@PathVariable String id) {
        quartoService.deleteQuarto(id);
    }

}
