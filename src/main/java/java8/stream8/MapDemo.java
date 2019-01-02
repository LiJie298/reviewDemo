package java8.stream8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapDemo {
    private List lists = new ArrayList();

    private static Random random = new Random();

    public static void main(String[] args) {
        MapDemo mapDemo = new MapDemo();
        mapDemo.start();

    }

    public void start() {
        List<Student> students = getStudents();
        //一共有多少个班级
        students.stream().filter(distinctByKey(Student::getClassName)).collect(Collectors.toList()).forEach(m -> System.out.println(m.getClassName()));
        //每个班级的男女比例怎么样
        Map<Integer, Long> a = students.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.counting()));
        a.entrySet().stream().forEach(a1 -> System.out.println((a1.getKey() == 0 ? "男 -> " : "女 -> ") + a1.getValue()));
        //每门课的最高成绩的同学的姓名
        Map<Integer, Map<String, Integer>> gradeMap = new HashMap<>();
        students.forEach(m -> gradeMap.put(m.getSno(), m.getCouares()));
//        students.stream().collect(Collectors.groupingBy(Student::getSno,Collectors.collectingAndThen()));
        //男女成绩平均分是多少

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }


    private List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            students.add(new Student(2018242114 + i, "JD" + random.nextInt(200), "2" + random.nextInt(3), random.nextInt(2), 19, getCourse()));
        }
        return students;
    }

    private List<Course> getCourse() {
        List<Course> courses = new ArrayList<>();
        Course course1 = new Course("c1", "english", 100);
        Course course2 = new Course("c2", "math", 100);
        Course course3 = new Course("c3", "chinese", 100);
        Course course4 = new Course("c4", "music", 100);
        Course course5 = new Course("c5", "PE", 100);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        return courses;
    }


    class Student {
        private int sno;
        private String name;
        private String className;
        private int sex;
        private int age;
        private List<Course> courses;

        public void doTest() {
            for (int i = 0; i < courses.size(); i++) {
                courses.get(i).setGrade(random.nextInt(2));
            }
        }

        public Student(int sno, String name, String className, int sex, int age, List<Course> courses) {
            this.sno = sno;
            this.name = name;
            this.className = className;
            this.sex = sex;
            this.age = age;
            this.courses = courses;
        }

        public int getSno() {
            return sno;
        }

        public void setSno(int sno) {
            this.sno = sno;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }


        public Map<String, Integer> getCouares() {
            Map<String, Integer> gradeMap = new HashMap<>();
            courses.stream().forEach(m -> gradeMap.put(m.getCno(), m.getGrade()));
            return gradeMap;
        }

        public void setCourses(List<Course> courses) {
            this.courses = courses;
        }
    }

    class Course {
        private String cno;
        private String name;
        private int total;
        private int grade;

        public Course(String cno, String name, int total) {
            this.cno = cno;
            this.name = name;
            this.total = total;
        }

        public String getCno() {
            return cno;
        }

        public void setCno(String cno) {
            this.cno = cno;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public int getGrade() {
            return grade;
        }
    }
}
