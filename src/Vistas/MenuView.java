package Vistas;

public class MenuView extends javax.swing.JFrame {

    public MenuView() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmi_alumno = new javax.swing.JMenu();
        jmi_FormularioAlumno = new javax.swing.JMenuItem();
        jmi_materia = new javax.swing.JMenu();
        jmi_FormularioMateria = new javax.swing.JMenuItem();
        jmi_inscripcion = new javax.swing.JMenu();
        jmi_FormularioInscripcion = new javax.swing.JMenuItem();
        jmi_FormularioNotas = new javax.swing.JMenuItem();
        jmi_consultas = new javax.swing.JMenu();
        jmi_FormularioConsultas = new javax.swing.JMenuItem();
        jmi_salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(102, 102, 255));
        escritorio.setDoubleBuffered(true);
        escritorio.setFocusCycleRoot(false);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jmi_alumno.setText("Alumno");

        jmi_FormularioAlumno.setText("Formulario Alumno");
        jmi_FormularioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_FormularioAlumnoActionPerformed(evt);
            }
        });
        jmi_alumno.add(jmi_FormularioAlumno);

        jMenuBar1.add(jmi_alumno);

        jmi_materia.setText("Materia");

        jmi_FormularioMateria.setText("Formulario Materia");
        jmi_FormularioMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_FormularioMateriaActionPerformed(evt);
            }
        });
        jmi_materia.add(jmi_FormularioMateria);

        jMenuBar1.add(jmi_materia);

        jmi_inscripcion.setText("Administración");

        jmi_FormularioInscripcion.setText("Formulario Inscripcion");
        jmi_FormularioInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_FormularioInscripcionActionPerformed(evt);
            }
        });
        jmi_inscripcion.add(jmi_FormularioInscripcion);

        jmi_FormularioNotas.setText("Formulario Notas");
        jmi_FormularioNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_FormularioNotasActionPerformed(evt);
            }
        });
        jmi_inscripcion.add(jmi_FormularioNotas);

        jMenuBar1.add(jmi_inscripcion);

        jmi_consultas.setText("Consultas");

        jmi_FormularioConsultas.setText("Alumnos por Materia");
        jmi_FormularioConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_FormularioConsultasActionPerformed(evt);
            }
        });
        jmi_consultas.add(jmi_FormularioConsultas);

        jMenuBar1.add(jmi_consultas);

        jmi_salir.setText("Salir");
        jmi_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_salirActionPerformed(evt);
            }
        });
        jMenuBar1.add(jmi_salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_FormularioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_FormularioAlumnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AlumnoView fa=new AlumnoView();
        fa.setVisible(true);
        escritorio.add(fa);
        fa.moveToFront();
    }//GEN-LAST:event_jmi_FormularioAlumnoActionPerformed

    private void jmi_FormularioMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_FormularioMateriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        MateriaView fm=new MateriaView();
        fm.setVisible(true);
        escritorio.add(fm);
        fm.moveToFront();
    }//GEN-LAST:event_jmi_FormularioMateriaActionPerformed

    private void jmi_FormularioInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_FormularioInscripcionActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        InscripcionView fi=new InscripcionView();
        fi.setVisible(true);
        escritorio.add(fi);
        fi.moveToFront();
    }//GEN-LAST:event_jmi_FormularioInscripcionActionPerformed

    private void jmi_FormularioNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_FormularioNotasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        InscripcionView fn=new InscripcionView();
        fn.setVisible(true);
        escritorio.add(fn);
        fn.moveToFront();
    }//GEN-LAST:event_jmi_FormularioNotasActionPerformed

    private void jmi_FormularioConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_FormularioConsultasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ConsultasView cv=new ConsultasView();
        cv.setVisible(true);
        escritorio.add(cv);
        cv.moveToFront();
    }//GEN-LAST:event_jmi_FormularioConsultasActionPerformed

    private void jmi_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_salirActionPerformed
        dispose();
    }//GEN-LAST:event_jmi_salirActionPerformed

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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmi_FormularioAlumno;
    private javax.swing.JMenuItem jmi_FormularioConsultas;
    private javax.swing.JMenuItem jmi_FormularioInscripcion;
    private javax.swing.JMenuItem jmi_FormularioMateria;
    private javax.swing.JMenuItem jmi_FormularioNotas;
    private javax.swing.JMenu jmi_alumno;
    private javax.swing.JMenu jmi_consultas;
    private javax.swing.JMenu jmi_inscripcion;
    private javax.swing.JMenu jmi_materia;
    private javax.swing.JMenu jmi_salir;
    // End of variables declaration//GEN-END:variables
}
