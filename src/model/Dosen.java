/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class Dosen {
    int idDosen;
    String namaDosen;
    String jabatanDosen;
    
    public Dosen(){}
    
    public void setIdDosen(int idDosen){
        this.idDosen = idDosen;
    }
    
    public void setNamaDosen(String namaDosen){
        this.namaDosen = namaDosen;
    }
    
    public void setJabatanDosen(String jabatanDosen){
        this.jabatanDosen = jabatanDosen;
    }
    
    public int getIdDosen(){
        return idDosen;
    }
    
    public String getNamaDosen(){
        return namaDosen;
    }
    
    public String getJabatanDosen(){
        return jabatanDosen;
    }
}
