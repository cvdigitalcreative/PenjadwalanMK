/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjadwalan;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kontroller.DatabaseManager;
import kontroller.PSO;
import model.DataHadir;
import model.Dosen;
import model.JadwalMK;
import model.MataKuliah;
import model.Ruangan;

/**
 *
 * @author DELL
 */
public class PenjadwalanMK extends javax.swing.JFrame {

    /**
     * Creates new form Penjadwalan
     */
    
    ArrayList<MataKuliah> mataKuliahs;
    ArrayList<Ruangan> ruangans;
    ArrayList<Dosen> dosens;
    ArrayList<DataHadir> dataHadirs;
    ArrayList<ArrayList> jadwalMK;
    int nMK;
    
    public PenjadwalanMK() {
        initComponents();
        nMK = 0;
        txtC1.setText(String.valueOf(2.0));
        txtC2.setText(String.valueOf(2.0));
        txtW.setText(String.valueOf(0.9));
        iterasi.setText(String.valueOf(100));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cb_semester = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtC1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtW = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtC2 = new javax.swing.JTextField();
        btnPSO = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParameter = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        BBalikLoadData = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_tahun = new javax.swing.JTextField();
        BLanjutTampilJadwal = new javax.swing.JButton();
        iterasi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        cb_semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "genap", "ganjil" }));
        cb_semester.setName(""); // NOI18N
        cb_semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_semesterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("W");

        txtC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtC1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("C1");

        txtW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("C2");

        txtC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtC2ActionPerformed(evt);
            }
        });

        btnPSO.setText("Proses Penjadwalan  PSO");
        btnPSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPSOActionPerformed(evt);
            }
        });

        tblParameter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "W", "C1", "C2", "Jumlah Benturan Terkecil"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblParameter);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Semester");

        BBalikLoadData.setText("Balik ke Load Data");
        BBalikLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBalikLoadDataActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tahun");

        tf_tahun.setText("2015");

        BLanjutTampilJadwal.setText("Lanjut ke Tampil Jadwal");
        BLanjutTampilJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLanjutTampilJadwalActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Iterasi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BBalikLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BLanjutTampilJadwal))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtC1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtC2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(iterasi, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPSO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tf_tahun)
                    .addComponent(iterasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnPSO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BBalikLoadData, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(BLanjutTampilJadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cb_semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_semesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_semesterActionPerformed

    private void BBalikLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBalikLoadDataActionPerformed
        LoadData loadData = new LoadData();
        loadData.setVisible(true);
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_BBalikLoadDataActionPerformed

    private void btnPSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPSOActionPerformed
        // TODO add your handling code here:
        int i;
        PSO pso = new PSO();
        ArrayList<MataKuliah> mataKuliahList;
        ArrayList<Ruangan> ruanganList;
        ArrayList<Dosen> dosenList;
        ArrayList<DataHadir> dataHadirList;
        MataKuliah mataKuliah;
        
        setDataMK();
        setDataDosen();
        setDataRuangan();
        setDataHadir();
        
        if(nMK == 0){
            JOptionPane.showMessageDialog(null, "data tidak ada");
        }
        else{
            mataKuliahList = new ArrayList<>();
            for(i=0; i<mataKuliahs.size(); i++){
                mataKuliahList.add(mataKuliahs.get(i));
            }

            ruanganList = new ArrayList<>();
            for(i=0; i<ruangans.size(); i++){
                ruanganList.add(ruangans.get(i));
            }

            dosenList = new ArrayList<>();
            for(i=0; i<dosens.size(); i++){
                dosenList.add(dosens.get(i));
            }

            dataHadirList = new ArrayList<>();
            for(i=0; i<dataHadirs.size(); i++){
                dataHadirList.add(dataHadirs.get(i));
            }

            pso.setRuangan(ruanganList);
            pso.setDataHadir(dataHadirList);
            pso.setIterasi(Integer.parseInt(iterasi.getText()));
            pso.setW(Double.parseDouble(txtW.getText()));
            pso.setC1(Double.parseDouble(txtC1.getText()));
            pso.setC2(Double.parseDouble(txtC2.getText()));
            pso.setR1(0.1);
            pso.setR2(0.9);
            pso.setMataKuliah(mataKuliahList);
            pso.setPSO();

            jadwalMK = pso.getJadwalMK();
            double jumlahBenturanTerkecil = pso.getJumlahBenturanTerkecil();

            String[] row = new String[5];

            DefaultTableModel parameterTable = (DefaultTableModel) tblParameter.getModel();

            row[0] = String.valueOf(tblParameter.getRowCount()+1);
            row[1] = txtW.getText();
            row[2] = txtC1.getText();
            row[3] = txtC2.getText();
            row[4] = String.valueOf((int)jumlahBenturanTerkecil);

            parameterTable.addRow(row);

            SimpanJadwalPSO();
        }
    }//GEN-LAST:event_btnPSOActionPerformed

    private void txtWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWActionPerformed

    private void txtC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtC1ActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtC1ActionPerformed

    private void txtC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtC2ActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtC2ActionPerformed

    private void BLanjutTampilJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLanjutTampilJadwalActionPerformed
        // TODO add your handling code here:
        TampilJadwal tampilJadwal = new TampilJadwal();
        tampilJadwal.setVisible(true);
        dispose();
    }//GEN-LAST:event_BLanjutTampilJadwalActionPerformed
    public void setDataMK(){
        int nDataMK;
        String sql;
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setKoneksiDatabase();
        
        sql = "select count(*) from mata_kuliah where s_semester ='"+cb_semester.getSelectedItem().toString()+"'";
        nDataMK = databaseManager.getJumlahDataMK(sql);
        System.out.println("jumlah mata kuliah : "+nDataMK);
        
        sql = "select *from mata_kuliah where s_semester ='"+cb_semester.getSelectedItem().toString()+"'";
        mataKuliahs = databaseManager.getDataMataKuliah(sql);
        nMK = mataKuliahs.size();
        System.out.println("jumlah mata kuliah : "+nMK);
    }
    
    public void setDataRuangan(){
        int nDataRuangan;
        String sql;
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setKoneksiDatabase();
        
        sql = "select count(*) from ruangan";
        nDataRuangan = databaseManager.getJumlahDataRuangan(sql);
        
        sql = "select *from ruangan";
        ruangans = databaseManager.getDataRuangan(sql);
    }
    
    public void setDataDosen(){
        int nDataDosen;
        String sql;
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setKoneksiDatabase();
        
        sql = "select count(*) from dosen";
        nDataDosen = databaseManager.getJumlahDataDosen(sql);
        
        sql = "select *from dosen";
        dosens = databaseManager.getDataDosen(sql);
    }
    
    public void setDataHadir(){
        int nDataHadir;
        String sql;
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setKoneksiDatabase();
        
        sql = "select count(*) from kehadiran_dosen";
        nDataHadir = databaseManager.getJumlahDataHadir(sql);
        
        sql = "select *from kehadiran_dosen";
        dataHadirs = databaseManager.getDataHadir(sql);
    }
    
    public void SimpanJadwalPSO(){
        int i,j,k,l, nData, nDataTS;
        ArrayList<ArrayList> jadwalJam;
        ArrayList<JadwalMK> jadwalMKList;
        JadwalMK jadwal_MK;
        String[] ruangan;
        int nDataRuangan;
        
        nDataRuangan = ruangans.size();
        ruangan = new String[nDataRuangan];
        
        for(i=0; i<nDataRuangan; i++){
            ruangan[i] = ruangans.get(i).getNamaRuangan();
        }
        
        String sql;
        int idAkhir = 0;
        int idAwal = 0;
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setKoneksiDatabase();
        
        sql = "select count(*) from jadwal_mk";
        nData = databaseManager.getJumlahDataJadwalMKTS(sql);
        
        sql = "select count(*) from jadwal_mk where tahun_jadwal="+Integer.parseInt(tf_tahun.getText())+" and semester_jadwal='"+cb_semester.getSelectedItem().toString()+"'";
        nDataTS = databaseManager.getJumlahDataJadwalMK(sql);
        
        if(nDataTS != 0){
            sql = "select id_jadwal from jadwal_mk where tahun_jadwal="+Integer.parseInt(tf_tahun.getText())+" and semester_jadwal='"+cb_semester.getSelectedItem().toString()+"'";
            idAwal = databaseManager.get_IdDataAwal(sql);
            idAkhir = nDataTS + idAwal; 
        }
        
        //System.out.println("nData : "+nData);
        //System.out.println("nDataTS : "+nDataTS);
        String[] row = new String[12];
        int mulai;
        
        if(nData == 0 || nDataTS == 0){
            mulai = nData + 1;
            for(i=0; i<jadwalMK.size(); i++){
                jadwalJam = jadwalMK.get(i);
                for(j=0; j<jadwalJam.size(); j++){
                    jadwalMKList = jadwalJam.get(j);

                    switch (i) {
                        case 0:
                            row[3] = "senin";
                            break;
                        case 1:
                            row[3] = "selasa";
                            break;
                        case 2:
                            row[3] = "rabu";
                            break;
                        case 3:
                            row[3] = "kamis";
                            break;
                        case 4:
                            row[3] = "jumat";
                            break;
                        default:
                            break;
                    }

                    if(j==0){
                        row[4] = "08:00-10:30";
                    }
                    else if(j==1){
                        row[4] = "10:30-13:00";
                    }
                    if(j==2){
                        row[4] = "13:30-16:00";
                    }

                    for(k=0; k<jadwalMKList.size(); k++){
                        jadwal_MK = jadwalMKList.get(k);

                        for(l=0; l<nDataRuangan; l++){
                            if(jadwal_MK.getRuangan() == l+1){
                                row[5] = ruangan[l];
                            }
                        }

                        if(jadwal_MK.getMKbenturan().isEmpty()){
                            int id = jadwal_MK.getIdMK();

                            row[6] = mataKuliahs.get(id).getKelas();
                            row[7] = mataKuliahs.get(id).getKodeMK();
                            row[8] = mataKuliahs.get(id).getNamaMK();
                            row[9] = String.valueOf(mataKuliahs.get(id).getSksMK());
                            row[10] = mataKuliahs.get(id).getSemesterMK();
                            row[11] = mataKuliahs.get(id).getDosenPengampuMK();
                        }
                        else{
                            String kelas="", kode = "", namaMK="", sks="", semester="", dosen="";

                            for(l=0; l<jadwal_MK.getMKbenturan().size(); l++){
                                int id = jadwal_MK.getMKbenturan().get(l);
                                
                                if(l == jadwal_MK.getMKbenturan().size()-1){
                                    kelas = kelas + mataKuliahs.get(id).getKelas();
                                    kode = kode + mataKuliahs.get(id).getKodeMK();
                                    namaMK = namaMK + mataKuliahs.get(id).getNamaMK();
                                    sks = sks + String.valueOf(mataKuliahs.get(id).getSksMK()); 
                                    semester = semester + mataKuliahs.get(id).getSemesterMK();
                                    dosen = dosen + mataKuliahs.get(id).getDosenPengampuMK();
                                }
                                else{
                                    kelas = kelas + mataKuliahs.get(id).getKelas() + ", ";
                                    kode = kode + mataKuliahs.get(id).getKodeMK() + ", ";
                                    namaMK = namaMK + mataKuliahs.get(id).getNamaMK() + ", ";
                                    sks = sks + String.valueOf(mataKuliahs.get(id).getSksMK()) + ", "; 
                                    semester = semester + mataKuliahs.get(id).getSemesterMK() + ", ";
                                    dosen = dosen + mataKuliahs.get(id).getDosenPengampuMK() + ", ";
                                }
                            }

                            row[6] = kelas;
                            row[7] = kode;
                            row[8] = namaMK;
                            row[9] = sks;
                            row[10] = semester;
                            row[11] = dosen;
                        }
                        row[0] = String.valueOf(mulai);
                        row[1] = tf_tahun.getText();
                        row[2] = cb_semester.getSelectedItem().toString();
                        //jadwalTable.addRow(row);
                        
                        sql = "INSERT INTO jadwal_mk (id_jadwal, tahun_jadwal, semester_jadwal, hari, jam, ruangan, kelas, kode, mata_kuliah, sks, semester_mk, dosen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        databaseManager.insertDataJadwal(sql, row);
                        mulai = mulai+1;
                    }
                }
            }
        }
        else{
            mulai = idAwal;
            int akhir = idAkhir;
            
            if(nDataTS != 0){
                for(i=idAwal; i<idAkhir; i++){
                    sql = "delete from jadwal_mk where id_jadwal = ?";
                    databaseManager.deleteDataJadwal(sql, i);
                }
                
                for(i=idAwal; i<=nData-nDataTS; i++){
                    sql = "UPDATE jadwal_mk set id_jadwal=? where id_jadwal=?";
                    databaseManager.updateIdDataJadwal(sql, i, akhir);
                    akhir = akhir + 1;
                }
                
                nData = nData-nDataTS;
                mulai = nData+1;
            }
            
            for(i=0; i<jadwalMK.size(); i++){
                jadwalJam = jadwalMK.get(i);
                for(j=0; j<jadwalJam.size(); j++){
                    jadwalMKList = jadwalJam.get(j);

                    switch (i) {
                        case 0:
                            row[3] = "senin";
                            break;
                        case 1:
                            row[3] = "selasa";
                            break;
                        case 2:
                            row[3] = "rabu";
                            break;
                        case 3:
                            row[3] = "kamis";
                            break;
                        case 4:
                            row[3] = "jumat";
                            break;
                        default:
                            break;
                    }

                    if(j==0){
                        row[4] = "08:00-10:30";
                    }
                    else if(j==1){
                        row[4] = "10:30-13:00";
                    }
                    if(j==2){
                        row[4] = "13:30-16:00";
                    }

                    for(k=0; k<jadwalMKList.size(); k++){
                        jadwal_MK = jadwalMKList.get(k);

                        for(l=0; l<nDataRuangan; l++){
                            if(jadwal_MK.getRuangan() == l+1){
                                row[5] = ruangan[l];
                            }
                        }

                        if(jadwal_MK.getMKbenturan().isEmpty()){
                            int id = jadwal_MK.getIdMK();

                            row[6] = mataKuliahs.get(id).getKelas();
                            row[7] = mataKuliahs.get(id).getKodeMK();
                            row[8] = mataKuliahs.get(id).getNamaMK();
                            row[9] = String.valueOf(mataKuliahs.get(id).getSksMK());
                            row[10] = mataKuliahs.get(id).getSemesterMK();
                            row[11] = mataKuliahs.get(id).getDosenPengampuMK();
                        }
                        else{
                            String kelas= "", kode = "", namaMK="", sks="", semester="", dosen="";

                            for(l=0; l<jadwal_MK.getMKbenturan().size(); l++){
                                int id = jadwal_MK.getMKbenturan().get(l);
                                
                                if(l == jadwal_MK.getMKbenturan().size()-1){
                                    kelas = mataKuliahs.get(id).getKelas();
                                    kode = kode + mataKuliahs.get(id).getKodeMK();
                                    namaMK = namaMK + mataKuliahs.get(id).getNamaMK();
                                    sks = sks + String.valueOf(mataKuliahs.get(id).getSksMK()); 
                                    semester = semester + mataKuliahs.get(id).getSemesterMK();
                                    dosen = dosen + mataKuliahs.get(id).getDosenPengampuMK();
                                }
                                else{
                                    kelas = kelas + mataKuliahs.get(id).getKelas() + ", ";
                                    kode = kode + mataKuliahs.get(id).getKodeMK() + ", ";
                                    namaMK = namaMK + mataKuliahs.get(id).getNamaMK() + ", ";
                                    sks = sks + String.valueOf(mataKuliahs.get(id).getSksMK()) + ", "; 
                                    semester = semester + mataKuliahs.get(id).getSemesterMK() + ", ";
                                    dosen = dosen + mataKuliahs.get(id).getDosenPengampuMK() + ", ";
                                }
                            }

                            row[6] = kelas;
                            row[7] = kode;
                            row[8] = namaMK;
                            row[9] = sks;
                            row[10] = semester;
                            row[11] = dosen;
                        }
                        row[0] = String.valueOf(mulai);
                        row[1] = tf_tahun.getText();
                        row[2] = cb_semester.getSelectedItem().toString();
                        
                        sql = "INSERT INTO jadwal_mk (id_jadwal, tahun_jadwal, semester_jadwal, hari, jam, ruangan, kelas, kode, mata_kuliah, sks, semester_mk, dosen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        databaseManager.insertDataJadwal(sql, row);
                        mulai = mulai+1;
                    }
                }
            }
        }
        
    }
    
    public ArrayList<ArrayList> getJadwalMKSend(){
        return jadwalMK;
    }
    
    public int getN_MK(){
        return nMK;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PenjadwalanMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjadwalanMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjadwalanMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjadwalanMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjadwalanMK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBalikLoadData;
    private javax.swing.JButton BLanjutTampilJadwal;
    private javax.swing.JButton btnPSO;
    private javax.swing.JComboBox cb_semester;
    private javax.swing.JTextField iterasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblParameter;
    private javax.swing.JTextField tf_tahun;
    private javax.swing.JTextField txtC1;
    private javax.swing.JTextField txtC2;
    private javax.swing.JTextField txtW;
    // End of variables declaration//GEN-END:variables
}
