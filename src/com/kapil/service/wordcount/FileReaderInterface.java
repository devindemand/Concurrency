package com.kapil.service.wordcount;

import java.util.List;
import java.util.Map;

/**
 * This interface is a functional interface annototed accordingly.so this has one abstract method which will parse the lines given after reading the file
 */
@FunctionalInterface
public interface FileReaderInterface {
    Map<String, Integer> fileParse(List<String> ll);
}
