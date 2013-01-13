/*  Mephisto Backup
Copyright (C) October 9th, 2008  Phillip Tribble
 *
This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String javaHome = System.getProperty("user.home");
        Scanner input = new Scanner(System.in);
        int seekcounter = 0;
        int spacecounter = 0;
        int arraycounter = 0;
        int linecounter = 0;
        String seek;
        String seek2;
        String Name = null;
        String Restorepath = null;
        String Backuplocation = null;
        String Excludes = null;
        String[] config = new String[1000];
        config[0] = "Name";
        config[1] = "Restorepath";
        config[2] = "Backuplocation";
        config[3] = "Excludes";
        linecounter = 0;
        String[] answers = new String[1000];
        String[] answers2 = new String[1000];
        //////////////////////////////////////////////////////////////////    
        String menu1 = ("----------------------------------------");
        String menu2 = ("     Mephisto Backup Beta Release 1.0B");
        String menu3 = ("  Copyright 2008; Licensed under the GPL");
        String menu4 = ("----------------------------------------");
        String menu5 = ("Release Notes: Functional, enjoy! Needs Beta Testing");
        String menu6 = ("----------------------------------------");
        String menu7 = ("               Main Menu");
        String menu8 = ("----------------------------------------");
        String menu9 = ("(1) Load previous filesystem backup.");
        String menu10 = ("(2) Create new file system backup.");
        String menu11 = ("(3) File System Restore.");
        String menu12 = ("(4) Home directory backup.");
        String menu13 = ("(5) Configuration Editor");  //Features not started yet
        String menu14 = ("(6) Quit.");  //Features not started yet
        String Mainmenu = (menu1 + "\n" + menu2 + "\n" + menu3 + "\n" + menu4 + "\n" + menu5 + "\n" + menu6 + "\n" + menu7 + "\n" + menu8 + "\n" + menu9 + "\n" + menu10 + "\n" + menu11 + "\n" + menu12 + "\n" + menu13 + "\n" + menu14 + "\n" + "\n");
        String halfmenu = (menu1 + "\n" + menu2 + "\n" + menu3 + "\n" + menu4 + "\n" + "\n");
        String changechoice = null;
        String therest = null;
        String new1 = null;
        String s = null;
        String scan = null;
        String backuplocation = null;
        String find_excluded_directory = null;
        String finalpart = null;
        String newstring = null;
        String cchoice1 = null;
        String config_file = (javaHome + "/.mephisto_config");
        String config_file_tmp = (javaHome + "/.mephisto_tmp");
        String restorelocation = null;
        String originalinput = null;
        String Destination = null;
        String excludestatement = "--exclude=";
        String changename = null;
        int test1 = 0;
        int test2 = 0;
        String backupname = null;
        int newstringlength;
        int originallength = 0;
        int cchoicelength = 0;
        int appcounter = 0;
        int appcounter2 = 0;
        int findlength = 0;
        int changenamelength = 0;
        int newlength = 0;
        int i = 0;
        int counter = 0;
        int menucounter = 0;
        double choice = 0;
        String filetype_exclude1 = null;
        String filetype_exclude3 = null;
        String filetype_exclude5 = null;
        String filetype_exclude4 = null;
        String filetype_exclude2 = null;
        //GENERATES THE CONFIG FILE 
        try {
            FileWriter createfile = new FileWriter(config_file, true);
            BufferedWriter brrconfig = new BufferedWriter(createfile);
            String empty = " ";
            brrconfig.write(empty);
            brrconfig.close();
        } catch (Exception ee) {  //END OF TRY
        }  //END OF CATCH
        //END GENERATE THE CONFIG FILE  
        try {
            FileWriter createfile = new FileWriter(config_file_tmp);
            BufferedWriter brrconfig = new BufferedWriter(createfile);
            String empty = " ";
            brrconfig.write(empty);
            brrconfig.close();
        } catch (Exception ee) {  //END OF TRY
        }  //END OF CATCH
        Process a = Runtime.getRuntime().exec("chmod 777 " + javaHome + config_file);
        Process b = Runtime.getRuntime().exec("chmod 777 " + javaHome + config_file_tmp);

        String exclude;
        String stop = null;
        int arraycounter2;
        //END GENERATE THE CONFIG FILE  
        while (menucounter < 100) {         //Loop for the main menu
            appcounter = 0;
            while (appcounter < 100) {
                System.out.print("\n");
                appcounter = appcounter + 1;
            }
            System.out.print("\n");
            menucounter = menucounter + 1;
            System.out.print(Mainmenu);
            System.out.print("Your Choice: ");
            System.out.print("\n");
            choice = input.nextDouble();
            if (choice < 0) {    //ERROR CATCHING IF STATEMENT
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                do {
                    System.out.print(Mainmenu);
                    System.out.print("Error: Invalid Selection!");
                    System.out.print("\n" + "Your Choice: ");
                    choice = input.nextDouble();
                } while (choice < 0);
            }
            if (choice > 6) { //ERROR CATCHING IF STATEMENT
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                do {
                    System.out.print(Mainmenu);
                    System.out.print("Error: Invalid Selection!");
                    System.out.print("\n" + "Your Choice: ");
                    choice = input.nextDouble();
                } while (choice > 5);
            }
            if (choice == 6) {
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n" + "\n" + "Thank you for using Mephisto Backup!" + "\n");
                System.exit(1);
            }
            //DRAWS MAIN MENU
            appcounter = 0;
            while (appcounter < 100) {
                System.out.print("\n");
                appcounter = appcounter + 1;
            }
            System.out.print(halfmenu);
            //END DRAW MAIN MENU

            if (choice == 1) {   //MENU ITEM 1 BEGINS
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                FileReader seekfile = new FileReader(config_file);
                BufferedReader seekbr = new BufferedReader(seekfile);
                linecounter = linecounter + 1;
                System.out.print("\n" + "Saved configurations:" + "\n");
                System.out.print("\n");
                arraycounter = -1;
                while ((seek = seekbr.readLine()) != null) {

                    if (seek.contains("Name=")) {
                        arraycounter++;
                        answers[arraycounter] = seek;
                        String[] diablo = seek.split("=");
                        answers2[arraycounter] = diablo[1];
                        System.out.print(answers2[arraycounter] + "\n");
                    }
                    if (seek.contains("Restorepath=")) {
                        arraycounter++;
                        answers[arraycounter] = seek;
                        String[] diablo = seek.split("=");
                        answers2[arraycounter] = diablo[1];
                    }

                    if (seek.contains("Backuplocation=")) {
                        arraycounter++;
                        answers[arraycounter] = seek;
                        String[] diablo = seek.split("=");
                        answers2[arraycounter] = diablo[1];

                    }
                    if (seek.contains("Excludes=")) {
                        arraycounter++;
                        answers[arraycounter] = seek;
                        String[] diablo = seek.split("=");
                        answers2[arraycounter] = diablo[1];
                        // break;
                        arraycounter = arraycounter + 1;
                    }

                    linecounter = linecounter + 1;
                }

                System.out.print("\n" + "Which configuration would you like to load? Only type in the name. \n");
                System.out.print("Press ! followed by enter to quit: ");
                Name = input.next();
                if (Name.contains("!")) {
                    appcounter = 0;
                    while (appcounter < 100) {
                        System.out.print("\n");
                        appcounter = appcounter + 1;
                    }
                    System.out.print(halfmenu);
                    System.out.print("\n" + "\n" + "Thank you for using Mephisto Backup!" + "\n");
                    System.exit(1);
                } else {
                    int proceede = 0;
                    seekcounter = 0;
                    arraycounter = 1;
                    FileReader seekagain = new FileReader(config_file);
                    BufferedReader brrseek = new BufferedReader(seekagain);
                    String scanarray;
                    arraycounter = -1;
                    linecounter = 0;
                    while ((seek2 = brrseek.readLine()) != null) {
                        if (seek2.contains(Name)) {
                            Name = answers2[arraycounter];
                            arraycounter = arraycounter + 1;
                            Restorepath = answers2[arraycounter];
                            arraycounter = arraycounter + 1;
                            Backuplocation = answers2[arraycounter];
                            arraycounter = arraycounter + 1;
                            Excludes = answers2[arraycounter];
                            linecounter = linecounter + 1;
                            proceede = 1;
                            break;
                        }
                        arraycounter++;
                    }
                    if (proceede == 0) {
                        appcounter = 0;
                        while (appcounter < 100) {
                            System.out.print("\n");
                            appcounter = appcounter + 1;
                        }
                        System.out.print(halfmenu);
                        System.out.print("Error: Invalid selection!");
                        System.exit(-1);
                    }
                    appcounter = 0;
                    while (appcounter < 100) {
                        System.out.print("\n");
                        appcounter = appcounter + 1;
                    }
                    System.out.print(halfmenu);
                    System.out.print("\n");
                    System.out.print("\n" + "Would you like to `run` , `edit` , or `restore` the configuration: " + Name + "\n");
                    System.out.print("\n");
                    String editorrun = input.next();

                    if (editorrun.contains("restore")) {
                        appcounter = 0;
                        while (appcounter < 100) {
                            System.out.print("\n");
                            appcounter = appcounter + 1;
                        }
                        System.out.print(halfmenu);
                        System.out.print("\n");
                        System.out.print("\n" + "Running restore..." + "\n");
                        finalpart = ("tar xpf " + Backuplocation + Name + ".tar " + Restorepath);
                        s = null;
                        try {
                            Process p = Runtime.getRuntime().exec(finalpart);
                            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                            System.out.println("\n" + "System Output:\n" + "\n");
                            while ((s = stdInput.readLine()) != null) {
                                System.out.println(s);
                            } //END OF A WHILE STATEMENT

                            System.out.print("\n" + "Restore operation complete!" + "\n");
                        } catch (IOException e) {
                            System.out.println("exception happened : ");
                            e.printStackTrace();
                        } //END OF A CATCH STATEMENT
                        appcounter = 0;
                        while (appcounter < 999999999) {
                            appcounter = appcounter + 1;
                        }
                    }
                    if (editorrun.contains("run")) {
                        appcounter = 0;
                        while (appcounter < 100) {
                            System.out.print("\n");
                            appcounter = appcounter + 1;
                        }
                        System.out.print(halfmenu);
                        System.out.print("\n");
                        System.out.print("\n" + "Running Backup configuration: " + Name);
                        finalpart = ("tar cpf " + Backuplocation + Name + ".tar " + "--exclude=*.deb --exclude=*.rpm --exclude=/sys/* " + "--exclude=/proc/* --exclude=/dev/* --exclude=/mnt/* --exclude=/media/* --exclude=/home/* " + "--exclude=" + Excludes + " --exclude=" + Name + ".tar" + " /");
                        s = null;
                        try {
                            Process p = Runtime.getRuntime().exec(finalpart);
                            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                            System.out.println("\n" + "System Output:\n" + "\n");
                            while ((s = stdInput.readLine()) != null) {
                                System.out.println(s);
                            } //END OF A WHILE STATEMENT
                        } catch (IOException e) {
                            System.out.println("exception happened : ");
                            e.printStackTrace();
                        } //END OF A CATCH STATEMENT
                        System.out.print("\n" + "Backup operation complete!" + "\n");
                        appcounter = 0;
                        while (appcounter < 999999999) {
                            appcounter = appcounter + 1;
                        }

                    }
                }
            }

            if (choice == 3) {   //BEGINS MENU ITEM 3
                int menucounter5 = 0;
                while (menucounter5 < 100) {
                    System.out.print("\n");
                    menucounter5 =
                            menucounter5 + 1;
                }
                System.out.print(halfmenu);
                String utar;

                System.out.print("Restore File Name: ");
                String restore = input.next();
                System.out.print("Restore folder:");
                String restorefolder = input.next();
                utar = "tar xpf " + restorefolder + restore + " /";
                System.out.print("Type ! to start the restore. Press any key followed by enter to exit: ");
                String cc = input.next();
                if (cc.equals("!")) {
                    s = null;
                    try {

                        Process p = Runtime.getRuntime().exec(utar);

                        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                        // read the output from the command
                        System.out.println("Output:\n");
                        while ((s = stdInput.readLine()) != null) {
                            System.out.println(s);
                        } //END OF A WHILE STATEMENT
// read any errors from the attempted command
                        System.out.println("Errors: (if any):\n");
                        while ((s = stdError.readLine()) != null) {
                            System.out.println(s);
                        } //END OF A WHILE STATEMENT.

                        System.exit(0);
                    } catch (IOException e) {
                        System.out.println("exception happened : ");
                        e.printStackTrace();
                    //System.exit(-1);
                    } //END OF A CATCH STATEMENT

                    Process p = Runtime.getRuntime().exec(utar);
                }  //END OF AN IF STATEMENT

            }     //END OF MENU ITEM 3
            if (choice == 2) {   //BEGINNING OF ITEM MENU 2
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("Please type a name for this backup. ");
                System.out.print("Press ! followed by enter to quit:  ");
                String name = input.next();
                if (name.equals("!")) {
                    System.exit(-1);
                }
                System.out.print("\n");
                System.out.print("Where would you like to store this backup? (Must have the / at the end) " + "\n" + "Example: /tmp/");
                System.out.print("\n");
                System.out.print("\n" + "Backup Location: ");
                backuplocation = input.next();
                System.out.print("\n");
                System.out.print("\n");
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n");
                System.out.print("Now it is time to tell the system what to backup." + "\n" + "\n" + "Where would you like to restore this backup to?" + "\n" + "\n" + " Example: type / to restore this filesystem to this computer." + "\n" + "Otherwise specify a mount point for another medium." + "\n" + "\n" + "(This is only for the config file to use in the future)");

                System.out.print("\n");
                System.out.print("\n" + "Restore Location: ");
                restorelocation = input.next();
                System.out.print("\n");
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n");
                System.out.print("The following directories are automatically excluded: /home /sys /proc /dev /mnt /media\n");
                System.out.print("\n");
                System.out.print("Directory to exclude: (Type none for none.): ");
                exclude = input.next();
                String eexclude = "--exclude=";
                String tar;
                tar = ("tar cfp " + backuplocation + name + ".tar " + "--exclude=*.deb --exclude=*.rpm --exclude=/sys/* " + "--exclude=/proc/* --exclude=/dev/* --exclude=/mnt/* --exclude=/media/* --exclude=/home/* " + eexclude + name + ".tar " + eexclude + exclude + " /");
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                //  System.out.print("\n");
                System.out.print("Type ! to start the backup . Press any key followed by enter to just save the configuration: ");
                String c = input.next();

                if (c.equals("!")) {
                    appcounter = 0;
                    while (appcounter < 100) {
                        System.out.print("\n");
                        appcounter = appcounter + 1;
                    }
                    System.out.print(halfmenu);
                    System.out.print("Backup up system...................." + "\n");
                    try {
                        Process p = Runtime.getRuntime().exec(tar);
                        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                        // read the output from the command
                        System.out.print("\n");
                        System.out.println("Output:\n");
                        while ((s = stdInput.readLine()) != null) {
                            System.out.println(s);
                        }
// read any errors from the attempted command
                        System.out.println("Errors: (if any):\n");
                        while ((s = stdError.readLine()) != null) {
                            System.out.println(s);
                        }
                    } catch (IOException e) {
                        System.out.println("exception happened : ");
                        e.printStackTrace();
                    // System.exit(-1);
                    } //END OF CATCH STATEMENT
                } //END OF IF STATEMENT
                //Inster code to save config file
                System.out.print("\n");
                appcounter = 0;
                while (appcounter < 999999) {
                    appcounter = appcounter + 1;
                }
                appcounter = 0;
                while (appcounter < 99) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("Would you like to save this configuration?\n");
                System.out.print("\n");
                System.out.print("Configuration will be saved to: " + config_file + " \n:");
                String save = input.next();
                if (save.equals("n")) {
                    System.out.print("\n" + "\n" + "Thank you for using Mephisto Backup!" + "\n");
                    System.exit(-1);
                } else if (save.equals("y")) {
                    //FOLLOWING STATEMENT SAVES THE CONFIGURATION FILE
                    FileWriter out = new FileWriter(config_file, true);
                    BufferedWriter brout = new BufferedWriter(out);
                    String finall = ("\n" + "Name=" + name + "\n" + "Restorepath=" + restorelocation + "\n" + "Backuplocation=" + backuplocation + "\n" + "Excludes=" + exclude + "\n");
                    brout.write(finall);
                    brout.close();
                    System.out.print("Configuration Save.....");
                    appcounter = 0;
                    while (appcounter < 999999999) {
                        appcounter = appcounter + 1 - 5;
                    }
                }
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n" + "\n" + "Thank you for using Mephisto Backup!" + "\n");
                System.exit(-1);
            }                                   //MENU ITEM 2 ENDS HERE
            i = i + 1;                          // ADDS 1 TO THE MAIN MENU COUNTER

            if (choice == 4) {
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n");
                System.out.print("Home directory backup supports up to 5 file extensions to exclude.");
                System.out.print("\n");
                System.out.print("\n");
                System.out.print("Would you like to exclude any filetypes?" + "\n" + "If so, type `yes` followed by enter." + "\n" + "Type `no` followed by enter to not exlude a file: ");
                // System.out.print("\n");
                String anyexcludes = input.next();
                String none = "no";
                if (anyexcludes.contains("yes")) {
                    do {
                        System.out.print("\n");
                        System.out.print("1st filetype to exclude (Type none for none): ");
                        filetype_exclude1 = input.next();
                        System.out.print("\n");
                        System.out.print("2nd filetype to exclude (Type none for none): ");
                        filetype_exclude2 = input.next();
                        System.out.print("\n");
                        System.out.print("3rd filetype to exclude (Type none for none): ");
                        filetype_exclude3 = input.next();
                        System.out.print("\n");
                        System.out.print("4th filetype to exclude (Type none for none): ");
                        filetype_exclude4 = input.next();
                        System.out.print("\n");
                        System.out.print("5th filetype to exclude (Type none for none): ");
                        filetype_exclude5 = input.next();
                        System.out.print("\n");
                        anyexcludes = "jibbajabba";
                    } while (anyexcludes.contains("yes"));
                }
                System.out.print("\n");
                System.out.print("Home directory to backup (No need to type /home/) : ");
                String homedestination = input.next();
                System.out.print("\n");
                System.out.print("Backup Name: ");
                String homebackupname = input.next();
                System.out.print("\n");
                System.out.print("Where to store the backup file (must include the / at the end.): ");

                String homebackuplocation = input.next();
                if (anyexcludes.contains("n")) {
                    filetype_exclude5 = "";
                    filetype_exclude4 = "";
                    filetype_exclude3 = "";
                    filetype_exclude2 = "";
                    filetype_exclude1 = "";
                    excludestatement = "";
                }
                if (filetype_exclude5.contains("n")) {
                    filetype_exclude5 = "";
                    excludestatement = "";
                }
                if (filetype_exclude4.contains("n")) {
                    filetype_exclude4 = "";
                    excludestatement = "";
                }
                if (filetype_exclude3.contains("n")) {
                    filetype_exclude3 = "";
                    excludestatement = "";
                }
                if (filetype_exclude2.contains("n")) {
                    filetype_exclude2 = "";
                    excludestatement = "";
                }
                if (filetype_exclude1.contains("n")) {
                    filetype_exclude1 = "";
                    excludestatement = "";
                }

                String homebackup = ("tar cpf " + homebackuplocation + homebackupname + ".tar" + " " + excludestatement + homebackupname + ".tar" + excludestatement + filetype_exclude1 + " " + excludestatement + filetype_exclude2 + " " + excludestatement + filetype_exclude3 + excludestatement + filetype_exclude4 + excludestatement + filetype_exclude5 + " " + "/home/" + homedestination);
                System.out.print("homebackup");
                s = null;
                while (appcounter < 400) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n");
                System.out.print("Backing up " + "/home/" + homedestination + " !");
                System.out.print("\n");
                try {
                    Process p = Runtime.getRuntime().exec(homebackup);
                    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    System.out.println("\n" + "System Output:\n" + "\n");
                    while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    } //END OF A WHILE STATEMENT
                    System.exit(-1);
                } catch (IOException e) {
                    System.out.println("exception happened : ");
                    e.printStackTrace();
                } //END OF A CATCH STATEMENT
                appcounter = 0;
                while (appcounter < 400) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n");
                System.out.print("Backup Complete!");
                System.out.print("\n");
                System.out.print("\n");
                System.exit(-1);
            }
            if (choice == 5) {
                appcounter = 0;
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n");
                String editorr;
                String editorrwriter;
                FileReader editorreader = new FileReader(config_file);
                BufferedReader buffereditor = new BufferedReader(editorreader);

                FileWriter editorwriter = new FileWriter(config_file_tmp);
                BufferedWriter buffereditorWriter = new BufferedWriter(editorwriter);
                stop = "run";
                while ((editorr = buffereditor.readLine()) != null) {
                    appcounter = 0;
                    while (appcounter < 100) {
                        System.out.print("\n");
                        appcounter = appcounter + 1;
                    }
                    System.out.print(halfmenu);

                    if (stop.contains("run")) {
                        appcounter = 0;
                        while (appcounter < 100) {
                            System.out.print("\n");
                            appcounter = appcounter + 1;
                        }
                        System.out.print(halfmenu);
                        System.out.print("Welcome to the Mephiso Configuration Editor.");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("The configuration file *MUST* be in the same format to function correctly.");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("Press enter to view the next line. Press e followed by enter to change the current line. ");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("Type stop followed by enter to finish editing and save the changes.");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("[Editing Configuration File]");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("Current Line =  " + editorr);
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("\n");
                        System.out.print("(Press enter for next line) Command: ");
                        System.out.print("\n");
                        String editchoice = input.nextLine();
                        if (editchoice.equals("e")) {
                            System.out.print("\n");
                            System.out.print("New value: ");
                            System.out.print("\n");
                            String newedit = input.next();
                            editorr = newedit;
                            System.out.print("\n");
                        }
                        if (editchoice.contains("stop")) {
                            stop = "stop";
                        }
                    }
                    buffereditorWriter.write(editorr + "\n");
                }
                buffereditorWriter.close();
                appcounter = 0;
                FileReader in = new FileReader(config_file_tmp);
                FileWriter out = new FileWriter(config_file);
                int c;
                while ((c = in.read()) != -1) {
                    out.write(c);
                }
                in.close();
                out.close();
                while (appcounter < 100) {
                    System.out.print("\n");
                    appcounter = appcounter + 1;
                }
                System.out.print(halfmenu);
                System.out.print("\n");
                System.out.print("Configuration Saved!");
                appcounter = 0;
                while (appcounter < 999999999) {
                    appcounter = appcounter + 1;
                }

            }
        } //END OF MAIN MENU SECTION
        System.out.print("\n");                  //TERMINATION SECTION
        System.out.print("[Program Terminated]"); //TERMINATION SECTION
    //System.exit(-1);                         //TERMINATION SECTION
    } //END OF PUBLIC MAIN
    }  //END OF PROGRAM

