package org.example;

import java.io.*;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(String.join(";", header));
            for (int[] row : data) {
                writer.println(Arrays.toString(row).replaceAll("\\[|\\]|\\s", "").replace(",", ";"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            header = reader.readLine().split(";");
            data = reader.lines()
                    .map(line -> Arrays.stream(line.split(";"))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {
                {100, 200, 123},
                {300, 400, 500}
        };

        AppData appData = new AppData(header, data);
        appData.save("data.csv");

        AppData loadedData = new AppData(new String[0], new int[0][0]);
        loadedData.load("data.csv");

        for (int[] row : loadedData.data) {
            System.out.println(Arrays.toString(row));
        }
    }
}
