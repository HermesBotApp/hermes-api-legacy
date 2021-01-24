package fr.blueberry.studio.hermes.api.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
    /**
     * Split an input into args and remove the split tag.
     * Manage to get Strings in quote into a single arg.
     * @param input - The input to process
     * @param splitTag - The split tag to remove if exists.
     * @return - An array containing the splitted args.
     */

    public static String[] argumentify(String input, char splitTag) {
        final String[] originalArgs = input.split(" ");
        final Pattern pattern = Pattern.compile("\"(.*?)\"");
        final Matcher matcher = pattern.matcher(input);
        final ArrayList<String> matches = new ArrayList<>();

        while(matcher.find()) {
           matches.add(matcher.group());
        }

        for(String match : matches) {
            input = input.replace(match, "");
        }

        final ArrayList<String> finalArgs = new ArrayList<>();

        int skip = 0;

        for (String originalArg : originalArgs) {
            boolean matched = false;

            for (String match : matches) {
                if (match.startsWith(originalArg)) {
                    finalArgs.add(match.replace("\"", ""));
                    matches.remove(match);
                    matched = true;
                    skip = match.split(" ").length - 1;
                    break;
                }
            }

            if (!matched) {
                if (skip == 0) {
                    finalArgs.add(originalArg);
                } else {
                    skip--;
                }
            }
        }

        return finalArgs.toArray(String[]::new);
    }

    /**
     * Concatenate args into one string after a given index (including index).
     * @param index - The index to concat after.
     * @param args - The args array
     * @return - A string of the args with spaces.
     */
    public static String stringify(int index, String[] args) {
        final StringBuilder sb = new StringBuilder();

        for(int i = 0; i < args.length; i++) {
            if(i >= index) {
                sb.append(args[i]).append(" ");
            }
        }

        return sb.toString();
    }

    /**
     * Convert a full command args with label to command args without label.
     * @param plainArgs - The full command args & label
     * @return - The args of the command without label.
     */
    public static String[] removeCommandLabel(String[] plainArgs) {
        final String[] args = new String[plainArgs.length - 1];

        System.arraycopy(plainArgs, 1, args, 0, args.length);

        return args;
    }

    /**
     * Capitalize the first letter of a word.
     * @param word - The word to capitalize
     * @return - The capitalized word.
     */
    public static String capitalizeFirst(String word) {
        final String firstLetter = word.substring(0, 1).toUpperCase();

        return firstLetter + word.substring(1);
    }

}