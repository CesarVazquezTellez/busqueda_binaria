import java.io.*;
import java.util.*;

public class BusquedaBinariaFile {

    private static final String BASE_PATH = "C:\\archivos\\";

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingresa el nombre del archivo de entrada:");
            String inputFileName = br.readLine();

            System.out.println("Ingresa el nombre del archivo de salida:");
            String outputFileName = br.readLine();

            String inputPath = BASE_PATH + inputFileName;
            String outputPath = BASE_PATH + outputFileName;

            List<Integer> numbers = readNumbersFromFile(inputPath);
            int[] array = numbers.stream().mapToInt(i -> i).toArray();

            System.out.println("Ingresa el número a buscar:");
            int target = Integer.parseInt(br.readLine());

            int result = binarySearch(array, target);

            printResult(target, result);
            writeResultToFile(outputPath, target, result);

            System.out.println("Archivo generado: " + outputPath);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static List<Integer> readNumbersFromFile(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            for (String p : parts) {
                numbers.add(Integer.parseInt(p));
            }
        }
        br.close();
        return numbers;
    }

    public static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void printResult(int target, int position) {
        System.out.println("Número buscado: " + target);

        if (position >= 0) {
            System.out.println("Resultado: ENCONTRADO");
            System.out.println("Posición: " + position);
        } else {
            System.out.println("Resultado: NO ENCONTRADO");
        }
    }

    public static void writeResultToFile(String filename, int target, int position) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        bw.write("Número buscado: " + target + "\n");

        if (position >= 0) {
            bw.write("Resultado: ENCONTRADO\n");
            bw.write("Posición: " + position + "\n");
        } else {
            bw.write("Resultado: NO ENCONTRADO\n");
        }

        bw.close();
    }
}
