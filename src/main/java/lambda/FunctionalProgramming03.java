package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FunctionalProgramming03 {

    public static void main(String[] args) {

        List<String> l=new ArrayList<>();

        l.add("Ali");
        l.add("Ali");
        l.add("Mark");
        l.add("Amanda");
        l.add("Christopher");
        l.add("Jackson");
        l.add("Mariano");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Benjamin");

        printUpperCase1(l);
        System.out.println();
        printUpperCase2(l);
        System.out.println();
        printSortedByLength(l);
        System.out.println();
        printSortedByLastChar(l);
        System.out.println();
        printSortedByFirstChar(l);
        System.out.println();
        //removeIfLengthGreaterThanFive1(l);
        System.out.println();
        //removeIfLengthGreaterThanFive2(l);
        System.out.println();
        removeIfStartingAOrEndingN(l);
    }

    // 1)Create a method to print all list elements in uppercase

    // 1. Way
    public static void printUpperCase1(List<String> l){
        l.stream().map(String::toUpperCase).forEach(Utils::printInTheSameLineWithASpace);
    }

    // 2. Way
    public static void printUpperCase2(List<String> l){
        l.replaceAll(String::toUpperCase);  // forEach kabul etmiyor
        System.out.println(l);
    }

    // 2) create a method to print the elements after ordering according to their lengths
    public static void printSortedByLength(List<String> l){
        l.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::printInTheSameLineWithASpace);
        l.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println); // Javanin kendi methodunu kullandim
    }

    // 3)create a method to sort the distinct elements by using their last characters
    public static void printSortedByLastChar(List<String> l){
        l.stream().distinct().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).forEach(System.out::println);
    }

    // 4)create a method to sort the elements  according to their lengths then according to their first characters
    public static void printSortedByFirstChar(List<String> l){
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.charAt(0))).forEach(System.out::println);
    }

    // 5) remove the elements if the length of the element is greater than 5
    // 1: Way
//    public static void removeIfLengthGreaterThanFive1(List<String> l){
//        l.removeIf(t->t.length()>5);
//        System.out.println("The length of elements is less than 5: "+l);
//    }
//
//    public static void removeIfLengthGreaterThanFive2(List<String> l){
//        l.stream().filter(t->t.length()<6).forEach(Utils::printInTheSameLineWithASpace);
//    }

    // 6) remove the elements if the  element is starting with 'A', 'a' or ending with 'N', 'n'
    public static void removeIfStartingAOrEndingN(List<String> l){
        l.removeIf(t->t.charAt(0)=='A' || t.charAt(0)=='a' || t.charAt(t.length()-1)=='N' || t.charAt(t.length()-1)=='n');
        System.out.println("===========> "+l);
    }

    // 7) create a method which takes the square of the length of every element, prints distinctly in reverse order
    public static void lengthSquareDistinctReversed(List<Integer> l){
        // l.stream().map(String::length).map(Utils::getSquare).distinct().sorted(Comparator.reverseOrder()).forEach(Utils::printInTheSameLineWithASpace);
        // map(String::length) calismadi
        // l.stream().collect(Collectors.groupingBy(String::length)).map(Utils::getSquare).distinct().sorted(Comparator.reverseOrder()).forEach(Utils::printInTheSameLineWithASpace);
    }

    // 8)create a method to check if the length of all elements are less than 12
//    public static void checkLengthToBeLessThanTwelve(List<Integer> l){
//          // Returns whether all elements of this stream match the provided condition
//            boolean result=l.stream().allMatch(t->t.length()<12);
//            System.out.println(result);
//    }

    // 9)create a method to check if the initial  of any element is not 'X'
//    public static void checkInitials(List<Integer> l){
//        boolean result=l.stream().noneMatch(t->t.startsWith('X'));
//        System.out.println(result);
//        }

        // 10) create a method to check if at least one of the elements match the provided condition
//        public static void checkLastChar(List<Integer> l){
//        boolean result=l.stream().anyMatch(t->t.endsWith("R"));
//            System.out.println(result);
//        }

}
