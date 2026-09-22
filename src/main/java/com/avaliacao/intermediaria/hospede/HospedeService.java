package com.avaliacao.intermediaria.hospede;

import com.avaliacao.intermediaria.common.CampoInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class HospedeService {
    private HashMap<String, Hospede> hospedes = new HashMap<>();

    public ArrayList<Hospede> getHospedes() {
        ArrayList<Hospede> resultado = new ArrayList<>();
        for (Hospede hospede : hospedes.values()) {
            if (!hospede.isDeleted()) {
                resultado.add(hospede);
            }
        }
        return resultado;
    }

    public Hospede addHospede(Hospede hospede) {

        if (hospede.getCpf() == null || hospede.getCpf().isEmpty()) {
            throw new CampoInvalidoException("CPF é obrigatório");
        }

        if (hospede.getNome() == null || hospede.getNome().isEmpty()) {
            throw new CampoInvalidoException("Nome é obrigatório");
        }

        if (hospede.getEmail() == null || hospede.getEmail().isEmpty()) {
            throw new CampoInvalidoException("E-mail é obrigatório");
        }

        if (hospede.getTelefone() == null || hospede.getTelefone().isEmpty()) {
            throw new CampoInvalidoException("Telefone é obrigatório");
        }

        hospedes.put(hospede.getCpf(), hospede);
        return hospede;

    }

    public Hospede editHospede(String cpf, Hospede hospede) {
        Hospede hospedeSalvo = getHospede(cpf);

        if (hospede.getNome() != null && !hospede.getNome().isEmpty()) {
            hospedeSalvo.setNome(hospede.getNome());
        }

        if (hospede.getEmail() != null && !hospede.getEmail().isEmpty()) {
            hospedeSalvo.setEmail(hospede.getEmail());
        }

        if (hospede.getTelefone() != null && !hospede.getTelefone().isEmpty()) {
            hospedeSalvo.setTelefone(hospede.getTelefone());
        }

        hospedes.put(cpf, hospedeSalvo);
        return hospedeSalvo;

    }

    public Hospede getHospede(String cpf) {
        Hospede cliente = hospedes.get(cpf);
        if (cliente == null || cliente.isDeleted()) {
            throw new HospedeNaoEncontradoException("Cliente não encontrado");
        }
        return cliente;
    }

    public void deleteHospede(String cpf) {
        Hospede cliente = getHospede(cpf);
        cliente.setDeleted(true);
    }
}
