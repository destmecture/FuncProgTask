import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        stringStatistic("лев кот мышь лев собака лось мышь лев кабан кабан");

    }

    public static void stringStatistic(String input){
        if(input==null){
            System.err.println("Строка пуста");
            System.exit(0);
        }
        String[] strArray = input.split(" ");
        Map<String, Integer> stringMap = new HashMap<>();

        for (String a: strArray){
            int cnt = (int) stream(strArray).filter(x-> Objects.equals(x, a)).count();
            stringMap.put(a, cnt);
        }

        System.out.println("Количество слов в строке = "+strArray.length);
        stringMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x-> System.out.println(x.getValue()+" - "+x.getKey()));
    }
}

