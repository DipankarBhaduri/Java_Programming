package streamApi;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<String> stringList = List.of("a","b","c","d") ;
        List<String> stringList1 = List.of("e","f","g","h") ;
        List<String> stringList2 = List.of("i","j","k","l") ;

        List<List<String>> listOfList = List.of(stringList,stringList1,stringList2) ;

        List<String> characters = listOfList.stream().flatMap(list -> list.stream()).collect(Collectors.toList()) ;
        characters.stream().forEach(chara -> System.out.print(chara+" - "));
    }
}
