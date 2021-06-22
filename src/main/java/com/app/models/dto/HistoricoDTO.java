package com.app.models.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.app.models.Historico;

public class HistoricoDTO {

    private String valor;
    private String hoje;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getHoje() {
        return hoje;
    }

    public void setHoje(String hoje) {
        this.hoje = hoje;
    }

    public HistoricoDTO EntidDTO(Historico historico) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        HistoricoDTO DTO = new HistoricoDTO();
        DTO.setValor("R$ " + historico.getValor().toString());
        DTO.setHoje(historico.getHoje().format(formatter));
        return DTO;
    }

    public List<HistoricoDTO> EntidDTO(List<Historico> historicos) {
        return historicos.stream().map(Historico -> EntidDTO(Historico)).collect(Collectors.toList());
    }

}