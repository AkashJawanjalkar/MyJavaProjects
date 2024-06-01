package Test_17May;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Employee 
{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) 
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public double getSalary() 
    {
        return salary;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() 
    {
        return id;
    }

    @Override
    public String toString() 
    {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
public class Employe07 
{

	public static void main(String[] args) 
	{
		Set<Employee> employees = new HashSet<>();
        employees.add(new Employee(1, "Ram", 50000.0));
        employees.add(new Employee(2, "Shyam", 60000.0));
        employees.add(new Employee(3, "Ganesh", 55000.0));
        employees.add(new Employee(4, "Dinesh", 65000.0));
        employees.add(new Employee(5, "Ramesh", 70000.0));

        System.out.println("Initial employees:");
        printEmployees(employees);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee ID to delete: ");
        int idToDelete = scanner.nextInt();

        Iterator<Employee> iterator = employees.iterator();
        boolean removed = false;
        while (iterator.hasNext()) 
        {
            Employee employee = iterator.next();
            if (employee.getId() == idToDelete) 
            {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) 
        {
            System.out.println("Employee with ID " + idToDelete + " has been removed.");
        } else 
        {
            System.out.println("Employee with ID " + idToDelete + " not found.");
        }

        System.out.println("\nRemaining employees:");
        printEmployees(employees);
    }

    private static void printEmployees(Set<Employee> employees) 
    {
        for (Employee employee : employees) 
        {
            System.out.println(employee);
        }
	}

}
