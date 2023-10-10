package com.example.practica_mario_rodriguez.clase;

public class Mineral {
    private int id;
    private String mineral;
    private String color;
    private String brillo;
    private String dureza_Mohs;
    private String grupo;

    public Mineral(int id, String mineral, String color, String brillo, String dureza_Mohs, String grupo) {
        this.id = id;
        this.mineral = mineral;
        this.color = color;
        this.brillo = brillo;
        this.dureza_Mohs = dureza_Mohs;
        this.grupo = grupo;
    }

    public Mineral(String mineral, String color, String brillo, String dureza_Mohs, String grupo) {
        this.mineral = mineral;
        this.color = color;
        this.brillo = brillo;
        this.dureza_Mohs = dureza_Mohs;
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMineral() {
        return mineral;
    }

    public void setMineral(String mineral) {
        this.mineral = mineral;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrillo() {
        return brillo;
    }

    public void setBrillo(String brillo) {
        this.brillo = brillo;
    }

    public String getDureza_Mohs() {
        return dureza_Mohs;
    }

    public void setDureza_Mohs(String dureza_Mohs) {
        this.dureza_Mohs = dureza_Mohs;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
