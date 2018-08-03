/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Formatter;
import model.DataHadir;
import model.JadwalMK;
import model.MataKuliah;
import model.Partikel;
import model.Ruangan;

/**
 *
 * @author USER
 */
public class PSO {
    private final String[] hari;
    private final String[] jam;
    private String[] ruangan;
    private double[][] V;
    private double[][] X;
    private double PBest;
    private double GBest;
    private int maxIter;
    private double jumlahBenturanTerkecil;
    private double fitnessGBest;
    private double c1;
    private double c2;
    private double r1;
    private double r2;
    private double w;
    private final int nJam;
    private final int nHari;
    private int nRuangan;
    private int nDataHadir;
    private final int nTimeSlot;
    private int nMK;
    private int partikelJadwalTerpilih;
    private ArrayList<Ruangan> ruangans;
    private ArrayList<DataHadir> dataHadirs;
    private ArrayList<double[][]> Partikel;
    private ArrayList<Partikel> Partikels;
    private ArrayList<MataKuliah> mataKuliahs;
    private ArrayList<ArrayList> jadwalHariMKPartikel;
    private ArrayList<ArrayList> jadwalMKTerpilih;
    private ArrayList<Integer> MKBenturan;
    
    public PSO(){
        hari = new String[]{"senin","selasa", "rabu", "kamis", "jumat"};
        jam = new String[]{"08:00-10:30", "10:30-13:00", "13:30-16:00"};
        
        nHari = hari.length;
        nJam = jam.length;
        nTimeSlot = nHari*nJam;
        fitnessGBest = 0.0;
        jumlahBenturanTerkecil = 0.0;
        jadwalMKTerpilih = new ArrayList<>();
    }
    
    public void setIterasi(int maxIter){
        this.maxIter = maxIter;
    }
    
    public void setRuangan(ArrayList<Ruangan> ruanganTemp){
        int i;
        
        nRuangan = ruanganTemp.size();
        ruangan = new String[nRuangan];
        
        for(i=0; i<nRuangan; i++){
            ruangan[i] = ruanganTemp.get(i).getNamaRuangan();
        }
    }
    
    public void setDataHadir(ArrayList<DataHadir> dataHadirTemp){
        int i;
        
        nDataHadir = dataHadirTemp.size();
        dataHadirs = new ArrayList<>();
        
        for(i=0; i<nDataHadir; i++){
            dataHadirs.add(dataHadirTemp.get(i));
        }
    }
    
    public void setC1(double c1){
        this.c1 = c1;
    }
    
    public void setC2(double c2){
        this.c2 = c2;
    }
    
    public void setR1(double r1){
        this.r1 = r1;
    }
    
    public void setR2(double r2){
        this.r2 = r2;
    }
    
    public void setW(double w){
        this.w = w;
    }
    
    public void setMataKuliah(ArrayList<MataKuliah> mataKuliah){
        int i;
        mataKuliahs = new ArrayList<>();
        
        for(i=0; i<mataKuliah.size(); i++){
            mataKuliahs.add(mataKuliah.get(i));
            //System.out.println(mataKuliahs.get(i).getIdMK());
        }
        
        nMK = mataKuliahs.size();
    }
    
    public Partikel bentukPartikel(){
        int i,j;
        
        V = new double[nMK][3];
        X = new double[nMK][3];
        Partikel partikel = new Partikel();
        
        for(i=0; i<nMK; i++){
            for(j=0; j<3; j++){
                switch (j) {
                    case 0:
                        {
                            Random r = new Random();
                            int rHari = r.nextInt(5)+1;
                            X[i][j] = (double)rHari;
                            //System.out.print(X[i][j]);
                            break;
                        }
                    case 1:
                        {
                            Random r = new Random();
                            int rJam = r.nextInt(3)+1;
                            X[i][j] = (double)rJam;
                            //System.out.print(X[i][j]);
                            break;
                        }
                    default:
                        {
                            Random r = new Random();
                            int rRuangan = r.nextInt(6)+1;
                            X[i][j] = (double)rRuangan;
                            //System.out.print(X[i][j]);
                            
                            break;
                        }
                }
                //System.out.print(X[i][j]+" ");
            }
            //System.out.println();
        }
        
        PBest = 0.0;
        
        V = X;
        
        partikel.setX(X);
        partikel.setV(V);
        partikel.setPBest(PBest);
        
        return partikel;
    }
    
