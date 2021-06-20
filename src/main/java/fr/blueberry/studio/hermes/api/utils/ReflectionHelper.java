package fr.blueberry.studio.hermes.api.utils;

public final class ReflectionHelper {

    private ReflectionHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * Get the top superclass of a class excluding 
     * java.lang.Object
     */
    public static Class<?> getMaxSuperClass(final Class<?> clazz) {
        Class<?> superClass = clazz.getSuperclass();
        if(superClass.equals(Object.class)) {
            return clazz;
        } else {
            return getMaxSuperClass(superClass);
        }
    }
}