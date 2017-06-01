package Entidades;

import java.io.Serializable;

public class InfoGeneral implements Serializable {

    private String mision;
    private String vision;
    private String objetivos;
    private String quienesSomos;
    private String bancoDescripcion;
    private String principios;

    public InfoGeneral() {
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getQuienesSomos() {
        return quienesSomos;
    }

    public void setQuienesSomos(String quienesSomos) {
        this.quienesSomos = quienesSomos;
    }

    public String getBancoDescripcion() {
        return bancoDescripcion;
    }

    public void setBancoDescripcion(String bancoDescripcion) {
        this.bancoDescripcion = bancoDescripcion;
    }

    public String getPrincipios() {
        return principios;
    }

    public void setPrincipios(String principios) {
        this.principios = principios;
    }

}
