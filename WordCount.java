//This code is written and contributed by AMAN KUMAR BEHERA in the month of October.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;


public class WordCount {

    public static void main(String[] args) {
        countWordsViaGUI();
    }


    
    public static void countWordsViaGUI() {
        setLookAndFeel();
        try {
            Scanner key = new Scanner(System.in);
            do {
                System.out.println("Opening GUI to choose file.");
                Scanner fileScanner = new Scanner(getFile());
                Stopwatch st = new Stopwatch();
                st.start();
                ArrayList<String> words = countWordsWithArrayList(fileScanner);
                st.stop();
                System.out.println("time to count: " + st);
                System.out.print("Enter number of words to display: ");
                int numWordsToShow = Integer.parseInt(key.nextLine());
                showWords(words, numWordsToShow);
                fileScanner.close();
                System.out.print("Perform another count? ");
            } while(key.nextLine().toLowerCase().charAt(0) == 'y');
            key.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Problem reading the data file. Exiting the program." + e);
        }
    }


    
    private static ArrayList<String> countWordsWithArrayList(Scanner fileScanner) {


        System.out.println("Total number of words: " + numWords);
        System.out.println("number of distincy words: " + result.size());
        return result;
    }


    
    private static Map<String, Integer> countWordsWithMap(Scanner fileScanner) {


        System.out.println("Total number of words: " + numWords);
        System.out.println("number of distincy words: " + result.size());
        return result;
    }


    private static void showWords(ArrayList<String> words, int numWordsToShow) {
        for(int i = 0; i < words.size() && i < numWordsToShow; i++)
            System.out.println(words.get(i));
    }


    private static void showWords(Map<String, Integer> words, int numWordsToShow) {



    }


    
    private static void performExp() {
        String[] smallerWorks = {"smallWords.txt", "2BR02B.txt", "Alice.txt", "SherlockHolmes.txt"};;
        String[] bigFile = {"ciaFactBook2008.txt"};
        timingExpWithArrayList(smallerWorks, 50);
        timingExpWithArrayList(bigFile, 3);
        timingExpWithMap(smallerWorks, 50);
        timingExpWithMap(bigFile, 3);
    }


    
    private static void timingExpWithMap(String[] titles, int numExp) {
        try {
            double[] times = new double[titles.length];
            final int NUM_EXP = 50;
            for(int i = 0; i < NUM_EXP; i++) {
                for(int j = 0; j < titles.length; j++) {
                    Scanner fileScanner = new Scanner(new File(titles[j]));
                    Stopwatch st = new Stopwatch();
                    st.start();
                    Map<String, Integer> words = countWordsWithMap(fileScanner);
                    st.stop();
                    System.out.println(words.size());
                    times[j] += st.time();
                    fileScanner.close();
                }
            }
            for(double a : times)
                System.out.println(a / NUM_EXP);
        }
        catch(FileNotFoundException e) {
            System.out.println("Problem reading the data file. Exiting the program." + e);
        }
    }


    
    private static void timingExpWithArrayList(String[] titles, int numExp) {
        try {
            double[] times = new double[titles.length];
            for(int i = 0; i < numExp; i++) {
                for(int j = 0; j < titles.length; j++) {
                    Scanner fileScanner = new Scanner(new File(titles[j]));
                    Stopwatch st = new Stopwatch();
                    st.start();
                    ArrayList<String> words = countWordsWithArrayList(fileScanner);
                    st.stop();
                    times[j] += st.time();
                    fileScanner.close();
                }
            }
            for(int i = 0; i < titles.length; i++)
                System.out.println("Average time for " + titles[i] + ": " + (times[i] / numExp));
        }
        catch(FileNotFoundException e) {
            System.out.println("Problem reading the data file. Exiting the program." + e);
        }
    }


    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
            System.out.println("Unable to set look at feel to local settings. " +
            "Continuing with default Java look and feel.");
        }
    }


    
    private static File getFile() {
        
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File To Count Words:");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
            f = chooser.getSelectedFile();
        return f;
    }
}
//This code is written and contributed by AMAN KUMAR BEHERA
