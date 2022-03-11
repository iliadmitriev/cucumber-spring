package org.example;

import io.cucumber.core.exception.CucumberException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try {
            // add default glue options to command line args
            String[] defaultOptions = new String[]{"--glue", "org.example"};
            String[] newArgs = Stream.concat(
                    Arrays.stream(defaultOptions),
                    Arrays.stream(args)
            ).toArray(String[]::new);

            // run tests with command line arguments
            io.cucumber.core.cli.Main.main(newArgs);

        } catch (CucumberException e) {
            System.out.println(e.getMessage());
            System.out.println("Didn't set glue and path to features\n" +
                    "Try to set ```--glue org.example path/to/features``` or use ```--help```");
        }
    }

}
