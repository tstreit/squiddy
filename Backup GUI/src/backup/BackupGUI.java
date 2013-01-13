/*
 * BackupGUI.java
 *
 * Created on October 27, 2008, 7:17 PM
 */
package backup;

import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;

/**
 *
 * @author  tstreit
 */
public class BackupGUI extends javax.swing.JFrame {
    //Booleans for Radio Buttons
    boolean excludeyes;
    boolean excludeno;
    boolean exclude1;
    boolean exclude2;
    boolean exclude3;
    boolean exclude4;
    boolean exclude5;
    boolean tar;
    boolean sevenz;
    boolean tar2;
    boolean sevenz2;

    /** Creates new form BackupGUI */
    public BackupGUI() {
        initComponents();
    }

    private void BackupTar(int iCtr2) {
        //Defining variables for backing up in tar file
        String s;
        String homebackup = ("tar cpf " + jTextField8.getText() + jTextField7.getText() + ".tar" + " " + jTextField1.getText());
        String homebackup1 = ("tar cpf " + jTextField8.getText() + jTextField7.getText() + ".tar" + " " + "--exclude=" + jTextField2.getText() + " " + jTextField1.getText());
        String homebackup2 = ("tar cpf " + jTextField8.getText() + jTextField7.getText() + ".tar" + " " + "--exclude=" + jTextField2.getText() + " " + "--exclude=" + jTextField3.getText() + " " + jTextField1.getText());
        String homebackup3 = ("tar cpf " + jTextField8.getText() + jTextField7.getText() + ".tar" + " " + "--exclude=" + jTextField2.getText() + " " + "--exclude=" + jTextField3.getText() + " " + "--exclude=" + jTextField4.getText() + " " + jTextField1.getText());
        String homebackup4 = ("tar cpf " + jTextField8.getText() + jTextField7.getText() + ".tar" + " " + "--exclude=" + jTextField2.getText() + " " + "--exclude=" + jTextField3.getText() + " " + "--exclude=" + jTextField4.getText() + " " + "--exclude=" + jTextField5.getText() + " " + jTextField1.getText());
        String homebackup5 = ("tar cpf " + jTextField8.getText() + jTextField7.getText() + ".tar" + " " + "--exclude=" + jTextField2.getText() + " " + "--exclude=" + jTextField3.getText() + " " + "--exclude=" + jTextField4.getText() + " " + "--exclude=" + jTextField5.getText() + " " + "--exclude=" + jTextField6.getText() + " " + jTextField1.getText());

        //If the radio button no is selected then this will be executed.
        if (excludeno) {
            try {
                Process p = Runtime.getRuntime().exec(homebackup);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                } //END OF A WHILE STATEMENT

            } catch (IOException e) {
                e.printStackTrace();
            } //END OF A CATCH STATEMENT

        }

