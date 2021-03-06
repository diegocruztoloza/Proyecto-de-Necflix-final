/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necflis;

import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author Edman
 */
public class AgregarPelicula extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarPelicula
     */
    public AgregarPelicula() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();

        jTextField2.setEditable(false);

        jTextField1.setEditable(false);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar Película");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Clic para listar películas diponibles");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Películas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla1);

        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(125, 402, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String filePath = "peliculasdisponibles.txt";
        File file = new File(filePath);
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            DefaultTableModel model = (DefaultTableModel)Tabla1.getModel();
            Object [] lines = br.lines().toArray();
            
            for(int i = 0; i < lines.length; i++){
                String[] row = lines[i].toString().split("-");
                model.addRow(row);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AgregarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseClicked
        BufferedReader file=null;
        try {
            String pelicula=String.valueOf(Tabla1.getValueAt(Tabla1.getSelectedRow(),0));
            if(evt.getClickCount() == 1){
                //JOptionPane.showMessageDialog(rootPane, "FILA: " + Tabla1.getSelectedColumn())
                try{
                    FileWriter Writer = new FileWriter("agregarpelicula.txt", true);
                    Writer.write(pelicula);
                    Writer.write(System.getProperty("line.separator"));
                    Writer.close();
                    //JOptionPane.showMessageDialog(null,"Success");
                    setVisible(true);
                    new NuevoCliente().setVisible(true);
                }
                
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            File archivo2 = null;
            FileReader fr2 = null;
            BufferedReader br2 = null;
            try {
                archivo = new File ("SeleccionarCliente.txt");
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);
                String nombre;
                
                while((nombre=br.readLine())!=null)
                    jTextField1.setText(nombre);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            String linea2;
            try {
                archivo2 = new File ("agregarpelicula.txt");
                fr2 = new FileReader (archivo2);
                br2 = new BufferedReader(fr2);
                while((linea2=br2.readLine())!=null)
                    jTextField2.setText(linea2);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            String nombre1 = jTextField1.getText();
            String pelicula2 = jTextField2.getText();
            file = new BufferedReader(new FileReader("peliculasclientes.txt"));
            String line;
            String input = "";
            while((line = file.readLine()) != null){
                if(line.contains(nombre1)){
                    input += line.replaceAll(line, line+"-"+pelicula2+"\n");
                }
                else{  
                    input += line+"\r\n";
                }
            }
            FileOutputStream fileOut = new FileOutputStream("peliculasclientes.txt");
            fileOut.write(input.getBytes());
            fileOut.close();
            JOptionPane.showMessageDialog(null,"¡Película Agregada!");
        }catch(FileNotFoundException ex){
            Logger.getLogger(AgregarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AgregarPelicula.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(AgregarPelicula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Tabla1MouseClicked
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla1;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
