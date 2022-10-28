
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

    public class urinals {
        public static void main(String[] args) throws IOException {
            //Author: Puneeth Reddy Rajidi

            //File reading
            readfile("src\\file1.dat");


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
            while(s.hasNextLine()) {
                    String y=s.nextLine();
                    boolean gh = goodString(y);
                    if (gh == false) {
                        System.out.println("-1");
                    }
                    else {
                        int x = urinalscount(y);
                        System.out.println(x);
                    }
                }
            }



        }

