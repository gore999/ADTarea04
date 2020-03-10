/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adtarea04;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.mycompany.adtarea04.modelos.TablaClientesModel;
import com.mycompany.adtarea04.modelos.TablaEmpXTiendaModel;
import com.mycompany.adtarea04.modelos.TablaEmpleadosModel;
import com.mycompany.adtarea04.modelos.TableProdXTiendaModel;
import com.mycompany.adtarea04.modelos.TableProductosModel;
import com.mycompany.adtarea04.modelos.TableTendaModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Carlos
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    ArrayList<Tienda> tiendas = new ArrayList();
    ArrayList<Cliente> clientes = new ArrayList();
    ArrayList<Producto> productos = new ArrayList();
    ArrayList<Empleado> empleados = new ArrayList();
    ArrayList<Producto> productosTienda = new ArrayList();// Listado de productos en tienda.
    ArrayList<Empleado> empleadosTienda = new ArrayList();// Listado de Empleados en tienda.
    ArrayList<Integer> cantProdTienda = new ArrayList();//ArrayList paralelo al de productos en tienda, para almacenar las cantidades de producto. 
    ArrayList<Integer> horasEmpTienda = new ArrayList();// Listado de Empleados en tienda.

    /*MODELOS------------------------------------------------------------------------------------------*/
    //Iniciar Modelos tablas.
    TableTendaModel tModel;
    TableProductosModel pModel;
    TablaEmpleadosModel eModel;
    TableProdXTiendaModel pXtModel;
    TablaEmpXTiendaModel eXtModel;
    TablaClientesModel cliModel;

    // Objetos Auxiliares
    Tienda tiendaAux;
    Producto productoAux;
    Empleado empleadoAux;
    provincias prov;
    Repositorio rep;

    public VentanaPrincipal() {
        //Obtener provincias del json
        System.out.println("aqui");
        //Crear tablas
        rep = Repositorio.getInstance();
        //Comprobar si existe el archivo de datos, si no es así, se crean las tablas, y se añaden las provincias)
        System.out.println("Alla");
        prov = rep.getProvinciasOBJ();//Recuperar el Objeto de clase Provincias (contiene una lista de Provincias)
        Collections.sort(prov.provincias);//Ordenamos las provincias.

        initComponents();
        addProvinciasToComboBox(prov);// Añadir las provincias al combobox de provincias.
        //Captar datos de las tablas sqlite.
        tiendas = rep.getAllTiendas();
//        System.out.println(tiendas.size());
//        System.out.println(tiendas.get(0).getCiudad());
        productos = rep.getAllProductos();
        empleados = rep.getAllEmpleados();
        clientes = rep.getAllClientes();
        /*MODELOS------------------------------------------------------------------------------------------*/
        //Iniciar Modelos tablas.
        tModel = new TableTendaModel(tiendas);
        pModel = new TableProductosModel(productos);
        eModel = new TablaEmpleadosModel(empleados);
        pXtModel = new TableProdXTiendaModel(tiendaAux);
        eXtModel = new TablaEmpXTiendaModel(tiendaAux);
        cliModel = new TablaClientesModel(clientes);
        //Asignar modelos a tablas.
        //Objetos sueltos

        TableTiendas.setModel(tModel);
        TableProductosOferta.setModel(pModel);
        TablaEmpleados.setModel(eModel);
        TablaClientes.setModel(cliModel);
        //Especificas de tienda
        TablaProductosXTienda.setModel(pXtModel);
        TablaEmpXTienda.setModel(eXtModel);

        //Establecer grosor de columnas con metodo creado al efecto (le pasamos la tabla y un array de anchos por columna.
        this.setWithColumns(TableTiendas, new int[]{120, 80, 80});
        this.setWithColumns(TableProductosOferta, new int[]{10, 80, 200, 10});
        this.setWithColumns(TablaEmpleados, new int[]{60, 200});
        this.setWithColumns(this.TablaProductosXTienda, new int[]{5, 80, 140, 20, 30});
        this.setWithColumns(this.TablaEmpXTienda, new int[]{80, 80, 30});
        TableTiendas.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabTiendas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableProductosOferta = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textProdPrezo = new javax.swing.JTextField();
        textIdProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaProdDescrip = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        ButtonAddProductoCatalogo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        textProdNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ButtonBorrarProductoDeCatalogo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        buttonDeleteTienda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableTiendas = new javax.swing.JTable();
        ComboProvincia = new javax.swing.JComboBox<>();
        TextCiudad = new javax.swing.JTextField();
        TextNombreTienda = new javax.swing.JTextField();
        buttonAddTienda = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textNombreEmpleado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        textApellidosEmpleado = new javax.swing.JTextField();
        buttonAddEmpleado = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        buttonDeleteEmpleado = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        labelProductoSeleccionado = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        textCantidadProdAdd = new javax.swing.JTextField();
        buttonAddProductoATienda = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        buttonRemoveProdTienda = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaProductosXTienda = new javax.swing.JTable();
        ButtonInformeStock = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        textHorasEmpleadoTienda = new javax.swing.JTextField();
        buttonAddEmpleadoTienda = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        labelEmpleadoSeleccionado = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        buttonRemoveEmpleadoFromTienda = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaEmpXTienda = new javax.swing.JTable();
        LabelTiendaSeleccionada = new javax.swing.JLabel();
        labelSeleccionTienda = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        textNombreCliente = new javax.swing.JTextField();
        textApellidosCliente = new javax.swing.JTextField();
        textEmailCliente = new javax.swing.JTextField();
        buttonRemoveCliente = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        buttonAddCliente = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        buttonCargarNoticias = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        textAreaNoticias = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabTiendas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jPanel1.setPreferredSize(new java.awt.Dimension(1460, 900));

        TableProductosOferta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableProductosOferta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableProductosOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductosOfertaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableProductosOferta);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("GESTION DE PRODUCTOS");

        jLabel7.setText("Identificador:");

        jLabel8.setText("Descripcion: ");

        TextAreaProdDescrip.setColumns(20);
        TextAreaProdDescrip.setRows(5);
        jScrollPane3.setViewportView(TextAreaProdDescrip);

        jLabel9.setText("Precio:");

        ButtonAddProductoCatalogo.setText("Añadir nuevo producto");
        ButtonAddProductoCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddProductoCatalogoActionPerformed(evt);
            }
        });

        jLabel11.setText("Nombre:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("CATALOGO DE PRODUCTOS");

        ButtonBorrarProductoDeCatalogo.setText("Borrar Producto Seleccionado");
        ButtonBorrarProductoDeCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBorrarProductoDeCatalogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(textProdNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(456, 456, 456))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(textProdPrezo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(ButtonAddProductoCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(ButtonBorrarProductoDeCatalogo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(textProdNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(textProdPrezo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonAddProductoCatalogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonBorrarProductoDeCatalogo))
        );

        buttonDeleteTienda.setText("Borrar Tienda Seleccionada");
        buttonDeleteTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteTiendaActionPerformed(evt);
            }
        });

        TableTiendas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableTiendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableTiendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableTiendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableTiendas);

        buttonAddTienda.setText("Añadir Tienda");
        buttonAddTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddTiendaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TIENDAS ACTIVAS");

        jLabel1.setText("Nombre");

        jLabel2.setText("Ciudad");

        jLabel3.setText("Provincia");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("GESTION DE TIENDAS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(46, 46, 46))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(buttonDeleteTienda))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextNombreTienda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboProvincia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(buttonAddTienda))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel4)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(TextNombreTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAddTienda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteTienda))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("GESTION DE EMPLEADOS");

        jLabel13.setText("Nombre:");

        jLabel14.setText("Apellidos:");

        buttonAddEmpleado.setText("Añadir nuevo empleado");
        buttonAddEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddEmpleadoActionPerformed(evt);
            }
        });

        TablaEmpleados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaEmpleados.setToolTipText("");
        TablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaEmpleados);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("EMPLEADOS DE LA FRANQUICIA");

        buttonDeleteEmpleado.setText("Despedir empleado");
        buttonDeleteEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textNombreEmpleado))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textApellidosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(buttonAddEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel15)
                            .addGap(87, 87, 87)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(buttonDeleteEmpleado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textApellidosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonAddEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteEmpleado)
                .addGap(5, 5, 5))
        );

        jPanel4.setBackground(new java.awt.Color(220, 220, 220));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel8.setBackground(new java.awt.Color(210, 210, 210));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Producto seleccionado:");

        labelProductoSeleccionado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelProductoSeleccionado.setForeground(new java.awt.Color(0, 105, 0));
        labelProductoSeleccionado.setText("No hay ningun producto seleccionado");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Cantidad:");

        buttonAddProductoATienda.setText("Añadir producto a tienda");
        buttonAddProductoATienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProductoATiendaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setText("Productos de la tienda");

        buttonRemoveProdTienda.setText("Quitar producto de la tienda");
        buttonRemoveProdTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveProdTiendaActionPerformed(evt);
            }
        });

        TablaProductosXTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(TablaProductosXTienda);

        jScrollPane10.setViewportView(jScrollPane5);

        ButtonInformeStock.setText("Stock-JSON");
        ButtonInformeStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInformeStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonRemoveProdTienda)
                .addGap(151, 151, 151))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel18))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCantidadProdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(buttonAddProductoATienda)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonInformeStock))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(labelProductoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(labelProductoSeleccionado))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(textCantidadProdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddProductoATienda)
                    .addComponent(ButtonInformeStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(buttonRemoveProdTienda)
                .addGap(32, 32, 32))
        );

        jPanel7.setBackground(new java.awt.Color(210, 210, 210));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Horas-tienda:");

        buttonAddEmpleadoTienda.setText("Añadir empleado a la tienda");
        buttonAddEmpleadoTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddEmpleadoTiendaActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Empleado seleccionado:");

        labelEmpleadoSeleccionado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEmpleadoSeleccionado.setForeground(new java.awt.Color(155, 0, 0));
        labelEmpleadoSeleccionado.setText("No hay ningun empleado seleccionado");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Empleados de la tienda");

        buttonRemoveEmpleadoFromTienda.setText("Eliminar empleado de tienda");
        buttonRemoveEmpleadoFromTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveEmpleadoFromTiendaActionPerformed(evt);
            }
        });

        TablaEmpXTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaEmpXTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEmpXTiendaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TablaEmpXTienda);

        jScrollPane11.setViewportView(jScrollPane6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel21))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(textHorasEmpleadoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonAddEmpleadoTienda))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEmpleadoSeleccionado)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRemoveEmpleadoFromTienda)
                .addGap(165, 165, 165))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(labelEmpleadoSeleccionado))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(textHorasEmpleadoTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddEmpleadoTienda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(buttonRemoveEmpleadoFromTienda)
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        LabelTiendaSeleccionada.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTiendaSeleccionada.setText("TIENDA SELECCIONADA");

        labelSeleccionTienda.setBackground(new java.awt.Color(255, 255, 255));
        labelSeleccionTienda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelSeleccionTienda.setForeground(new java.awt.Color(0, 0, 105));
        labelSeleccionTienda.setText("No hay tienda seleccionada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(LabelTiendaSeleccionada)
                .addGap(18, 18, 18)
                .addComponent(labelSeleccionTienda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelTiendaSeleccionada)
                    .addComponent(labelSeleccionTienda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        tabTiendas.addTab("Tiendas", jPanel1);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Nombre: ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Apellidos:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("E-mail:");

        textNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        textApellidosCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        textEmailCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        buttonRemoveCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonRemoveCliente.setText("Eliminar cliente seleccionado");
        buttonRemoveCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveClienteActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("CLIENTES DE LA FRANQUICIA");

        buttonAddCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonAddCliente.setText("Añadir Cliente");
        buttonAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddClienteActionPerformed(evt);
            }
        });

        TablaClientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TablaClientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaClientes.setRequestFocusEnabled(false);
        TablaClientes.setRowHeight(24);
        jScrollPane7.setViewportView(TablaClientes);

        jScrollPane9.setViewportView(jScrollPane7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(buttonAddCliente)))
                .addContainerGap(292, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonRemoveCliente)
                .addGap(547, 547, 547))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(536, 536, 536))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane9)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(textNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(textApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(textEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddCliente))
                .addGap(31, 31, 31)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(buttonRemoveCliente)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        tabTiendas.addTab("Clientes", jPanel3);

        buttonCargarNoticias.setText("Cargar noticias");
        buttonCargarNoticias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCargarNoticiasActionPerformed(evt);
            }
        });

        textAreaNoticias.setColumns(20);
        textAreaNoticias.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        textAreaNoticias.setLineWrap(true);
        textAreaNoticias.setRows(5);
        textAreaNoticias.setWrapStyleWord(true);
        textAreaNoticias.setMargin(new java.awt.Insets(20, 20, 20, 20));
        textAreaNoticias.setMinimumSize(new java.awt.Dimension(124, 58));
        jScrollPane8.setViewportView(textAreaNoticias);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buttonCargarNoticias))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(buttonCargarNoticias)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabTiendas.addTab("Noticias", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabTiendas, javax.swing.GroupLayout.DEFAULT_SIZE, 1404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddClienteActionPerformed
        // Tomamos datos del cliente.
        String nombre = this.textNombreCliente.getText().trim();
        String apel = this.textApellidosCliente.getText().trim();
        String email = this.textEmailCliente.getText().trim();
        System.out.println(nombre.isEmpty() + " " + apel.isEmpty() + " " + email.isEmpty());
        System.out.println(nombre);
        if (!nombre.isEmpty() && !apel.isEmpty() && !email.isEmpty()) {
            Cliente c = new Cliente(nombre, apel, email);
            Repositorio rep = Repositorio.getInstance();
            rep.addCliente(c, this.clientes);
            this.TablaClientes.repaint();
            this.TablaClientes.revalidate();
        } else {
            mensajeError("Todos los campos deben de estar cubiertos");
        }
    }//GEN-LAST:event_buttonAddClienteActionPerformed

    private void buttonRemoveClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveClienteActionPerformed
        // TODO add your handling code here:
        int indexRow = this.TablaClientes.getSelectedRow();
        Cliente c = clientes.get(indexRow);
        if (indexRow != -1) {
            Repositorio rep = Repositorio.getInstance();
            rep.deleteCliente(c, clientes);
            TablaClientes.repaint();
            TablaClientes.revalidate();
        } else {
            this.mensajeError("Debe elegir un cliente a borrar (click en tabla)");
        }

    }//GEN-LAST:event_buttonRemoveClienteActionPerformed

    private void buttonCargarNoticiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCargarNoticiasActionPerformed
        // TODO add your handling code here:
        SAXParserFactory factory = SAXParserFactory.newInstance();
        String f = "http://ep00.epimg.net/rss/elpais/portada.xml";
        MiHandler hd = new MiHandler();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(f, hd);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        String bloqueNoticias = "";
        for (Noticia n : hd.noticias) {
            bloqueNoticias += n.toString();
        }
        bloqueNoticias = bloqueNoticias.replace("<p>", "\n");
        bloqueNoticias = bloqueNoticias.replace("</p>", "\n");
        this.textAreaNoticias.setText(bloqueNoticias);
    }//GEN-LAST:event_buttonCargarNoticiasActionPerformed

    private void buttonRemoveEmpleadoFromTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveEmpleadoFromTiendaActionPerformed
        // TODO add your handling code here:
        int indexRow = this.TablaEmpXTienda.getSelectedRow();//obtener indexRow de la tabla productos.
        if (indexRow != -1) {
            TiendaEmpleado tiendaEmp = eXtModel.getTe().get(indexRow);

            Repositorio rep = Repositorio.getInstance();
            rep.removeEmpFromTienda(tiendaEmp);
            this.TablaEmpXTienda.repaint();

            this.TablaEmpXTienda.revalidate();
        } else {
            this.mensajeError("No hay ningun producto seleccionado");
        }
    }//GEN-LAST:event_buttonRemoveEmpleadoFromTiendaActionPerformed

    private void buttonAddEmpleadoTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEmpleadoTiendaActionPerformed
        // TODO add your handling code here:
        if (tiendaAux != null && empleadoAux != null) {//Debe haber un producto y una tienda seleccionados.
            try {
                int horas = Integer.parseInt(this.textHorasEmpleadoTienda.getText());
                Repositorio rep = Repositorio.getInstance();

                TiendaEmpleado te = rep.getTiendaEmpleado(tiendaAux, empleadoAux);
                if (te == null) {//Si la relacion no existe la creamos
                    rep.insertEmpleadoEnTienda(tiendaAux, empleadoAux, horas);
                } else {//Si la relacion ya existe, actualizamos las horas
                    te.setHoras(horas);
                }

                this.eXtModel.setTiendaAnalizada(tiendaAux);
                this.TablaEmpXTienda.revalidate();
                this.TablaEmpXTienda.repaint();
            } catch (Exception ex) {
                mensajeError("El numero de unidades debe de ser un valor entero y no puede estar vacio");
            }
        } else {
            mensajeError("Debe de seleccionar (click en las tablas) una tienda y un producto");
        }
    }//GEN-LAST:event_buttonAddEmpleadoTiendaActionPerformed

    private void buttonRemoveProdTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveProdTiendaActionPerformed
        // TODO add your handling code here:
        int indexRow = this.TablaProductosXTienda.getSelectedRow();//obtener indexRow de la tabla productos.
        if (indexRow != -1) {
            //Recuperar el objeto que represena la relacion
            TiendaProducto tiendaProducto = pXtModel.getTp().get(indexRow);
            Repositorio rep = Repositorio.getInstance();
            //destruirlo en el repositorio (destruir el objeto y su representacion en BD.
            rep.removeProdFromTienda(tiendaProducto);
            //Actualizar vista de la tabla.
            this.TablaProductosXTienda.repaint();
            this.TablaProductosXTienda.revalidate();
        } else {
            this.mensajeError("No hay ningun producto seleccionado");
        }
    }//GEN-LAST:event_buttonRemoveProdTiendaActionPerformed

    //Añade un producto a una tienda con su cantidad.
    private void buttonAddProductoATiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProductoATiendaActionPerformed

        if (tiendaAux != null && productoAux != null) {//Debe haber un producto y una tienda seleccionados.
            try {
                int cantidad = Integer.parseInt(this.textCantidadProdAdd.getText());
                Repositorio rep = Repositorio.getInstance();// 
                //Si el producto ya está en la tienda, actualizamos cantidad, si no, insertamos.
                TiendaProducto tp = rep.getTiendaProducto(tiendaAux, productoAux);
                if (tp == null) {//Si la relacion no existe la creamos
                    rep.insertProductoEnTienda(tiendaAux, productoAux, cantidad);
                } else {//Si la relacion ya existe, actualizamos la cantiadad.
                    tp.setCantidad(cantidad);
                }
                this.pXtModel.cambiarTienda(tiendaAux);
                this.TablaProductosXTienda.revalidate();
                this.TablaProductosXTienda.repaint();
            } catch (Exception ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                mensajeError(ex.getMessage() + "El numero de unidades debe de ser un valor entero y no puede estar vacio");
            }
        } else {
            mensajeError("Debe de seleccionar (click en las tablas) una tienda y un producto");
        }
    }//GEN-LAST:event_buttonAddProductoATiendaActionPerformed

    private void buttonDeleteEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteEmpleadoActionPerformed
        // TODO add your handling code here:
        int valor = this.TablaEmpleados.getSelectedRow();
        Repositorio rep = Repositorio.getInstance();
        Empleado emp = empleados.get(valor);
        if (JOptionPane.showConfirmDialog(null, "Realmente desea despedir a " + emp.getNombre() + " " + emp.getApellidos() + "?\nSe le eliminará permanentemente de todas las tiendas", "Confirmar despido", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            rep.deleteEmpleado(emp, empleados);
            if (tiendaAux != null) {//Si hay una tienda seleccionada hay que hacer cambios en su tabla de empleados, que estará visible.
                //rep.getTiendaEmpleadoData(tiendaAux, empleadosTienda, horasEmpTienda);
            }
            TablaEmpleados.revalidate();
            TablaEmpleados.repaint();
            TablaEmpXTienda.revalidate();
            TablaEmpXTienda.repaint();
        }
    }//GEN-LAST:event_buttonDeleteEmpleadoActionPerformed

    private void TablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEmpleadosMouseClicked
        // TODO add your handling code here:
        int row = this.TablaEmpleados.rowAtPoint(evt.getPoint());
        empleadoAux = empleados.get(row);
        this.labelEmpleadoSeleccionado.setText(empleadoAux.getNombre() + " " + empleadoAux.getApellidos());
    }//GEN-LAST:event_TablaEmpleadosMouseClicked

    private void buttonAddEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEmpleadoActionPerformed
        // TODO add your handling code here:
        if (!textNombreEmpleado.getText().isEmpty() && !textApellidosEmpleado.getText().isEmpty()) {
            String nombre = this.textNombreEmpleado.getText();
            String apellidos = this.textApellidosEmpleado.getText();
            Empleado emp = new Empleado(nombre, apellidos);//Crear un empleado.
            Repositorio rep = Repositorio.getInstance();
            rep.insertEmpleado(emp, this.empleados);//el metodo añade el empleado si no hay en el listado otro que se llame igual.
            textNombreEmpleado.setText("");
            textApellidosEmpleado.setText("");
            this.TablaEmpleados.revalidate();
            this.TablaEmpleados.repaint();
        } else {
            this.mensajeError("Debe cubrir los datos del empleado.");
        }
    }//GEN-LAST:event_buttonAddEmpleadoActionPerformed

