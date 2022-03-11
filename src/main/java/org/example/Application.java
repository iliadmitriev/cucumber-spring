package org.example;

import io.cucumber.core.exception.CucumberException;
import io.qameta.allure.ConfigurationBuilder;
import io.qameta.allure.ReportGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        if ( Arrays.asList(args).contains("--help") ) {
            // display cucumber help
            io.cucumber.core.cli.Main.main("--help");
        } else {
            cucumber_run_tests(args);
        }
    }

    private static void cucumber_run_tests(String[] args) {
        try {
            // add default glue options to command line args
            String[] defaultOptions = new String[]{
                    // search path for cucumber objects
                    "--glue", "org.example",
                    // plugin for reports
                    "--plugin", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
            };
            String[] newArgs = Stream.concat(
                    Arrays.stream(defaultOptions),
                    Arrays.stream(args)
            ).toArray(String[]::new);

            // run tests with command line arguments
            // (without quitting, to generate allure report later)
            byte exitStatus = io.cucumber.core.cli.Main.run(
                    newArgs,
                    Thread.currentThread().getContextClassLoader()
            );

            // generate allure report
            ReportGenerator generator = new ReportGenerator(new ConfigurationBuilder().useDefault().build());
            generator.generate(Paths.get("allure-report"), Paths.get("allure-results"));

            // exit with tests result exit code
            System.exit(exitStatus);

        } catch (CucumberException e) {
            System.out.println(e.getMessage());
            System.out.println("Didn't set glue and path to features\n" +
                    "Try to set command line parameters ```path/to/features``` or use ```--help```");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
