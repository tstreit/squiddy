/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundmachine;

import java.io.File;

/**
 *
 * @author tstreit
 */
class FileFilter extends javax.swing.filechooser.FileFilter {
    @Override
    public boolean accept(File f) {
        return f.getName ().toLowerCase ().endsWith (".xml") || f.isDirectory ();
    }

    @Override
    public String getDescription() {
        return "XML files (*.xml)";
    }   
}