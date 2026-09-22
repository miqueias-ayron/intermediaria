package com.avaliacao.intermediaria.reserva;

import com.avaliacao.intermediaria.common.CampoInvalidoException;
import com.avaliacao.intermediaria.hospede.Hospede;
import com.avaliacao.intermediaria.hospede.HospedeService;
import com.avaliacao.intermediaria.quarto.Quarto;
import com.avaliacao.intermediaria.quarto.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class ReservaService{
    @Autowired
    private HospedeService hospedeService;

    @Autowired
    private QuartoService quartoService;

    private HashMap<String, Reserva> reservas = new HashMap<>();

    public ArrayList<Reserva> getReservas() {
        ArrayList<Reserva> resultado = new ArrayList<>();
        for (Reserva Reserva : reservas.values()) {
            if (!Reserva.isDeleted()) {
                resultado.add(Reserva);
            }
        }
        return resultado;
    }

    public Reserva addReserva(Reserva reserva) {

        if (reserva.getDataCheckOut() == null) {
            throw new CampoInvalidoException("Data de checkout é obrigatória");
        }

        if (reserva.getDataCheckIn() == null) {
            throw new CampoInvalidoException("Data checkin é obrigatória");
        }

        if (reserva.getHospede() == null || reserva.getHospede().getCpf() == null) {
            throw new CampoInvalidoException("Hospede é obrigatório");
        }

        Hospede hospede = hospedeService.getHospede(reserva.getHospede().getCpf());
        reserva.setHospede(hospede);

        Quarto quarto = quartoService.getPrimeiroDisponivel();
        quarto.setDisponivel(false);
        reserva.setQuarto(quarto);

        reserva.setId(UUID.randomUUID().toString());

        reservas.put(reserva.getId(), reserva);
        return reserva;

    }


    public Reserva editReserva(String id, Reserva reserva) {
        Reserva reservaSalvo = getReserva(id);

        if (reserva.getDataCheckOut() != null) {
            reservaSalvo.setDataCheckOut(reserva.getDataCheckOut());
        }

        if (reserva.getDataCheckIn() != null) {
            reservaSalvo.setDataCheckIn(reserva.getDataCheckIn());
        }

        reservas.put(id, reservaSalvo);
        return reservaSalvo;

    }

    public Reserva getReserva(String id) {
        Reserva reserva = reservas.get(id);
        if (reserva == null || reserva.isDeleted()) {
            throw new ReservaNaoEncontradaException("Locação não encontrada");
        }
        return reserva;
    }

    public void deleteReserva(String id) {
        Reserva reserva = getReserva(id);
        reserva.setDeleted(true);
    }
}
