/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class JadwalMK {
    int id_mk;
    double jam;
    double ruangan;
    ArrayList<Integer> mk_benturan;
    
    public JadwalMK(){
        mk_benturan = new ArrayList<>();
    }
    
    public void setJam(double jam){
        this.jam = jam;
    }
    
    public void setRuangan(double ruangan){
        this.ruangan = ruangan;
    }
    
    public void setIdMK(int id_mk){
        this.id_mk = id_mk;
    }
    
    public void setMKbenturan(int id_mk){
        mk_benturan.add(this.id_mk);
        mk_benturan.add(id_mk);
    }
    
    public void setMKHadirbenturan(int id_mk){
        mk_benturan.add(id_mk);
    }
    
    public double getJam(){
        return jam;
    }
    
    public double getRuangan(){
        return ruangan;
    }
    
    public ArrayList<Integer> getMKbenturan(){
        return mk_benturan;
    }
    
    public int getIdMK(){
        return id_mk;
    }
}
