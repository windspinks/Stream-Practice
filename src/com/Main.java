package com;

import javax.xml.ws.EndpointReference;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        printEntries(entries);
        printTuesdays(entries);
        countTueWedThur(entries);
        weekendList(entries);
        weekdaySet(entries);
        printDurationGreaterThan10(entries);
        findMaxDuration(entries);
        listGreaterThan50(entries);
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println("For Loop:");
        for (Entry entry : entries) {
            System.out.println(entry + ", ");
        }
        System.out.println("\nStream, forEach:");
        entries.forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {

        //Print out tuesday entries
        System.out.println("For Loop:");
        for (Entry e : entries){
            if (e.getDay().equals(Day.TUESDAY))
            {System.out.println(e + ", ");}
        }
        System.out.println("\nStream, filter, forEach:");
        entries.stream().filter(e -> e.getDay().equals(Day.TUESDAY))
            .forEach(e -> System.out.println(e + ", "));
        System.out.println();
    }

    public static void countTueWedThur(List<Entry> entries) {
        //Count the number of Tuesday, Wednesday, and Thursday entries
        System.out.println("For Loop:");
        int count = 0;
        for (Entry e : entries){
            if (e.getDay().equals(Day.TUESDAY)){count++;}
            if (e.getDay().equals(Day.WEDNESDAY)){count++;}
            if (e.getDay().equals(Day.THURSDAY)){count++;}
        }
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count);
        System.out.println("Stream, filter, count: ");
        long count1 = entries.stream()
            .filter(e -> e.getDay().equals(Day.TUESDAY) || e.getDay().equals(Day.WEDNESDAY) || e.getDay().equals(Day.THURSDAY))
            .count();
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count1);
        System.out.println();
    }

    public static void weekendList(List<Entry> entries) {
        //Create a list of weekend (Saturday and Sunday) entries
        System.out.println("For Loop:");
        List<Entry> weekends = new ArrayList<>();
        for (Entry e : entries){
            if (e.getDay().equals(Day.SATURDAY) || e.getDay().equals(Day.SUNDAY))
            weekends.add(e);
        }
        System.out.println(weekends);
        System.out.println("Stream, filter, collect:");
        weekends = entries.stream().filter(e -> e.getDay().equals(Day.SATURDAY) || e.getDay().equals(Day.SUNDAY))
            .collect(Collectors.toList());
        System.out.println(weekends);
        System.out.println();
    }

    public static void weekdaySet(List<Entry> entries) {
        //Create a SET of weekday entries
        System.out.println("For Loop:");
        Set<String> weekdays = new HashSet<>();
        for (Entry e : entries){
            if (e.getDay().equals(Day.MONDAY) ||
                e.getDay().equals(Day.TUESDAY) ||
                e.getDay().equals(Day.WEDNESDAY) ||
                e.getDay().equals(Day.THURSDAY) ||
                e.getDay().equals(Day.FRIDAY))
            {weekdays.add(e.getNote());}
        }
        System.out.println(weekdays);
        System.out.println("Stream, filter, map, collect:");
        weekdays = entries.stream()
            .filter(e ->
                e.getDay().equals(Day.MONDAY) ||
                e.getDay().equals(Day.TUESDAY) ||
                e.getDay().equals(Day.WEDNESDAY) ||
                e.getDay().equals(Day.THURSDAY) ||
                e.getDay().equals(Day.FRIDAY))
            .map(Entry::getNote)
            .collect(Collectors.toSet());
        System.out.println(weekdays);
        System.out.println();
    }

    public static void printDurationGreaterThan10(List<Entry> entries){
        System.out.println("For Loop:");
        for (Entry e : entries){
            if (e.getDuration() > 10){
                System.out.println(e.getDuration());
            }
        }
        System.out.println("Stream, filter, forEach:");
        entries.stream().filter(e -> e.getDuration() > 10)
            .forEach(e -> System.out.println(e.getDuration()));
        System.out.println();
    }

    public static void findMaxDuration(List<Entry> entries){
        System.out.println("For Loop:");
        int temp = 0;
        for (Entry e : entries){
            if (e.getDuration() > temp){
                temp = e.getDuration();
            }
        }
        System.out.println("The Max Duration is: " + temp);
        System.out.println("Stream, mapToInt, max, getAsInt:");
        temp = entries.stream().mapToInt(Entry::getDuration)
            .max().getAsInt();
        System.out.println("The Max Duration is: " + temp);
        System.out.println();
    }

    public static void listGreaterThan50(List<Entry> entries){
        System.out.println("For Loop:");
        List<Entry> greaterThan50 = new ArrayList<>();
        for (Entry e : entries){
            if (e.getDuration() > 50){
                greaterThan50.add(e);
            }
        }
        System.out.println(greaterThan50);
        System.out.println("Stream, filter, collect:");
        greaterThan50 = entries.stream().filter(e -> e.getDuration() > 50).collect(Collectors.toList());
        System.out.println(greaterThan50);
        System.out.println();
    }
}
