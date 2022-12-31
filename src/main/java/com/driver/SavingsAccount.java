package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super();
        // minimum balance is 0 by default
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
        this.setName(name);
        this.setBalance(balance);
        setMinBalance(0);
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        try {
            if(amount < getBalance())
            {
                try {
                    if(amount < maxWithdrawalLimit)
                    {
                        setBalance(getBalance()-amount);
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Maximum Withdraw Limit Exceed");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Insufficient Balance");
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        double finalAmount;
        double simpleInterest;
        simpleInterest = (getBalance() + years + rate) / 100;
        finalAmount = simpleInterest + getBalance();
        return finalAmount;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double finalAmount;
        finalAmount = (getBalance()) * (Math.pow((1 + (rate/100)), years));
        return finalAmount;
    }

}
