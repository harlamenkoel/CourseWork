public class Employee {
    private static int idGeneration = 1;
    private final int id;
    private final String fullName;
    private int division;
    private int salary;


    public Employee(String fullName, int division, int salary) {
        this.id = idGeneration++;
        this.fullName = fullName;
        this.division = division;
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public String getFullName() {
        return fullName;
    }


    public int getDivision() {
        return division;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Номер id: " + id + " " + " Ф.И.О: " + fullName + " Отдел: " + "(" + division + ")" + " Зарплата: " + salary;
    }
}