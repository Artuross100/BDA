package Entidades;

import java.io.Serializable;

public class Division implements Serializable {

    private long ide;
    private char id;
    private String comentarios;

    public Division(char id, String comentarios, long ide) {
        this.id = id;
        this.comentarios = comentarios;
        this.ide = ide;
    }

    public Division() {
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

    public long getIde() {
        return ide;
    }

    public void setIde(long ide) {
        this.ide = ide;
    }

}
