package net.sonicd5.framecage.util.type;

import java.util.HashMap;
import java.util.Map;

public class TypedStorage {
    Map<Class<?>, Object> map = new HashMap<>();

    @SafeVarargs
    public <E> TypedStorage(E... objects) {
        for (E element : objects) {
            map.put(element.getClass(), element);
        }
    }

    @SuppressWarnings("unchecked")
    public <E> E getByType(Class<E> key, boolean isCovariant) {
        if (isCovariant) {
            for (Map.Entry<Class<?>, Object> entry : map.entrySet()) {
                if (key.isAssignableFrom(entry.getKey())) {
                    return (E) entry.getValue();
                }
            }
        } else {
            return (E) map.get(key);
        }

        return null;
    }

    public <E> E getByType(Class<E> key) {
        return getByType(key, false);
    }

    public <E> boolean contains(Class<E> key) {
        return map.containsKey(key);
    }
}
