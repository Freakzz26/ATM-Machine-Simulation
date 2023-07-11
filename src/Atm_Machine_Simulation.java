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
    private int account_balance=50000;

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
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
            System.out.println("Your current balance is: "+Math.abs(account_balance-withdraw));
        }

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Do you wish to a) Withdraw or b) Deposit or c)Check Balance or d) Exit? ");
        String ch= scanner.next();
        int deposit=0;
        Balance balance=new Balance();
        if(ch.equals("a"))
        {
            System.out.println("Enter the amount to be withdrawed: ");
            int withdraw=scanner.nextInt();
            try
            {
                validateFunds(withdraw,balance.getAccount_balance());
            }
            catch(InsufficientFundsException exception)
            {
                System.out.println(exception.getMessage());
            }
            catch (InvalidAmoutException exception)
            {
                System.out.println(exception.getMessage());
            }

        }
        else if(ch.equals("b"))
        {
            System.out.println("Enter the amount to be deposited: ");
            deposit=scanner.nextInt();
            System.out.println("Money Deposited!");
            System.out.println("YOUR CURRENT BALANCE: "+(deposit+balance.getAccount_balance()));
        }
        else if(ch.equals("c"))
        {
            System.out.println("Your Current Balance is: "+(deposit+balance.getAccount_balance()));
        }
        else if(ch.equals("d"))
        {
            System.out.println("Exit");
        }

    }
}
