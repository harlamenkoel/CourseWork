public class CourseWork {
    private static Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        EMPLOYEES[0] = new Employee("Иванов Иван Иванович", 2, 25_000);
        EMPLOYEES[1] = new Employee("Иванова Ивана Ивановна", 3, 25_750);
        EMPLOYEES[2] = new Employee("Иванян Ивэн Ивэнович", 1, 24_620);
        EMPLOYEES[3] = new Employee("Иванидзе Ивон Ивонович", 4, 26_850);
        EMPLOYEES[4] = new Employee("Ивано Вано Ванович", 5, 23_999);
        EMPLOYEES[5] = new Employee("Петрова Мария Семеновна", 2, 24_920);
        EMPLOYEES[6] = new Employee("Иванко Драго Малкович", 1, 28_800);
        EMPLOYEES[7] = new Employee("Федоров Федя Федорович", 3, 25_458);
        EMPLOYEES[8] = new Employee("Петров Петр Петрович", 5, 23_999);
        EMPLOYEES[9] = new Employee("Свиридова Юлия Аркадьевна", 1, 27_850);
        System.out.println();
        outputList();
        System.out.println();
        System.out.println("Сумма затрат на зарплаты в месяц:" + getTotalSalaries());
        double averageSalary = getAverageSalaries();
        System.out.println("Среднее значение зарплат: " + averageSalary);
        Employee employeeWithMinSalary = findEmployeeWithMinSalary();
        System.out.println();
        System.out.println("Минимальную зарплату получает: " + employeeWithMinSalary);
        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary();
        System.out.println("Максимальную зарплату получает: " + employeeWithMaxSalary);
        System.out.println();
        getFullName();
        System.out.println();
        getIndexedSalary();
        System.out.println();
        int divisionNumber = 1;
        System.out.println("Минимальная зарплата в " + divisionNumber + " отделе: " + findEmployeeDivisionWithMinSalary(divisionNumber));
        System.out.println("Максимальная зарплата в " + divisionNumber + " отделе: " + findEmployeeDivisionWithMaxSalary(divisionNumber));
        System.out.println();
        System.out.println("Средняя зарплата по " + divisionNumber + " отделу: " + (int) getDivisionAverageSalaries(divisionNumber));
        System.out.println();
        System.out.println("Проиндексированная зарплата " + divisionNumber + " отдела");
        getDivisionIndexedSalary(divisionNumber);
        System.out.println();
        getStaffDivision(divisionNumber);
        System.out.println();
        int borderSalary = 25_000;
        System.out.println("Сотрудники с зарплатой больше, либо равно " + borderSalary);
        checkHigherSalary(borderSalary);
        System.out.println();
        System.out.println("Сотрудники с зарплатой меньше " + borderSalary);
        checkLowerSalary(borderSalary);
    }

    private static void outputList() {
        for (Employee employee : EMPLOYEES) {
            if (employee != null)
                System.out.println(employee);

        }
    }

    private static int getTotalSalaries() {
        int sum = 0;

        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        int min = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;

        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        int max = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;

        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static double getAverageSalaries() {
        int count = 0;

        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                count++;
            }
        }
        if (count != 0) {
            return (double) getTotalSalaries() / count;
        }
        return 0;
    }

    private static void getFullName() {
        for (Employee employee : EMPLOYEES) {
            if (employee != null)
                System.out.println(employee.getFullName());

        }
    }

    private static void getIndexedSalary() {
        int percent = 10;
        for (Employee employee : EMPLOYEES) {
            int indexedSalary = employee.getSalary() + employee.getSalary() * percent / 100;
            System.out.println(employee.getFullName() + " Проиндексированная зарплата на 10%: " + indexedSalary);
        }
    }

    private static Employee findEmployeeDivisionWithMinSalary(int division) {
        int min = Integer.MAX_VALUE;
        Employee employeeDivisionWithMinSalary = null;

        for (Employee employee : EMPLOYEES) {
            if (employee.getDivision() == division && employee.getSalary() < min) {
                min = employee.getSalary();
                employeeDivisionWithMinSalary = employee;
            }
        }
        return employeeDivisionWithMinSalary;
    }

    private static Employee findEmployeeDivisionWithMaxSalary(int division) {
        int max = Integer.MIN_VALUE;
        Employee employeeDivisionWithMaxSalary = null;

        for (Employee employee : EMPLOYEES) {
            if (employee.getDivision() == division && employee.getSalary() > max) {
                max = employee.getSalary();
                employeeDivisionWithMaxSalary = employee;
            }
        }
        return employeeDivisionWithMaxSalary;
    }

    private static int getTotalDivisionSalaries(int division) {
        int sum = 0;

        for (Employee employee : EMPLOYEES) {
            if (employee.getDivision() == division) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static double getDivisionAverageSalaries(int division) {
        int count = 0;

        for (Employee employee : EMPLOYEES) {
            if (employee.getDivision() == division) {
                count++;
            }
        }
        if (count != 0) {
            return (double) getTotalDivisionSalaries(division) / count;
        }
        return 0;
    }

    private static void getDivisionIndexedSalary(int division) {
        int percent = 20;
        double indexedSalary;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDivision() == division) {
                indexedSalary = employee.getSalary() + (double) employee.getSalary() * percent / 100;
                System.out.println(employee.getFullName() + " Проиндексированная зарплата на " + percent + " %: " + (int) indexedSalary);
            }
        }
    }

    private static void getStaffDivision(int division) {
        for (Employee employee : EMPLOYEES) {
            if (employee.getDivision() == division) {
                System.out.println("Номер id: " + employee.getId() + " Ф.И.О: "
                        + employee.getFullName() + " Зарплата: " + employee.getSalary());
            }
        }
    }

    private static void checkHigherSalary(int borderSalary) {
        for (Employee employee : EMPLOYEES) {
            if (borderSalary <= employee.getSalary()) {
                System.out.println("Номер id: " + employee.getId() + " Ф.И.О: "
                        + employee.getFullName() + " Зарплата: " + employee.getSalary());
            }
        }
    }

    private static void checkLowerSalary(int borderSalary) {
        for (Employee employee : EMPLOYEES) {
            if (borderSalary > employee.getSalary()) {
                System.out.println("Номер id: " + employee.getId() + " Ф.И.О: "
                        + employee.getFullName() + " Зарплата: " + employee.getSalary());
            }
        }
    }
}