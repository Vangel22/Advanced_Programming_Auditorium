package auditoriska7.zadaca3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.stream.Collectors;

//sekoj string zapocnuva so golema bukva
//malite bukvi se alfabetski podredeni
public class ArrangeLetters {
    public static String arrange(String input){
        String[] parts = input.split("\\s+"); //go zemam zborot

        for(int i=0; i<parts.length; i++){
            char[] w = parts[i].toCharArray(); //ova e niza od karakteri za eden zbor
            Arrays.sort(w); //vo rastecki redosled gi sortira bukvite
            parts[i] = new String(w); //zborot sega ke se zameni izmenet na istata pozicija
        }
        return Arrays.stream(parts).sorted().collect(Collectors.joining(" "));
        //prikazi ja nizata so site delovi sortirani i delimiter ni naznacuva prazno mesto pomegju zborovite
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        sentence = arrange(sentence);
        System.out.println(sentence);
    }
}
