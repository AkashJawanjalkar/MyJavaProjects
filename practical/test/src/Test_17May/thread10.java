package Test_17May;

class Table 
{
    synchronized void printTable(int n) 
    {
        for (int i = 1; i <= 10; i++) 
        {
            System.out.println(n + " * " + i + " = " + (n * i));
            try 
            {
                Thread.sleep(100); 
            } catch (InterruptedException e) 
            {
                System.out.println(e);
            }
        }
        System.out.println();
    }
}

class MyThread implements Runnable 
{
    Table table;
    int number;

    MyThread(Table table, int number) 
    {
        this.table = table;
        this.number = number;
    }

    public void run() 
    {
        table.printTable(number);
    }
}

public class thread10 
{

	public static void main(String[] args) 
	{
		Table obj = new Table(); 

        Thread t1 = new Thread(new MyThread(obj, 5));
        Thread t2 = new Thread(new MyThread(obj, 7));
        Thread t3 = new Thread(new MyThread(obj, 9));

        t1.start();
        t2.start();
        t3.start();
	}
}