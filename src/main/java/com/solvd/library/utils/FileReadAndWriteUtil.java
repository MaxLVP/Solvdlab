package com.solvd.library.utils;

import com.solvd.library.MyLogger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class FileReadAndWriteUtil {
    static final MyLogger logger = MyLogger.getInstance();

    public static void readAndWriteFile() {
        try {
            List<String> content = FileUtils.readLines(new File("src/main/resources/fileToRead.txt"), StandardCharsets.UTF_8);
            String contents = StringUtils.join(content, " ");
            contents = RegExUtils.removeAll(contents, "\\p{P}");
            List<String> words = Arrays.stream(StringUtils.split(StringUtils.lowerCase(contents), " ")).distinct().toList();
            FileUtils.writeStringToFile(new File("src/main/resources/fileToWrite.txt"), "Количество уникальных слов: " + words.size(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            logger.warn(ex.getMessage());
        }
    }
}
