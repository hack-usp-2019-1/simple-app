package com.hackusp.klabinusp.model;

public class Usuario {
    private String id;
    private String roleId;
    private double pesoIc;
    private double pesoEstagio;
    private double pesoPalestra;

    public Usuario(String id, String roleId, double pesoIc, double pesoEstagio, double pesoPalestra) {
        this.id = id;
        this.roleId = roleId;
        this.pesoIc = pesoIc;
        this.pesoEstagio = pesoEstagio;
        this.pesoPalestra = pesoPalestra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public double getPesoIc() {
        return pesoIc;
    }

    public void setPesoIc(double pesoIc) {
        this.pesoIc = pesoIc;
    }

    public double getPesoEstagio() {
        return pesoEstagio;
    }

    public void setPesoEstagio(double pesoEstagio) {
        this.pesoEstagio = pesoEstagio;
    }

    public double getPesoPalestra() {
        return pesoPalestra;
    }

    public void setPesoPalestra(double pesoPalestra) {
        this.pesoPalestra = pesoPalestra;
    }
}
