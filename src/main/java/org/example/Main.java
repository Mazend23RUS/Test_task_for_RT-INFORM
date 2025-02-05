package org.example;

import grovy.GroovyClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    static List<String> getCountOfNumber (List<?> firstInput, int[] secondInput){
        List<Integer> workList = null;

        if (firstInput == null && secondInput == null) {
            System.out.println("На вход должен подаваться хотя бы один список или массив !");
            throw new RuntimeException();
        } else if(secondInput == null){
            workList = (List<Integer>) firstInput;
        } else if (firstInput== null) {
            workList = Arrays.stream(secondInput).boxed().collect(toList());
        }
        else {
            System.out.println("На вход должен подаваться только один список или массив !");;
        }


        Map<Integer,Long> inputData;
        inputData = workList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        List<String> result = new ArrayList<>();
        inputData.entrySet().stream().forEach((k) -> result.add(k.getKey() + ":" + k.getValue())) ;
        return result;
    }


    public static void main(String[] args) {

        int[] randomNumbers = new int[]{1, 2, 3, 1, 4, 5, 6, 6, 6, 7, 8, 9, 0};
        List<Integer> k = Stream.of(10, 46, 1, 46, 2, 7, 2, 2, 88).collect(Collectors.toList());
        List<Long> s = Stream.of(10L, 46L, 1L, 46L, 2L, 7L, 2L, 2L, 88L).collect(Collectors.toList());


        System.out.println(GroovyClass.getCountOfNumberGroovy(null, randomNumbers) + " - Отработал метод Groovy. На входе был массив");
        System.out.println(GroovyClass.getCountOfNumberGroovy(k, null) + " - Отработал метод Groovy. На входе был Список Integer");
        System.out.println(GroovyClass.getCountOfNumberGroovy(s, null) + " - Отработал метод Groovy. На входе был Список Long" + "\n");

        System.out.println("Отработал метод JAVA!");
        System.out.println(getCountOfNumber(null, randomNumbers) + " - На входе был массив");
        System.out.println(getCountOfNumber(k, null) + " - На входе был Список Integer");
        System.out.println(getCountOfNumber(s, null) + " - На входе был массив Long");

    }


}