    public void insialisasiP(){
        int i;
        
        Partikels = new ArrayList<>();
        
        for(i=0; i<2; i++){
            //System.out.println("Partikel ke-"+i);
            Partikels.add(bentukPartikel());
            //System.out.println();
        }
        
        System.out.println("Inisialisasi Partikel is Done");
    }
    
    public void setjadwalMK(){
        int i,j,k,l,m, fitnessTerbesarIndex, maxJamKelasA, maxJamKelasB;
        ArrayList<Integer> daftarHariN;
        ArrayList<ArrayList> hariList;
        ArrayList<JadwalMK> jadwalJam;
        ArrayList<ArrayList> jadwalHari;
        ArrayList<ArrayList> jadwalHariJam;
        ArrayList<ArrayList> hariListPartikel;
        double[] fitnessPartikel;
        double[] jumlahBenturan;
        JadwalMK jadwalMK;
        double max, min;
        
        hariListPartikel = new ArrayList<>();
        for(i=0; i<2; i++){
            //System.out.println("partikel ke-"+i);
            hariList = new ArrayList<>();
            for(j=0; j<nHari; j++){
                //System.out.println("hari ke-"+j);
                daftarHariN = new ArrayList<>();
                for(k=0; k<nMK; k++){
                    if(j+1 == Partikels.get(i).getX()[k][0]){
                        //System.out.println("Timeslot ke-"+k);
                        daftarHariN.add(k);
                    }
                }
                hariList.add(daftarHariN);
            }
            hariListPartikel.add(hariList);
        }
        
        jumlahBenturan = new double[2];
        
        for(i=0; i<2; i++){
            jumlahBenturan[i] = 0.0;
        }
        
        jadwalHariMKPartikel = new ArrayList<>();
        MKBenturan = new ArrayList<>();
        for(i=0; i<2; i++){
            //System.out.println("partikel ke-"+i);
            hariList = hariListPartikel.get(i);
            jadwalHari = new ArrayList<>();
            for(j=0; j<hariList.size(); j++){
                //System.out.println("hari ke-"+j);
                daftarHariN = hariList.get(j);
                jadwalHariJam = new ArrayList<>();
                for(k=0; k<nJam; k++){
                    //System.out.println("jam ke-"+k);
                    jadwalJam = new ArrayList<>();
                    maxJamKelasA = 0;
                    maxJamKelasB = 0;
                    for(l=0; l<daftarHariN.size(); l++){
                        double jamTemp = Partikels.get(i).getX()[daftarHariN.get(l)][1];
                        double ruanganTemp = Partikels.get(i).getX()[daftarHariN.get(l)][2];
                        
                        if(jamTemp == k+1){
                            if(jadwalJam.isEmpty()){
                                if(mataKuliahs.get(daftarHariN.get(l)).getKelas().equals("-")){
                                    jadwalMK = new JadwalMK();
                                    jadwalMK.setIdMK(daftarHariN.get(l));
                                    jadwalMK.setJam(jamTemp);
                                    jadwalMK.setRuangan(ruanganTemp);
                                    jadwalJam.add(jadwalMK);   
                                    int nJadwal = jadwalJam.size()-1;

                                    for(int h=1; h<nDataHadir; h++){
                                        if(mataKuliahs.get(daftarHariN.get(l)).getDosenPengampuMK().equals(dataHadirs.get(h).getNamaDosen()) && dataHadirs.get(h).getHari() == j && dataHadirs.get(h).getJam() == k){
                                            if(dataHadirs.get(h).getHadir() == 0){
                                                jumlahBenturan[i] += 1.0;
                                                MKBenturan.add(daftarHariN.get(l));
                                                jadwalJam.get(nJadwal).setMKHadirbenturan(daftarHariN.get(l));
                                            }   
                                        }
                                    }
                                }
                                
                                if(mataKuliahs.get(daftarHariN.get(l)).getKelas().equals("regA") && jamTemp == (k+1) && maxJamKelasA == 0){
                                    jadwalMK = new JadwalMK();
                                    jadwalMK.setIdMK(daftarHariN.get(l));
                                    jadwalMK.setJam(jamTemp);
                                    jadwalMK.setRuangan(ruanganTemp);
                                    jadwalJam.add(jadwalMK);   
                                    int nJadwal = jadwalJam.size()-1;

                                    for(int h=1; h<nDataHadir; h++){
                                        if(mataKuliahs.get(daftarHariN.get(l)).getDosenPengampuMK().equals(dataHadirs.get(h).getNamaDosen()) && dataHadirs.get(h).getHari() == j && dataHadirs.get(h).getJam() == k){
                                            if(dataHadirs.get(h).getHadir() == 0){
                                                jumlahBenturan[i] += 1.0;
                                                MKBenturan.add(daftarHariN.get(l));
                                                jadwalJam.get(nJadwal).setMKHadirbenturan(daftarHariN.get(l));
                                            }   
                                        }
                                    }
                                    maxJamKelasA = 1;
                                }
                                
                                if(mataKuliahs.get(daftarHariN.get(l)).getKelas().equals("regB") && jamTemp == (k+1) && maxJamKelasB == 0){
                                    jadwalMK = new JadwalMK();
                                    jadwalMK.setIdMK(daftarHariN.get(l));
                                    jadwalMK.setJam(jamTemp);
                                    jadwalMK.setRuangan(ruanganTemp);
                                    jadwalJam.add(jadwalMK);   
                                    int nJadwal = jadwalJam.size()-1;

                                    for(int h=1; h<nDataHadir; h++){
                                        if(mataKuliahs.get(daftarHariN.get(l)).getDosenPengampuMK().equals(dataHadirs.get(h).getNamaDosen()) && dataHadirs.get(h).getHari() == j && dataHadirs.get(h).getJam() == k){
                                            if(dataHadirs.get(h).getHadir() == 0){
                                                jumlahBenturan[i] += 1.0;
                                                MKBenturan.add(daftarHariN.get(l));
                                                jadwalJam.get(nJadwal).setMKHadirbenturan(daftarHariN.get(l));
                                            }   
                                        }
                                    }

                                    maxJamKelasB = 1;   
                                }
                                //System.out.println("mk : "+jadwalMK.getIdMK());
                            }
                            else{
                                int status = 0;
                                
                                for(m=0; m<jadwalJam.size(); m++){
                                    if(jamTemp == jadwalJam.get(m).getJam() && ruanganTemp == jadwalJam.get(m).getRuangan()){
                                        jumlahBenturan[i] += 1.0;
                                        jadwalJam.get(m).setMKbenturan(daftarHariN.get(l));
                                        MKBenturan.add(daftarHariN.get(l));
                                        //System.out.print("mk benturan pada jam dan ruangan sama (non count): ");
                                        status = 1;
                                    }
                                    
                                    if(jamTemp == jadwalJam.get(m).getJam() && mataKuliahs.get(daftarHariN.get(l)).getDosenPengampuMK().equals(mataKuliahs.get(jadwalJam.get(m).getIdMK()).getDosenPengampuMK())){
                                        jumlahBenturan[i] += 1.0;
                                        jadwalJam.get(m).setMKbenturan(daftarHariN.get(l));
                                        MKBenturan.add(daftarHariN.get(l));
                                        status = 1;
                                    }
                                }
                                
                                if(status == 0){
                                    //System.out.println(nJadwal);
                                    
                                    if(mataKuliahs.get(daftarHariN.get(l)).getKelas().equals("-")){
                                        jadwalMK = new JadwalMK();
                                        jadwalMK.setIdMK(daftarHariN.get(l));
                                        jadwalMK.setJam(jamTemp);
                                        jadwalMK.setRuangan(ruanganTemp);
                                        jadwalJam.add(jadwalMK);   
                                        int nJadwal = jadwalJam.size()-1;
                                        
                                        for(int h=1; h<nDataHadir; h++){
                                            if(mataKuliahs.get(daftarHariN.get(l)).getDosenPengampuMK().equals(dataHadirs.get(h).getNamaDosen()) && dataHadirs.get(h).getHari() == j && dataHadirs.get(h).getJam() == k){
                                                if(dataHadirs.get(h).getHadir() == 0){
                                                    jumlahBenturan[i] += 1.0;
                                                    MKBenturan.add(daftarHariN.get(l));
                                                    jadwalJam.get(nJadwal).setMKHadirbenturan(daftarHariN.get(l));
                                                }   
                                            }
                                        }
                                    }
                                    
                                    if(mataKuliahs.get(daftarHariN.get(l)).getKelas().equals("regA") && jamTemp == (k+1) && maxJamKelasA == 0){
                                        jadwalMK = new JadwalMK();
                                        jadwalMK.setIdMK(daftarHariN.get(l));
                                        jadwalMK.setJam(jamTemp);
                                        jadwalMK.setRuangan(ruanganTemp);
                                        jadwalJam.add(jadwalMK);   
                                        int nJadwal = jadwalJam.size()-1;
                                        
                                        for(int h=1; h<nDataHadir; h++){
                                            if(mataKuliahs.get(daftarHariN.get(l)).getDosenPengampuMK().equals(dataHadirs.get(h).getNamaDosen()) && dataHadirs.get(h).getHari() == j && dataHadirs.get(h).getJam() == k){
                                                if(dataHadirs.get(h).getHadir() == 0){
                                                    jumlahBenturan[i] += 1.0;
                                                    MKBenturan.add(daftarHariN.get(l));
                                                    jadwalJam.get(nJadwal).setMKHadirbenturan(daftarHariN.get(l));
                                                }   
                                            }
                                        }
                                        maxJamKelasA = 1;
                                    }

                                    if(mataKuliahs.get(daftarHariN.get(l)).getKelas().equals("regB") && jamTemp == (k+1) && maxJamKelasB == 0){
                                        jadwalMK = new JadwalMK();
                                        jadwalMK.setIdMK(daftarHariN.get(l));
                                        jadwalMK.setJam(jamTemp);
                                        jadwalMK.setRuangan(ruanganTemp);
                                        jadwalJam.add(jadwalMK);   
                                        int nJadwal = jadwalJam.size()-1;
                                        
                                        for(int h=1; h<nDataHadir; h++){
                                            if(mataKuliahs.get(daftarHariN.get(l)).getDosenPengampuMK().equals(dataHadirs.get(h).getNamaDosen()) && dataHadirs.get(h).getHari() == j && dataHadirs.get(h).getJam() == k){
                                                if(dataHadirs.get(h).getHadir() == 0){
                                                    jumlahBenturan[i] += 1.0;
                                                    MKBenturan.add(daftarHariN.get(l));
                                                    jadwalJam.get(nJadwal).setMKHadirbenturan(daftarHariN.get(l));
                                                }   
                                            }
                                        }
                                        
                                        maxJamKelasB = 1;   
                                    }
                                    //System.out.println("mk : "+jadwalMK.getIdMK());
                                }
                            }
                        }
                    }
                    //System.out.println();
                    jadwalHariJam.add(jadwalJam);
                }
                //System.out.println();
                jadwalHari.add(jadwalHariJam);
            }
            //System.out.println();
            jadwalHariMKPartikel.add(jadwalHari);
        }
        
        /*for(i=0; i<2; i++){
            System.out.println("jumlah benturan ke-"+i+": "+jumlahBenturan[i]);
        }*/
        
        min = 1000.00;
        int indexMin = 0;
        for(i=0; i<2; i++){            
            if(min > jumlahBenturan[i]){
                min = jumlahBenturan[i];
                indexMin = i;
            }
            else if(jumlahBenturan[i] == 0.0){
                min = 0.0;
                indexMin = i;
            }
            System.out.println("jumlah benturan : "+jumlahBenturan[i]);
        }
        
        if(jadwalMKTerpilih.isEmpty()){
            jadwalMKTerpilih.add(jadwalHariMKPartikel.get(indexMin));
        }
        else{
            if(jumlahBenturanTerkecil > min){
                jadwalMKTerpilih = new ArrayList<>();
                jadwalMKTerpilih.add(jadwalHariMKPartikel.get(indexMin));
            }
        }
        
        fitnessPartikel = new double[2];
        
        for(i=0; i<2; i++){
            fitnessPartikel[i] = 1.0/(jumlahBenturan[i]+0.001);
            
            /*NumberFormat nf = NumberFormat.getInstance(Locale.US); // get instance
            nf.setMaximumFractionDigits(2); // set decimal places
            String number = nf.format(fitnessPartikel[i]);
            fitnessPartikel[i] = Double.valueOf(number);*/
            
            System.out.println("Fitness partikel ke-"+i+": "+fitnessPartikel[i]);
        }
        
        max = 0.0;
        fitnessTerbesarIndex = -1;
        
        for(i=0; i<2; i++){
            Partikels.get(i).setPBest(jumlahBenturan[i]);
            
            if(max < fitnessPartikel[i]){
                max = fitnessPartikel[i];
                fitnessTerbesarIndex = i;
            }
            
            System.out.println("PBest partikel ke-"+i+": "+Partikels.get(i).getPBest());
        }
        
        partikelJadwalTerpilih = fitnessTerbesarIndex;
        
        if(fitnessGBest == 0.0){
            GBest = Partikels.get(fitnessTerbesarIndex).getPBest();
            fitnessGBest = fitnessPartikel[fitnessTerbesarIndex];
            jumlahBenturanTerkecil = min;
        }
        else{
            if(fitnessGBest < fitnessPartikel[fitnessTerbesarIndex]){
                fitnessGBest = fitnessPartikel[fitnessTerbesarIndex];
                GBest = Partikels.get(fitnessTerbesarIndex).getPBest();
            }
            
            if(jumlahBenturanTerkecil > min ){
                jumlahBenturanTerkecil = min;
            }
        }
        
        System.out.println("Jumlah Benturan Terkecil : "+jumlahBenturanTerkecil);
        System.out.println("Gbest : "+GBest);
        System.out.println("Set jadwal is Done");
    }   
    
