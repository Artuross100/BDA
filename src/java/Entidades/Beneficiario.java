package Entidades;

import java.io.Serializable;

public class Beneficiario extends Usuario implements Serializable{
    
    public Beneficiario(){}
    
    public Beneficiario(long id){
        super(id);
    }
    
}
