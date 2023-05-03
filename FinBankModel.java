import java.util.ArrayList;
import java.util.Random;

class FinBank{

    static String[] clientInstitutions = {"Citadel LLC","Bridgewater Associates","SoFi", "BlackRock", "Renaissance Technologies", "Brody's Mexican Restaurant","Two Sigma", "Garda Capital Partners", "Nasdaq, Inc.", "Jessica"};

    static Random generate = new Random();

    static <Typ> Typ pickRandom(Typ[] array){  
        int rndm = generate.nextInt(array.length);  
        return array[rndm]; //
    }

    static int[] accountRange(){
        int min = 100000000; // min value of range
        int max = 999999999;
        int[] ACCTS = new int[10];

        for(int i=0; i<10; i++){
        int ACCT = (int)Math.floor(Math.random()*(max-min+1)+min);
        ACCTS[i] = ACCT;
        }
        return ACCTS;

    }

    
    ArrayList<bankAccount> accounts = new ArrayList<>(); //arraylist of bank accounts


        public FinBank(int i){
            for(i=1; i<11; i++){
                accounts.add(new bankAccount());
            }
        }
    

    class bankAccount{

        private String acctNum;
        private String acctHolder;  
        private double balance = 0;
        private double digiBalance = 0;

        public bankAccount(){
            acctNum = ""+pickRandom(ACCTS.accountRange);
            acctHolder = pickRandom(clientInstitutions);

        }

        public void deposit(double moneyInput)
        {    
            balance = balance + moneyInput;
        }

        public String getAcctNumber(){
            return acctNum;
        }

        public String getAcctHolder(){
            return acctHolder;
        }

        public String getAcctBalance(){
            return balance;
        }

        public void digiDeposit(double moneyInput){    
            digiBalance = digiBalance + moneyInput;
        }

        public boolean withdrawal(double moneyInput){
            if(moneyInput > balance){ //refuse withdrawal
                System.out.println("Insufficient funds");
                return false;  
            }

            else {
                balance = balance - moneyInput;
                return true; //withdrawal honored
            }
        }
        
        public boolean digiRedeem(double moneyInput)
        {
            if(moneyInput > digiBalance){ //refuse withdrawal
                System.out.println("Insufficient funds");
                return false;
            }
            else {
                digiBalance = digiBalance - moneyInput;
                return true; //withdrawal honored
            }
        }

    }

}

public class FinBankModel { //a "custom" type, like a "String"


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

        FinBank fIhI = new FinBank(10);

        fIhI.accounts.get(3).deposit(333333.33);

        for(FinBank.bankAccount b : fIhI.accounts){
            System.out.println(b.getAcctNumber() + " " + b.getAcctHolder()+" "+b.getAcctBalance());
        }

    }

            
}


