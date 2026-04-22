package citi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequency {
    public static void main(String[] args) {
        String str = "Democracy of the people for the people and by the people";

        String [] arr = str.split(" ");
        Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).limit(3).forEach(s->System.out.println(s.getKey()+" : "+s.getValue()));

    }
}
