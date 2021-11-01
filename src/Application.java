import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        Student student1 = new Student(1L,"Lill Null",30.5);
        Student student2 = new Student(2L,"Boolean Scott",40.34);
        Student student3 = new Student(3L, "Pointer Ram", 20.0);
        Student student4 = new Student(4L, "Object Stephen",23.56);
        Student student5 = new Student(5L,"Variable Lill",30.5);
        Student student6 = new Student(6L, "Meta Mark",20.0);

        List<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(student1,student2,student3,student4,student5,student6));

        //Print all students using for each
        students.stream().forEach(e->System.out.println(e));

        //Return a list containing only the scores of the users using map
        List<Double> studentsScores = students.stream().map(e->e.getScore()).collect(Collectors.toList());
        System.out.println("Printing student scores");
        studentsScores.stream().forEach(e->System.out.println(e));

         //Remove duplicates by collecting the results of challenge 2 into a set
         Set<Double> uniqueScores = students.stream().map(Student::getScore).collect(Collectors.toSet()); // you could use lambdas
         System.out.println("Printing unique scores");
         uniqueScores.stream().forEach(e->System.out.println(e));

         //Remove duplicates but this time using the distinct operation
         List<Double> distinctScores = students.stream().map(Student::getScore).distinct().collect(Collectors.toList());
         System.out.println("Printing unique scores using distinct");
         distinctScores.stream().forEach(e->System.out.println(e));

         //Return and print the sum of all users scores
         System.out.println("Printing the sum of scores");
         System.out.println(students.stream().mapToDouble(e->e.getScore()).sum());

         // Repeat challenge 5 but using the reduce operation
         System.out.println("Printing the sum of scores using reduce operation");
         System.out.println(students.stream().mapToDouble(Student::getScore).reduce(0.0,Double::sum));

         //Return a HashMap of student's id and score using Collectors.toMap
         System.out.println("Printing map of student's id and score");
         Map<Long,Double> studentIdScoreMap = students.stream().collect(Collectors.toMap(Student::getId,Student::getScore));
         System.out.println(studentIdScoreMap);

         //Get all students with scores greater than 30
         System.out.println("Printing students with scores greater than 30");
         students.stream().filter(e->e.getScore()>30).forEach(e->System.out.println(e.getName()));

         // Repeat challenge 8 but sort the scores from lowest to highest using sorted
        System.out.println("Printing students with scores greater than 30 in ascending order");
        students.stream().filter(e->e.getScore()>30).sorted(Comparator.comparing(Student::getScore)).forEach(e->System.out.println(e.getName()));

        //Repeat challenge 9 but sort the scores from highest to lowest using sorted
        System.out.println("Printing students with scores greater than 30 in descending order");
        students.stream().filter(e->e.getScore()>30).sorted(Comparator.comparing(Student::getScore,Comparator.reverseOrder())).forEach(e->System.out.println(e.getName()));


        //Notice Lill Null and Variable Lill in challenge 10 have the same score perform a further sort based on their names in descending order
        System.out.println("Printing students with scores greater than 30 in descending order of scores and names");
        students.stream().filter(e->e.getScore()>30).sorted(Comparator.comparing(Student::getScore,Comparator.reverseOrder())
                .thenComparing(Student::getName,Comparator.reverseOrder())).forEach(e->System.out.println(e.getName()));


        //A new List of students just arrived, create a new list of students that combines the old students and the new students using flatMap
        Student student7 = new Student(7L,"Newton New",30.5);
        Student student8 = new Student(8L,"New Pointer",40.34);
        List<Student> newStudents = Arrays.asList(student7,student8);
        List<Student> newStudentsList = Stream.of(students,newStudents).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(newStudentsList);

        //cheers !!!

    }
}
