package Entidades;

import java.io.Serializable;

public class Division implements Serializable{
    
    private char id;
    private String comentarios;

    public Division(char id, String comentarios) {
        this.id = id;
        this.comentarios = comentarios;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
}
