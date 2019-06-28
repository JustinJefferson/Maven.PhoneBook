package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> map;
    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        List<String> numbers = new LinkedList<>();
        numbers.add(phoneNumber);
        map.put(name, numbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> numbers = new LinkedList<>();
        Collections.addAll(numbers, phoneNumbers);
        map.put(name, numbers);
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        Boolean entry = map.containsKey(name);
        if(entry) {
            return true;
        }
        else {
            List<List<String>> allNumbers = new LinkedList<>(map.values());
            for(List<String> listNumbers : allNumbers) {
                if(listNumbers.contains(name)) return true;
            }
        }

        return false;
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        List<String> names = new LinkedList<>(map.keySet());
        for(String name : names) {
            if(map.get(name).contains(phoneNumber)) return name;
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new LinkedList<>(map.keySet());
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
