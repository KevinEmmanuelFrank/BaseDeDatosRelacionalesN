package Animales;

import java.sql.Date;

public class Animal {

    private int id;
    private String nombre;
    private String tipoAnimal;
    private Date fechaDeNacimiento;
    private boolean adopcion;

    public Animal() {
    }

    public Animal(int id, String nombre, String tipoAnimal, Date fechaDeNacimiento, boolean adopcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.adopcion = adopcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public boolean getAdopcion() {
        return adopcion;
    }

    public void setAdopcion(boolean adopcion) {
        this.adopcion = adopcion;
    }

}
