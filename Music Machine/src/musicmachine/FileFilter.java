package musicmachine;

import java.io.File;

class FileFilter extends javax.swing.filechooser.FileFilter {
    @Override
    public boolean accept(File f) {
        return f.getName ().toLowerCase ().endsWith (".txt") || f.isDirectory ();
    }

    @Override
    public String getDescription() {
        return "Text Files (*.txt)";
    }   
}