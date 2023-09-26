package Vistas;

import AccesoADatos.AlumnoData;
import Entidades.Alumno;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;


public class AlumnoView extends javax.swing.JInternalFrame {
    AlumnoData aD= new AlumnoData();
    Alumno a= null;
    
    public AlumnoView() {
        initComponents();
        datos();
        celdaNOEdit();
     
    
       
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtf_dni = new javax.swing.JTextField();
        jtf_apellido = new javax.swing.JTextField();
        jtf_nombre = new javax.swing.JTextField();
        jrb_estado = new javax.swing.JRadioButton();
        jdc_fechaNacimiento = new com.toedter.calendar.JDateChooser();
        jb_buscar = new javax.swing.JButton();
        jb_nuevo = new javax.swing.JButton();
        jb_eliminar = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_exit = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("ALUMNO");

        jLabel2.setText("DNI");

        jLabel3.setText("Apellido");

        jLabel4.setText("Nombre");

        jLabel5.setText("Estado");

        jLabel6.setText("Fecha de Nacimiento");

        jb_buscar.setBackground(new java.awt.Color(153, 153, 255));
        jb_buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_buscar.setText("Buscar");
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });

        jb_nuevo.setBackground(new java.awt.Color(153, 153, 255));
        jb_nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_nuevo.setText("Nuevo");
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });

        jb_eliminar.setBackground(new java.awt.Color(153, 153, 255));
        jb_eliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_eliminar.setText("Eliminar");
        jb_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminarActionPerformed(evt);
            }
        });

        jb_guardar.setBackground(new java.awt.Color(153, 153, 255));
        jb_guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_guardar.setText("Guardar");

        jb_exit.setBackground(new java.awt.Color(153, 153, 255));
        jb_exit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jb_exit.setText("Salir");
        jb_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jb_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jb_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jb_guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtf_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_apellido)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jrb_estado)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(jb_buscar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(49, 49, 49)
                                .addComponent(jdc_fechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jtf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5))
                    .addComponent(jrb_estado))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jdc_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_eliminar)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_guardar)
                    .addComponent(jb_exit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
              
        try{           
            int dni = Integer.parseInt(jtf_dni.getText());  
              
              a=aD.buscarAlumnoPorDni(dni);
           
            if( a!=null){
                 datosView();
                 jtf_apellido.setText(a.getApellido());                         
                 jtf_nombre.setText(a.getNombre());
                 jrb_estado.setSelected(a.isEstado());
                 
                 LocalDate ld=a.getFechaNacimiento();
                 java.util.Date d= java.util.Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
                 jdc_fechaNacimiento.setDate(d);            
                
                    
            }else
               JOptionPane.showMessageDialog(this, " DNI no encontrado en la Base de Datos");
            
            
         }catch (NumberFormatException nf){
            JOptionPane.showMessageDialog(this,"Reingrese su DNI");
         }
    
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
       datosView();
       celdaEdit();
       
        try {           
        
            int dni = Integer.parseInt(jtf_dni.getText());
            String apellido=jtf_apellido.getText();
            String nombre=jtf_nombre.getText();
            
                if (apellido.isEmpty() || nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No pueden exixtir campos vacios."); 
                    return;
                }  
                
            java.util.Date fn=jdc_fechaNacimiento.getDate();
            LocalDate ld= fn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Boolean estado=jrb_estado.isSelected();
                
            if (a==null){
                
                a=new Alumno(dni, apellido, nombre, ld, estado);
                aD.guardarAlumno(a);
                
            }else{
                
                a.setDni(dni);
                a.setApellido(apellido);
                a.setNombre(nombre);
                a.setFechaNacimiento(ld);
                aD.modificarAlumno(a);
                
            }             

         } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Reingrese su DNI" );
         }
        
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminarActionPerformed
       datosView();
       celdaEdit();
       
        try {           
                        
            if (a!=null){
                
               aD.eliminarAlumno(a.getIdAlumno());
               a=null;
               datos();               
                
            }else
                JOptionPane.showMessageDialog(this, " No se ha seleccionado alumno");              

         } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Reingrese su DNI" );
         }
    }//GEN-LAST:event_jb_eliminarActionPerformed

    private void jb_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_exitActionPerformed
        dispose();
    }//GEN-LAST:event_jb_exitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_eliminar;
    private javax.swing.JButton jb_exit;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_nuevo;
    private com.toedter.calendar.JDateChooser jdc_fechaNacimiento;
    private javax.swing.JRadioButton jrb_estado;
    private javax.swing.JTextField jtf_apellido;
    private javax.swing.JTextField jtf_dni;
    private javax.swing.JTextField jtf_nombre;
    // End of variables declaration//GEN-END:variables


public void datos(){
  
    jtf_apellido.setVisible(false);  
    jtf_nombre.setVisible(false);   
    jrb_estado.setVisible(false);  
    jdc_fechaNacimiento.setVisible(false);
}

public void datosView(){
    
    jtf_apellido.setVisible(true);
    jtf_nombre.setVisible(true);    
    jrb_estado.setVisible(true);   
    jdc_fechaNacimiento.setVisible(true);
}

public void celdaNOEdit(){

jtf_apellido.setEditable(false);
jtf_nombre.setEditable(false);
jrb_estado.setEnabled(false);
jdc_fechaNacimiento.setEnabled(false);

}
public void celdaEdit(){

jtf_apellido.setEditable(true);
jtf_nombre.setEditable(true);
jrb_estado.setEnabled(true);
jdc_fechaNacimiento.setEnabled(true);

}
}
