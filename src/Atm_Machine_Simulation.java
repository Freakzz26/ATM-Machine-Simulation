import java.util.Scanner;
class InsufficientFundsException extends Exception
{
    public InsufficientFundsException(String message)
    {
        super(message);
    }
}
class InvalidAmoutException extends Exception
{
    public InvalidAmoutException(String message)
    {
        super(message);
    }
}
class Balance
{
    private int account_balance=500;

    public int getAccount_balance() {
        return account_balance;
    }

    public int setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
        return account_balance;
    }
}
public class Atm_Machine_Simulation  {
    public static void validateFunds(int withdraw,int account_balance) throws InsufficientFundsException,InvalidAmoutException{
        if(withdraw>account_balance)
        {
            throw new InsufficientFundsException("Insufficient Funds!!!");
        }
        if(withdraw<=0)
        {
            throw new InvalidAmoutException("Invalid Amount !!! Enter correct amount to be withdrawed");
        }
        else
        {
            System.out.println("Your money withdrawed successfully");

            System.out.println("Your current balance is: "+Math.abs(account_balance));
        }

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String ch;
        int deposit=0,withdraw=0;
        Balance balance=new Balance();
        int x=0,y=0;
        do {
            System.out.println("Do you wish to a) Withdraw or b) Deposit or c)Check Balance or d) Exit? ");
            ch= scanner.next();
            if (ch.equals("a")) {
                System.out.println("Enter the amount to be withdrawed: ");
                withdraw = scanner.nextInt();
                try {
                    x=balance.setAccount_balance(balance.getAccount_balance()-withdraw);
                    validateFunds(withdraw,x);
                } catch (InsufficientFundsException exception) {
                    System.out.println(exception.getMessage());
                } catch (InvalidAmoutException exception) {
                    System.out.println(exception.getMessage());
                }

            } else if (ch.equals("b")) {
                System.out.println("Enter the amount to be deposited: ");
                deposit = scanner.nextInt();
                balance.setAccount_balance(balance.getAccount_balance()+deposit);
                System.out.println("Your Balance is "+balance.getAccount_balance());
            } else if (ch.equals("c")) {
                System.out.println("Your Current Balance is: " + balance.getAccount_balance());
            }
            else if(ch.equals("d"))
            {
                break;
            }
        }while(!ch.equals("d"));
        if(ch.equals("d"))
        {
            System.out.println("Thankyou!!");
        }


    }
}
