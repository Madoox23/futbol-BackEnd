package com.back.futbol.exceptions;

public class ErrorMessaje {
    private String type;
    private String message;

    public ErrorMessaje(String type, String message) { //metodo constructor de la clase, al momento de instanciar tendremos
        this.type = type;                              //la capacidad de asignar valores a estos dos atributos
        this.message = message;
    }

    public ErrorMessaje(){
        this.type = "";
        this.message ="";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
