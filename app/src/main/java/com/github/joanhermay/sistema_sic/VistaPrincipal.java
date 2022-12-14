/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.github.joanhermay.sistema_sic;

/**
 *
 * @author joanhermay
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public VistaPrincipal() {
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

        panelTitulo = new javax.swing.JPanel();
        txtTituloApp = new javax.swing.JLabel();
        panelGlobal = new javax.swing.JPanel();
        panelPeriodoContable = new javax.swing.JPanel();
        txtAnioPeriodoContable = new javax.swing.JLabel();
        txtMesPeriodoContable = new javax.swing.JLabel();
        cbAnioPeriodoContable = new javax.swing.JComboBox<>();
        cbMesPeriodoContable = new javax.swing.JComboBox<>();
        txtEstadoPeriodoContable = new javax.swing.JLabel();
        txtSalidaEstadoPeriodoContable = new javax.swing.JTextField();
        btnCerrarPeriodoContable = new javax.swing.JButton();
        separadorAnioMesYEstadosFinancierosExtra = new javax.swing.JSeparator();
        panelEstadosFinancierosExta = new javax.swing.JPanel();
        btnVerBalanceGeneral = new javax.swing.JButton();
        btnVerEstadoDeResultado = new javax.swing.JButton();
        panelTabGlobal = new javax.swing.JTabbedPane();
        panelTabLibroDiario = new javax.swing.JPanel();
        panelAsientos = new javax.swing.JPanel();
        panelTablaAsientos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAsientosDeDiario = new javax.swing.JTable();
        btnRegistrarNuenoAsiento = new javax.swing.JButton();
        btnEliminarAsiento = new javax.swing.JButton();
        btnEditarAsiento = new javax.swing.JButton();
        panelMovimientos = new javax.swing.JPanel();
        panelTablaMovimientos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMovimientosDeAsientosDeDiario = new javax.swing.JTable();
        panelTabLibroMayor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMovimientosCuentaEspecificaLibroMayor = new javax.swing.JTable();
        panelTotales = new javax.swing.JPanel();
        txtTotalDebeLibroMayor = new javax.swing.JLabel();
        ftxtTotalDebeLibroMayor = new javax.swing.JFormattedTextField();
        txtTotalHaberLibroMayor = new javax.swing.JLabel();
        ftxtTotalHaberLibroMayor = new javax.swing.JFormattedTextField();
        txtSaltoTotalCuentaLibroMayor = new javax.swing.JLabel();
        ftxtSaldoTotalCuentaLibroMayor = new javax.swing.JFormattedTextField();
        txtCuentaLibroMayor = new javax.swing.JLabel();
        cbCuentaAMostrarLibroMayor = new javax.swing.JComboBox<>();
        barraMenuOpciones = new javax.swing.JMenuBar();
        menuAcciones = new javax.swing.JMenu();
        menuItemCrearPeriodoContable = new javax.swing.JMenuItem();
        munuItemVerCatalogoDeCuenta = new javax.swing.JMenuItem();
        munuItemCostoDeManoDeObra = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        panelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        panelTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTituloApp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTituloApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTituloApp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTituloApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTituloApp, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPeriodoContable.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodo Contable"));

        txtAnioPeriodoContable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAnioPeriodoContable.setText("Anio");

        txtMesPeriodoContable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMesPeriodoContable.setText("Mes");

        cbAnioPeriodoContable.setAlignmentX(0.0F);
        cbAnioPeriodoContable.setEnabled(false);

        cbMesPeriodoContable.setEnabled(false);

        txtEstadoPeriodoContable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtEstadoPeriodoContable.setText("ESTADO");

        txtSalidaEstadoPeriodoContable.setEditable(false);
        txtSalidaEstadoPeriodoContable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSalidaEstadoPeriodoContable.setFocusable(false);

        btnCerrarPeriodoContable.setText("Cerrar Periodo");
        btnCerrarPeriodoContable.setEnabled(false);

        separadorAnioMesYEstadosFinancierosExtra.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelEstadosFinancierosExta.setEnabled(false);
        panelEstadosFinancierosExta.setLayout(new java.awt.GridLayout(1, 2, 50, 100));

        btnVerBalanceGeneral.setText("Balance General");
        btnVerBalanceGeneral.setEnabled(false);
        panelEstadosFinancierosExta.add(btnVerBalanceGeneral);

        btnVerEstadoDeResultado.setText("Estado de Resultado");
        btnVerEstadoDeResultado.setEnabled(false);
        panelEstadosFinancierosExta.add(btnVerEstadoDeResultado);

        javax.swing.GroupLayout panelPeriodoContableLayout = new javax.swing.GroupLayout(panelPeriodoContable);
        panelPeriodoContable.setLayout(panelPeriodoContableLayout);
        panelPeriodoContableLayout.setHorizontalGroup(
            panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeriodoContableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPeriodoContableLayout.createSequentialGroup()
                        .addComponent(txtAnioPeriodoContable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnioPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPeriodoContableLayout.createSequentialGroup()
                        .addComponent(txtMesPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMesPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPeriodoContableLayout.createSequentialGroup()
                        .addComponent(txtEstadoPeriodoContable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalidaEstadoPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCerrarPeriodoContable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorAnioMesYEstadosFinancierosExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEstadosFinancierosExta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPeriodoContableLayout.setVerticalGroup(
            panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelPeriodoContableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPeriodoContableLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnioPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAnioPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstadoPeriodoContable)
                            .addComponent(txtSalidaEstadoPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMesPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbMesPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPeriodoContableLayout.createSequentialGroup()
                                .addComponent(btnCerrarPeriodoContable)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPeriodoContableLayout.createSequentialGroup()
                        .addGroup(panelPeriodoContableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(separadorAnioMesYEstadosFinancierosExtra)
                            .addComponent(panelEstadosFinancierosExta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        panelTabGlobal.setEnabled(false);

        panelTabLibroDiario.setEnabled(false);
        panelTabLibroDiario.setLayout(new java.awt.GridLayout(1, 2));

        panelTablaAsientos.setBorder(javax.swing.BorderFactory.createTitledBorder("Asientos Diario"));

        tbAsientosDeDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbAsientosDeDiario.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbAsientosDeDiario);

        btnRegistrarNuenoAsiento.setText("Registrar nuevo asiento");
        btnRegistrarNuenoAsiento.setEnabled(false);

        btnEliminarAsiento.setText("Eliminar asiento");
        btnEliminarAsiento.setEnabled(false);

        btnEditarAsiento.setText("Editar asiento");
        btnEditarAsiento.setEnabled(false);

        javax.swing.GroupLayout panelTablaAsientosLayout = new javax.swing.GroupLayout(panelTablaAsientos);
        panelTablaAsientos.setLayout(panelTablaAsientosLayout);
        panelTablaAsientosLayout.setHorizontalGroup(
            panelTablaAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaAsientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaAsientosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminarAsiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarAsiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarNuenoAsiento)))
                .addContainerGap())
        );
        panelTablaAsientosLayout.setVerticalGroup(
            panelTablaAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaAsientosLayout.createSequentialGroup()
                .addGroup(panelTablaAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarNuenoAsiento)
                    .addComponent(btnEditarAsiento)
                    .addComponent(btnEliminarAsiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelAsientosLayout = new javax.swing.GroupLayout(panelAsientos);
        panelAsientos.setLayout(panelAsientosLayout);
        panelAsientosLayout.setHorizontalGroup(
            panelAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsientosLayout.createSequentialGroup()
                .addComponent(panelTablaAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAsientosLayout.setVerticalGroup(
            panelAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTablaAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTabLibroDiario.add(panelAsientos);

        panelTablaMovimientos.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos de asiento"));

        tbMovimientosDeAsientosDeDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbMovimientosDeAsientosDeDiario);

        javax.swing.GroupLayout panelTablaMovimientosLayout = new javax.swing.GroupLayout(panelTablaMovimientos);
        panelTablaMovimientos.setLayout(panelTablaMovimientosLayout);
        panelTablaMovimientosLayout.setHorizontalGroup(
            panelTablaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaMovimientosLayout.setVerticalGroup(
            panelTablaMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMovimientosLayout = new javax.swing.GroupLayout(panelMovimientos);
        panelMovimientos.setLayout(panelMovimientosLayout);
        panelMovimientosLayout.setHorizontalGroup(
            panelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovimientosLayout.createSequentialGroup()
                .addComponent(panelTablaMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovimientosLayout.setVerticalGroup(
            panelMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTablaMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTabLibroDiario.add(panelMovimientos);

        panelTabGlobal.addTab("Libro Diario", panelTabLibroDiario);

        panelTabLibroMayor.setEnabled(false);

        tbMovimientosCuentaEspecificaLibroMayor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbMovimientosCuentaEspecificaLibroMayor.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbMovimientosCuentaEspecificaLibroMayor);

        panelTotales.setBorder(javax.swing.BorderFactory.createTitledBorder("Totales"));
        panelTotales.setLayout(new java.awt.GridLayout(3, 2, 0, 5));

        txtTotalDebeLibroMayor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalDebeLibroMayor.setText("DEBE");
        panelTotales.add(txtTotalDebeLibroMayor);

        ftxtTotalDebeLibroMayor.setEditable(false);
        ftxtTotalDebeLibroMayor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("$ ###,###,###,##0.##"))));
        ftxtTotalDebeLibroMayor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftxtTotalDebeLibroMayor.setEnabled(false);
        panelTotales.add(ftxtTotalDebeLibroMayor);

        txtTotalHaberLibroMayor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalHaberLibroMayor.setText("HABER");
        panelTotales.add(txtTotalHaberLibroMayor);

        ftxtTotalHaberLibroMayor.setEditable(false);
        ftxtTotalHaberLibroMayor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("$ ###,###,###,##0.##"))));
        ftxtTotalHaberLibroMayor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftxtTotalHaberLibroMayor.setEnabled(false);
        panelTotales.add(ftxtTotalHaberLibroMayor);

        txtSaltoTotalCuentaLibroMayor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSaltoTotalCuentaLibroMayor.setText("SALDO TOTAL");
        panelTotales.add(txtSaltoTotalCuentaLibroMayor);

        ftxtSaldoTotalCuentaLibroMayor.setEditable(false);
        ftxtSaldoTotalCuentaLibroMayor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("$ ###,###,###,##0.##"))));
        ftxtSaldoTotalCuentaLibroMayor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftxtSaldoTotalCuentaLibroMayor.setEnabled(false);
        panelTotales.add(ftxtSaldoTotalCuentaLibroMayor);

        txtCuentaLibroMayor.setText("Cuenta");

        cbCuentaAMostrarLibroMayor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCuentaAMostrarLibroMayor.setEnabled(false);

        javax.swing.GroupLayout panelTabLibroMayorLayout = new javax.swing.GroupLayout(panelTabLibroMayor);
        panelTabLibroMayor.setLayout(panelTabLibroMayorLayout);
        panelTabLibroMayorLayout.setHorizontalGroup(
            panelTabLibroMayorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabLibroMayorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabLibroMayorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, panelTabLibroMayorLayout.createSequentialGroup()
                        .addComponent(txtCuentaLibroMayor)
                        .addGap(40, 40, 40)
                        .addComponent(cbCuentaAMostrarLibroMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelTabLibroMayorLayout.setVerticalGroup(
            panelTabLibroMayorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabLibroMayorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabLibroMayorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCuentaLibroMayor)
                    .addComponent(cbCuentaAMostrarLibroMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTabGlobal.addTab("Libro Mayor", panelTabLibroMayor);

        javax.swing.GroupLayout panelGlobalLayout = new javax.swing.GroupLayout(panelGlobal);
        panelGlobal.setLayout(panelGlobalLayout);
        panelGlobalLayout.setHorizontalGroup(
            panelGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabGlobal)
                    .addComponent(panelPeriodoContable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGlobalLayout.setVerticalGroup(
            panelGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPeriodoContable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(panelTabGlobal)
                .addContainerGap())
        );

        menuAcciones.setText("Acciones");

        menuItemCrearPeriodoContable.setText("Crear nuevo periodo contable");
        menuAcciones.add(menuItemCrearPeriodoContable);

        munuItemVerCatalogoDeCuenta.setText("Ver Catalogo de cuentas");
        menuAcciones.add(munuItemVerCatalogoDeCuenta);

        munuItemCostoDeManoDeObra.setText("Costo de mano de obra");
        menuAcciones.add(munuItemCostoDeManoDeObra);

        barraMenuOpciones.add(menuAcciones);

        setJMenuBar(barraMenuOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuBar barraMenuOpciones;
    public javax.swing.JButton btnCerrarPeriodoContable;
    public javax.swing.JButton btnEditarAsiento;
    public javax.swing.JButton btnEliminarAsiento;
    public javax.swing.JButton btnRegistrarNuenoAsiento;
    public javax.swing.JButton btnVerBalanceGeneral;
    public javax.swing.JButton btnVerEstadoDeResultado;
    public javax.swing.JComboBox<String> cbAnioPeriodoContable;
    public javax.swing.JComboBox<String> cbCuentaAMostrarLibroMayor;
    public javax.swing.JComboBox<String> cbMesPeriodoContable;
    public javax.swing.JFormattedTextField ftxtSaldoTotalCuentaLibroMayor;
    public javax.swing.JFormattedTextField ftxtTotalDebeLibroMayor;
    public javax.swing.JFormattedTextField ftxtTotalHaberLibroMayor;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JMenu menuAcciones;
    public javax.swing.JMenuItem menuItemCrearPeriodoContable;
    public javax.swing.JMenuItem munuItemCostoDeManoDeObra;
    public javax.swing.JMenuItem munuItemVerCatalogoDeCuenta;
    public javax.swing.JPanel panelAsientos;
    public javax.swing.JPanel panelEstadosFinancierosExta;
    public javax.swing.JPanel panelGlobal;
    public javax.swing.JPanel panelMovimientos;
    public javax.swing.JPanel panelPeriodoContable;
    public javax.swing.JTabbedPane panelTabGlobal;
    public javax.swing.JPanel panelTabLibroDiario;
    public javax.swing.JPanel panelTabLibroMayor;
    public javax.swing.JPanel panelTablaAsientos;
    public javax.swing.JPanel panelTablaMovimientos;
    public javax.swing.JPanel panelTitulo;
    public javax.swing.JPanel panelTotales;
    public javax.swing.JSeparator separadorAnioMesYEstadosFinancierosExtra;
    public javax.swing.JTable tbAsientosDeDiario;
    public javax.swing.JTable tbMovimientosCuentaEspecificaLibroMayor;
    public javax.swing.JTable tbMovimientosDeAsientosDeDiario;
    public javax.swing.JLabel txtAnioPeriodoContable;
    public javax.swing.JLabel txtCuentaLibroMayor;
    public javax.swing.JLabel txtEstadoPeriodoContable;
    public javax.swing.JLabel txtMesPeriodoContable;
    public javax.swing.JTextField txtSalidaEstadoPeriodoContable;
    public javax.swing.JLabel txtSaltoTotalCuentaLibroMayor;
    public javax.swing.JLabel txtTituloApp;
    public javax.swing.JLabel txtTotalDebeLibroMayor;
    public javax.swing.JLabel txtTotalHaberLibroMayor;
    // End of variables declaration//GEN-END:variables
}
