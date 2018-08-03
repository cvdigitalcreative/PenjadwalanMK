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
public class DataHadir {
    int idHadir;
    String nama;
    int hari;
    int jam;
    int hadir;
    
    public DataHadir(){}
    
    public void setIdHadir(int idHadir){
        this.idHadir = idHadir;
    }
    
    public void setNamaDosen(String nama){
        this.nama = nama;
    }
    
    public void setHari(int hari){
        this.hari = hari;
    }
    
    public void setJam(int jam){
        this.jam = jam;
    }
    
    public void setHadir(int hadir){
        this.hadir = hadir;
    }
    
    
    public int getIdHadir(){
        return idHadir; 
    }
    
    public String getNamaDosen(){
        return nama;
    }
    
    public int getHari(){
        return hari;
    }
    
    public int getJam(){
        return jam;
    }
    
    public int getHadir(){
        return hadir;
    }
}
