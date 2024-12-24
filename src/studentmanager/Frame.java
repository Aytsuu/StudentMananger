// This file contains the components of the main frame
package studentmanager;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Frame extends javax.swing.JFrame {

    // Instantiating necessary objects
    Database db = new Database();
    DefaultTableModel model = new DefaultTableModel();

    // Initializing variable
    String lastID = db.validID();
    boolean isUpdate = false;
    boolean searching = false;
    String type = null;
    boolean hoverEffect = true;
    String updateEmail = "";

    // Catching special characters and invalid spacing using regex
    String specialCharRegex = "^[^!@#%^&*()_+\\-=\\[\\]{}\\|;':\",./<>?~`]+$";
    String emailSpecialChar = "^[a-zA-Z0-9]+@ctu\\.edu\\.ph";
    String spacingRegex = "^\\s.*|^.*\\s{2,}.*$|.*\\s$|\\w{1}";

    // Constructor
    public Frame() {
        initComponents(); // Initializes all of the java swing components in the GUI Builder

        // Sets location to center and frame opacity to 0
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(null);

        // Hides certain components of the frame at the time of execution
        NameInvalidNotice.setVisible(false);
        AgeInvalidNotice.setVisible(false);
        EmailInvalidNotice.setVisible(false);
        confirmation.setVisible(false);
        dimBG.setVisible(false);

        // Table design
        jScrollPane1.getViewport().setBackground(Color.white);
        jScrollPane1.setBorder(null);
        listTable.getColumnModel().setColumnMargin(0);
        jScrollPane1.getVerticalScrollBar().setUI(null);

        // When the program executes
        name.requestFocusInWindow(); // Directs the focus to the name text field
        setId(); // Calls the method setId which automatically generates the id
        showList(); // Calls the method showList to show the list in the frame table
        search.setText("Search"); // Sets search bar text to Search
    }

    // This method automatically generates the id
    public void setId() {
        if (lastID == "") { // If list is empty
            id.setText(String.valueOf(1000)); // Id starts with 4 digits 1000
        } else { // Otherwise increment last id in the list by 1
            id.setText(String.valueOf(Integer.parseInt(lastID) + 1));
        }
    }

    // This method shows the list in the frame table
    public void showList() {

        // Initializes variables 
        String[] column = new String[4];
        model = (DefaultTableModel) listTable.getModel();

        // Connects to the database to fetch data and populate the table 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            db.connect = DriverManager.getConnection(db.url, db.user, db.pass);
            db.st = db.connect.createStatement();
            db.rs = db.st.executeQuery("Select * From list Order by ID");

            // Iterating each row, retrieving data from each column
            while (db.rs.next()) {
                column[0] = db.rs.getString("ID");
                column[1] = db.rs.getString("Name");
                column[2] = db.rs.getString("Age");
                column[3] = db.rs.getString("Email");

                // Adds the data to the frame table
                model.addRow(column);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method performs fast seaching of data in the table 
    public void search() {

        try {
            model = (DefaultTableModel) listTable.getModel(); // Gets the model of the frame table
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model); // This predefined class provides sorting and filtering
            listTable.setRowSorter(sorter); // Setting the row sorter of the fraame table
            sorter.setRowFilter(RowFilter.regexFilter("(?i)"+search.getText())); // Filters the data within the table according to the key searched by the user
        } catch (Exception e) {
        }
    }

    // This method checks if email is already in used
    public boolean validateEmail() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            db.connect = DriverManager.getConnection(db.url, db.user, db.pass);
            db.st = db.connect.createStatement();
            db.rs = db.st.executeQuery("SELECT Email FROM list");

            while (db.rs.next()) {
                
                if (email.getText().toLowerCase().equals(db.rs.getString("Email").toLowerCase())) {
                    if(updateEmail.equals(db.rs.getString("Email"))) return true;
                    return false; // Returns false if similar email is found in the database
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true; // Returns true if no similar email is found in the database
    }

    public void clear() {
        db.clear(); // Calls the method clear in the database class
        new Frame().setVisible(true);
        setVisible(false);
    }

    public void remove() {
        // Initializing variables
        int selected = listTable.getSelectedRow();
        model = (DefaultTableModel) listTable.getModel(); // Gets the model of the frame table

        if (selected >= 0) { // True, If user has selected data in the table
            String selectedID = model.getValueAt(selected, 0).toString(); // Stores the id in a variable

            db.remove(selectedID); // Calls the remove method in the database class, passing the id as parameter

            // An alternative to automatically reloads the frame
            new Frame().setVisible(true);
            setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new studentmanager.Panel();
        confirmation = new studentmanager.Panel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        confirmNo = new javax.swing.JLabel();
        confirmYes = new javax.swing.JLabel();
        dimBG = new studentmanager.Panel();
        exit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTable = new rojerusan.RSTableMetro();
        jLabel4 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        panel3 = new studentmanager.Panel();
        id = new javax.swing.JLabel();
        panel4 = new studentmanager.Panel();
        add = new javax.swing.JLabel();
        panel5 = new studentmanager.Panel();
        remove = new javax.swing.JLabel();
        panel6 = new studentmanager.Panel();
        update = new javax.swing.JLabel();
        panel7 = new studentmanager.Panel();
        clear = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EmailInvalidNotice = new studentmanager.Panel1();
        NameInvalidNotice = new studentmanager.Panel1();
        AgeInvalidNotice = new studentmanager.Panel1();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setMinimumSize(new java.awt.Dimension(930, 450));
        panel1.setPreferredSize(new java.awt.Dimension(909, 644));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        confirmation.setBackground(new java.awt.Color(51, 51, 51));
        confirmation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Are you sure about that?");
        confirmation.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 330, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentmanager/notice.png"))); // NOI18N
        jLabel6.setText("  CONFIRMATION");
        confirmation.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 50));

        confirmNo.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        confirmNo.setForeground(new java.awt.Color(255, 255, 255));
        confirmNo.setText("NO");
        confirmNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmNoMouseClicked(evt);
            }
        });
        confirmation.add(confirmNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 60, -1));

        confirmYes.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        confirmYes.setForeground(new java.awt.Color(255, 255, 255));
        confirmYes.setText("YES");
        confirmYes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmYesMouseClicked(evt);
            }
        });
        confirmation.add(confirmYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 60, -1));

        panel1.add(confirmation, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 330, 190));

        dimBG.setBackground(new java.awt.Color(51, 51, 51,190));
        dimBG.setEnabled(false);

        javax.swing.GroupLayout dimBGLayout = new javax.swing.GroupLayout(dimBG);
        dimBG.setLayout(dimBGLayout);
        dimBGLayout.setHorizontalGroup(
            dimBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1163, Short.MAX_VALUE)
        );
        dimBGLayout.setVerticalGroup(
            dimBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        panel1.add(dimBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1163, 670));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentmanager/exit.png"))); // NOI18N
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        panel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, 30, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));

        listTable.setBackground(new java.awt.Color(255, 255, 255));
        listTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(230, 230, 230)));
        listTable.setForeground(new java.awt.Color(255, 255, 255));
        listTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        listTable.setAutoscrolls(false);
        listTable.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        listTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        listTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        listTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        listTable.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        listTable.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        listTable.setColorSelBackgound(new java.awt.Color(204, 204, 204));
        listTable.setColorSelForeground(new java.awt.Color(51, 51, 51));
        listTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listTable.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listTable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listTable.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        listTable.setGridColor(new java.awt.Color(255, 255, 255));
        listTable.setGrosorBordeFilas(0);
        listTable.setGrosorBordeHead(0);
        listTable.setMultipleSeleccion(false);
        listTable.setRowHeight(55);
        listTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        listTable.setSelectionForeground(new java.awt.Color(51, 51, 51));
        listTable.setShowGrid(false);
        jScrollPane1.setViewportView(listTable);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 660, 540));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentmanager/manager.png"))); // NOI18N
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 40));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        search.setForeground(new java.awt.Color(51, 51, 51));
        search.setText("Search");
        search.setMargin(new java.awt.Insets(6, 6, 6, 6));
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        panel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(817, 20, 280, 35));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentmanager/search.png"))); // NOI18N
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 30, 35));

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(230, 230, 230)));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        id.setForeground(new java.awt.Color(51, 51, 51));
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id.setText("ID");
        panel3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 30));

        panel4.setBackground(new java.awt.Color(51, 51, 51));

        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setText("ADD");
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel3.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 100, 30));

        panel5.setBackground(new java.awt.Color(51, 51, 51));

        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove.setText("REMOVE");
        remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel3.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 100, -1));

        panel6.setBackground(new java.awt.Color(51, 51, 51));

        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        update.setText("UPDATE");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel3.add(panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 100, -1));

        panel7.setBackground(new java.awt.Color(51, 51, 51));

        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clear.setText("CLEAR");
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel3.add(panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 100, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Email");
        panel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Name");
        panel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        EmailInvalidNotice.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout EmailInvalidNoticeLayout = new javax.swing.GroupLayout(EmailInvalidNotice);
        EmailInvalidNotice.setLayout(EmailInvalidNoticeLayout);
        EmailInvalidNoticeLayout.setHorizontalGroup(
            EmailInvalidNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        EmailInvalidNoticeLayout.setVerticalGroup(
            EmailInvalidNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panel3.add(EmailInvalidNotice, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 285, -1, -1));

        NameInvalidNotice.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout NameInvalidNoticeLayout = new javax.swing.GroupLayout(NameInvalidNotice);
        NameInvalidNotice.setLayout(NameInvalidNoticeLayout);
        NameInvalidNoticeLayout.setHorizontalGroup(
            NameInvalidNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        NameInvalidNoticeLayout.setVerticalGroup(
            NameInvalidNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panel3.add(NameInvalidNotice, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 125, -1, -1));

        AgeInvalidNotice.setBackground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout AgeInvalidNoticeLayout = new javax.swing.GroupLayout(AgeInvalidNotice);
        AgeInvalidNotice.setLayout(AgeInvalidNoticeLayout);
        AgeInvalidNoticeLayout.setHorizontalGroup(
            AgeInvalidNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        AgeInvalidNoticeLayout.setVerticalGroup(
            AgeInvalidNoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panel3.add(AgeInvalidNotice, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 205, -1, -1));

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(51, 51, 51));
        name.setMargin(new java.awt.Insets(6, 6, 6, 6));
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFocusGained(evt);
            }
        });
        panel3.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 250, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Age");
        panel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        age.setBackground(new java.awt.Color(255, 255, 255));
        age.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        age.setForeground(new java.awt.Color(51, 51, 51));
        age.setMargin(new java.awt.Insets(6, 6, 6, 6));
        age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ageFocusGained(evt);
            }
        });
        panel3.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 250, 40));

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(51, 51, 51));
        email.setMargin(new java.awt.Insets(6, 6, 6, 6));
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
        });
        panel3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 250, 40));

        panel1.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 330, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0); // Terminates the program, when exit button is clicked
    }//GEN-LAST:event_exitMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // This section initiates the adding of data to the database, when add button is clicked
        if (isUpdate == true) { // Prohibits adding if update is clicked
            return;
        }

        if (!(name.getText().isEmpty() && age.getText().isEmpty() && email.getText().isEmpty())) { // If the textfields are not empty, the statements below will execute
            if (name.getText().matches(".*\\d.*|^.*\\\\.*|^.*\\$.*") || !name.getText().matches(specialCharRegex) || name.getText().matches(spacingRegex)) { // True, if name contains digits      
                add.requestFocus(); // Passes the focus to the add button
                NameInvalidNotice.setVisible(true); // Shows a name invalid notice
                return;
            }
            if ((!age.getText().matches("[\\d]+")) || Integer.parseInt(age.getText()) > 116) { // True, if age is not numbers or age is greater than 116
                add.requestFocus(); // Passes the focus to the add button
                AgeInvalidNotice.setVisible(true); // Shows an age invalid notice
                return;
            }
            if ((!email.getText().matches(emailSpecialChar)) || email.getText().equals("@ctu.edu.ph") || email.getText().matches("^.*\\s.*$")) { // True, if email does end with @ctu.edu.ph and email is equal to @ctu.edu.ph
                add.requestFocus(); // Passes the focus to the add button
                EmailInvalidNotice.setVisible(true); // Shows an email invalid notice
                return;
            }
            boolean validity = validateEmail(); // Calls a method that validates email 

            if (validity == true) { // If email is valid
                db.add(id.getText(), name.getText(), age.getText(), email.getText()); // Calls the add method in the class database, passing all data entered

                // An alternative to automatically reload the frame
                new Frame().setVisible(true);
                setVisible(false);
            } else {
                add.requestFocus(); // Passes the focus to the add button
                EmailInvalidNotice.setVisible(true); // Shows an email invalid notice
                return;
            }
        }
    }//GEN-LAST:event_addMouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        // This section initiates removal of the selected data in the table
        if (listTable.getSelectedRow() >= 0) {

            hoverEffect = false;

            name.setEnabled(false);
            age.setEnabled(false);
            email.setEnabled(false);
            search.setText("");
            search.setEnabled(false);
            listTable.setEnabled(false);
            listTable.getTableHeader().setEnabled(false);
            add.setEnabled(false);
            update.setEnabled(false);
            remove.setEnabled(false);
            clear.setEnabled(false);
            exit.setEnabled(false);
            confirmation.setVisible(true);
            dimBG.setVisible(true);
            type = "remove";
        }
    }//GEN-LAST:event_removeMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // This section performs an update to the selected data in the table
        // Initializing variables
        int selected = listTable.getSelectedRow();
        model = (DefaultTableModel) listTable.getModel(); // Gets the model of the frame table
        
        if(selected < 0 && isUpdate == false){
            return;
        }
        
        
        if ((name.getText().isEmpty() && age.getText().isEmpty() && email.getText().isEmpty()) || isUpdate == false) { // If the textfields are not empty, the statements below will execute
            if (listTable.getRowCount() > 0 && selected >= 0) { // Checks if frame table is not empty

                // Takes data from each column, storing them in another variable
                String selectedId = model.getValueAt(selected, 0).toString();
                String selectedName = model.getValueAt(selected, 1).toString();
                String selectedAge = model.getValueAt(selected, 2).toString();
                String selectedEmail = model.getValueAt(selected, 3).toString();
                updateEmail = selectedEmail;
                // Sets the id, name, age, and email textfields to the text retrieve in the table
                id.setText(selectedId);
                name.setText(selectedName);
                age.setText(selectedAge);
                email.setText(selectedEmail);
                isUpdate = true;
            }
        } 
        else { // If textfields are empty
            if (name.getText().matches(".*\\d.*|^.*\\\\.*|^.*\\$.*") || !name.getText().matches(specialCharRegex) || name.getText().matches(spacingRegex)) { // True, if name contains digits
                add.requestFocus(); // Passes the focus to the add button
                NameInvalidNotice.setVisible(true); // Shows a name invalid notice
                return;
            }
            if ((!age.getText().matches("[\\d]+")) || Integer.parseInt(age.getText()) > 116) { // True, if age is not numbers or age is greater than 116
                add.requestFocus(); // Passes the focus to the add button
                AgeInvalidNotice.setVisible(true); // Shows an age invalid notice
                return;
            }
            if ((!email.getText().matches(emailSpecialChar)) || email.getText().equals("@ctu.edu.ph") || email.getText().matches("^.*\\s.*$")) { // True, if email does end with @ctu.edu.ph and email is equal to @ctu.edu.ph
                add.requestFocus(); // Passes the focus to the add button
                EmailInvalidNotice.setVisible(true); // Shows an email invalid notice
                return;
            }
            boolean emailValidity = validateEmail();
            if(emailValidity == true){
                // If all conditions above are false, these block of codes will execute
                db.update(id.getText(), name.getText(), age.getText(), email.getText()); // Calls the update method in the database class, passing all data in the textfield and label

                // An alternative to automatically reloads the frame
                new Frame().setVisible(true);
                setVisible(false);
            }
            else {
                add.requestFocus(); // Passes the focus to the add button
                EmailInvalidNotice.setVisible(true); // Shows an email invalid notice
                return;
            }
        }
    }//GEN-LAST:event_updateMouseClicked

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        // This section clears the table, when clear button is clicked

        if (listTable.getRowCount() > 0) {

            hoverEffect = false;

            name.setEnabled(false);
            age.setEnabled(false);
            email.setEnabled(false);
            search.setText("");
            search.setEnabled(false);
            listTable.setEnabled(false);
            listTable.getTableHeader().setEnabled(false);
            add.setEnabled(false);
            update.setEnabled(false);
            remove.setEnabled(false);
            clear.setEnabled(false);
            exit.setEnabled(false);
            confirmation.setVisible(true);
            dimBG.setVisible(true);
            type = "clear";
        }
    }//GEN-LAST:event_clearMouseClicked

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        // If search bar is clicked

        if (search.getText().equals("Search") && searching == false) { // True, if the text in the search bar is Search
            search.setText(""); // Sets the textfield to blank
        }

        // Removes the selection in the table
        if (listTable.getRowCount() > 0 && isUpdate == false) {
            listTable.removeRowSelectionInterval(0, listTable.getRowCount() - 1);
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        if (search.getText().equals("")) { // True, if focus is not in the search bar
            search.setText("Search"); // Sets the textfield back to Search
            searching = false;
        }
    }//GEN-LAST:event_searchFocusLost

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // Each key released in the search bar
        searching = true;
        search(); // Calls the method the performs fast searching and passing the key

    }//GEN-LAST:event_searchKeyReleased

    private void nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusGained

        // If name textfield is focused, invalid notices will be hidden
        NameInvalidNotice.setVisible(false);
        AgeInvalidNotice.setVisible(false);
        EmailInvalidNotice.setVisible(false);

        // Removes the selection in the table
        if (listTable.getRowCount() > 0 && isUpdate == false) {
            listTable.removeRowSelectionInterval(0, listTable.getRowCount() - 1);
        }
    }//GEN-LAST:event_nameFocusGained

    private void ageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFocusGained

        // If age textfield is focused, invalid notices will be hidden
        NameInvalidNotice.setVisible(false);
        AgeInvalidNotice.setVisible(false);
        EmailInvalidNotice.setVisible(false);

        // Removes the selection in the table
        if (listTable.getRowCount() > 0 && isUpdate == false) {
            listTable.removeRowSelectionInterval(0, listTable.getRowCount() - 1);
        }
    }//GEN-LAST:event_ageFocusGained

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained

        // If email textfield is focused, invalid notices will be hidden
        NameInvalidNotice.setVisible(false);
        AgeInvalidNotice.setVisible(false);
        EmailInvalidNotice.setVisible(false);

        // Removes the selection in the table
        if (listTable.getRowCount() > 0 && isUpdate == false) {
            listTable.removeRowSelectionInterval(0, listTable.getRowCount() - 1);
        }
    }//GEN-LAST:event_emailFocusGained

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // Removes the selection in the table
        if (listTable.getRowCount() > 0 && isUpdate == false) {
            listTable.removeRowSelectionInterval(0, listTable.getRowCount() - 1);
        }
        panel1.requestFocusInWindow();
    }//GEN-LAST:event_panel1MouseClicked

    private void confirmYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmYesMouseClicked
        confirmation.setVisible(false);
        dimBG.setVisible(false);
        name.setEnabled(true);
        age.setEnabled(true);
        email.setEnabled(true);
        search.setEnabled(true);
        listTable.setEnabled(true);
        listTable.getTableHeader().setEnabled(true);
        add.setEnabled(true);
        update.setEnabled(true);
        remove.setEnabled(true);
        clear.setEnabled(true);
        exit.setEnabled(true);
        if (type == "clear") {
            clear();
        } else {
            remove();
        }
    }//GEN-LAST:event_confirmYesMouseClicked

    private void confirmNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmNoMouseClicked
        confirmation.setVisible(false);
        dimBG.setVisible(false);
        name.setEnabled(true);
        age.setEnabled(true);
        email.setEnabled(true);
        search.setEnabled(true);
        listTable.setEnabled(true);
        listTable.getTableHeader().setEnabled(true);
        add.setEnabled(true);
        update.setEnabled(true);
        remove.setEnabled(true);
        clear.setEnabled(true);
        exit.setEnabled(true);
        search.setText("Search");
        hoverEffect = true;

    }//GEN-LAST:event_confirmNoMouseClicked

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        if (hoverEffect == true)
            panel4.setBackground(new Color(85, 85, 85)); // Hover effect
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        panel4.setBackground(new Color(51, 51, 51)); // Hover effect
    }//GEN-LAST:event_addMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        if (hoverEffect == true)
            panel6.setBackground(new Color(85, 85, 85)); // Hover effect
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        panel6.setBackground(new Color(51, 51, 51)); // Hover effect
    }//GEN-LAST:event_updateMouseExited

    private void clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseEntered
        if (hoverEffect == true)
            panel7.setBackground(new Color(85, 85, 85)); // Hover effect
    }//GEN-LAST:event_clearMouseEntered

    private void clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseExited
        panel7.setBackground(new Color(51, 51, 51)); // Hover effect
    }//GEN-LAST:event_clearMouseExited

    private void removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseEntered
        if (hoverEffect == true)
            panel5.setBackground(new Color(85, 85, 85)); // Hover effect
    }//GEN-LAST:event_removeMouseEntered

    private void removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseExited
        panel5.setBackground(new Color(51, 51, 51)); // Hover effect
    }//GEN-LAST:event_removeMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private studentmanager.Panel1 AgeInvalidNotice;
    private studentmanager.Panel1 EmailInvalidNotice;
    private studentmanager.Panel1 NameInvalidNotice;
    private javax.swing.JLabel add;
    private javax.swing.JTextField age;
    private javax.swing.JLabel clear;
    private javax.swing.JLabel confirmNo;
    private javax.swing.JLabel confirmYes;
    private studentmanager.Panel confirmation;
    private studentmanager.Panel dimBG;
    private javax.swing.JTextField email;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro listTable;
    private javax.swing.JTextField name;
    private studentmanager.Panel panel1;
    private studentmanager.Panel panel3;
    private studentmanager.Panel panel4;
    private studentmanager.Panel panel5;
    private studentmanager.Panel panel6;
    private studentmanager.Panel panel7;
    private javax.swing.JLabel remove;
    private javax.swing.JTextField search;
    private javax.swing.JLabel update;
    // End of variables declaration//GEN-END:variables
}