        //If the radio button yes is selected then this will be executed.
        if (excludeyes) {
            //If one exlusion is selected this will be executed.
            if (exclude1) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup1);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }

            //If two exlusions is selected this will be executed.
            if (exclude2) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup2);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }

            //If three exlusions is selected this will be executed.
            if (exclude3) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup3);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }

            //If four exlusions is selected this will be executed.
            if (exclude4) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup4);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }

            //If five exlusions is selected this will be executed.
            if (exclude5) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup5);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }
        }
    }

    private void Backup7z(int iCtr2) {
        // Requires p7zip package to be installed
        // Defining variables for backing up with 7z file
        String s;
        String homebackup = ("7za a -t7z " + jTextField8.getText() + jTextField7.getText() + ".7z" + " " + jTextField1.getText());
        String homebackup1 = ("7za a -t7z " + jTextField8.getText() + jTextField7.getText() + ".7z" + " " + "-r -x!" + jTextField2.getText() + " " + jTextField1.getText());
        String homebackup2 = ("7za a -t7z " + jTextField8.getText() + jTextField7.getText() + ".7z" + " " + "-r -x!" + jTextField2.getText() + " " + "-r -x!" + jTextField3.getText() + " " + jTextField1.getText());
        String homebackup3 = ("7za a -t7z " + jTextField8.getText() + jTextField7.getText() + ".7z" + " " + "-r -x!" + jTextField2.getText() + " " + "-r -x!" + jTextField3.getText() + " " + "-r -x!" + jTextField4.getText() + " " + jTextField1.getText());
        String homebackup4 = ("7za a -t7z " + jTextField8.getText() + jTextField7.getText() + ".7z" + " " + "-r -x!" + jTextField2.getText() + " " + "-r -x!" + jTextField3.getText() + " " + "-r -x!" + jTextField4.getText() + " " + "-r -x!" + jTextField5.getText() + " " + jTextField1.getText());
        String homebackup5 = ("7za a -t7z " + jTextField8.getText() + jTextField7.getText() + ".7z" + " " + "-r -x!" + jTextField2.getText() + " " + "-r -x!" + jTextField3.getText() + " " + "-r -x!" + jTextField4.getText() + " " + "-r -x!" + jTextField5.getText() + " " + "-r -x!" + jTextField6.getText() + " " + jTextField1.getText());

        //If the radio button no is selected then this will be executed.
        if (excludeno) {
            try {
                Process p = Runtime.getRuntime().exec(homebackup);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                } //END OF A WHILE STATEMENT

            } catch (IOException e) {
                e.printStackTrace();
            } //END OF A CATCH STATEMENT

        }

        //If the radio button yes is selected then this will be executed.
        if (excludeyes) {
            //If one exlusion is selected this will be executed.
            if (exclude1) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup1);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }

            //If two exlusions is selected this will be executed.
            if (exclude2) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup2);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }

            //If three exlusions is selected this will be executed.
            if (exclude3) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup3);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }

            //If four exlusions is selected this will be executed.
            if (exclude4) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup4);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }

            //If five exlusions is selected this will be executed.
            if (exclude5) {
                try {
                    Process p = Runtime.getRuntime().exec(homebackup5);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT

                } catch (IOException e) {
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT

            }
        }
    }

    private void RestoreTar(int iCtr) {
        // Defining variables for restoring with tar file
        String s;
        String restore = ("tar xf " + jTextField9.getText() + " -C " + jTextField10.getText());
        try {
            Process p = Runtime.getRuntime().exec(restore);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            } //END OF A WHILE STATEMENT

        } catch (IOException e) {
            e.printStackTrace();
        } //END OF A CATCH STATEMENT

    }

    private void Restore7z(int iCtr) {
        // Requires p7zip package to be installed
        // Defining variables for restoring with 7z file
        String s;
        String restore = ("7z x " + jTextField9.getText() + " -oc:" + jTextField10.getText() + " -y");
        try {
            Process p = Runtime.getRuntime().exec(restore);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            } //END OF A WHILE STATEMENT

        } catch (IOException e) {
            e.printStackTrace();
        } //END OF A CATCH STATEMENT

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Backup");

        jLabel1.setText("What directory would you like to backup?");

        jLabel3.setText("Give the backup a name:");

        jLabel4.setText("Where would you like to store the backup?");

        jButton2.setText("Backup");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Do you have files that you would like to exclude?");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Yes");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("No");
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });

        jLabel2.setText("How many?");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("1");
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton3ItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("2");
        jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton4ItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("3");
        jRadioButton5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton5ItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("4");
        jRadioButton6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton6ItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("5");
        jRadioButton7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton7ItemStateChanged(evt);
            }
        });

        jLabel6.setText("Please list, one per box up to five: (Example: *.jpeg for all JPEG files or pic.jpeg for one JPEG file)");

        jButton7.setText("Browse");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Browse");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel11.setText("Would you like to make this a .tar or .7z backup?");

        jRadioButton8.setText("Tar File");
        jRadioButton8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton8ItemStateChanged(evt);
            }
        });

        jRadioButton9.setText("7z File");
        jRadioButton9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton9ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton9))
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton7))
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(376, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton7, jButton8});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                .addGap(87, 87, 87))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton7, jButton8, jProgressBar2});

        jTabbedPane1.addTab("Backup", jPanel1);

        jLabel7.setText("Choose a Backup File:");

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Restore the Backup Where:");

        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Restore");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("Is this a Tar File or 7z File?");

        jRadioButton10.setText("Tar File");
        jRadioButton10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton10ItemStateChanged(evt);
            }
        });

        jRadioButton11.setText("7z File");
        jRadioButton11.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton11ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(422, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(744, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton11)
                        .addContainerGap(755, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(612, 612, 612))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, jButton4, jButton5});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5))
                .addContainerGap(317, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, jButton4, jButton5});

        jTabbedPane1.addTab("Restore", jPanel2);

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("About");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton6});

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // Ends program
    System.exit(0);
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    // Calls About class
    About a = null;
    a = new About();
    a.setVisible(true);
}//GEN-LAST:event_jButton6ActionPerformed

private void jRadioButton11ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton11ItemStateChanged
    //Fires event that state has changed.
    sevenz2 = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton11ItemStateChanged

