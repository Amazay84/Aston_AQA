import java.util.*;
import java.util.stream.Collectors;

public class Students {
    Collection<Student> students;

    public Students() {
        this.students = Arrays.asList(
                new Student ("Дмитрий", 17, Gender.MAN),
                new Student ("Mаксим", 20, Gender.MAN),
                new Student ("Екатерина", 20, Gender.WOMAN),
                new Student ("миxаил", 28, Gender.MAN));
    }

    public int getMansAverageAge() {
        return this.students.stream().
                filter(s -> s.getGender() == Gender.MAN).
                map(s -> s.getAge()).
                collect(Collectors.summingInt(Integer::intValue));
    }

    public void timeToArmy() {
        this.students.stream().
                filter(s -> s.getGender() == Gender.MAN && s.getAge() >=18 && s.getAge() <= 27).
                forEach(System.out::println);
    }

    private enum Gender {
        MAN,
        WOMAN
    }
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{ " +
                    "name = " +
                    name +
                    ", gender = " +
                    gender +
                    ", age = " +
                    age +
                    " }";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(getName(), student.getName()) &&
                    Objects.equals(getAge(), student.getAge()) &&
                    getGender() == student.getGender();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getAge(), getGender());
        }
    }
    public class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            return student1.getAge().compareTo(student2.getAge());
        }
    }
}
