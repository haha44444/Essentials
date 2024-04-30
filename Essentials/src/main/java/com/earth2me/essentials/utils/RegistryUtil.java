package com.earth2me.essentials.utils;

public final class RegistryUtil {

    private RegistryUtil() {
    }

    public static <T> T valueOf(Class<T> registry, String... names) {
        for (String name : names) {
            try {
                final T value = (T) registry.getDeclaredField(name).get(null);
                if (value != null) {
                    return value;
                }
            } catch (NoSuchFieldException | IllegalAccessException ignored) {
            }
        }
        return null;
    }
}
