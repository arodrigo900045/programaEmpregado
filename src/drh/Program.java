package drh;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;


public class Program 
{
    public static void main(String[] args) 
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //Instanciar uma lista de funcionarios
        List<Employee> list = new ArrayList<>();
        
        System.out.print("How many employees will be registered? ");
        int N = sc.nextInt();
        
        for(int i=0; i<N; i++)
        {
            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":" );
            
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            //Validar se o Id já foi digitado para não haver repeticao na digitaçao de ID
            while(hasId(list, id))
            {
                System.out.println("Id alread taken! Try again: ");
                System.out.print("Id: ");
                id = sc.nextInt();
            }           
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            
            //Guardar os dados dos funcionario na lista
            Employee emp = new Employee(id, name, salary);
           	//Inserir o funcionario na lista
            list.add(emp);
        }
        //System.out.println();
        System.out.print("Enter the employee id that will have salary increase : ");
        int idsalary = sc.nextInt();
        //encontrar(procurar) o Id do funcionario existe na lista para ser incrementado x % do salario.
        
        Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
        //Integer pos = position(list, idsalary);        
        
        if(/*posp*/emp == null)
        {
            System.out.println("This id does not exist!");    
                 
        }else{
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            emp.increaseSalary(percent);
            //list.get(pos).increaseSalary(percent);
        }
        System.out.println();
        System.out.println("List of employees: \n ");
        
        //imprimir lista de funcionarios
        for(Employee e : list)
        {
            System.out.println(e);
        }    
        
        sc.close();
    }
    
    public static Integer position(List<Employee> list, int id)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getId() == id)
            {
                return i;
            }
        } 
        return null;
        
    }
    //Ver se o Id já foi digitado
    public static boolean hasId(List<Employee> list, int id) 
    {
            Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	    return emp != null;
	
    }   


    
}
