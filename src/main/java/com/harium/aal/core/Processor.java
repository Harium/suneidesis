package com.harium.aal.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Processor {

    public static Process run(final String ... command) {
        //String[] fullCommand = prependString(command, params);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder().command(command).redirectErrorStream(true);
            Process process = processBuilder.start();
            //process.waitFor();
            return process;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String runOutput(String ... command) {
        Process process = run(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // Read the output from the command
        StringBuilder builder = new StringBuilder();
        String s = null;
        while (true) {
            try {
                if ((s = stdInput.readLine()) == null) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
            builder.append(s);
            builder.append("\n");
        }
        return builder.toString();
    }

}
