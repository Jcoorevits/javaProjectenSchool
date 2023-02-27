package fact.it.demolambdastream;

import fact.it.demolambdastream.model.NewFunctionalInterface;
import fact.it.demolambdastream.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoLambdaStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoLambdaStreamApplication.class, args);
        //Consumer Lambda
        Consumer<String> consumer1 = t-> System.out.println("Hello " + t);
        consumer1.accept("world");

        //extended Consumer Lambda expression
        Consumer<String> consumer2 = (t)->{System.out.println("Hello " + t);};
        consumer2.accept("world (extended)");

        //Function Lambda expression
        Function<String, Integer> function1 = s -> s.length();

        //Function extended Lambda expression
        Function<String, Integer> function2 = (s) -> {return s.length();};

        //Function with method reference
        Function<String, Integer> function3 = String::length;

        System.out.println("function with lambda expression: " + function1.apply("hi") );
        System.out.println("function with extended lambda expression: " + function2.apply("hihi") );
        System.out.println("function with method reference: " + function3.apply("hihihi") );

        //use of own created functional interface
        NewFunctionalInterface newFunctionalInterface = (n, t) -> {
            for(int i = 0 ; i<n;i++){
                System.out.println(t);
            };};
        newFunctionalInterface.doSomething(3,"hello");

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("first iteration");
        list.forEach(x -> System.out.println(x));
        list.removeIf(n -> n.equals("b"));
        System.out.println("second iteration");
        list.forEach(x -> System.out.println(x));
        list.replaceAll(n->n+"!");
        System.out.println("third iteration");
        list.forEach(System.out::println);


        ArrayList<String> companyList = new ArrayList<>();
        companyList.add("Google");
        companyList.add("Apple");
        companyList.add("Microsoft");
        //output is sorted
        companyList.stream().sorted().forEach(System.out::println);
        System.out.println("original ArrayList output: ");
        //output is not sorted
        companyList.forEach(System.out::println);

        companyList.sort(Comparator.naturalOrder());
        companyList.forEach(System.out::println);

        ArrayList<Integer> numbers= new ArrayList<>();
        numbers.add(6);
        numbers.add(5);
        numbers.add(1);
        numbers.add(9);
        //if j-i = output, the list will be sorted in descending order
        numbers.sort((i, j)->j-i);
        //alternative sorting method that can also be used for a String
        numbers.sort((i, j)->j.compareTo(i)) ;

        numbers.forEach((n)->{System.out.println(n);});

        List<Student> studentList = Stream.of(new Student("Chris", "Akkermans", 21),
                new Student("Anna", "Bergmans", 18),
                new Student("Carly", "Coopman", 25),
                new Student("Dirk", "Dieltjens", 19)).toList();

        studentList.stream()
                .filter(e -> e.getFirstName().contains("a"))
                .sorted((i,j) -> j.getLastName().compareTo(i.getLastName()))
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getAge()));
    }

}
