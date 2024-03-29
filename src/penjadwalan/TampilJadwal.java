/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjadwalan;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import kontroller.DatabaseManager;
import model.JadwalMK;
import model.MataKuliah;
import model.Ruangan;

/**
 *
 * @author DELL
 */
public final class TampilJadwal extends javax.swing.JFrame {

    /**
     * Creates new form TampilJadwal
     */
    
    private int nRuangan;
    private int nMK;
    private String[] ruangan;
    ArrayList<MataKuliah> mataKuliahs;
    String[][] dataSelected, dataDB;
    int nDataTS, nData, idAwal, idAkhir;
    String tahun, semester;
    String[] jam;
    String[] hari;
    
    ArrayList<ArrayList> jadwalMK;
    public TampilJadwal() {
        initComponents();
        setRuangan();
        setMataKuliah();
        setJamHari();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTJadwal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cb_semesterTampil = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_tahunTampil = new javax.swing.JComboBox();
        btn_TampilJadwal = new javax.swing.JButton();
        BBalikPenjadwalan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BCariJadwal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pilihHari = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        pilihJam = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        tblTJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hari", "Jam", "Ruangan", "kelas", "Kode MK", "Mata Kuliah", "Sks", "Semester", "Dosen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTJadwal);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("TAMPIL JADWAL");

