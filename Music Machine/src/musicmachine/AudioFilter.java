package musicmachine;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class AudioFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()){
            return true;
        }
        String extension = Utils.getExtension(f);
        if (extension != null){
            if ((extension.equals(Utils.mp3))) 
            {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String getDescription() {
        return "mp3";
    }

    static class Utils {
        public final static String mp3 = "mp3";

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