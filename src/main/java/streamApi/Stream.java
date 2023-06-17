package streamApi;

import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(2,3,4,5,6,7,8,9,10,11,12,13,14,15) ;
        List<Integer> evenNumber = integerList.stream().filter(num -> num % 2 == 0 ).collect(Collectors.toList());
        evenNumber.stream().forEach(element -> System.out.print(element+" "));
    }
}
