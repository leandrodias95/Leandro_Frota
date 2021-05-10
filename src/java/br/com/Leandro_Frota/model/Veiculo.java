/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Leandro_Frota.model;

/**
 *
 * @author leopc
 */
public class Veiculo {
    private int idVeiculo;
    private String marca;
    private String modelo;
    private int odometro;
    private double valorVeiculo;
    private String observacao;

    public Veiculo() {
    this.idVeiculo= 0;
    this.marca="";
    this.modelo="";
    this.odometro=0;
    this.valorVeiculo=0;
    this.observacao=""; //perguntar sobre os inteiros e o double
    }

    public Veiculo(int idVeiculo, String marca, String modelo, int odometro, double valorVeiculo, String observacao) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.odometro = odometro;
        this.valorVeiculo = valorVeiculo;
        this.observacao = observacao;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getOdometro() {
        return odometro;
    }

    public void setOdometro(int odometro) {
        this.odometro = odometro;
    }

    public double getValorVeiculo() {
        return valorVeiculo;
    }

    public void setValorVeiculo(double valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
