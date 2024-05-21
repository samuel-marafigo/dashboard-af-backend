package com.dashboardaf.backend.dto;

import java.time.LocalDate;
import java.util.List;

public class AttendanceDTO {

    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private boolean municipes;
    private List<Unit> unidades;
    private List<Retorno> retorno;

    public AttendanceDTO() {}

    public AttendanceDTO(LocalDate dataInicio, LocalDate dataFinal, boolean municipes, List<Unit> unidades, List<Retorno> retorno) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.municipes = municipes;
        this.unidades = unidades;
        this.retorno = retorno;
    }

    // Getters and Setters
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isMunicipes() {
        return municipes;
    }

    public void setMunicipes(boolean municipes) {
        this.municipes = municipes;
    }

    public List<Unit> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unit> unidades) {
        this.unidades = unidades;
    }

    public List<Retorno> getRetorno() {
        return retorno;
    }

    public void setRetorno(List<Retorno> retorno) {
        this.retorno = retorno;
    }

    public static class Retorno {
        private String titulo;
        private Double quantidade;

        public Retorno() {}

        public Retorno(String titulo, Double quantidade) {
            this.titulo = titulo;
            this.quantidade = quantidade;
        }

        // Getters and Setters
        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Double getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Double quantidade) {
            this.quantidade = quantidade;
        }
    }

    public static class Unit {
        private Integer id;

        public Unit() {}

        public Unit(Integer id) {
            this.id = id;
        }

        // Getters and Setters
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
