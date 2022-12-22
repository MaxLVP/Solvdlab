package com.solvd.library.utils;

import com.solvd.library.MyLogger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileReadAndWriteUtil {
    static final MyLogger LOGGER = MyLogger.getInstance();
    private static final HashMap<String, Integer> NUMBER_OF_WORDS = new HashMap<>();

    public static void countUniqueWordsInFile() {
        try {
            List<String> content = FileUtils.readLines(new File("src/main/resources/fileToRead.txt"),
                    StandardCharsets.UTF_8);
            String contents = StringUtils.join(content, " ");
            contents = RegExUtils.removeAll(contents, "\\p{P}");
            List<String> words = Arrays.stream(StringUtils.split(StringUtils.lowerCase(contents), " "))
                    .distinct().toList();
            FileUtils.writeStringToFile(new File("src/main/resources/fileToWrite.txt"),
                    "Количество уникальных слов: " + words.size(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            LOGGER.warn(ex.getMessage());
        }
    }

    public static void countWordsInFile() {
        try {
            List<String> content = FileUtils.readLines(new File("src/main/resources/fileToRead.txt"),
                    StandardCharsets.UTF_8);
            String contents = StringUtils.join(content, " ");
            contents = RegExUtils.removeAll(contents, "\\p{P}");
            List<String> words = Arrays.stream(StringUtils.split(StringUtils.lowerCase(contents))).toList();
            for (String word : words) {
                int count = Collections.frequency(words, word);
                NUMBER_OF_WORDS.put(word, count);
            }
            for (String key : NUMBER_OF_WORDS.keySet()) {
                FileUtils.writeStringToFile(new File("src/main/resources/numberOfWords.txt"),
                        "Слово: " + key + " Количество вхождений: " + NUMBER_OF_WORDS.get(key) + "\n",
                        StandardCharsets.UTF_8, true);
            }
        } catch (IOException ex) {
            LOGGER.warn(ex.getMessage());
        }
    }
}
