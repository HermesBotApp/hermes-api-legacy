package fr.blueberry.studio.hermes.api.utils;

import java.awt.*;

public final class ColorHelper {
    public static final String ANSI_RESET = "\u001B[0m";

    private ColorHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * Convert an hexa color to RGB Color
     * @param hexa - The String of the hexadecimal color.
     * @return - The RGB Color
     */
    public static Color toRGB(final String hexa) {
        return new Color(Integer.parseInt(hexa, 16));
    }

    /**
     * Convert a Color to ANSI Foreground
     * @param color - The Color to convert
     * @return - The String representation of the ANSI Foreground color
     */
    public static String toAnsiForeground(final Color color) {
        return String.format("\u001B[38;2;%s;%s;%sm", color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * Convert a Color to ANSI Background
     * @param color - The Color to convert
     * @return - The String representation of the ANSI Background color
     */
    public static String toAnsiBackground(final Color color) {
        return String.format("\u001B[48;2;%s;%s;%sm", color.getRed(), color.getGreen(), color.getBlue());
    }
}
