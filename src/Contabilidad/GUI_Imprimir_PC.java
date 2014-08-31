/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contabilidad;

import Clases_Auxiliares.Conexion;
import Clases_Auxiliares.Validaciones;
import Objetos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Manolo
 */
public class GUI_Imprimir_PC extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUI_A_Prod
     */
    private Conexion r_con;
    private Usuario usr;
    private String nameTable = "plan_cuentas";
    private String orden_por_CPC = "pc_codigo_plan_cuenta";
    private String orden_por_cro_C = "pc_nro_cuenta";
    private String nombre_reporte = "plan_cuentas.jrxml";
    private String id_modulo_imp = "8";
    private String minCPC,maxCPC,minNC,maxNC;
    
    public GUI_Imprimir_PC(Usuario u, Conexion con) {
        usr = u;
        r_con=con;      
        initComponents();  
        minCPC="";
        maxCPC="";
        minNC="";
        maxCPC="";
        minimosYmaximos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Filtro Reporte Plan de Cuentas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/articulo.png"))); // NOI18N
        setInheritsPopupMenu(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Preferencias:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("desde Cuenta:");

        jTextField1.setToolTipText("");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/previsualizar.png"))); // NOI18N
        jButton2.setText("Visualizar Reporte");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("hasta Cuenta:");

        jTextField2.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("desde Código:");

        jTextField3.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("hasta Código:");

        jTextField4.setToolTipText("");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("por Código de Plan de Cuenta");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("por número de Plan de Cuenta");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Ordenado por:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(java.awt.Color.red);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("  ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/print.png"))); // NOI18N
        jButton3.setText("Imprimir Reporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        r_con.cierraConexion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (validarDatos()){
            try {
                  
                  //cargo Parametros del Reporte
                   Map parametros = new HashMap();
                   parametros.put("name_empresa", r_con.getRazon_social());
                   if (jCheckBox1.isSelected()){
                        parametros.put("orden",this.orden_por_CPC);
                   }
                   else{
                       parametros.put("orden",this.orden_por_cro_C);
                   }
                   parametros.put("menor_cod_PC",""+jTextField3.getText());
                   parametros.put("mayor_cod_PC",""+jTextField4.getText());
                   parametros.put("menor_nro_C",Integer.parseInt(jTextField1.getText()));
                   parametros.put("mayor_nro_C",Integer.parseInt(jTextField2.getText()));
                               
                   
                   // Compilamos el .jrxml y lo cargamos  
                   //final String jasperName = JasperCompileManager.compileReportToFile("src/Reportes/"+nombre_reporte);  
                   //final JasperReport report = (JasperReport)JRLoader.loadObject(jasperName);  
                   
                  
                    //localizo el reporte para usarlo
                    JasperReport report = JasperCompileManager.compileReport("src/Reportes/"+nombre_reporte);
                    
                    r_con.Connection();
                    JasperPrint print = JasperFillManager.fillReport(report, parametros, r_con.getConn());
           
                    //creo un objeto Visor del Reporte
                    JasperViewer jviewer = new JasperViewer(print,false);
                    jviewer.setTitle("Reporte Plan de Cuentas."); 
            
                    //quito el boton de imprimir del Visor
                    JRootPane JRP = (JRootPane) jviewer.getComponent(0);           
                    JLayeredPane JLP = (JLayeredPane) JRP.getComponent(1);
                    JPanel JP = (JPanel) JLP.getComponent(0);
                    JPanel JP2 = (JPanel) JP.getComponent(0);
                    JRViewer JRV = (JRViewer) JP2.getComponent(0);
                    JPanel JP3 = (JPanel) JRV.getComponent(0);            
                    //COMPONENTE 0 es el Boton Guardar, el 1 el es de Imprimir
                    JP3.getComponent(1).setEnabled(false);
                    
                    jviewer.setVisible(true);
            
            
            } catch (Exception e) {
                r_con.cierraConexion();
                System.out.println(e.getMessage());
            } 
            finally {
                      r_con.cierraConexion();
            }    
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {            
            //cargo Parametros del Reporte
            Map parametros = new HashMap();
            parametros.put("name_empresa", r_con.getRazon_social());
            if (jCheckBox1.isSelected()){
                parametros.put("orden",this.orden_por_CPC);
            }
            else{
                parametros.put("orden",this.orden_por_cro_C);
            } 
            parametros.put("menor_cod_PC",""+jTextField3.getText());
            parametros.put("mayor_cod_PC",""+jTextField4.getText());
            parametros.put("menor_nro_C",Integer.parseInt(jTextField1.getText()));
            parametros.put("mayor_nro_C",Integer.parseInt(jTextField2.getText()));
            
            //localizo el reporte para usarlo
            JasperReport report = JasperCompileManager.compileReport("src/Reportes/"+nombre_reporte);
            
            r_con.Connection();
            //cargo los datos
            JasperPrint print = JasperFillManager.fillReport(report, parametros, r_con.getConn());            

            //vector con las impresoras del modulo de la base de datos
            Vector<Vector<String>>v = r_con.getContenidoTabla("SELECT * FROM impresoras WHERE imp_id_modulo = "+id_modulo_imp);
            //total impresoras disponibles
            PrintService [] impresoras = PrintServiceLookup.lookupPrintServices(null, null);
            //vector con las impresoras del modulo como objeto impresora (PrintService)
            Vector<PrintService>impresoras_modulo = new Vector();
            //objeto impresora en el que se imprime
            PrintService impresora = null;

            if (v.size()>0){
                String nombre_imp;
                //caso en que sea una unica impresora por modulo
                //if(v.size()==1){
                    //nombre_imp=v.elementAt(0).firstElement();
                    //AttributeSet aset = new HashAttributeSet();
                    //aset.add(new PrinterName(nombre_imp, null));
                    //impresoras = PrintServiceLookup.lookupPrintServices(null, aset);
                    //impresora = impresoras[0];
                    //}

                //caso en que haya mas de una impresora por modulo
                if (v.size()>=1){
                    //localizo con el simple nombre de la base de dato, el objeto impresora y los cargo
                    for (int i = 0; i < v.size(); i++) {
                        nombre_imp=v.elementAt(i).firstElement();
                        AttributeSet aset = new HashAttributeSet();
                        aset.add(new PrinterName(nombre_imp, null));
                        impresoras = PrintServiceLookup.lookupPrintServices(null, aset);
                        impresora = impresoras[0];
                        impresoras_modulo.add(impresora);
                    }
                    //paso las impresoras del modulo a un arreglo para poder mostrarlo en el Dialog
                    PrintService [] listado_impresoras = new PrintService[impresoras_modulo.size()];
                    for (int i = 0; i < impresoras_modulo.size(); i++) {
                        listado_impresoras[i]=impresoras_modulo.elementAt(i);
                    }
                    //muestro el listado de impresoras como objeto y se la asigno a la impresora a imprimir
                    impresora = (PrintService) JOptionPane.showInputDialog(null, "Seleccione una impresora asignada a este módulo:",
                        "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, listado_impresoras, listado_impresoras[0]);
                }

                //mando a imprimir el reporte en la impresora
                if (impresora != null){
                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, print );
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora );
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.TRUE);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
                    jrprintServiceExporter.exportReport();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay Impresoras asignadas a este Modulo, "
                    + "\npóngase en contacto con el Administrador de Impresoras.","Atención",JOptionPane.WARNING_MESSAGE);
            }
            r_con.cierraConexion();
        } catch (JRException ex) {
            Logger.getLogger(GUI_Imprimir_PC.class.getName()).log(Level.SEVERE, null, ex);
            r_con.cierraConexion();
        }

    }//GEN-LAST:event_jButton3ActionPerformed
   
    
    private void minimosYmaximos (){
        
        try {
            r_con.Connection();
            
            ResultSet res = r_con.Consultar("SELECT MIN(pc_codigo_plan_cuenta),MAX(pc_codigo_plan_cuenta),MIN(pc_nro_cuenta),MAX(pc_nro_cuenta) FROM "+nameTable+" WHERE pc_codigo_plan_cuenta<>'0'");
            res.next();
            minCPC=res.getString(1);
            maxCPC=res.getString(2);
            minNC=res.getString(3);
            maxNC=res.getString(4);
            
            jTextField1.setText(minNC);
            jTextField2.setText(maxNC);
            jTextField3.setText(minCPC);
            jTextField4.setText(maxCPC);
            
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Imprimir_PC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
               
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

public void setTitleLabel (String t){
        this.jLabel1.setText(t);
}

    private boolean validarDatos() {
        //unicamente valido el numero de cuenta
        boolean valido = false;
        Validaciones val = new Validaciones();
        
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("")){
            mensajeError("Ingrese un valor para Cuenta Desde.. Hasta.");
        }
        else{
            if (!val.isInt(jTextField1.getText()) || !val.isInt(jTextField2.getText())){
                mensajeError("Ingrese un valor NUMERICO para Cuenta Desde.. Hasta.");
            }
            else{
                valido = true;
                mensajeError(" ");
            }
        } 
        return valido;
    }
    
    private void mensajeError(String msj) {
        jLabel7.setText(msj);        
    }

}
