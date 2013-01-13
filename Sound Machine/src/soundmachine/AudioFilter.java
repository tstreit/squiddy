/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundmachine;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author tstreit
 */
public class AudioFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()){
            return true;
        }
        String extension = Utils.getExtension(f);
        if (extension != null){
            if ((extension.equals(Utils.wav))) 
            {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "wav";
    }

    static class Utils {
        public final static String wav = "wav";

        public static String getExtension(File f){
            String ext = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');
            if (i > 0 && i < s.length() - 1){
                ext = s.substring(i+1).toLowerCase();
            }
            return ext;
        }
    }
}