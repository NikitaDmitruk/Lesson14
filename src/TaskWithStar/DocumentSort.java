package TaskWithStar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentSort {
    public static void main(String[] args) {
        Scanner scanners = new Scanner(System.in);
        StringBuilder textForValidation = new StringBuilder();
        System.out.println("Укажите путь к файлу:");
        try (FileReader reader = new FileReader(scanners.nextLine())) {
            int i;
            while ((i = reader.read()) != -1) {
                textForValidation.append((char) i);
            }
            ArrayList<String> documents = new ArrayList<>();
            Matcher document = Pattern.compile("\\w+").matcher(textForValidation);
            while (document.find()) {
                documents.add(document.group());
            }
            for (String text : documents) {
                System.out.println(text);
                Validator.validation(text);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static class Validator {
        public static void validation(String text) {
            try (FileWriter reportValid = new FileWriter("src/TaskWithStar/ReportWithValidDocs.txt", true);
                 FileWriter reportInvalid = new FileWriter("src/TaskWithStar/ReportWithInvalidDocs.txt", true)) {
                Matcher valid = Pattern.compile("(docnum|contract)\\w+").matcher(text);
                if (text.length() == 15) {
                    if (valid.matches()) {
                        reportValid.write(text + "\n");
                        reportValid.flush();
                    } else {
                        reportInvalid.write(text + " - не содержит docnum или contract!\n");
                        reportInvalid.flush();
                    }
                } else if (valid.matches()) {
                    reportInvalid.write(text + " - длина не 15 символов!\n");
                    reportInvalid.flush();
                } else {
                    reportInvalid.write(text + " - не содержит docnum или contract и длина не 15 символов!\n");
                    reportInvalid.flush();
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