//Añadir una tienda
    private void buttonAddTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddTiendaActionPerformed
        // Recuperar datos de la interfaz.

        if (!TextNombreTienda.getText().isEmpty() && !TextCiudad.getText().isEmpty()) {//No puede estar vacio ninguno de los dos campos.
            //Recuperar datos
            String nomeTenda = TextNombreTienda.getText();
            String ciudadTenda = TextCiudad.getText();
            String provTenda = ComboProvincia.getSelectedItem().toString();
            //Crear un objeto Tienda
            Tienda t = new Tienda(nomeTenda, ciudadTenda, provTenda);// Le ponemos un id cualquiera, solo a efectos de ajustarnos al constructor.
            rep.insertTienda(t, tiendas);
            //            //Proceder al guardado de datos. Ejecutar el metodo insertTienda en una instancia del repositorio.
            //            Repositorio rep = Repositorio.getInstance();
            //            rep.insertTienda(t, tiendas);//Pasamos el objeto y el listado de tiendas.
            this.TableTiendas.revalidate();
            vaciarCamposTienda();
        } else {
            this.mensajeError("El nombre de la tienda y la ciudad no pueden ser nulos");
        }
    }//GEN-LAST:event_buttonAddTiendaActionPerformed

    private void TableTiendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableTiendasMouseClicked
        // TODO add your handling code here:
        int row = TableTiendas.rowAtPoint(evt.getPoint());
        tiendaAux = tiendas.get(row);

        this.labelSeleccionTienda.setText(tiendaAux.getNombre() + "-" + tiendaAux.getCiudad() + " (" + tiendaAux.getProvincia() + ").");
        Repositorio rep = Repositorio.getInstance();
       // rep.getTiendaProductoData(tiendaAux, this.productosTienda, this.cantProdTienda); XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        //rep.getTiendaEmpleadoData(tiendaAux, empleadosTienda, horasEmpTienda);
        //Actualizar datos
        this.pXtModel.cambiarTienda(tiendaAux);
        this.eXtModel.setTiendaAnalizada(tiendaAux);
        TablaProductosXTienda.revalidate();
        TablaProductosXTienda.repaint();
        TablaEmpXTienda.revalidate();
        TablaEmpXTienda.repaint();
    }//GEN-LAST:event_TableTiendasMouseClicked

    private void buttonDeleteTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteTiendaActionPerformed
        // TODO add your handling code here:
        
        int indexRowTienda = TableTiendas.getSelectedRow();
        Tienda t = tiendas.get(indexRowTienda);
        Repositorio rep = Repositorio.getInstance();
        rep.deleteTienda(t, tiendas);
        tiendaAux = null;
        this.labelSeleccionTienda.setText("");
        this.TableTiendas.revalidate();
        this.productosTienda.clear();
        this.empleadosTienda.clear();
        this.labelSeleccionTienda.setText("No hay tienda seleccionada");
        this.TablaProductosXTienda.repaint();
        this.TablaEmpXTienda.repaint();
    }//GEN-LAST:event_buttonDeleteTiendaActionPerformed

    /*
        Borrar un producto de todo el catalogo de la franquicia. Borra el producto y todas sus relaciones. Actualiza tabla oferta y tabla productos de la tienda. 
     */
    private void ButtonBorrarProductoDeCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBorrarProductoDeCatalogoActionPerformed
        // TODO add your handling code here:
        if(!TableProductosOferta.getSelectionModel().isSelectionEmpty()){
        Producto p = productos.get(TableProductosOferta.getSelectedRow());//Tomamos el producto del arraylist que corresponde al indice de la indexRow seleccionada.
        if (JOptionPane.showConfirmDialog(null, "Realmente desea eliminar " + p.getNombre() + " del catalogo?\nSe eliminará permanentemente de todas las tiendas", "Confirmar borrado", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            if (productoAux.equals(p)) {
                this.vaciarProducto();
            }
            Repositorio rep = Repositorio.getInstance();
            rep.deleteProducto(p, productos);
            if (tiendaAux != null) {//Si hay tienda seleccionada....
                ///rep.getTiendaProductoData(tiendaAux, productosTienda, cantProdTienda);xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            }
            //Actualizar tablas.
            this.TableProductosOferta.revalidate();
            this.TablaProductosXTienda.revalidate();
            this.TableProductosOferta.repaint();
            this.TablaProductosXTienda.repaint();
        }
        }else{
            this.mensajeError("Debe seleccionar un producto");
        }
    }//GEN-LAST:event_ButtonBorrarProductoDeCatalogoActionPerformed

//´ñade un producto al catalogo de la empresa
    private void ButtonAddProductoCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddProductoCatalogoActionPerformed
        // TODO add your handling code here:
        if (!this.textProdNombre.getText().isEmpty() && !this.textProdPrezo.getText().isEmpty() && !TextAreaProdDescrip.getText().isEmpty()) {
            Long id = Long.parseLong(this.textIdProducto.getText());
            String nombre = this.textProdNombre.getText();
            String descripcion = this.TextAreaProdDescrip.getText();
            Double precio = Double.parseDouble(this.textProdPrezo.getText());
            Producto p = new Producto(id, nombre, descripcion, precio);
            Repositorio rep = Repositorio.getInstance();
            rep.insertProducto(p, productos);
            vaciarCamposProducto();
            this.TableProductosOferta.revalidate();
        } else {
            this.mensajeError("Los campos nombre, precio y descripcion no pueden estar vacios.");
        }
    }//GEN-LAST:event_ButtonAddProductoCatalogoActionPerformed

    //Al seleccionar un producto de la oferta de catalogo, este pasa a almacenarse como productoAux.
    private void TableProductosOfertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductosOfertaMouseClicked
        // TODO add your handling code here:
        int row = TableProductosOferta.rowAtPoint(evt.getPoint());
        productoAux = productos.get(row);
        this.labelProductoSeleccionado.setText(productoAux.getNombre() + " (id: " + productoAux.getIdentificador() + ").");
    }//GEN-LAST:event_TableProductosOfertaMouseClicked

    private void TablaEmpXTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEmpXTiendaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaEmpXTiendaMouseClicked

    private void ButtonInformeStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInformeStockActionPerformed
        // TODO add your handling code here:
        if(tiendaAux!=null){
            //Creacion de un objeto StockTienda para enviar a la nueva ventana.
            ArrayList<ProductoParaInforme> productos=new ArrayList();
            for( TiendaProducto tp: tiendaAux.getProductosXTienda()){
                Producto p=tp.getProducto();
                ProductoParaInforme ppi=new ProductoParaInforme(p.getId(),p.getNombre(),p.getDescripcion(),p.getPrecio(),tp.getCantidad());
                productos.add(ppi);
            }
            
            InformeDeStockJFrame infFrame=new InformeDeStockJFrame(tiendaAux.getNombre(),productos);
            infFrame.setVisible(true);
        }else{
            this.mensajeError("Debe seleccionar una tienda para obtener el informe de Stock");
        }
    }//GEN-LAST:event_ButtonInformeStockActionPerformed

    private void vaciarCamposTienda() {
        this.TextNombreTienda.setText("");
        this.TextCiudad.setText("");
    }

    private void vaciarCamposProducto() {
        this.textIdProducto.setText("");
        this.textProdNombre.setText("");
        this.textProdPrezo.setText("");
        this.TextAreaProdDescrip.setText("");
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAddProductoCatalogo;
    private javax.swing.JButton ButtonBorrarProductoDeCatalogo;
    private javax.swing.JButton ButtonInformeStock;
    private javax.swing.JComboBox<String> ComboProvincia;
    private javax.swing.JLabel LabelTiendaSeleccionada;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JTable TablaEmpXTienda;
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JTable TablaProductosXTienda;
    private javax.swing.JTable TableProductosOferta;
    private javax.swing.JTable TableTiendas;
    private javax.swing.JTextArea TextAreaProdDescrip;
    private javax.swing.JTextField TextCiudad;
    private javax.swing.JTextField TextNombreTienda;
    private javax.swing.JButton buttonAddCliente;
    private javax.swing.JButton buttonAddEmpleado;
    private javax.swing.JButton buttonAddEmpleadoTienda;
    private javax.swing.JButton buttonAddProductoATienda;
    private javax.swing.JButton buttonAddTienda;
    private javax.swing.JButton buttonCargarNoticias;
    private javax.swing.JButton buttonDeleteEmpleado;
    private javax.swing.JButton buttonDeleteTienda;
    private javax.swing.JButton buttonRemoveCliente;
    private javax.swing.JButton buttonRemoveEmpleadoFromTienda;
    private javax.swing.JButton buttonRemoveProdTienda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labelEmpleadoSeleccionado;
    private javax.swing.JLabel labelProductoSeleccionado;
    private javax.swing.JLabel labelSeleccionTienda;
    private javax.swing.JTabbedPane tabTiendas;
    private javax.swing.JTextField textApellidosCliente;
    private javax.swing.JTextField textApellidosEmpleado;
    private javax.swing.JTextArea textAreaNoticias;
    private javax.swing.JTextField textCantidadProdAdd;
    private javax.swing.JTextField textEmailCliente;
    private javax.swing.JTextField textHorasEmpleadoTienda;
    private javax.swing.JTextField textIdProducto;
    private javax.swing.JTextField textNombreCliente;
    private javax.swing.JTextField textNombreEmpleado;
    private javax.swing.JTextField textProdNombre;
    private javax.swing.JTextField textProdPrezo;
    // End of variables declaration//GEN-END:variables
//Metodo para recuperar las provincias desde Gson
    private static provincias getProvincias() throws JsonIOException, JsonSyntaxException {
        provincias prov = null;
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("provincias.json"), "UTF-8"));//Leer el archivo en utf
            prov = gson.fromJson(br, provincias.class);
            //FileReader f           f = new FileReader();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ADTarea04.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        return prov;
    }

    private void addProvinciasToComboBox(provincias prov) {
        System.out.println(prov);

        for (Provincia p : prov.provincias) {
            try {
                this.ComboProvincia.addItem(p.getNome());
            } catch (Exception exx) {
                System.out.println("Error");
            }
        }
    }

    private void setWithColumns(JTable tabla, int[] columnas) {

        for (int i = 0; i < columnas.length; i++) {
            TableColumn column = tabla.getColumnModel().getColumn(i); //cogemos la columna que corresponde al indice.
            column.setPreferredWidth(columnas[i]); //aplicamos el valor que corresponde en el array

        }
    }

    private void mensajeError(String msj) {
        JOptionPane.showMessageDialog(rootPane, msj, "Error", HEIGHT);
    }

    private void vaciarProducto() {
        this.productoAux = null;
        this.labelProductoSeleccionado.setText("No hay ningun producto seleccionado");
    }

    private void vaciarEmpleado() {
        this.empleadoAux = null;
        this.labelEmpleadoSeleccionado.setText("No hay ningun empleado seleccionado");
    }

}
