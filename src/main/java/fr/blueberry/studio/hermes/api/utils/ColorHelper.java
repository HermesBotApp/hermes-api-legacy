package fr.blueberry.studio.hermes.api.utils;

import java.awt.Color;

public class ColorHelper {
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Convert an hexa color to RGB Color
     * @param hexa - The String of the hexadecimal color.
     * @return - The RGB Color
     */
    public static Color toRGB(String hexa) {
        return new Color(
            Integer.valueOf(hexa.substring(1, 3), 16),
            Integer.valueOf(hexa.substring(3, 5), 16),
            Integer.valueOf(hexa.substring(5, 7), 16)
        );
    }

    /**
     * Convert a Color to ANSI Foreground
     * @param color - The Color to convert
     * @return - The String representation of the ANSI Foreground color
     */
    public static String toAnsiForeground(Color color) {
        return "\u001B[38;2;" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
    }

    /**
     * Convert a Color to ANSI Background
     * @param color - The Color to convert
     * @return - The String representation of the ANSI Background color
     */
    public static String toAnsiBackground(Color color) {
        return "\u001B[48;2;" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
    }
}
