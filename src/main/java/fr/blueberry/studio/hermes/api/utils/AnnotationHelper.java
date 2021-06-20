package fr.blueberry.studio.hermes.api.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class AnnotationHelper {

    private AnnotationHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * Get an annotation value from a class
     *
     * @param annotationMethodName - The method name to get value in the annotation.
     * @param clazz                - The class where the annotation is fixed.
     * @return - The annotation value or null if none is found.
     */
    public static Object getAnnotationValue(final String annotationMethodName, final Class<?> clazz) {
        for (final Annotation annotation : clazz.getAnnotations()) {
            final Class<? extends Annotation> annotationType = annotation.annotationType();

            for (final Method method : annotationType.getDeclaredMethods()) {
                if (method.getName().equals(annotationMethodName)) {
                    try {
                        return method.invoke(annotation);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     * Get an annotation value from annotation
     *
     * @param annotationMethodName - The method name to get value in the annotation.
     * @return - The annotation value or null if none is found.
     */
    public static Object getAnnotationValue(final String annotationMethodName, final Annotation annotation) {

        for (final Method method : annotation.annotationType().getDeclaredMethods()) {
            if (method.getName().equals(annotationMethodName)) {
                try {
                    return method.invoke(annotation);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}