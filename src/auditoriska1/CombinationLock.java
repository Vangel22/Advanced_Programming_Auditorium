package auditoriska1;

import java.util.Scanner;

public class CombinationLock {
    private int combination;
    private boolean isOpen;

    CombinationLock(int combination){
        this.combination = combination;
        this.isOpen = false;
    }
    public boolean Open(int combination){
        this.isOpen = (this.combination == combination);
        return this.isOpen;
    }
    public boolean Change(int oldCombo,int newCombo){
        if(this.combination == oldCombo){
            this.combination = newCombo;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CombinationLock combo = new CombinationLock(123);
        System.out.println(combo.Open(123));
        System.out.println(combo.Change(123,456));
        System.out.println(combo.Open(123));
    }
}
