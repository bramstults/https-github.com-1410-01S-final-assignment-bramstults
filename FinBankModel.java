import java.util.ArrayList;
import java.util.Random;

class FinBank{
    ArrayList<bankAccount> accounts = new ArrayList<>(); //arraylist of bank accounts
    Random generator = new Random();

    public FinBank(int i){
        for(i=1; i<10; i++){
            accounts.add(new bankAccount("000000000","bram"));
        }

    }

}

class bankAccount{

    private String acctNum;
    private String acctHolder;  
    private double balance;
    private double digiBalance;

    public bankAccount(String numInput, String nameInput)
    {
        acctNum = numInput;
        acctHolder = nameInput;
        balance = 0;
        digiBalance = 0;
    }

    public void deposit(double moneyInput)
    {    
        balance = balance + moneyInput;
    }

    public String getAcctNumber(){
        return acctNum;
    }

    public void digiDeposit(double moneyInput)
    {    
        digiBalance = digiBalance + moneyInput;
    }

    public boolean withdrawal(double moneyInput)
    {
        if(moneyInput > balance){ //refuse withdrawal
            return false;
            System.out.println("Insufficient funds");
        }
        else {
            balance = balance - moneyInput;
            return true; //withdrawal honored
        }
    }

}

public class FinBankModel { //a "custom" type, like a "String"



    public boolean digiRedeem(double moneyInput)
    {
        if(moneyInput > digiBalance){ //refuse withdrawal
            return false;
            System.out.println("Insufficient funds");
        }
        else {
            digiBalance = digiBalance - moneyInput;
            return true; //withdrawal honored
        }
    }


    // static currency(String currInput, String digiCurrInput)
    // {
    //     String nationalCurr = currInput;
    //     String digitalCurr = digiCurrInput;

    // }

    // static compareRates(String nationalCurr, String digitalCurr){
    //     dollarRate();
    //     digitalRate();
    // }


public static void main(String[] args){

    //FinBankModel f = new FinBankModel();  //ainsi dite: "f is a FinBankModel"... 
                                            //until this object is instantiated all "those methods" can't be called
                                        //if a "constructor" is used, it is to initialize in a specific state... like with a specific acctNum and acctHolder
    //TODO

    // bankAccount b = new bankAccount();
    
    FinBank f = new FinBank(10);

    f.accounts.get(2).deposit(2000.00);

    for(bankAccount b : f.accounts){
        System.out.println(b.acctNum + " " + b.acctHolder+" "+b.balance);
    }

}

        
}
