package com.avaliacao.intermediaria.quarto;

import com.avaliacao.intermediaria.common.CampoInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class QuartoService {

    private HashMap<String, Quarto> quartos = new HashMap<>();

    public ArrayList<Quarto> getQuartos() {
        ArrayList<Quarto> resultado = new ArrayList<>();
        for (Quarto Quarto : quartos.values()) {
            if (!Quarto.isDeleted()) {
                resultado.add(Quarto);
            }
        }
        return resultado;
    }

    public Quarto addQuarto(Quarto quarto) {

        if (quarto.getAndar() == null) {
            throw new CampoInvalidoException("Andar é obrigatória");
        }

        if (quarto.getTipo() == null || quarto.getTipo().isEmpty()) {
            throw new CampoInvalidoException("Tipo é obrigatória");
        }

        if (quarto.getPrecoPorNoite() <= 0) {
            throw new CampoInvalidoException("Valor por noite é obrigatório");
        }

        quartos.put(quarto.getId(), quarto);
        return quarto;

    }


    public Quarto editQuarto(String id, Quarto quarto) {
        Quarto quartoSalvo = getQuarto(id);

        if (quarto.getTipo() != null && !quarto.getTipo().isEmpty()) {
            quartoSalvo.setTipo(quarto.getTipo());
        }

        if (quarto.getPrecoPorNoite() > 0) {
            quartoSalvo.setPrecoPorNoite(quarto.getPrecoPorNoite());
        }

        quartos.put(id, quartoSalvo);
        return quartoSalvo;

    }

    public Quarto getQuarto(String id) {
        Quarto Quarto = quartos.get(id);
        if (Quarto == null || Quarto.isDeleted()) {
            throw new QuartoNaoEncontradoException("Quarto não encontrado");
        }
        return Quarto;
    }

    public void deleteQuarto(String codigoPatrimonio) {
        Quarto Quarto = getQuarto(codigoPatrimonio);
        Quarto.setDeleted(true);
    }

    public Quarto getPrimeiroDisponivel() {

        for (Quarto quarto : quartos.values()) {
            if (!quarto.isDeleted() && quarto.isDisponivel()) {
                return quarto;
            }
        }

        throw new QuartoNaoEncontradoException("Nenhum quarto disponível");

    }
}
