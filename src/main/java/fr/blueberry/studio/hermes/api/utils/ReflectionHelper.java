package fr.blueberry.studio.hermes.api.utils;

public class ReflectionHelper {

    /**
     * Get the top superclass of a class excluding 
     * java.lang.Object
     */
    public static Class<?> getMaxSuperClass(Class<?> clazz) {
        Class<?> lastClass = clazz;

        while(clazz != Object.class) {
            clazz = clazz.getSuperclass();
            if(clazz != Object.class) {
                lastClass = clazz;
            }
        }

        return lastClass;
    }
}