private void jRadioButton10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton10ItemStateChanged
    //Fires event that state has changed.
    tar2 = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton10ItemStateChanged

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    // If tar file is selected
    if (tar2) {
        // Start loop for progress bar
        for (int iCtr = 1; iCtr < 101; iCtr++) {
            RestoreTar(iCtr);
            jProgressBar1.setValue(iCtr);
            Rectangle progressRect = jProgressBar1.getBounds();
            progressRect.x = 0;
            progressRect.y = 0;
            jProgressBar1.paintImmediately(progressRect);
        }
    }
    // If 7z file is selected
    if (sevenz2) {
        // Start loop for progress bar
        for (int iCtr = 1; iCtr < 101; iCtr++) {
            Restore7z(iCtr);
            jProgressBar1.setValue(iCtr);
            Rectangle progressRect = jProgressBar1.getBounds();
            progressRect.x = 0;
            progressRect.y = 0;
            jProgressBar1.paintImmediately(progressRect);
        }
    }
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    // Browse to where restored directory will go
    String choosedirectory;
    JFileChooser fc2 = new JFileChooser();
    fc2.setAcceptAllFileFilterUsed(false);
    fc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    fc2.showOpenDialog(fc2);
    choosedirectory = fc2.getSelectedFile().toString();
    jTextField10.setText(choosedirectory);
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // Browse to where restore file is located
    String choosefile;
    JFileChooser fc = new JFileChooser();
    fc.setAcceptAllFileFilterUsed(false);
    fc.showOpenDialog(fc);
    choosefile = fc.getSelectedFile().toString();
    jTextField9.setText(choosefile);
}//GEN-LAST:event_jButton3ActionPerformed

private void jRadioButton9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton9ItemStateChanged
    //Fires event that state has changed.
    sevenz = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton9ItemStateChanged

private void jRadioButton8ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton8ItemStateChanged
    //Fires event that state has changed.
    tar = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton8ItemStateChanged

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    // Browse to where is backup file will be stored
    String choosedirectory;
    JFileChooser fc4 = new JFileChooser();
    fc4.setAcceptAllFileFilterUsed(false);
    fc4.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    fc4.showOpenDialog(fc4);
    choosedirectory = fc4.getSelectedFile().toString();
    jTextField8.setText(choosedirectory + "/");
}//GEN-LAST:event_jButton8ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    // Browse to what directory or files will be backed up
    String choosedirectory;
    JFileChooser fc3 = new JFileChooser();
    fc3.setAcceptAllFileFilterUsed(false);
    fc3.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    fc3.showOpenDialog(fc3);
    choosedirectory = fc3.getSelectedFile().toString();
    jTextField1.setText(choosedirectory);
}//GEN-LAST:event_jButton7ActionPerformed

private void jRadioButton7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton7ItemStateChanged
    //Fires event that state has changed.
    exclude5 = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton7ItemStateChanged

private void jRadioButton6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton6ItemStateChanged
    //Fires event that state has changed.
    exclude4 = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton6ItemStateChanged

private void jRadioButton5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton5ItemStateChanged
    //Fires event that state has changed.
    exclude3 = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton5ItemStateChanged

private void jRadioButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton4ItemStateChanged
    //Fires event that state has changed.
    exclude2 = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton4ItemStateChanged

private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
    //Fires event that state has changed.
    exclude1 = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton3ItemStateChanged

private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
    //Fires event that state has changed.
    excludeno = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton2ItemStateChanged

private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
    //Fires event that state has changed.
    excludeyes = (evt.getStateChange() == ItemEvent.SELECTED);
}//GEN-LAST:event_jRadioButton1ItemStateChanged

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // If tar file is selected
    if (tar) {
        for (int iCtr = 1; iCtr < 101; iCtr++) {
            BackupTar(iCtr);
            jProgressBar2.setValue(iCtr);
            Rectangle progressRect = jProgressBar2.getBounds();
            progressRect.x = 0;
            progressRect.y = 0;
            jProgressBar2.paintImmediately(progressRect);
        }
    }
    // If 7z file is selected
    if (sevenz) {
        for (int iCtr = 1; iCtr < 101; iCtr++) {
            Backup7z(iCtr);
            jProgressBar2.setValue(iCtr);
            Rectangle progressRect = jProgressBar2.getBounds();
            progressRect.x = 0;
            progressRect.y = 0;
            jProgressBar2.paintImmediately(progressRect);
        }
    }
}//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BackupGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
