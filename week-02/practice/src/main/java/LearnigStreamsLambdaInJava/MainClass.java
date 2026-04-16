package LearnigStreamsLambdaInJava;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//lambda,stream

public class MainClass {
    public static void main(String[] args) {


        //older way, now there is a better way if the interface contains only one method.
        //Walkable obj= new WalkFast();
        //obj.walk(4);

//        Walkable  obj=new Walkable() {
//            @Override
//            public int walk(int steps) {
//                return 0;
//            }
//        }

//        Walkable obj = (step,enable)->{
//            System.out.println("Walking fast : "+step + " steps " + enable);
//            return 2*step;
//        };
//
//        Walkable obj2 = (step,enable)->2*step;
//
//        obj.walk(20,true);
//        obj2.walk(30,true);

        List<String> fruits=List.of("apple","orange","banana","kiwi","grape");
        //parallelStream() auto configures thread
        //Stream<String> stream=fruits.parallelStream();
       // Stream<String> stream=fruits.stream();

        //stream.forEach((fruit)->System.out.println(fruit));
        //the below will give error, we cannot use stream more than once.
        //stream.forEach((fruit)->System.out.println(fruit));

//        stream
//                .filter(fruit-> fruit.length()>5)
//                .sorted()
//                .map(fruit->fruit.toUpperCase())
//                //.map(String::length)
//                .forEach(System.out::println);

        Map<String,Integer> fruitLengthList =fruits
                .stream()
                .filter(fruit->fruit.length()>5)
               // .map(String::length)
              //  .collect(Collectors.toSet());
                      .collect(Collectors.toMap(
                            fruit->fruit,
                              String::length
                      ));
        System.out.println(fruitLengthList);




    }
}

interface Walkable{
    int walk(int steps,boolean isEnabled);
}

//class WalkFast implements Walkable{
//    @Override
//    public int walk(int steps) {
//        System.out.println("Walking fast : "+steps + " steps");
//        return 2*steps;
//    }
//}
