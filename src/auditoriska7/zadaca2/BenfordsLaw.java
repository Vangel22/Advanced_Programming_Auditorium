package auditoriska7.zadaca2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BenfordsLaw {
    static final String INPUT_FILE = "C:/Users/vange/OneDrive/Desktop/benford.txt";

    public static void main(String[] args) throws FileNotFoundException {
        NumbersReader numbersReader = new LineNumbersReader();
        List<Integer> numbers = numbersReader.read(new FileInputStream(INPUT_FILE));
        BenfordsLaw benfordsLaw = new BenfordsLaw();
        int[] count = benfordsLaw.counts(numbers);
        CountVisualizer visualizer = new CountVisualizer(100);
        visualizer.visualize(System.out, count);
    }

    public int[] counts(List<Integer> numbers) {
        int[] result = new int[10];
        for (Integer number : numbers) {
            int digit = firstDigit(number);
            result[digit]++;
        }
        return result;
    }

    public static int firstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    public int[] countsFunc(List<Integer> numbers){
        return numbers.stream()
                .map(BenfordsLaw::firstDigit)
                .map(x -> {
                    int[] res = new int[10];
                    res[x]++;
                    return res;
                })
                .reduce(new int[10], (left,right) -> {
                    Arrays.setAll(left, i -> left[i] + right[i]);
                    return left;
                });
    }

}

interface NumbersReader{
    List<Integer> read(InputStream inputStream);
    //sakam kako lista da gi procitam podatocite od benford.txt
    //i da gi zemam broevite
}
class LineNumbersReader implements NumbersReader{
    @Override
    public List<Integer> read(InputStream inputStream) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            return reader.lines()
                    .filter(line -> !line.isEmpty()) //ne gi gledaj praznite linii
                    .map(line -> Integer.parseInt(line.trim())) //od sekoja linija zemi go brojot i skrati gi praznite mesta so trim
                    .collect(Collectors.toList()); //zacuvaj go rezultatot vo lista
        }catch (IOException e){
            System.err.println(e.getMessage());
            //ni vrakja error bidejki nemozeme da procitame od fajlot
        }
        return Collections.emptyList();
        //ako ne uspeeme da procitame vo try blokot se vrakja prazna lista
    }
}
//ova treba da e nekoj fajl od koj treba da procitame nesto dopolnitelno
//no ne e dovolno objasneto, zatoa ke go komentiram kodot
class SunspotNumbersReader implements NumbersReader{
    @Override
    public List<Integer> read(InputStream inputStream) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){ //citam od input
            return br.lines() //ova ke ni vrati stream od linii
                    .filter(line -> !line.isEmpty()) //line se odnesuva za inputStream vlezot
                    .map(line -> {
                        String[] parts = line.split("\\s+");
                        return Integer.parseInt(parts[parts.length-1]);
                        //podelba na linijata na delovi i vrakjanje na originalnata dolzina
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            //frla greska
        }
        return Collections.emptyList();
        //ako ne uspee try blokot vrati prazna lista
    }
}

class CountVisualizer{

    private final int n;

    public CountVisualizer(int n) {
        this.n = n;
    }

    public void visualize(OutputStream outputStream,int[] counts){
        PrintWriter printWriter = new PrintWriter(outputStream); //gi zemam podatocite za izlez
        for(Integer count: counts){ //za sekoj element vo counts, istiot se izminuva
            while(count > 0){
                printWriter.print("*");
                count -= n; //ne mi e bas jasna operacijata no nekako gi namaluva dzvezdite
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}