/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on Sep 24, 2011, 2:54:04 PM
 */
package conkyscriptbuilder;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.io.*;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author tstreit
 */
public class Main extends javax.swing.JFrame {

    /**
     * Defining variables
     */
    File fFile = new File(".xml");
    FileFilter fFileFilter = new FileFilter();
    Component frame = null;
    Color aColor;
    Color bColor;
    String rgbTitle;
    String rgbText;
    String s;
    String backup = "./backupconky.sh";
    String runbanshee = "./banshee.sh";
    String changenet = "./changenet.sh";
    String reload = "./conkymv.sh";
    String restore = "./restoreconky.sh";
    String font;
    String fontsize;
    String aligntext;
    String textupper;
    String titlecolor;
    String textcolor;
    String transparent;
    String basicinfo2;
    String host;
    String kernel;
    String uptime;
    String time;
    String date;
    String cpuinfo2;
    String cpuspeed;
    String cpuload;
    String cpuusage;
    String cpuproc;
    String cpuprocnum;
    String cpuact;
    String memdiskinfo2;
    String ram;
    String homedir;
    String netinfo2;
    String fedora;
    String publicip;
    String netusage;
    String netapp;
    String weather;
    String fortunes;
    boolean uppercaseYes;
    boolean uppercaseNo;
    boolean transparentYes;
    boolean transparentNo;
    boolean basicinfo;
    boolean cpuinfo;
    boolean memdiskinfo;
    boolean netinfo;
    boolean redhatfedora;
    boolean hostnameYes;
    boolean hostnameNo;
    boolean kernelYes;
    boolean kernelNo;
    boolean uptimeYes;
    boolean uptimeNo;
    boolean timeYes;
    boolean timeNo;
    boolean dateYes;
    boolean dateNo;
    boolean cpuspeedYes;
    boolean cpuspeedNo;
    boolean cpuloadYes;
    boolean cpuloadNo;
    boolean cpuusageYes;
    boolean cpuusageNo;
    boolean cpuprocYes;
    boolean cpuprocNo;
    boolean cpuactYes;
    boolean cpuactNo;
    boolean ramYes;
    boolean ramNo;
    boolean homedirYes;
    boolean homedirNo;
    boolean publicipYes;
    boolean publicipNo;
    boolean netusageYes;
    boolean netusageNo;
    boolean netappYes;
    boolean netappNo;
    boolean banshee;
    boolean bansheeartYes;
    boolean bansheeartNo;
    boolean bansheealYes;
    boolean bansheealNo;
    boolean bansheesoYes;
    boolean bansheesoNo;
    boolean bansheeposYes;
    boolean bansheeposNo;
    boolean weatherYes;
    boolean weatherNo;
    boolean fortunesYes;
    boolean fortunesNo;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * Creates new form About
     */
    private void About() {
        About a = new About();
        a.setVisible(true);
    }

