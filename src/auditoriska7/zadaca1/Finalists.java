package auditoriska7.zadaca1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomPicker{
    private final int n;

    public RandomPicker(int n) {
        this.n = n;
    }
    public List<Integer> pick(int x){
        Random random = new Random();
        List<Integer> picked = new ArrayList<>(); //lista od 3 primer
        while(picked.size() != x){ //int x = 3 i ke generirame 3 broevi i ke gi cuvame vo lista
            int pick = random.nextInt(n)+1; //+1 bidejki random trgnuva od nula
            if(!picked.contains(pick)){
                picked.add(pick);
            }
        }
        return picked;
    }
}

public class Finalists {
    public static void main(String[] args) {
        RandomPicker picker = new RandomPicker(30);
        List<Integer> picked = picker.pick(3);
        System.out.println(picked);
    }
}
