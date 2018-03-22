package com.kapil.service.wordcount;

import com.kapil.service.wordcount.FileReaderInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public void wordCount() {
        String fileName = "C:\\Learning\\Paragraphtxt.txt";
        HashMap<String, Integer> wcMap = new HashMap<>();

        //Read the contents of the file as String input and delimit by comma and put them into map and increment count whenever i see the word
        //use the java stream and get the list of lines
        List<String> listOfLines = new ArrayList<>();
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            List<String> ll = stream.collect(Collectors.toList());
            System.out.println("Number of lines inside the document is:" + ll.size());

            //Calling the functional interface's method
            FileReaderInterface fi2 = (lineList) -> {
                int counter = 0;
                HashMap<String, Integer> wcMapp = new HashMap<String, Integer>();
                String splits[] = null;
                String insideStr = "";
                //ll.forEach(System.out::println);
                for (int i = 0; i < ll.size(); i++) {
                    //convert each of the lines ,which is an object inside the list to a string and split
                    insideStr = ll.get(i).toString();
                    splits = insideStr.split("\\s");
                    //get the size of this array and parse the array , add to map with key as the word and if the key exists just increment the counter
                    for (int j = 0; j < splits.length; j++) {
                        if (wcMapp.containsKey(splits[j])) {
                            //just increment the counter and add the new value to the existing key which is the word
                            String cnt = wcMapp.get(splits[j]).toString();
                            counter = Integer.valueOf(cnt) + 1;
                            wcMapp.put(splits[j], counter);
                        } else {
                            //this is the first time the word is ever found , so just add it to the map directly
                            wcMapp.put(splits[j], 1);
                        }
                    }
                }
                return wcMapp;
            };
            wcMap = (HashMap<String, Integer>) fi2.fileParse(ll);
            Map<String, Integer> sortedMap = sortMapByKeys(wcMap);


            //wcMap = (HashMap<String, Integer>) fileParse(ll); this is plain old way of Java7 or lower of calling a method
            //System.out.println("Size of the map now is:" + wcMap.size());
            //iterate the map now to display word count
            for (Map.Entry entry : sortedMap.entrySet()) {
                System.out.print("Word:" + entry.getKey() + "\t");
                System.out.println("Count:" + "\t" + entry.getValue());
            }
        } catch (IOException ioE) {
            ioE.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Use this method to sort the map based on keys
     *
     * @param wcMap
     * @return
     */
    private static Map<String, Integer> sortMapByKeys(HashMap<String, Integer> wcMap) {

        List<String> keys = new LinkedList<String>(wcMap.keySet());
        Collections.sort(keys);
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (String key : keys) {
            sortedMap.put(key, wcMap.get(key));
        }

        return sortedMap;

    }

 /*   static Map<String, Integer> fileParse(List<String> ll) {
        int counter = 0;
        HashMap<String, Integer> wcMap = new HashMap<String, Integer>();
        String splits[] = null;
        String insideStr = "";
        //ll.forEach(System.out::println);
        for (int i = 0; i < ll.size(); i++) {
            //convert each of the lines ,which is an object inside the list to a string and split
            insideStr = ll.get(i).toString();
            splits = insideStr.split("\\s");
            //get the size of this array and parse the array , add to map with key as the word and if the key exists just increment the counter
            for (int j = 0; j < splits.length; j++) {
                if (wcMap.containsKey(splits[j])) {
                    //just increment the counter and add the new value to the existing key which is the word
                    counter++;
                    wcMap.put(splits[j], counter);
                } else {
                    //this is the first time the word is ever found , so just add it to the map directly
                    wcMap.put(splits[j], counter);
                }
            }
        }
        return wcMap;
    }*/
}
