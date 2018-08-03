/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DataHadir;
import model.Dosen;
import model.MataKuliah;
import model.Ruangan;

/**
 *
 * @author USER
 */
public class DatabaseManager {
    private Connection conn = null;
    
    private final String user = "root";
    private final String password = "";
    
    public DatabaseManager(){}
    
    public void setKoneksiDatabase(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/penjadwalan", user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDataJadwal(String sql, String[] data){
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(data[0]));
            statement.setInt(2, Integer.parseInt(data[1]));
            statement.setString(3, data[2]);
            statement.setString(4, data[3]);
            statement.setString(5, data[4]);
            statement.setString(6, data[5]);
            statement.setString(7, data[6]);
            statement.setString(8, data[7]);
            statement.setString(9, data[8]);
            statement.setString(10, data[9]);
            statement.setString(11, data[10]);
            statement.setString(12, data[11]);
            
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDataJadwal(String sql, String[] data, int tahun){
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, data[0]);
            statement.setString(2, data[1]);
            statement.setString(3, data[2]);
            statement.setInt(4, tahun);
            statement.setString(5, data[3]);
            statement.setString(6, data[4]);
            statement.setString(7, data[5]);
            statement.setString(8, data[6]);
            
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int get_IdDataAwal(String sql){
        int idDataAwal = 0;
        
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            
            idDataAwal = result.getInt(1); 

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idDataAwal;
    }
    
    public void deleteDataJadwal(String sql, int dataHapus){
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, dataHapus);            
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateIdDataJadwal(String sql, int dataUbah, int indexDataUbah){
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, dataUbah);
            statement.setInt(2, indexDataUbah);
            
            int rowsUpdated = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDataJadwal(String sql, String[] data){
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(data[0]));
            statement.setString(2, data[3]);
            statement.setString(3, data[4]);
            statement.setString(4, data[5]);
            statement.setString(5, data[6]);
            statement.setString(6, data[7]);
            statement.setString(7, data[8]);
            statement.setString(8, data[9]);
            statement.setString(9, data[10]);
            statement.setInt(10, Integer.parseInt(data[1]));
            statement.setString(11, data[2]);
            
            
            int rowsUpdated = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDataMK(String sql, MataKuliah MK){ 
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, MK.getIdMK());
            statement.setString(2, MK.getKelas());
            statement.setString(3, MK.getNamaMK());
            statement.setString(4, MK.getDosenPengampuMK());
            statement.setInt(5, MK.getSksMK());
            statement.setString(6, MK.getSemesterMK());
            statement.setString(7, MK.getKodeMK());
            statement.setString(8, MK.getSemester());
            
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDataDosen(String sql, Dosen dosen){ 
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, dosen.getIdDosen());
            statement.setString(2, dosen.getNamaDosen());
            statement.setString(3, dosen.getJabatanDosen());
            
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDataRuangan(String sql, Ruangan ruangan){ 
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ruangan.getIdRuangan());
            statement.setString(2, ruangan.getNamaRuangan());
            
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<MataKuliah> getDataMataKuliah(String sql){
        MataKuliah mataKuliah;
        ArrayList<MataKuliah> mataKuliahs;
        
        mataKuliahs = new ArrayList<>();
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                mataKuliah = new MataKuliah();
                mataKuliah.setIdMK(result.getInt(1));
                mataKuliah.setKelas(result.getString(2));
                mataKuliah.setNamaMK(result.getString(3));
                mataKuliah.setDosenPengampuMK(result.getString(4));
                mataKuliah.setSksMK(result.getInt(5));
                mataKuliah.setSemesterMK(result.getString(6));
                mataKuliah.setKodeMK(result.getString(7));
                mataKuliah.setSemester(result.getString(8));
                mataKuliahs.add(mataKuliah);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mataKuliahs;
    }
    
    public ArrayList<String[]> getDataJadwalMK(String sql){
        ArrayList<String[]> dataJadwal;
        
        dataJadwal = new ArrayList<>();
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                String[] Data = new String[12];
                Data[0] = String.valueOf(result.getInt(1));
                Data[1] = String.valueOf(result.getInt(2));
                Data[2] = result.getString(3);
                Data[3] = result.getString(4);
                Data[4] = result.getString(5);
                Data[5] = result.getString(6);
                Data[6] = result.getString(7);
                Data[7] = result.getString(8);
                Data[8] = result.getString(9);
                Data[9] = result.getString(10);
                Data[10] = result.getString(11);
                Data[11] = result.getString(12);
            
                dataJadwal.add(Data);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataJadwal;
    }
    
    public ArrayList<Dosen> getDataDosen(String sql){
        ArrayList<Dosen> dosens;
        
        dosens = new ArrayList<>();
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                Dosen dosen = new Dosen();
                dosen.setIdDosen(result.getInt(1));
                dosen.setNamaDosen(result.getString(2));
                dosen.setJabatanDosen(result.getString(3));
                dosens.add(dosen);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dosens;
    }
    
    public ArrayList<DataHadir> getDataHadir(String sql){
        ArrayList<DataHadir> hadirs;
        
        hadirs = new ArrayList<>();
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                DataHadir dataHadir = new DataHadir();
                dataHadir.setIdHadir(result.getInt(1));
                dataHadir.setNamaDosen(result.getString(2));
                dataHadir.setHari(result.getInt(3));
                dataHadir.setJam(result.getInt(4));
                dataHadir.setHadir(result.getInt(5));
                hadirs.add(dataHadir);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hadirs;
    }
    
    public ArrayList<Ruangan> getDataRuangan(String sql){
        ArrayList<Ruangan> ruangans;
        
        ruangans = new ArrayList<>();
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                Ruangan ruangan = new Ruangan();
                ruangan.setIdRuangan(result.getInt(1));
                ruangan.setNamaRuangan(result.getString(2));
                ruangans.add(ruangan);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ruangans;
    }
    
    public int getJumlahDataMK(String sql){
        int jumlah = 0;
        
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            jumlah = result.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlah;
    }
    
    public int getJumlahDataJadwalMK(String sql){
        int jumlah = 0;
        
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            jumlah = result.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlah;
    }
    
    public int getJumlahDataJadwalMKTS(String sql){
        int jumlah = 0;
        
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            jumlah = result.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlah;
    }
            
    public int getJumlahDataDosen(String sql){
        int jumlah = 0;
        
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            jumlah = result.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlah;
    }
    
    public int getJumlahDataHadir(String sql){
        int jumlah = 0;
        
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            jumlah = result.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlah;
    }
    
    public int getJumlahDataPengampu(String sql){
        int jumlah = 0;
        
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            jumlah = result.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlah;
    }
    
    public int getJumlahDataRuangan(String sql){
        int jumlah = 0;
        
        try {            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            jumlah = result.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlah;
    }
}