    public void updatePartikel(){
        int i,j,k;
        double floor;
        double ceil;
        double total;
        double[][] Xtemp;
        double[][] Vtemp;
        
        for(i=0; i<2; i++){
            Vtemp = new double[nMK][3];
            Xtemp = new double[nMK][3];
            
            for(j=0; j<nMK; j++){
                for(k=0; k<3; k++){
                    Vtemp[j][k] = Partikels.get(i).getV()[j][k];
                    Xtemp[j][k] = Partikels.get(i).getX()[j][k];
                }
            }
            
            /*System.out.println("V lama : ");
            for(j=0; j<nMK; j++){
                for(k=0; k<3; k++){
                    System.out.print(Vtemp[j][k]+" ");
                }
                System.out.println();
            }
            */
            
            
            /*System.out.println();
            System.out.println("X lama : ");
            for(j=0; j<nMK; j++){
                for(k=0; k<3; k++){
                    System.out.print(Xtemp[j][k]+" ");
                }
                System.out.println();
            }*/
            
            //System.out.println("V baru :");
            for(j=0; j<nMK; j++){
                for(k=0; k<MKBenturan.size(); k++){
                    if(j == MKBenturan.get(k)){
                        for(int l=0; l<3; l++){
                            Vtemp[j][l] = (w*Vtemp[j][l])+(c1*r1*(Partikels.get(i).getPBest() - Xtemp[j][l]))+(c2*r2*(GBest - Xtemp[j][l]));
                            Xtemp[j][l] = Xtemp[j][l] + Vtemp[j][l];
                        }
                    }
                }
                    //NumberFormat nf = NumberFormat.getInstance(Locale.US); // get instance
                    //nf.setMaximumFractionDigits(2); // set decimal places
                    //Vtemp[j][k] = Double.valueOf(nf.format(Vtemp[j][k]));
                    //System.out.print(Vtemp[j][k]+" ");
                
                
                /*for(k=0; k<3; k++){
                    Xtemp[j][k] = Xtemp[j][k] + Vtemp[j][k];
                }*/
                //System.out.println();
            }
            
            
            /*System.out.println();
            System.out.println("X baru :");
            for(j=0; j<nMK; j++){                
                for(k=0; k<3; k++){
                    System.out.print(Xtemp[j][k]+" ");
                }
                System.out.println();
            }*/
            
            //System.out.println();
            //System.out.println("V baru pembulatan untuk partikel ke-"+i);
            for(j=0; j<nMK; j++){
                for(k=0; k<3; k++){
                    floor = Math.floor(Vtemp[j][k]);
                    ceil = Math.ceil(Vtemp[j][k]);
                    total = floor+ceil;
                    
                    if(Vtemp[j][k] < total/2.0){
                        Vtemp[j][k] = floor;
                    }
                    else{
                        Vtemp[j][k] = ceil;
                    }
                    
                    if((k==0 && Vtemp[j][k] > 5) || (k == 1 && Vtemp[j][k] > 3) || (k==2 && Vtemp[j][k] > 6)){
                        if(k==0){
                            double temp = Vtemp[j][k];
                            
                            while(temp > 5){
                                temp = temp-1;
                                
                                if(Vtemp[j][k] > 5){
                                    Vtemp[j][k] = 1;
                                }
                                else{
                                    Vtemp[j][k] = Vtemp[j][k]+1;
                                    if(temp == 5 && Vtemp[j][k] == 6.0){
                                        Vtemp[j][k] = 1;
                                    }
                                }
                            }
                        }
                        
                        if(k==1){
                            double temp = Vtemp[j][k];
                            
                            while(temp > 3){
                                temp = temp-1;
                                
                                if(Vtemp[j][k] > 3){
                                    Vtemp[j][k] = 1;
                                }
                                else{
                                    Vtemp[j][k] = Vtemp[j][k]+1;
                                    if(temp == 3 && Vtemp[j][k] == 4.0){
                                        Vtemp[j][k] = 1;
                                    }
                                }
                            }
                        }
                        
                        if(k==2){
                            double temp = Vtemp[j][k];
                            
                            while(temp > 6){
                                temp = temp-1;
                                
                                if(Vtemp[j][k] > 6){
                                    Vtemp[j][k] = 1;
                                }
                                else{
                                    Vtemp[j][k] = Vtemp[j][k]+1;
                                    if(temp == 6 && Vtemp[j][k] == 7.0){
                                        Vtemp[j][k] = 1;
                                    }
                                }
                            }
                        }
                    }
                    
                    if(Vtemp[j][k] < 1){
                        Vtemp[j][k] = 1;
                    }
                    
                    System.out.print(Vtemp[j][k]+" ");
                }
                System.out.println();
            }
            
            //System.out.println();
            //System.out.println("X baru pembulatan untuk partikel ke-"+i);
            for(j=0; j<nMK; j++){
                for(k=0; k<3; k++){
                    floor = Math.floor(Xtemp[j][k]);
                    ceil = Math.ceil(Xtemp[j][k]);
                    total = floor+ceil;
                    
                    if(Xtemp[j][k] < total/2.0){
                        Xtemp[j][k] = floor;
                    }
                    else{
                        Xtemp[j][k] = ceil;
                    }
                    
                    if((k==0 && Xtemp[j][k] > 5) || (k == 1 && Xtemp[j][k] > 3) || (k==2 && Xtemp[j][k] > 6)){
                        if(k==0){
                            double temp = Xtemp[j][k];
                            
                            while(temp > 5){
                                temp = temp-1;
                                
                                if(Xtemp[j][k] > 5){
                                    Xtemp[j][k] = 1;
                                }
                                else{
                                    Xtemp[j][k] = Xtemp[j][k]+1;
                                    if(temp == 5 && Xtemp[j][k] == 6.0){
                                        Xtemp[j][k] = 1;
                                    }
                                }
                            }
                        }
                        
                        if(k==1){
                            double temp = Xtemp[j][k];
                            
                            while(temp > 3){
                                temp = temp-1;
                                
                                if(Xtemp[j][k] > 3){
                                    Xtemp[j][k] = 1;
                                }
                                else{
                                    Xtemp[j][k] = Xtemp[j][k]+1;
                                    if(temp == 3 && Xtemp[j][k] == 4.0){
                                        Xtemp[j][k] = 1;
                                    }
                                }
                            }
                        }
                        
                        if(k==2){
                            double temp = Xtemp[j][k];
                            
                            while(temp > 6){
                                temp = temp-1;
                                
                                if(Xtemp[j][k] > 6){
                                    Xtemp[j][k] = 1;
                                }
                                else{
                                    Xtemp[j][k] = Xtemp[j][k]+1;
                                    if(temp == 6 && Xtemp[j][k] == 7.0){
                                        Xtemp[j][k] = 1;
                                    }
                                }
                            }
                        }
                    }
                    
                    if(Xtemp[j][k] < 1){
                        Xtemp[j][k] = 1;
                    }
                    
                    //System.out.print(Xtemp[j][k]+" ");
                }
                //System.out.println();
            }
            
            Partikels.get(i).setX(Xtemp);
            Partikels.get(i).setV(Vtemp);
        }
        
        /*for(i=0; i<2; i++){
            System.out.println("Partikel X ke-"+i);
            for(j=0; j<nMK; j++){
                for(k=0; k<3; k++){
                    System.out.print(Partikels.get(i).getX()[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }*/
        
        System.out.println("Update Partikel is Done");
    }
    
    public ArrayList<ArrayList> getJadwalMK(){
        return jadwalMKTerpilih.get(0); 
    }
    
    public double getJumlahBenturanTerkecil(){
        return jumlahBenturanTerkecil;
    }
    
    public void setPSO(){
        int i;
        
        for(i=0; i<maxIter; i++){
            System.out.println("Iterasi ke-"+i);
            if(i == 0){
                insialisasiP();
                setjadwalMK();
                
                if(jumlahBenturanTerkecil == 0.0){
                    i=maxIter;
                }
                
                updatePartikel();
            }   
            else{
                setjadwalMK();
                
                if(jumlahBenturanTerkecil == 0.0){
                    i=maxIter;
                }
                
                updatePartikel();
            }
            System.out.println();
        }
    }
}
