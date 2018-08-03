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
public class Ruangan {
    int id_ruangan;
    String nama_ruangan;
    
    public Ruangan(){}
    
    public void setIdRuangan(int id_ruangan){
        this.id_ruangan = id_ruangan;
    }
    
    public void setNamaRuangan(String nama_ruangan){
        this.nama_ruangan = nama_ruangan;
    }
    
    public int getIdRuangan(){
        return id_ruangan;
    }
    
    public String getNamaRuangan(){
        return nama_ruangan;
    }
}
