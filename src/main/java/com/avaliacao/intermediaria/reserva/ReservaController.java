package com.avaliacao.intermediaria.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reservas")
    public ArrayList<Reserva> getReservas() {
        return reservaService.getReservas();
    }

    @PostMapping("/reservas")
    public Reserva addReserva(@RequestBody Reserva reserva) {
        return reservaService.addReserva(reserva);
    }

    @PutMapping("/reservas/{id}")
    public Reserva editReserva(@PathVariable String id, @RequestBody Reserva reserva) {
        return reservaService.editReserva(id, reserva);
    }

    @GetMapping("/reservas/{id}")
    public Reserva getReserva(@PathVariable String id) {
        return reservaService.getReserva(id);
    }

    @DeleteMapping("/reservas/{id}")
    public void deleteReserva(@PathVariable String id) {
        reservaService.deleteReserva(id);
    }

}
