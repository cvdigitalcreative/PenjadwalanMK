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
public class Partikel {
    double X[][];
    double V[][];
    double Pbest;

    public Partikel(){}
    
    public void setX(double[][] partikelX){
        X = partikelX;
    }
    
    public double[][] getX(){
        return X;
    }
    
    public void setV(double[][] partikelV){
        V = partikelV;
    }
    
    public double[][] getV(){
        return V;
    }
    
    public void setPBest(double partikelPBest){
        Pbest = partikelPBest;
    }
    
    public double getPBest(){
        return Pbest;
    }
}