        cb_semesterTampil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "genap", "ganjil" }));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Semester");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tahun");

        cb_tahunTampil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih", "2015", "2016", "2017", "2018", "2019" }));

        btn_TampilJadwal.setText("Tampil Jadwal");
        btn_TampilJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TampilJadwalActionPerformed(evt);
            }
        });

        BBalikPenjadwalan.setText("Balik ke Penjadwalan");
        BBalikPenjadwalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBalikPenjadwalanActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ubah Jadwal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        BCariJadwal.setText("Cari Jadwal Baru Dosen");
        BCariJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCariJadwalActionPerformed(evt);
            }
        });

        jLabel4.setText("Hari yang diinginkan :");

        pilihHari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "senin", "selasa", "rabu", "kamis", "jumat" }));

        jLabel5.setText("Jam yang diinginkan : ");

        pilihJam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00-10:30", "10:30-13:00", "13:30-16:00" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BCariJadwal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(pilihHari, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pilihJam, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pilihHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(pilihJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(BCariJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_tahunTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_semesterTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_TampilJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jLabel1)
                        .addGap(0, 357, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BBalikPenjadwalan, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_TampilJadwal)
                    .addComponent(cb_semesterTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cb_tahunTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BBalikPenjadwalan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TampilJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TampilJadwalActionPerformed
        // TODO add your handling code here:        
        int i;
        DefaultTableModel jadwalTable = (DefaultTableModel) tblTJadwal.getModel();
        for(i=tblTJadwal.getRowCount()-1; i>=0; i--){
            jadwalTable.removeRow(i);
        }
        
        tampilJadwalPSO();
    }//GEN-LAST:event_btn_TampilJadwalActionPerformed

    private void BCariJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCariJadwalActionPerformed
        // TODO add your handling code here:
        int i,j,k,l,m;
        String sql;
        DefaultTableModel jadwalTable = (DefaultTableModel) tblTJadwal.getModel();
        
        int row = tblTJadwal.getSelectedRow();
        
        if(row != -1){
            String hariValue = jadwalTable.getValueAt(row, 0).toString();
            String jamValue = jadwalTable.getValueAt(row, 1).toString();
            String ruanganValue = jadwalTable.getValueAt(row, 2).toString();

            ArrayList<String> ruanganTblList;
            String hariTerpilih = "", jamTerpilih = "", ruanganTerpilih = "";
            
            if((pilihHari.getSelectedItem().toString().equals("jumat") && pilihJam.getSelectedItem().toString().equals("10:30-13:00")) == false){
                ruanganTblList = new ArrayList<>();
                System.out.print("ruangan yang sudah ditempati : ");

                    for(k=0; k<nDataTS; k++){
                        if(pilihHari.getSelectedItem().toString().equals(dataSelected[k][0])){
                            if(pilihJam.getSelectedItem().toString().equals(dataSelected[k][1])){
                                for(l=0; l<ruangan.length; l++){
                                    if(ruangan[l].equals(dataSelected[k][2])){
                                        ruanganTblList.add(ruangan[l]);
                                    }
                                }
                            }
                        }
                    }


                for(m=0; m<ruanganTblList.size(); m++){
                    System.out.print(ruanganTblList.get(m)+" ");
                }

                System.out.println();

                for(l=0; l<ruangan.length; l++){
                    int ruanganAda = 0;
                    for(m=0; m<ruanganTblList.size(); m++){
                        if(ruangan[l].equals(ruanganTblList.get(m))){
                            ruanganAda = 1;
                        }
                    }

                    if(ruanganAda == 0){
                        hariTerpilih = pilihHari.getSelectedItem().toString();
                        jamTerpilih = pilihJam.getSelectedItem().toString();
                        ruanganTerpilih = ruangan[l];
                        l = ruangan.length;
                        k = nDataTS;
                    }
                }

                if(!ruanganTerpilih.equals("")){
                    System.out.println("ruangan terpilih : "+ruanganTerpilih);
                    System.out.println();
                    
                    DatabaseManager databaseManager = new DatabaseManager();
                    databaseManager.setKoneksiDatabase();
                    ArrayList<String[]> dataJadwalMK;
                    String[] info = new String[7];

                    info[0] = hariTerpilih;
                    info[1] = jamTerpilih;
                    info[2] = ruanganTerpilih;
                    info[3] = cb_semesterTampil.getSelectedItem().toString();
                    info[4] = hariValue;
                    info[5] = jamValue;
                    info[6] = ruanganValue;

                    sql = "update jadwal_mk set hari=?, jam=?, ruangan=? where tahun_jadwal=? and semester_jadwal=? and hari=? and jam=? and ruangan=?";
                    databaseManager.updateDataJadwal(sql, info, Integer.parseInt(cb_tahunTampil.getSelectedItem().toString()));
                    
                    System.out.println("hari baru : "+hariTerpilih);
                    System.out.println("jam baru : "+jamTerpilih);
                    System.out.println("ruangan baru : "+ruanganTerpilih);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Maaf, ruangan yang anda pilih sudah diisi");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Maaf, anda tidak bisa memindahkan jadwal ke hari jumat dan jam 10:30-13:00");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Maaf, anda lupa memilih jadwal Dosen yang ingin diubah");
        }
    }//GEN-LAST:event_BCariJadwalActionPerformed

    private void BBalikPenjadwalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBalikPenjadwalanActionPerformed
        // TODO add your handling code here:
        PenjadwalanMK penjadwalanMK = new PenjadwalanMK();
        penjadwalanMK.setVisible(true);
        dispose();
    }//GEN-LAST:event_BBalikPenjadwalanActionPerformed

    public void tampilJadwalPSO(){
        int i, j, k, l;
        String sql;
        ArrayList<ArrayList> jadwalJam;
        ArrayList<JadwalMK> jadwalMKList;
        JadwalMK jadwal_MK;
        ArrayList<String[]> dataJadwalMK;
        
        String[] row = new String[9];
        idAkhir = 0;
        idAwal = 0;
        tahun = cb_tahunTampil.getSelectedItem().toString();
        semester =  cb_semesterTampil.getSelectedItem().toString();
        
        DefaultTableModel jadwalTable = (DefaultTableModel) tblTJadwal.getModel();

        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setKoneksiDatabase();
        
        sql = "select count(*) from jadwal_mk";
        nData = databaseManager.getJumlahDataJadwalMKTS(sql);
        
        sql = "select count(*) from jadwal_mk where tahun_jadwal="+Integer.parseInt(cb_tahunTampil.getSelectedItem().toString())+" and semester_jadwal='"+cb_semesterTampil.getSelectedItem().toString()+"'";
        nDataTS = databaseManager.getJumlahDataJadwalMK(sql);
        
        sql = "select *from jadwal_mk where tahun_jadwal="+Integer.parseInt(cb_tahunTampil.getSelectedItem().toString())+" and semester_jadwal='"+cb_semesterTampil.getSelectedItem().toString()+"'";
        dataJadwalMK = databaseManager.getDataJadwalMK(sql);
        
        if(nDataTS != 0){
            sql = "select id_jadwal from jadwal_mk where tahun_jadwal="+Integer.parseInt(cb_tahunTampil.getSelectedItem().toString())+" and semester_jadwal='"+cb_semesterTampil.getSelectedItem().toString()+"'";
            idAwal = databaseManager.get_IdDataAwal(sql);
            idAkhir = nDataTS + idAwal; 
        }
        
        dataSelected = new String[nDataTS][3];
        dataDB = new String[nDataTS][12];
        
        for(i=0; i<hari.length; i++){
            for(j=0; j<jam.length; j++){
                for(k=0; k<nDataTS; k++){
                    if(dataJadwalMK.get(k)[3].equals(hari[i]) && dataJadwalMK.get(k)[4].equals(jam[j])){
                        if((dataJadwalMK.get(k)[3].equals("jumat") && dataJadwalMK.get(k)[4].equals("10:30-13:00")) == false){
                            row[0] = dataJadwalMK.get(k)[3];
                            row[1] = dataJadwalMK.get(k)[4]; 
                            row[2] = dataJadwalMK.get(k)[5];
                            row[3] = dataJadwalMK.get(k)[6];
                            row[4] = dataJadwalMK.get(k)[7];
                            row[5] = dataJadwalMK.get(k)[8];
                            row[6] = dataJadwalMK.get(k)[9];
                            row[7] = dataJadwalMK.get(k)[10];
                            row[8] = dataJadwalMK.get(k)[11];
                            dataSelected[k][0]  = dataJadwalMK.get(k)[3];
                            dataSelected[k][1]  = dataJadwalMK.get(k)[4];
                            dataSelected[k][2]  = dataJadwalMK.get(k)[5];
                            dataDB[k][0] = dataJadwalMK.get(k)[3];
                            dataDB[k][1] = dataJadwalMK.get(k)[4]; 
                            dataDB[k][2] = dataJadwalMK.get(k)[5];
                            dataDB[k][3] = dataJadwalMK.get(k)[6];
                            dataDB[k][4] = dataJadwalMK.get(k)[7];
                            dataDB[k][5] = dataJadwalMK.get(k)[8];
                            dataDB[k][6] = dataJadwalMK.get(k)[9];
                            dataDB[k][7] = dataJadwalMK.get(k)[10];
                            dataDB[k][8] = dataJadwalMK.get(k)[11];

                            jadwalTable.addRow(row);
                        }
                    }
                }
            }
        }
    }
    
    public void setRuangan(){
        int nDataRuangan,i;
        ArrayList<Ruangan> ruangans;
        String sql;
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setKoneksiDatabase();
        
        sql = "select count(*) from ruangan";
        nDataRuangan = databaseManager.getJumlahDataRuangan(sql);
        
        sql = "select *from ruangan";
        ruangans = databaseManager.getDataRuangan(sql);
        
        nRuangan = ruangans.size();
        ruangan = new String[nRuangan];
        
        for(i=0; i<nRuangan; i++){
            ruangan[i] = ruangans.get(i).getNamaRuangan();}
    }
    
    public void setMataKuliah(){
        int nDataMK, i;
        String sql;
        
        ArrayList<MataKuliah> mataKuliahList;
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.setKoneksiDatabase();
        
        sql = "select count(*) from mata_kuliah";
        nDataMK = databaseManager.getJumlahDataMK(sql);
        
        sql = "select *from mata_kuliah";
        mataKuliahList = databaseManager.getDataMataKuliah(sql);
        nMK = mataKuliahList.size();
        
        mataKuliahs = new ArrayList<>();
        
        for(i=0; i<mataKuliahList.size(); i++){
            mataKuliahs.add(mataKuliahList.get(i));
            //System.out.println(mataKuliahs.get(i).getIdMK());
        }
    }
    
    public void setJamHari(){
        int i;
        
        jam = new String[3];
        hari = new String[5];
        
        jam[0] = "08:00-10:30";
        jam[1] = "10:30-13:00";    
        jam[2] = "13:30-16:00";    
        
        hari[0] = "senin";
        hari[1] = "selasa";    
        hari[2] = "rabu";
        hari[3] = "kamis";
        hari[4] = "jumat";
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
            java.util.logging.Logger.getLogger(TampilJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilJadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBalikPenjadwalan;
    private javax.swing.JButton BCariJadwal;
    private javax.swing.JButton btn_TampilJadwal;
    private javax.swing.JComboBox cb_semesterTampil;
    private javax.swing.JComboBox cb_tahunTampil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox pilihHari;
    private javax.swing.JComboBox pilihJam;
    private javax.swing.JTable tblTJadwal;
    // End of variables declaration//GEN-END:variables
}
