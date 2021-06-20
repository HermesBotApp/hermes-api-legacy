package fr.blueberry.studio.hermes.api.utils;

import org.apache.commons.io.IOUtils;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class FileHelper {

    private FileHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    
    /**
     * Copy a file inside the jar application to a destination file
     * @param src - The source file to copy
     * @param dest - The destination file
     * @throws IOException - If something went wrong while manipulating IOs
     */
    public static void copyFileFromJar(final String src, final String dest) throws IOException {
        final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(src);
        final FileOutputStream out = new FileOutputStream(dest);

        IOUtils.copy(is, out);
    }

    /**
     * Copy a file from the jar.
     * @param src - The jar source?
     * @param path - The file source path in jar.
     * @param dest - The destination file.
     * @return - A copy of the jar file in destination file.
     * @throws IOException - If there is something wrong with I/O. 
     */
    public static File copyFileFromJar(final File src, final String path, final File dest) throws IOException {
        final JarFile jarFile = new JarFile(src);
        final JarEntry jarEntry = jarFile.getJarEntry(path);
        final InputStream is = jarFile.getInputStream(jarEntry);
        final FileOutputStream out = new FileOutputStream(dest);
        
        IOUtils.copy(is, out);
        out.close();
        is.close();
        jarFile.close();

        return dest;
    }

    /**
     * Get a jar entry in a jar file.
     * @param jar - The jar where to get entry.
     * @param file - The path of the file inside the jar
     * @return - The file entry in jar
     * @throws IOException - If there is something wrong with I/O
     */
    public static JarEntry getFileEntry(final File jar, final String file) throws IOException {
        final JarFile jarFile = new JarFile(jar);
        final JarEntry jarEntry = jarFile.getJarEntry(file);
       
        jarFile.close();

        return jarEntry;
    }

    /**
     * Parse a plugin meta file.
     * @param pluginFile - The plugin file to parse
     * @return - A yaml with all the parsed data
     */
    public static YamlFile parsePluginMeta(final File pluginFile) throws IOException {
        final File tempOutFile = File.createTempFile(pluginFile.getName(), ".yml");
        tempOutFile.deleteOnExit();

        return new YamlFile(copyFileFromJar(pluginFile, "plugin.yml", tempOutFile));
    }
}