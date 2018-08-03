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
public class MataKuliah {
    int id_mk;
    int sksMK;
    String kelas;
    String namaMK;
    String dosenPengampuMK;
    String kodeMK;
    String semesterMK;
    String semester;
    
    public MataKuliah(){}
    
    public void setIdMK(int id_mk){
        this.id_mk = id_mk;
    }
    
    public void setSksMK(int sksMK){
        this.sksMK = sksMK;
    }
    
    public void setNamaMK(String namaMK){
        this.namaMK = namaMK;
    }
    
    public void setKelas(String kelas){
        this.kelas = kelas;
    }
    
    public void setDosenPengampuMK(String dosenPengampuMK){
        this.dosenPengampuMK = dosenPengampuMK;
    }
    
    public void setSemesterMK(String semesterMK){
        this.semesterMK = semesterMK;
    }
    
    public void setSemester(String semester){
        this.semester = semester;
    }
    
    public void setKodeMK(String kodeMK){
        this.kodeMK = kodeMK;
    }
    
    public int getIdMK(){
        return id_mk;
    }
    
    public int getSksMK(){
        return sksMK;
    }
    
    public String getKelas(){
        return kelas;
    }
    
    public String getNamaMK(){
        return namaMK;
    }
    
    public String getDosenPengampuMK(){
        return dosenPengampuMK;
    }
    
    public String getSemesterMK(){
        return semesterMK;
    }
    
    public String getSemester(){
        return semester;
    }
    
    public String getKodeMK(){
        return kodeMK;
    }
}
