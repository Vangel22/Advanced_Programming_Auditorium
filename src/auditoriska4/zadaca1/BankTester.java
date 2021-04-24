package auditoriska4.zadaca1;

interface InterestBearingAccount{
    public void addInterest();
}

abstract class Account {
    protected String name;
    protected int number;
    protected double currentState;

    public Account(String name, int number, double currentState) {
        this.name = name;
        this.number = number;
        this.currentState = currentState;
    }

    public double getCurrentState() {
        return currentState;
    }

    public double addAmount(double amount) {
        return currentState += amount;
    }
    public double withdrawAmount(double amount){
        return currentState-=amount;
    }
}

//smetkite bez kamata
class NoInterestCheckingAccount extends Account{

    public NoInterestCheckingAccount(String name, int number, double currentState) {
        super(name, number, currentState);
    }
}

//smetkite so kamata
class InterestCheckingAccount extends Account implements InterestBearingAccount{

    public static final double interestRate = .03;

    public InterestCheckingAccount(String name, int number, double currentState) {
        super(name, number, currentState);
    }

    @Override
    public void addInterest() {
        addAmount(getCurrentState()*interestRate);
    }
}

class Bank{
    private Account[] account;
    private int totalAccounts;
    private int max;

    //ke znam kolku smetki imam
    public Bank(int max){
        this.totalAccounts = 0;
        this.max = max;
        account = new Account[max];
    }
    //suma na site smetki
    public double totalAssets(Account[] account){
        double sum = 0;
        for(int i=0; i<account.length; i++){
            sum += account[i].getCurrentState();
        }
        return sum;
    }

    public void addInterest(Account[] accounts){
        for(Account a : accounts){
            if(a instanceof InterestBearingAccount){
                InterestBearingAccount store = (InterestBearingAccount) a;
                store.addInterest(); //dodadi kamata na tocno taa smetka
            }
        }
    }
}

class PlatinumCheckingAccount extends Account implements InterestBearingAccount{

    public PlatinumCheckingAccount(String name, int number, double currentState) {
        super(name, number, currentState);
    }

    @Override
    public void addInterest() {
        addAmount(getCurrentState() * InterestCheckingAccount.interestRate*2);
    }
}

public class BankTester {
    public static void main(String[] args) {
        Account[] accounts = new Account[5];
        accounts[0].name = "Vangel";
        accounts[0].currentState = 0;
        accounts[0].number = 1;

        accounts[0].getCurrentState();
        accounts[0].addAmount(200);
        accounts[0].withdrawAmount(100);
    }
}