    /**
     * Backup current .conkyrc file
     */
    private void BackupConky() {
        try {
            Process p = Runtime.getRuntime().exec(backup);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            JOptionPane.showMessageDialog(null, "Your .conkyrc has been backed up to the conkyrc_bak file.");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            } //END OF A WHILE STATEMENT
            JOptionPane.showMessageDialog(frame, "Your conky configuration has been backed up.");

        } catch (IOException e) {
        } //END OF A CATCH STATEMENT
    }

    /**
     * Change network name for Red Hat 6/Fedora 15 new naming scheme
     */
    private void ChangeNet() {
        try {
            Process p = Runtime.getRuntime().exec(changenet);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            } //END OF A WHILE STATEMENT

        } catch (IOException e) {
        } //END OF A CATCH STATEMENT
    }

    /**
     * Exits application
     */
    private void Exit() {
        System.exit(0);
    }

    /**
     * Creates new project file for conky configuration
     */
    private void NewProject() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("."));
        fc.setFileFilter(fFileFilter);
        fc.setSelectedFile(fFile);
        int result = fc.showSaveDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) {
        } else if (result == JFileChooser.APPROVE_OPTION) {
            fFile = fc.getSelectedFile();
        }

        jLabel37.setText(fFile.getName());

        /**
         * Set all objects to default positions
         */
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);

        if (uppercaseYes) {
            jRadioButton4.setSelected(true);
        }

        jLabel9.setText("");
        jLabel10.setText("");

        if (transparentYes) {
            jRadioButton2.setSelected(true);
        }

        jCheckBox1.setSelected(false);

        if (hostnameYes) {
            jRadioButton6.setSelected(true);
        }

        if (kernelYes) {
            jRadioButton8.setSelected(true);
        }

        if (uptimeYes) {
            jRadioButton10.setSelected(true);
        }

        if (timeYes) {
            jRadioButton12.setSelected(true);
        }

        if (dateYes) {
            jRadioButton14.setSelected(true);
        }

        jCheckBox2.setSelected(false);

        if (cpuspeedYes) {
            jRadioButton16.setSelected(true);
        }

        if (cpuloadYes) {
            jRadioButton18.setSelected(true);
        }

        if (cpuusageYes) {
            jRadioButton20.setSelected(true);
        }

        if (cpuprocYes) {
            jRadioButton22.setSelected(true);
            jSpinner1.setValue(1);
        }

        if (cpuactYes) {
            jRadioButton24.setSelected(true);
        }

        jCheckBox3.setSelected(false);

        if (ramYes) {
            jRadioButton26.setSelected(true);
        }

        if (homedirYes) {
            jRadioButton28.setSelected(true);
        }

        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);

        if (publicipYes) {
            jRadioButton30.setSelected(true);
        }

        if (netusageYes) {
            jRadioButton32.setSelected(true);
        }

        if (netappYes) {
            jRadioButton34.setSelected(true);
        }

        if (weatherYes) {
            jRadioButton38.setSelected(true);
        }

        if (fortunesYes) {
            jRadioButton40.setSelected(true);
        }

        JOptionPane.showMessageDialog(frame, "Your new project has been created.");
    }

    /**
     * Opens project file for conky configuration
     */
    private void OpenProject() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("."));
        fc.setFileFilter(fFileFilter);
        fc.setSelectedFile(fFile);
        int result = fc.showOpenDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) {
        } else if (result == JFileChooser.APPROVE_OPTION) {
            fFile = fc.getSelectedFile();
        }

        jLabel37.setText(fFile.getName());

        Document doc = ParseFile(fFile);
        font = doc.getElementsByTagName("font").item(0).getTextContent();
        int aInt = Integer.parseInt(font);
        fontsize = doc.getElementsByTagName("fontsize").item(0).getTextContent();
        int bInt = Integer.parseInt(fontsize);
        aligntext = doc.getElementsByTagName("aligntext").item(0).getTextContent();
        int cInt = Integer.parseInt(aligntext);
        textupper = doc.getElementsByTagName("textupper").item(0).getTextContent();
        titlecolor = doc.getElementsByTagName("titlecolor").item(0).getTextContent();
        textcolor = doc.getElementsByTagName("textcolor").item(0).getTextContent();
        transparent = doc.getElementsByTagName("transparent").item(0).getTextContent();
        basicinfo2 = doc.getElementsByTagName("basicinfo").item(0).getTextContent();
        host = doc.getElementsByTagName("host").item(0).getTextContent();
        kernel = doc.getElementsByTagName("kernel").item(0).getTextContent();
        uptime = doc.getElementsByTagName("uptime").item(0).getTextContent();
        time = doc.getElementsByTagName("time").item(0).getTextContent();
        date = doc.getElementsByTagName("date").item(0).getTextContent();
        cpuinfo2 = doc.getElementsByTagName("cpuinfo").item(0).getTextContent();
        cpuspeed = doc.getElementsByTagName("cpuspeed").item(0).getTextContent();
        cpuload = doc.getElementsByTagName("cpuload").item(0).getTextContent();
        cpuusage = doc.getElementsByTagName("cpuusage").item(0).getTextContent();
        cpuproc = doc.getElementsByTagName("cpuproc").item(0).getTextContent();
        cpuprocnum = doc.getElementsByTagName("cpuprocnum").item(0).getTextContent();
        int dInt = Integer.parseInt(cpuprocnum);
        cpuact = doc.getElementsByTagName("cpuact").item(0).getTextContent();
        memdiskinfo2 = doc.getElementsByTagName("memdiskinfo").item(0).getTextContent();
        ram = doc.getElementsByTagName("ram").item(0).getTextContent();
        homedir = doc.getElementsByTagName("homedir").item(0).getTextContent();
        netinfo2 = doc.getElementsByTagName("netinfo").item(0).getTextContent();
        fedora = doc.getElementsByTagName("fedora").item(0).getTextContent();
        publicip = doc.getElementsByTagName("publicip").item(0).getTextContent();
        netusage = doc.getElementsByTagName("netusage").item(0).getTextContent();
        netapp = doc.getElementsByTagName("netapp").item(0).getTextContent();
        weather = doc.getElementsByTagName("weather").item(0).getTextContent();
        fortunes = doc.getElementsByTagName("fortunes").item(0).getTextContent();

        /**
         * Set objects to position according to xml file
         */
        jComboBox1.setSelectedIndex(aInt);
        jComboBox2.setSelectedIndex(bInt);
        jComboBox3.setSelectedIndex(cInt);

        if (textupper.equals("Yes")) {
            jRadioButton3.setSelected(true);
        } else {
            jRadioButton4.setSelected(true);
        }

        aColor = Color.decode(titlecolor);
        jLabel9.setForeground(aColor);
        jLabel9.setText("The is the color of your Title text.");
        bColor = Color.decode(textcolor);
        jLabel10.setForeground(bColor);
        jLabel10.setText("The is the color of your Text.");

        if (transparent.equals("Yes")) {
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton2.setSelected(true);
        }

        if (basicinfo2.equals("Yes")) {
            jCheckBox1.setSelected(true);
        } else {
            jCheckBox1.setSelected(false);
        }

        if (host.equals("Yes")) {
            jRadioButton5.setSelected(true);
        } else {
            jRadioButton6.setSelected(true);
        }

        if (kernel.equals("Yes")) {
            jRadioButton7.setSelected(true);
        } else {
            jRadioButton8.setSelected(true);
        }

        if (uptime.equals("Yes")) {
            jRadioButton9.setSelected(true);
        } else {
            jRadioButton10.setSelected(true);
        }

        if (time.equals("Yes")) {
            jRadioButton11.setSelected(true);
        } else {
            jRadioButton12.setSelected(true);
        }

        if (date.equals("Yes")) {
            jRadioButton13.setSelected(true);
        } else {
            jRadioButton14.setSelected(true);
        }

        if (cpuinfo2.equals("Yes")) {
            jCheckBox2.setSelected(true);
        } else {
            jCheckBox2.setSelected(false);
        }

        if (cpuspeed.equals("Yes")) {
            jRadioButton15.setSelected(true);
        } else {
            jRadioButton16.setSelected(true);
        }

        if (cpuload.equals("Yes")) {
            jRadioButton17.setSelected(true);
        } else {
            jRadioButton18.setSelected(true);
        }

        if (cpuusage.equals("Yes")) {
            jRadioButton19.setSelected(true);
        } else {
            jRadioButton10.setSelected(true);
        }

        if (cpuproc.equals("Yes")) {
            jRadioButton21.setSelected(true);
            jSpinner1.setValue(dInt);
        } else {
            jRadioButton22.setSelected(true);
            jSpinner1.setValue(0);
        }

        if (cpuact.equals("Yes")) {
            jRadioButton23.setSelected(true);
        } else {
            jRadioButton24.setSelected(true);
        }

        if (memdiskinfo2.equals("Yes")) {
            jCheckBox3.setSelected(true);
        } else {
            jCheckBox3.setSelected(false);
        }

        if (ram.equals("Yes")) {
            jRadioButton25.setSelected(true);
        } else {
            jRadioButton26.setSelected(true);
        }

        if (homedir.equals("Yes")) {
            jRadioButton27.setSelected(true);
        } else {
            jRadioButton28.setSelected(true);
        }

        if (netinfo2.equals("Yes")) {
            jCheckBox4.setSelected(true);
        } else {
            jCheckBox4.setSelected(false);
        }

        if (fedora.equals("Yes")) {
            jCheckBox5.setSelected(true);
        } else {
            jCheckBox5.setSelected(false);
        }

        if (publicip.equals("Yes")) {
            jRadioButton29.setSelected(true);
        } else {
            jRadioButton30.setSelected(true);
        }

        if (netusage.equals("Yes")) {
            jRadioButton31.setSelected(true);
        } else {
            jRadioButton32.setSelected(true);
        }

        if (netapp.equals("Yes")) {
            jRadioButton33.setSelected(true);
        } else {
            jRadioButton34.setSelected(true);
        }

        if (weather.equals("Yes")) {
            jRadioButton37.setSelected(true);
        } else {
            jRadioButton38.setSelected(true);
        }

        if (fortunes.equals("Yes")) {
            jRadioButton39.setSelected(true);
        } else {
            jRadioButton40.setSelected(true);
        }

    }

    /**
     * Parses and reads xml file
     */
    private Document ParseFile(File fFile) {
        DocumentBuilder docBuilder;
        Document doc = null;
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setIgnoringElementContentWhitespace(true);
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("Wrong parser configuration: " + e.getMessage());
            return null;
        }

        try {
            doc = docBuilder.parse(fFile);
        } catch (SAXException e) {
            System.out.println("Wrong XML file structure: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println("Could not read source file: " + e.getMessage());
        }
        return doc;
    }

    /**
     * Creates new form Prerequisites
     */
    private void Prereq() {
        Prerequisites p = new Prerequisites();
        p.setVisible(true);
    }

    /**
     * Reload conky
     */
    private void ReloadConky() {
        if (jCheckBox6.isSelected()) {
            try {
                Process p = Runtime.getRuntime().exec(runbanshee);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                } //END OF A WHILE STATEMENT
                JOptionPane.showMessageDialog(frame, "Conky has been saved and reloaded.");

            } catch (IOException e) {
            } //END OF A CATCH STATEMENT
        } else {
            try {
                Process p = Runtime.getRuntime().exec(reload);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                } //END OF A WHILE STATEMENT
                JOptionPane.showMessageDialog(frame, "Conky has been saved and reloaded.");

            } catch (IOException e) {
            } //END OF A CATCH STATEMENT
        }
    }

    /**
     * Restore conky file from backup
     */
    private void RestoreConky() {
        try {
            Process p = Runtime.getRuntime().exec(restore);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            JOptionPane.showMessageDialog(null, "Your .conkyrc has been restored from the conkyrc_bak file.");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            } //END OF A WHILE STATEMENT
            JOptionPane.showMessageDialog(frame, "Your conky configuration has been restored from your backup.");

        } catch (IOException e) {
        } //END OF A CATCH STATEMENT
    }

    /**
     * Save conky configuration to current project name as an xml file.
     */
    private void SaveProject() {
        try {
            OutputStream fout = new FileOutputStream(fFile);
            OutputStream bout = new BufferedOutputStream(fout);
            OutputStreamWriter out = new OutputStreamWriter(bout, "8859_1");
            out.write("<?xml version=\"1.0\" ");
            out.write("encoding=\"ISO-8859-1\"?>\r\n");
            out.write("<conky>\r\n");

            /**
             * Look & Feel
             */
            out.write("<font>" + jComboBox1.getSelectedIndex() + "</font>\r\n");
            out.write("<fontsize>" + jComboBox2.getSelectedIndex() + "</fontsize>\r\n");
            out.write("<aligntext>" + jComboBox3.getSelectedIndex() + "</aligntext>\r\n");
            if (uppercaseYes) {
                out.write("<textupper>Yes</textupper>\r\n");
            } else {
                out.write("<textupper>No</textupper>\r\n");
            }
            out.write("<titlecolor>#" + rgbTitle + "</titlecolor>\r\n");
            out.write("<textcolor>#" + rgbText + "</textcolor>\r\n");
            if (transparentYes) {
                out.write("<transparent>Yes</transparent>\r\n");
            } else {
                out.write("<transparent>No</transparent>\r\n");
            }

            /**
             * System Monitoring
             */
            if (jCheckBox1.isSelected()) {
                out.write("<basicinfo>Yes</basicinfo>\r\n");
                if (hostnameYes) {
                    out.write("<host>Yes</host>\r\n");
                } else {
                    out.write("<host>No</host>\r\n");
                }
                if (kernelYes) {
                    out.write("<kernel>Yes</kernel>\r\n");
                } else {
                    out.write("<kernel>No</kernel>\r\n");
                }
                if (uptimeYes) {
                    out.write("<uptime>Yes</uptime>\r\n");
                } else {
                    out.write("<uptime>No</uptime>\r\n");
                }
                if (timeYes) {
                    out.write("<time>Yes</time>\r\n");
                } else {
                    out.write("<time>No</time>\r\n");
                }
                if (dateYes) {
                    out.write("<date>Yes</date>\r\n");
                } else {
                    out.write("<date>No</date>\r\n");
                }
            }

            if (jCheckBox2.isSelected()) {
                out.write("<cpuinfo>Yes</cpuinfo>\r\n");
                if (cpuspeedYes) {
                    out.write("<cpuspeed>Yes</cpuspeed>\r\n");
                } else {
                    out.write("<cpuspeed>No</cpuspeed>\r\n");
                }
                if (cpuloadYes) {
                    out.write("<cpuload>Yes</cpuload>\r\n");
                } else {
                    out.write("<cpuload>No</cpuload>\r\n");
                }
                if (cpuusageYes) {
                    out.write("<cpuusage>Yes</cpuusage>\r\n");
                } else {
                    out.write("<cpuusage>No</cpuusage>\r\n");
                }
                if (cpuprocYes) {
                    out.write("<cpuproc>Yes</cpuproc>\r\n");
                    out.write("<cpuprocnum>" + jSpinner1.getValue().toString() + "</cpuprocnum>\r\n");
                } else {
                    out.write("<cpuproc>No</cpuproc>\r\n");
                    out.write("<cpuprocnum>0</cpuprocnum>\r\n");
                }
                if (cpuactYes) {
                    out.write("<cpuact>Yes</cpuact>\r\n");
                } else {
                    out.write("<cpuact>No</cpuact>\r\n");
                }
            }

            if (jCheckBox3.isSelected()) {
                out.write("<memdiskinfo>Yes</memdiskinfo>\r\n");
                if (ramYes) {
                    out.write("<ram>Yes</ram>\r\n");
                } else {
                    out.write("<ram>No</ram>\r\n");
                }
                if (homedirYes) {
                    out.write("<homedir>Yes</homedir>\r\n");
                } else {
                    out.write("<homedir>No</homedir>\r\n");
                }
            }

            if (jCheckBox4.isSelected()) {
                out.write("<netinfo>Yes</netinfo>\r\n");
                if (jCheckBox5.isSelected()) {
                    out.write("<fedora>Yes</fedora>\r\n");
                } else {
                    out.write("<fedora>No</fedora>\r\n");
                }
                if (publicipYes) {
                    out.write("<publicip>Yes</publicip>\r\n");
                } else {
                    out.write("<publicip>No</publicip>\r\n");
                }
                if (netusageYes) {
                    out.write("<netusage>Yes</netusage>\r\n");
                } else {
                    out.write("<netusage>No</netusage>\r\n");
                }
                if (netappYes) {
                    out.write("<netapp>Yes</netapp>\r\n");
                } else {
                    out.write("<netapp>No</netapp>\r\n");
                }
            }

            /**
             * Utilities
             */
            if (weatherYes) {
                out.write("<weather>Yes</weather>\r\n");
            } else {
                out.write("<weather>no</weather>\r\n");
            }

            /**
             * Extra Bling!
             */
            if (fortunesYes) {
                out.write("<fortunes>Yes</fortunes>\r\n");
            } else {
                out.write("<fortunes>No</fortunes>\r\n");
            }

            out.write("</conky>");
            out.flush();
            out.close();

            JOptionPane.showMessageDialog(frame, "Your project has been saved.");

        } catch (UnsupportedEncodingException e) {
            System.out.println(
                    "This VM does not support the Latin-1 character set.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Color chooser for Title information in conky
     */
    public void TitleColor() {
        Color newColor = JColorChooser.showDialog(rootPane, "Choose Title Color", getBackground());
        if (newColor != null) {
            jLabel9.setForeground(newColor);
            jLabel9.setText("The is the color of your Title text.");
        }
        rgbTitle = Integer.toHexString(newColor.getRGB());
        rgbTitle = rgbTitle.substring(2, rgbTitle.length());
    }

    /**
     * Color chooser for Text information in conky
     */
    public void TextColor() {
        Color newColor = JColorChooser.showDialog(rootPane, "Choose Title Color", getBackground());
        if (newColor != null) {
            jLabel10.setForeground(newColor);
            jLabel10.setText("The is the color of your Text.");
            rgbText = Integer.toHexString(newColor.getRGB());
            rgbText = rgbText.substring(2, rgbText.length());
        }
    }

    /**
     * Save conkyrc file
     */
    private void WriteFile() {

        try {
            OutputStream fout = new FileOutputStream("conkyrc");
            OutputStream bout = new BufferedOutputStream(fout);
            OutputStreamWriter out = new OutputStreamWriter(bout, "8859_1");

            /**
             * Look & Feel
             */
            out.write("# Create own window instead of using desktop (required in nautilus)\n");
            out.write("own_window yes\n");
            out.write("own_window_type override\n");

            if (transparentYes) {
                out.write("own_window_transparent yes\n");
            } else {
                out.write("own_window_transparent no\n");
            }

            out.write("\n");
            out.write("# Use double buffering (reduces flicker, may not work for everyone)\n");
            out.write("double_buffer yes\n");
            out.write("\n");
            out.write("# fiddle with window\n");
            out.write("use_spacer left\n");
            out.write("\n");
            out.write("# Use Xft?\n");
            out.write("use_xft yes\n");
            out.write("xftfont " + jComboBox1.getSelectedItem().toString() + ":size=" + jComboBox2.getSelectedItem().toString() + "\n");
            out.write("xftalpha 0.8\n");
            out.write("text_buffer_size 2048\n");
            out.write("\n");
            out.write("# Update interval in seconds\n");
            out.write("update_interval 1\n");
            out.write("\n");
            out.write("# Minimum size of text area\n");
            out.write("# minimum_size 250 5\n");
            out.write("\n");
            out.write("# Draw shades?\n");
            out.write("draw_shades no\n");
            out.write("\n");
            out.write("# Text stuff\n");
            out.write("draw_outline no # amplifies text if yes\n");
            out.write("draw_borders no\n");

            if (uppercaseYes) {
                out.write("uppercase yes # set to no if you do not want all text to be in uppercase\n");
            } else {
                out.write("uppercase no # set to yes if you want all text to be in uppercase\n");
            }

            out.write("\n");
            out.write("# Stippled borders?\n");
            out.write("stippled_borders 3\n");
            out.write("\n");
            out.write("# border margins\n");
            out.write("#border_margin 9\n");
            out.write("\n");
            out.write("# border width\n");
            out.write("border_width 15\n");
            out.write("\n");
            out.write("# Default colors and also border colors, grey90 == #e5e5e5\n");
            out.write("default_color grey\n");
            out.write("\n");
            out.write("# Text alignment\n");

            if (jComboBox3.getSelectedItem().toString().equals("Top Left")) {
                out.write("alignment top_left\n");
            }

            if (jComboBox3.getSelectedItem().toString().equals("Top Right")) {
                out.write("alignment top_right\n");
            }

            if (jComboBox3.getSelectedItem().toString().equals("Bottom Left")) {
                out.write("alignment bottom_left\n");
            }

            if (jComboBox3.getSelectedItem().toString().equals("Bottom Right")) {
                out.write("alignment bottom_right\n");
            }

            out.write("\n");
            out.write("# Gap between borders of screen and text\n");
            out.write("gap_x 10\n");
            out.write("gap_y 10\n");
            out.write("\n");

            /**
             * System Monitoring
             */
            out.write("# stuff after 'TEXT' will be formatted on screen\n");
            out.write("TEXT\n");
            out.write("$color\n");

            if (jCheckBox1.isSelected()) {
                out.write("${color #" + rgbTitle + "}SYSTEM ${hr 2}$color\n");
                out.write("${color #" + rgbText + "}\n");

                if (hostnameYes) {
                    out.write("Hostname: $alignr$nodename\n");
                }

                if (kernelYes) {
                    out.write("Kernel: $alignr$kernel\n");
                }

                if (uptimeYes) {
                    out.write("Uptime: $alignr$uptime\n");
                }

                if (timeYes) {
                    out.write("Time: ${alignr}${time %I:%M%p}\n");
                }

                if (dateYes) {
                    out.write("Date: ${alignr}${exec date +\"%D\"}\n");
                }

                out.write("$color\n");
            }

            if (jCheckBox2.isSelected()) {
                out.write("\n");
                out.write("${color #" + rgbTitle + "}CPU ${hr 2}$color\n");
                out.write("${color #" + rgbText + "}\n");

                if (cpuspeedYes) {
                    out.write("CPU Speed: $alignr${freq}MHz\n");
                }

                if (cpuloadYes) {
                    out.write("CPU Load: $alignr${loadavg}\n");
                }

                if (cpuusageYes) {
                    out.write("\n");
                    out.write("CPU Current Usage: $cpubar\n");
                    out.write("\n");
                }

                if (cpuprocYes) {
                    out.write("CPU Top " + jSpinner1.getValue().toString() + " Processes:\n");
                    if (jSpinner1.getValue().toString().equals("1")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("2")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("3")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("4")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("5")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("6")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("7")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                        out.write("${top name 7} $alignr ${top pid 7} ${top cpu 7}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("8")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                        out.write("${top name 7} $alignr ${top pid 7} ${top cpu 7}\n");
                        out.write("${top name 8} $alignr ${top pid 8} ${top cpu 8}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("9")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                        out.write("${top name 7} $alignr ${top pid 7} ${top cpu 7}\n");
                        out.write("${top name 8} $alignr ${top pid 8} ${top cpu 8}\n");
                        out.write("${top name 9} $alignr ${top pid 9} ${top cpu 9}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("10")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                        out.write("${top name 7} $alignr ${top pid 7} ${top cpu 7}\n");
                        out.write("${top name 8} $alignr ${top pid 8} ${top cpu 8}\n");
                        out.write("${top name 9} $alignr ${top pid 9} ${top cpu 9}\n");
                        out.write("${top name 10} $alignr ${top pid 10} ${top cpu 10}\n");
                    }

                }

                if (cpuactYes) {
                    out.write("\n");
                    out.write("CPU Activity: ${cpugraph 000000 0000ff}\n");
                }

                out.write("$color\n");
            }

            if (jCheckBox3.isSelected()) {
                out.write("\n");
                out.write("${color #" + rgbTitle + "}MEMORY / DISK ${hr 2}$color\n");
                out.write("${color #" + rgbText + "}\n");
                out.write("\n");

                if (ramYes) {
                    out.write("RAM Usage:   $memperc% Free   ${membar 6}\n");
                }

                if (homedirYes) {
                    out.write("Root Directory:  ${fs_free_perc /}% Free   ${fs_bar 6 /}$color\n");
                }

                out.write("$color\n");
            }

            if (jCheckBox4.isSelected()) {
                out.write("\n");
                out.write("${color #" + rgbTitle + "}NETWORK (${addr eth0}) ${hr 2}$color\n");
                out.write("${color #" + rgbText + "}\n");

                if (publicipYes) {
                    out.write("Public IP: ${execi 1800 ~/.conkyscripts/publicip.sh}\n");
                }

                if (netusageYes) {
                    out.write("Down: ${downspeed eth0} k/s ${alignr}Up: ${upspeed eth0} k/s\n");
                    out.write("${downspeedgraph eth0 25,140 000000 ff0000} ${alignr}${upspeedgraph eth0 25,140 000000 00ff00}\n");
                    out.write("Total: ${totaldown eth0} ${alignr}Total: ${totalup eth0}\n");
                }

                if (netappYes) {
                    out.write("${execi 30 netstat -ept | grep ESTAB | awk '{print $9}' | cut -d: -f1 | sort | uniq -c | sort -nr}\n");
                }

                out.write("$color\n");
            }

            /**
             * Multimedia
             */
            if (jCheckBox6.isSelected()) {
                out.write("\n");
                out.write("${color #" + rgbTitle + "}BANSHEE ${hr 2}$color\n");
                out.write("${color #" + rgbText + "}\n");
                out.write("Status: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=ST}\n");

                if (bansheeartYes) {
                    out.write("Artist: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=AR}\n");
                }

                if (bansheealYes) {
                    out.write("Album: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=AL}\n");
                }

                if (bansheesoYes) {
                    out.write("Song: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=TI}\n");
                }

                if (bansheeposYes) {
                    out.write("Position: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=PT}/${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=LE}\n");
                }

                out.write("$color\n");
            }

            /**
             * Utilities
             */
            if (weatherYes) {
                out.write("$color\n");
                out.write("${color #" + rgbTitle + "}WEATHER ${hr 2}$color\n");
                out.write("${color #" + rgbText + "}\n");
                out.write("${execi 1800 ~/.conkyscripts/weather.sh}\n");
                out.write("$color\n");

            }

            /**
             * Extra Bling!
             */
            if (fortunesYes) {
                out.write("$color\n");
                out.write("${color #" + rgbTitle + "}FORTUNE ${hr 2}$color\n");
                out.write("${color #" + rgbText + "}\n");
                out.write("${execi 120 fortune -s | fold -w50}\n");
                out.write("$color\n");
            }

            out.flush();
            out.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println(
                    "This VM does not support the Latin-1 character set.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } //END OF A CATCH STATEMENT
    }

    /**
     * Save conkyrc file
     */
    private void WriteFile2() {

        try {
            OutputStream fout = new FileOutputStream("conkyrc");
            OutputStream bout = new BufferedOutputStream(fout);
            OutputStreamWriter out = new OutputStreamWriter(bout, "8859_1");

            /**
             * Look & Feel
             */
            out.write("# Create own window instead of using desktop (required in nautilus)\n");
            out.write("own_window yes\n");
            out.write("own_window_type override\n");

            if (transparentYes) {
                out.write("own_window_transparent yes\n");
            } else {
                out.write("own_window_transparent no\n");
            }

            out.write("\n");
            out.write("# Use double buffering (reduces flicker, may not work for everyone)\n");
            out.write("double_buffer yes\n");
            out.write("\n");
            out.write("# fiddle with window\n");
            out.write("use_spacer left\n");
            out.write("\n");
            out.write("# Use Xft?\n");
            out.write("use_xft yes\n");
            out.write("xftfont " + jComboBox1.getSelectedItem().toString() + ":size=" + jComboBox2.getSelectedItem().toString() + "\n");
            out.write("xftalpha 0.8\n");
            out.write("text_buffer_size 2048\n");
            out.write("\n");
            out.write("# Update interval in seconds\n");
            out.write("update_interval 1\n");
            out.write("\n");
            out.write("# Minimum size of text area\n");
            out.write("# minimum_size 250 5\n");
            out.write("\n");
            out.write("# Draw shades?\n");
            out.write("draw_shades no\n");
            out.write("\n");
            out.write("# Text stuff\n");
            out.write("draw_outline no # amplifies text if yes\n");
            out.write("draw_borders no\n");

            if (uppercaseYes) {
                out.write("uppercase yes # set to no if you do not want all text to be in uppercase\n");
            } else {
                out.write("uppercase no # set to yes if you want all text to be in uppercase\n");
            }

            out.write("\n");
            out.write("# Stippled borders?\n");
            out.write("stippled_borders 3\n");
            out.write("\n");
            out.write("# border margins\n");
            out.write("#border_margin 9\n");
            out.write("\n");
            out.write("# border width\n");
            out.write("border_width 15\n");
            out.write("\n");
            out.write("# Default colors and also border colors, grey90 == #e5e5e5\n");
            out.write("default_color grey\n");
            out.write("\n");
            out.write("# Text alignment\n");

            if (jComboBox3.getSelectedItem().toString().equals("Top Left")) {
                out.write("alignment top_left\n");
            }

            if (jComboBox3.getSelectedItem().toString().equals("Top Right")) {
                out.write("alignment top_right\n");
            }

            if (jComboBox3.getSelectedItem().toString().equals("Bottom Left")) {
                out.write("alignment bottom_left\n");
            }

            if (jComboBox3.getSelectedItem().toString().equals("Bottom Right")) {
                out.write("alignment bottom_right\n");
            }

            out.write("\n");
            out.write("# Gap between borders of screen and text\n");
            out.write("gap_x 10\n");
            out.write("gap_y 10\n");
            out.write("\n");

            /**
             * System Monitoring
             */
            out.write("# stuff after 'TEXT' will be formatted on screen\n");
            out.write("TEXT\n");
            out.write("$color\n");

            if (jCheckBox1.isSelected()) {
                out.write("${color " + titlecolor + "}SYSTEM ${hr 2}$color\n");
                out.write("${color " + textcolor + "}\n");

                if (hostnameYes) {
                    out.write("Hostname: $alignr$nodename\n");
                }

                if (kernelYes) {
                    out.write("Kernel: $alignr$kernel\n");
                }

                if (uptimeYes) {
                    out.write("Uptime: $alignr$uptime\n");
                }

                if (timeYes) {
                    out.write("Time: ${alignr}${time %I:%M%p}\n");
                }

                if (dateYes) {
                    out.write("Date: ${alignr}${exec date +\"%D\"}\n");
                }

                out.write("$color\n");
            }

            if (jCheckBox2.isSelected()) {
                out.write("\n");
                out.write("${color " + titlecolor + "}CPU ${hr 2}$color\n");
                out.write("${color " + textcolor + "}\n");

                if (cpuspeedYes) {
                    out.write("CPU Speed: $alignr${freq}MHz\n");
                }

                if (cpuloadYes) {
                    out.write("CPU Load: $alignr${loadavg}\n");
                }

                if (cpuusageYes) {
                    out.write("\n");
                    out.write("CPU Current Usage: $cpubar\n");
                    out.write("\n");
                }

                if (cpuprocYes) {
                    out.write("CPU Top " + jSpinner1.getValue().toString() + " Processes:\n");
                    if (jSpinner1.getValue().toString().equals("1")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("2")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("3")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("4")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("5")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("6")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("7")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                        out.write("${top name 7} $alignr ${top pid 7} ${top cpu 7}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("8")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                        out.write("${top name 7} $alignr ${top pid 7} ${top cpu 7}\n");
                        out.write("${top name 8} $alignr ${top pid 8} ${top cpu 8}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("9")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                        out.write("${top name 7} $alignr ${top pid 7} ${top cpu 7}\n");
                        out.write("${top name 8} $alignr ${top pid 8} ${top cpu 8}\n");
                        out.write("${top name 9} $alignr ${top pid 9} ${top cpu 9}\n");
                    }
                    if (jSpinner1.getValue().toString().equals("10")) {
                        out.write("${top name 1} $alignr ${top pid 1} ${top cpu 1}\n");
                        out.write("${top name 2} $alignr ${top pid 2} ${top cpu 2}\n");
                        out.write("${top name 3} $alignr ${top pid 3} ${top cpu 3}\n");
                        out.write("${top name 4} $alignr ${top pid 4} ${top cpu 4}\n");
                        out.write("${top name 5} $alignr ${top pid 5} ${top cpu 5}\n");
                        out.write("${top name 6} $alignr ${top pid 6} ${top cpu 6}\n");
                        out.write("${top name 7} $alignr ${top pid 7} ${top cpu 7}\n");
                        out.write("${top name 8} $alignr ${top pid 8} ${top cpu 8}\n");
                        out.write("${top name 9} $alignr ${top pid 9} ${top cpu 9}\n");
                        out.write("${top name 10} $alignr ${top pid 10} ${top cpu 10}\n");
                    }

                }

                if (cpuactYes) {
                    out.write("\n");
                    out.write("CPU Activity: ${cpugraph 000000 0000ff}\n");
                }

                out.write("$color\n");
            }

            if (jCheckBox3.isSelected()) {
                out.write("\n");
                out.write("${color " + titlecolor + "}MEMORY / DISK ${hr 2}$color\n");
                out.write("${color " + textcolor + "}\n");
                out.write("\n");

                if (ramYes) {
                    out.write("RAM Usage:   $memperc% Free   ${membar 6}\n");
                }

                if (homedirYes) {
                    out.write("Root Directory:  ${fs_free_perc /}% Free   ${fs_bar 6 /}$color\n");
                }

                out.write("$color\n");
            }

            if (jCheckBox4.isSelected()) {
                out.write("\n");
                out.write("${color " + titlecolor + "}NETWORK (${addr eth0}) ${hr 2}$color\n");
                out.write("${color " + textcolor + "}\n");

                if (publicipYes) {
                    out.write("Public IP: ${execi 1800 ~/.conkyscripts/publicip.sh}\n");
                }

                if (netusageYes) {
                    out.write("Down: ${downspeed eth0} k/s ${alignr}Up: ${upspeed eth0} k/s\n");
                    out.write("${downspeedgraph eth0 25,140 000000 ff0000} ${alignr}${upspeedgraph eth0 25,140 000000 00ff00}\n");
                    out.write("Total: ${totaldown eth0} ${alignr}Total: ${totalup eth0}\n");
                }

                if (netappYes) {
                    out.write("${execi 30 netstat -ept | grep ESTAB | awk '{print $9}' | cut -d: -f1 | sort | uniq -c | sort -nr}\n");
                }

                out.write("$color\n");
            }

            /**
             * Multimedia
             */
            if (jCheckBox6.isSelected()) {
                out.write("\n");
                out.write("${color #" + rgbTitle + "}BANSHEE ${hr 2}$color\n");
                out.write("${color #" + rgbText + "}\n");
                out.write("Status: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=ST}\n");

                if (bansheeartYes) {
                    out.write("Artist: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=AR}\n");
                }

                if (bansheealYes) {
                    out.write("Album: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=AL}\n");
                }

                if (bansheesoYes) {
                    out.write("Song: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=TI}\n");
                }

                if (bansheeposYes) {
                    out.write("Position: ${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=PT}/${exec python ~/.conkyscripts/banshee/conkyBanshee.py --datatype=LE}\n");
                }

                out.write("$color\n");
            }

            /**
             * Utilities
             */
            if (weatherYes) {
                out.write("$color\n");
                out.write("${color " + titlecolor + "}WEATHER ${hr 2}$color\n");
                out.write("${color " + textcolor + "}\n");
                out.write("${execi 1800 ~/.conkyscripts/weather.sh}\n");
                out.write("$color\n");

            }

            /**
             * Extra Bling!
             */
            if (fortunesYes) {
                out.write("$color\n");
                out.write("${color " + titlecolor + "}FORTUNE ${hr 2}$color\n");
                out.write("${color " + textcolor + "}\n");
                out.write("${execi 120 fortune -s | fold -w50}\n");
                out.write("$color\n");
            }

            out.flush();
            out.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println(
                    "This VM does not support the Latin-1 character set.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } //END OF A CATCH STATEMENT
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        buttonGroup15 = new javax.swing.ButtonGroup();
        buttonGroup16 = new javax.swing.ButtonGroup();
        buttonGroup17 = new javax.swing.ButtonGroup();
        buttonGroup18 = new javax.swing.ButtonGroup();
        buttonGroup19 = new javax.swing.ButtonGroup();
        buttonGroup20 = new javax.swing.ButtonGroup();
        buttonGroup21 = new javax.swing.ButtonGroup();
        buttonGroup22 = new javax.swing.ButtonGroup();
        buttonGroup23 = new javax.swing.ButtonGroup();
        buttonGroup24 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jRadioButton33 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jRadioButton35 = new javax.swing.JRadioButton();
        jRadioButton36 = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jRadioButton41 = new javax.swing.JRadioButton();
        jRadioButton42 = new javax.swing.JRadioButton();
        jRadioButton43 = new javax.swing.JRadioButton();
        jRadioButton44 = new javax.swing.JRadioButton();
        jRadioButton45 = new javax.swing.JRadioButton();
        jRadioButton46 = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton38 = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jRadioButton39 = new javax.swing.JRadioButton();
        jRadioButton40 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conky Script Builder");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jLabel1.setText("Choose a Font:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PT Sans", "Bitstream Charter", "DejaVu LGC Sans", "DejaVU Sans", "DejaVu Sans Mono", "DejaVu Serif", "Liberation Mono", "Liberation Sans", "Liberation Serif", "LKLUG", "Lohit Bengali", "Lohit Gujarati", "Lohit Telugu", "Nimbus Mono L", "Nimbus Sans L", "URW Bookman L", "Utopia", "VL Gothic", "Waree", "WenQuanYi Zen Hei Mono", "WenQuanYi Zen Hei Sharp", " " }));

        jLabel2.setText("Font Size:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "18", "20", "22", "24", "26", "28", "32", "36" }));

        jLabel3.setText("Align Text:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Top Left", "Top Right", "Bottom Left", "Bottom Right" }));

        jLabel4.setText("Window Transparent?");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Yes");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("No");
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });

        jLabel5.setText("Text in All Uppercase?");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Yes");
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton3ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setSelected(true);
        jRadioButton4.setText("No");
        jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton4ItemStateChanged(evt);
            }
        });

        jLabel6.setText("Title Color:");

        jButton2.setText("Choose Color");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Text Color:");

        jButton4.setText("Choose Color");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Set up how you want your Conky configuration to look.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(760, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jLabel6))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(451, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("Look & Feel", jScrollPane1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jLabel11.setText("What would like to monitor on your system?");

        jLabel12.setText("Hostname?");

        buttonGroup3.add(jRadioButton5);
        jRadioButton5.setText("Yes");
        jRadioButton5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton5ItemStateChanged(evt);
            }
        });

        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setSelected(true);
        jRadioButton6.setText("No");
        jRadioButton6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton6ItemStateChanged(evt);
            }
        });

        jLabel13.setText("Kernel Version?");

        buttonGroup4.add(jRadioButton7);
        jRadioButton7.setText("Yes");
        jRadioButton7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton7ItemStateChanged(evt);
            }
        });

        buttonGroup4.add(jRadioButton8);
        jRadioButton8.setSelected(true);
        jRadioButton8.setText("No");
        jRadioButton8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton8ItemStateChanged(evt);
            }
        });

        jLabel14.setText("How long the system has been running?");

        jLabel15.setText("Basic System Information?");

        buttonGroup5.add(jRadioButton9);
        jRadioButton9.setText("Yes");
        jRadioButton9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton9ItemStateChanged(evt);
            }
        });

        buttonGroup5.add(jRadioButton10);
        jRadioButton10.setSelected(true);
        jRadioButton10.setText("No");
        jRadioButton10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton10ItemStateChanged(evt);
            }
        });

        jLabel16.setText("Time?");

        buttonGroup6.add(jRadioButton11);
        jRadioButton11.setText("Yes");
        jRadioButton11.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton11ItemStateChanged(evt);
            }
        });

        buttonGroup6.add(jRadioButton12);
        jRadioButton12.setSelected(true);
        jRadioButton12.setText("No");
        jRadioButton12.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton12ItemStateChanged(evt);
            }
        });

        jLabel17.setText("Date?");

        buttonGroup7.add(jRadioButton13);
        jRadioButton13.setText("Yes");
        jRadioButton13.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton13ItemStateChanged(evt);
            }
        });

        buttonGroup7.add(jRadioButton14);
        jRadioButton14.setSelected(true);
        jRadioButton14.setText("No");
        jRadioButton14.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton14ItemStateChanged(evt);
            }
        });

        jLabel18.setText("CPU Information?");

        jLabel19.setText("CPU Speed?");

        buttonGroup8.add(jRadioButton15);
        jRadioButton15.setText("Yes");
        jRadioButton15.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton15ItemStateChanged(evt);
            }
        });

        buttonGroup8.add(jRadioButton16);
        jRadioButton16.setSelected(true);
        jRadioButton16.setText("No");
        jRadioButton16.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton16ItemStateChanged(evt);
            }
        });

        jLabel20.setText("CPU Load?");

        buttonGroup9.add(jRadioButton17);
        jRadioButton17.setText("Yes");
        jRadioButton17.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton17ItemStateChanged(evt);
            }
        });

        buttonGroup9.add(jRadioButton18);
        jRadioButton18.setSelected(true);
        jRadioButton18.setText("No");
        jRadioButton18.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton18ItemStateChanged(evt);
            }
        });

        jLabel21.setText("CPU Current Usage Bar?");

        buttonGroup10.add(jRadioButton19);
        jRadioButton19.setText("Yes");
        jRadioButton19.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton19ItemStateChanged(evt);
            }
        });

        buttonGroup10.add(jRadioButton20);
        jRadioButton20.setSelected(true);
        jRadioButton20.setText("No");
        jRadioButton20.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton20ItemStateChanged(evt);
            }
        });

        jLabel22.setText("CPU Top Processes?");

        buttonGroup11.add(jRadioButton21);
        jRadioButton21.setText("Yes");
        jRadioButton21.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton21ItemStateChanged(evt);
            }
        });

        buttonGroup11.add(jRadioButton22);
        jRadioButton22.setSelected(true);
        jRadioButton22.setText("No");
        jRadioButton22.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton22ItemStateChanged(evt);
            }
        });

        jLabel23.setText("How many?");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jLabel24.setText("CPU Activity Bar?");

        buttonGroup12.add(jRadioButton23);
        jRadioButton23.setText("Yes");
        jRadioButton23.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton23ItemStateChanged(evt);
            }
        });

        buttonGroup12.add(jRadioButton24);
        jRadioButton24.setSelected(true);
        jRadioButton24.setText("No");
        jRadioButton24.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton24ItemStateChanged(evt);
            }
        });

        jLabel25.setText("Memory & Disk Information?");

        jLabel26.setText("RAM Usage?");

        buttonGroup13.add(jRadioButton25);
        jRadioButton25.setText("Yes");
        jRadioButton25.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton25ItemStateChanged(evt);
            }
        });

        buttonGroup13.add(jRadioButton26);
        jRadioButton26.setSelected(true);
        jRadioButton26.setText("No");
        jRadioButton26.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton26ItemStateChanged(evt);
            }
        });

        jLabel27.setText("Monitor Root Directory Usage?");

        buttonGroup14.add(jRadioButton27);
        jRadioButton27.setText("Yes");
        jRadioButton27.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton27ItemStateChanged(evt);
            }
        });

        buttonGroup14.add(jRadioButton28);
        jRadioButton28.setSelected(true);
        jRadioButton28.setText("No");
        jRadioButton28.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton28ItemStateChanged(evt);
            }
        });

        jLabel28.setText("Network Information?");

        jLabel29.setText("Public IP Address?");

        buttonGroup15.add(jRadioButton29);
        jRadioButton29.setText("Yes");
        jRadioButton29.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton29ItemStateChanged(evt);
            }
        });

        buttonGroup15.add(jRadioButton30);
        jRadioButton30.setSelected(true);
        jRadioButton30.setText("No");
        jRadioButton30.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton30ItemStateChanged(evt);
            }
        });

        jLabel30.setText("Network Usage Graph?");

        buttonGroup16.add(jRadioButton31);
        jRadioButton31.setText("Yes");
        jRadioButton31.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton31ItemStateChanged(evt);
            }
        });

        buttonGroup16.add(jRadioButton32);
        jRadioButton32.setSelected(true);
        jRadioButton32.setText("No");
        jRadioButton32.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton32ItemStateChanged(evt);
            }
        });

        jLabel31.setText("Applications Using the Network?");

        buttonGroup17.add(jRadioButton33);
        jRadioButton33.setText("Yes");
        jRadioButton33.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton33ItemStateChanged(evt);
            }
        });

        buttonGroup17.add(jRadioButton34);
        jRadioButton34.setSelected(true);
        jRadioButton34.setText("No");
        jRadioButton34.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton34ItemStateChanged(evt);
            }
        });

        jCheckBox1.setText("Include");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jCheckBox2.setText("Include");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });

        jCheckBox3.setText("Include");
        jCheckBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox3ItemStateChanged(evt);
            }
        });

        jCheckBox4.setText("Include");
        jCheckBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox4ItemStateChanged(evt);
            }
        });

        jLabel35.setText("If you are running Red Hat 6/Fedora 15 or higher check this box:");

        jCheckBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox5ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1175, Short.MAX_VALUE)
                                .addComponent(jSeparator4)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton6))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton8))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(14, 14, 14)
                                            .addComponent(jRadioButton9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton10))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox1))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton12))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jRadioButton14)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton16))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton18))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton20))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addGap(2, 2, 2)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(jRadioButton22))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton24))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton26))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton28))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox4))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox5))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton30))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton32))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton34)))))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jCheckBox2))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jRadioButton15)
                    .addComponent(jRadioButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jRadioButton17)
                    .addComponent(jRadioButton18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jRadioButton19)
                    .addComponent(jRadioButton20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jRadioButton21)
                    .addComponent(jLabel23)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jRadioButton23)
                    .addComponent(jRadioButton24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jRadioButton25)
                    .addComponent(jRadioButton26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jRadioButton27)
                    .addComponent(jRadioButton28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jCheckBox4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel35))
                    .addComponent(jCheckBox5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton29)
                    .addComponent(jRadioButton30)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jRadioButton31)
                    .addComponent(jRadioButton32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jRadioButton33)
                    .addComponent(jRadioButton34))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        jTabbedPane1.addTab("System Monitoring", jScrollPane2);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel32.setText("Banshee Information:");

        jLabel39.setText("Position?");

        jCheckBox6.setText("Include");
        jCheckBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox6ItemStateChanged(evt);
            }
        });

        buttonGroup21.add(jRadioButton35);
        jRadioButton35.setText("Yes");
        jRadioButton35.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton35ItemStateChanged(evt);
            }
        });

        buttonGroup21.add(jRadioButton36);
        jRadioButton36.setText("No");
        jRadioButton36.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton36ItemStateChanged(evt);
            }
        });

        jLabel38.setText("Artist?");

        jLabel40.setText("Album?");

        jLabel41.setText("Song?");

        buttonGroup22.add(jRadioButton41);
        jRadioButton41.setText("Yes");
        jRadioButton41.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton41ItemStateChanged(evt);
            }
        });

        buttonGroup22.add(jRadioButton42);
        jRadioButton42.setText("No");
        jRadioButton42.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton42ItemStateChanged(evt);
            }
        });

        buttonGroup23.add(jRadioButton43);
        jRadioButton43.setText("Yes");
        jRadioButton43.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton43ItemStateChanged(evt);
            }
        });

        buttonGroup23.add(jRadioButton44);
        jRadioButton44.setText("No");
        jRadioButton44.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton44ItemStateChanged(evt);
            }
        });

        buttonGroup24.add(jRadioButton45);
        jRadioButton45.setText("Yes");
        jRadioButton45.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton45ItemStateChanged(evt);
            }
        });

        buttonGroup24.add(jRadioButton46);
        jRadioButton46.setText("No");
        jRadioButton46.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton46ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton36))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton42))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton44))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton46)))
                .addContainerGap(653, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jRadioButton41)
                    .addComponent(jRadioButton42))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jRadioButton43)
                    .addComponent(jRadioButton44))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jRadioButton45)
                    .addComponent(jRadioButton46))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jRadioButton35)
                    .addComponent(jRadioButton36))
                .addContainerGap(561, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        jTabbedPane1.addTab("Multimedia", jScrollPane3);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel33.setText("Would like to inlude your weather forecast?");

        buttonGroup19.add(jRadioButton37);
        jRadioButton37.setText("Yes");
        jRadioButton37.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton37ItemStateChanged(evt);
            }
        });

        buttonGroup19.add(jRadioButton38);
        jRadioButton38.setSelected(true);
        jRadioButton38.setText("No");
        jRadioButton38.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton38ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton38)
                .addContainerGap(850, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jRadioButton37)
                    .addComponent(jRadioButton38))
                .addContainerGap(683, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel4);

        jTabbedPane1.addTab("Utilities", jScrollPane4);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel34.setText("Would like to see some funny fortunes?");

        buttonGroup20.add(jRadioButton39);
        jRadioButton39.setText("Yes");
        jRadioButton39.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton39ItemStateChanged(evt);
            }
        });

        buttonGroup20.add(jRadioButton40);
        jRadioButton40.setSelected(true);
        jRadioButton40.setText("No");
        jRadioButton40.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton40ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton40)
                .addContainerGap(850, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jRadioButton39)
                    .addComponent(jRadioButton40))
                .addContainerGap(683, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel5);

        jTabbedPane1.addTab("Extra Bling!", jScrollPane5);

        jButton1.setText("Quick Save & Reload Conky");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel36.setText("Current Project File:");

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("New Project");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Open Project");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Save Project");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Reload Conky Project");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator1);

        jMenu4.setText("Quick Conky");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Quick Save/Reload Conky");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Backup Conky");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Restore Conky");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenu1.add(jMenu4);
        jMenu1.add(jSeparator2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Exit");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Support");

        jMenuItem8.setText("Prerequisites");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Help");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton3});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        About();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Exit();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Exit();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TitleColor();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TextColor();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
        /**
         * Fires event that state has changed
         */
        uppercaseYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton3ItemStateChanged

    private void jRadioButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton4ItemStateChanged
        /**
         * Fires event that state has changed
         */
        uppercaseNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton4ItemStateChanged

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        /**
         * Fires event that state has changed
         */
        transparentYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
        /**
         * Fires event that state has changed
         */
        transparentNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void jRadioButton5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton5ItemStateChanged
        /**
         * Fires event that state has changed
         */
        hostnameYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton5ItemStateChanged

    private void jRadioButton6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton6ItemStateChanged
        /**
         * Fires event that state has changed
         */
        hostnameNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton6ItemStateChanged

    private void jRadioButton7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton7ItemStateChanged
        /**
         * Fires event that state has changed
         */
        kernelYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton7ItemStateChanged

    private void jRadioButton8ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton8ItemStateChanged
        /**
         * Fires event that state has changed
         */
        kernelNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton8ItemStateChanged

    private void jRadioButton9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton9ItemStateChanged
        /**
         * Fires event that state has changed
         */
        uptimeYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton9ItemStateChanged

    private void jRadioButton10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton10ItemStateChanged
        /**
         * Fires event that state has changed
         */
        uptimeNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton10ItemStateChanged

    private void jRadioButton11ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton11ItemStateChanged
        /**
         * Fires event that state has changed
         */
        timeYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton11ItemStateChanged

    private void jRadioButton12ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton12ItemStateChanged
        /**
         * Fires event that state has changed
         */
        timeNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton12ItemStateChanged

    private void jRadioButton13ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton13ItemStateChanged
        /**
         * Fires event that state has changed
         */
        dateYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton13ItemStateChanged

    private void jRadioButton14ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton14ItemStateChanged
        /**
         * Fires event that state has changed
         */
        dateNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton14ItemStateChanged

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        /**
         * Fires event that state has changed
         */
        basicinfo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuinfo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jCheckBox2ItemStateChanged

    private void jCheckBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox3ItemStateChanged
        /**
         * Fires event that state has changed
         */
        memdiskinfo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jCheckBox3ItemStateChanged

    private void jCheckBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox4ItemStateChanged
        /**
         * Fires event that state has changed
         */
        netinfo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jCheckBox4ItemStateChanged

    private void jRadioButton15ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton15ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuspeedYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton15ItemStateChanged

    private void jRadioButton16ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton16ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuspeedNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton16ItemStateChanged

    private void jRadioButton17ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton17ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuloadYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton17ItemStateChanged

    private void jRadioButton18ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton18ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuloadNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton18ItemStateChanged

    private void jRadioButton19ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton19ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuusageYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton19ItemStateChanged

    private void jRadioButton20ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton20ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuusageNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton20ItemStateChanged

    private void jRadioButton21ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton21ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuprocYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton21ItemStateChanged

    private void jRadioButton22ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton22ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuprocNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton22ItemStateChanged

    private void jRadioButton23ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton23ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuactYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton23ItemStateChanged

    private void jRadioButton24ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton24ItemStateChanged
        /**
         * Fires event that state has changed
         */
        cpuactNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton24ItemStateChanged

    private void jRadioButton25ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton25ItemStateChanged
        /**
         * Fires event that state has changed
         */
        ramYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton25ItemStateChanged

    private void jRadioButton26ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton26ItemStateChanged
        /**
         * Fires event that state has changed
         */
        ramNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton26ItemStateChanged

    private void jRadioButton27ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton27ItemStateChanged
        /**
         * Fires event that state has changed
         */
        homedirYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton27ItemStateChanged

    private void jRadioButton28ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton28ItemStateChanged
        /**
         * Fires event that state has changed
         */
        homedirNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton28ItemStateChanged

    private void jRadioButton29ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton29ItemStateChanged
        /**
         * Fires event that state has changed
         */
        publicipYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton29ItemStateChanged

    private void jRadioButton30ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton30ItemStateChanged
        /**
         * Fires event that state has changed
         */
        publicipNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton30ItemStateChanged

    private void jRadioButton31ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton31ItemStateChanged
        /**
         * Fires event that state has changed
         */
        netusageYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton31ItemStateChanged

    private void jRadioButton32ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton32ItemStateChanged
        /**
         * Fires event that state has changed
         */
        netusageNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton32ItemStateChanged

    private void jRadioButton33ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton33ItemStateChanged
        /**
         * Fires event that state has changed
         */
        netappYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton33ItemStateChanged

    private void jRadioButton34ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton34ItemStateChanged
        /**
         * Fires event that state has changed
         */
        netappNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton34ItemStateChanged

    private void jRadioButton37ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton37ItemStateChanged
        /**
         * Fires event that state has changed
         */
        weatherYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton37ItemStateChanged

    private void jRadioButton38ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton38ItemStateChanged
        /**
         * Fires event that state has changed
         */
        weatherNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton38ItemStateChanged

    private void jRadioButton39ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton39ItemStateChanged
        /**
         * Fires event that state has changed
         */
        fortunesYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton39ItemStateChanged

    private void jRadioButton40ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton40ItemStateChanged
        /**
         * Fires event that state has changed
         */
        fortunesNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton40ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        WriteFile();
        ReloadConky();
        if (jCheckBox5.isSelected()) {
            ChangeNet();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        WriteFile();
        ReloadConky();
        if (jCheckBox5.isSelected()) {
            ChangeNet();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jCheckBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox5ItemStateChanged
        /**
         * Fires event that state has changed
         */
        redhatfedora = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jCheckBox5ItemStateChanged

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Prereq();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        BackupConky();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        RestoreConky();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        NewProject();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        SaveProject();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        OpenProject();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        WriteFile2();
        ReloadConky();
        if (jCheckBox5.isSelected()) {
            ChangeNet();
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jCheckBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox6ItemStateChanged
        /**
         * Fires event that state has changed
         */
        banshee = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jCheckBox6ItemStateChanged

    private void jRadioButton35ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton35ItemStateChanged
        /**
         * Fires event that state has changed
         */
        bansheeposYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton35ItemStateChanged

    private void jRadioButton36ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton36ItemStateChanged
        /**
         * Fires event that state has changed
         */
        bansheeposNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton36ItemStateChanged

    private void jRadioButton41ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton41ItemStateChanged
        /**
         * Fires event that state has changed
         */
        bansheeartYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton41ItemStateChanged

    private void jRadioButton42ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton42ItemStateChanged
        /**
         * Fires event that state has changed
         */
        bansheeartNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton42ItemStateChanged

    private void jRadioButton43ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton43ItemStateChanged
        /**
         * Fires event that state has changed
         */
        bansheealYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton43ItemStateChanged

    private void jRadioButton44ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton44ItemStateChanged
        /**
         * Fires event that state has changed
         */
        bansheealNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton44ItemStateChanged

    private void jRadioButton45ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton45ItemStateChanged
        /**
         * Fires event that state has changed
         */
        bansheesoYes = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton45ItemStateChanged

    private void jRadioButton46ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton46ItemStateChanged
        /**
         * Fires event that state has changed
         */
        bansheesoNo = (evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_jRadioButton46ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup15;
    private javax.swing.ButtonGroup buttonGroup16;
    private javax.swing.ButtonGroup buttonGroup17;
    private javax.swing.ButtonGroup buttonGroup18;
    private javax.swing.ButtonGroup buttonGroup19;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup20;
    private javax.swing.ButtonGroup buttonGroup21;
    private javax.swing.ButtonGroup buttonGroup22;
    private javax.swing.ButtonGroup buttonGroup23;
    private javax.swing.ButtonGroup buttonGroup24;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JRadioButton jRadioButton39;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton40;
    private javax.swing.JRadioButton jRadioButton41;
    private javax.swing.JRadioButton jRadioButton42;
    private javax.swing.JRadioButton jRadioButton43;
    private javax.swing.JRadioButton jRadioButton44;
    private javax.swing.JRadioButton jRadioButton45;
    private javax.swing.JRadioButton jRadioButton46;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}