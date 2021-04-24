package auditoriska9;

import java.util.*;

//verojatnosta deka dvajca vo edna prostorija se rodeni na ist den vo godinata
//2 do 50 lica vo prostorijata
public class BirthdayParadox {

    static final int NUMBER_OF_TRIALS = 5000; //eksperimenti
    private final int maxPeople; //maksimum lugje vo prostorijata

    public BirthdayParadox(int maxPeople) { //maksimum lugje vo prostorijata
        this.maxPeople = maxPeople;
    }

    public Map<Integer, Double> simulate(int numTrials){ //za konkreten broj na eksperimenti
        Random random = new Random();
        Map<Integer, Double> probabilities = new TreeMap<>();
        for(int numPeople = 2; numPeople <= maxPeople; numPeople++){
            double probability = simulation(numPeople,numTrials,random);
            probabilities.put(numPeople,probability);
        }
        return probabilities;
    }

    public double simulation(int numPeople,int numTrials,Random random){
        int positiveEvents = 0;
        for(int i=0; i<numTrials; i++){
            if(singleExperiment(numPeople,random)){ //ako ima dvajca ili poveke so ist rodenden
                ++positiveEvents;
            }
        }
        return positiveEvents * 1.0 / NUMBER_OF_TRIALS; //ova ke presmetuva eden vid prosek za verojatnosta
    }

    private boolean singleExperiment(int numPeople, Random random){
        int sameBirthday = 1;
        Set<Integer> room = new HashSet<>();
        for(int i=0; i<numPeople; i++){
            int birthday = random.nextInt(365) + 1; //bidejki startuva od nula, a so +1 startuva od 1
            if(!room.add(birthday)){ //ako ne go dodade rodendenot znaci veke postoi
                ++sameBirthday;
            }
        }
        return sameBirthday >= 2;
    }

    public static void main(String[] args) {
        BirthdayParadox birthday = new BirthdayParadox(50);
        Map<Integer, Double> probabilities = birthday.simulate(NUMBER_OF_TRIALS);

        //ova go dobiv taka sto probabilities prima ->probabilities<- od simulate kade tamu e naznaceno deka
        //prima dve vrednosti a toa se -numPeople- i -probability(numPeople,numTrials,random)-
        probabilities.forEach((key,value) ->
                System.out.printf("For %d people, the probability of two birthdays is about %.3f\n",key,value));
    }
}
