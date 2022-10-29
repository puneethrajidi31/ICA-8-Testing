
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Vector;

public class urinals {
        public static void main(String[] args) throws IOException {
            //Author: Puneeth Reddy Rajidi

            //File reading
            System.out.println("Enter 1 for reading the file and 2 for reading the string");
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
            if(x==1) {
                readfile("src\\urinals.dat");
            }
            else if(x==2) {
                String t = stringfetch();
                System.out.println("Possible number of Urinals are "+urinalscount(t));
            }
            else {
                System.out.println("Invalid Input");
            }

        }

        public static boolean goodString(String str) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                    if (i > 0 && str.charAt(i) == '1' && str.charAt(i - 1) == '1') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;

        }

        public static int urinalscount(String str) {
            if (goodString(str) == true) {
                int[] a = new int[str.length()];
                for (int i = 0; i < a.length; i++) {
                    a[i] = 0;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (i == 0) {
                        if (str.charAt(i) == '0') {
                            if (i + 1 < str.length()) {
                                if (str.charAt(i + 1) == '1') {
                                    a[i] = 0;
                                } else {
                                    a[i] = 1;
                                }
                            }
                        } else {
                            a[i] = 0;
                        }
                    } else if (i == 1) {
                        if (str.charAt(i) == '1') {
                            a[i] = a[i - 1];
                        } else {
                            if (str.charAt(i - 1) == '1') {
                                a[i] = a[i - 1];
                            } else if (i + 1 < str.length() && str.charAt(i + 1) == '1') {
                                a[i] = a[i - 1];
                            } else {
                                a[i] = 1;
                            }
                        }
                    } else {
                        a[i] = a[i - 1];
                        if (str.charAt(i) == '1') {
                            a[i] = a[i - 1];
                        } else {
                            if (str.charAt(i - 1) == '1') {
                                a[i] = a[i - 1];
                            } else if (i + 1 < str.length() && str.charAt(i + 1) == '1') {
                                a[i] = a[i - 1];
                            } else {
                                a[i] = Math.max(a[i], 1 + a[i - 2]);
                            }
                        }
                    }
                }
                return a[str.length() - 1];
            } else {
                return -1;
            }


        }

        public static boolean filefound(String path) {
            try {
                File file = new File(path);
                Scanner s = new Scanner(file);
                return true;
            } catch (FileNotFoundException e) {
                return false;
            }

        }


        public static boolean emptyfilecheck(String path) {
            try {
                File file = new File(path);
                Scanner s = new Scanner(file);
                return s.hasNextLine();
            } catch (Exception e) {
                return false;
            }
        }





        public static void readfile(String path) throws IOException
        {

            if(filefound(path)==false)
            {
                System.out.println("File not found");
                return;
            }
            if(emptyfilecheck(path)==false)
            {
                System.out.println("Empty file");
                return;
            }
            File file = new File(path);
            Scanner s = new Scanner(file);
            Vector<Integer> v=new Vector<Integer>();
            while(s.hasNextLine()) {
                    String y=s.nextLine();
                    boolean gh = goodString(y);
                    if (gh == false) {
                        v.add(-1);
                        break;
                        //Stopping the loop as we got -1

                    }
                    else {
                        int x = urinalscount(y);
                        v.add(x);
                    }
                }
            writefile(v);
            }

        public static String stringfetch(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the string:");
            String str=sc.next();
            return str;
        }

        public static void writefile(Vector<Integer>v) throws IOException {

            File f=new File("src\\rule.dat");
            File x=f;
            int count=1;
            //Checking if the file is duplicated or not and ensuring the proper file name
            while(x.exists())
            {
                x=new File("src\\rule"+count+".dat");
                count++;
            }
            f=x;

                FileWriter p=new FileWriter(f.getAbsoluteFile());
                BufferedWriter b=new BufferedWriter(p);
                for(Integer i:v)
                {
                    b.write(i+"\n");
                }
                b.close();
            }



        }

