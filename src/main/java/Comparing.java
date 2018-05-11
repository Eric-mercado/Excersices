import java.util.Comparator;

public class Comparing {

    class Employee implements Comparable{

        private String name;
        private String department;
        private Integer age;

        public Employee (String name, String department, int age) {
            this.age = age;
            this.department = department;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public int compareTo(Object o) {

            Employee employee = (Employee) o;

            return Comparator.comparing((Employee e) -> e.getDepartment())
                    .thenComparing(e -> e.getName())
                    .thenComparing(e ->e.getAge())
                    .compare(this, employee);
        }
        }

    }

