package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by blueberryninja on 4/13/17.
 */
public class FileReader {

    private String filename;

    public FileReader(String filename){
        this.filename = filename;
    }

    public char[][] getMap() throws FileNotFoundException {

        Scanner in = new Scanner(new FileInputStream(filename));
        char[][] res = new char[10][10];

        for (int i = 0; i < 10; ++i){
            char[] line = in.nextLine().toCharArray();
            res[i] = line;
        }

        return res;
    }


}
