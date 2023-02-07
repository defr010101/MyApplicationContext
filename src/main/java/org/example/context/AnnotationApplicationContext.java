package org.example.context;

import org.example.context.annotation.Component;
import org.example.context.annotation.Value;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContext implements ApplicationContext {
    private Map<String, Object> map = new HashMap<>();

    public AnnotationApplicationContext(Class... classes) throws InstantiationException, IllegalAccessException {
        for (int i = 0; i < classes.length; i++) {
            if (classes[i].isAnnotationPresent(Component.class)) {
                System.out.println("Start creating bean [" + classes[i].getName() + "]");

                Object bean = classes[i].newInstance();
                Component annotation = (Component) classes[i].getAnnotation(Component.class);

                Field[] fields = bean.getClass().getDeclaredFields();

                for (int j = 0; j < fields.length; j++) {
                    if (fields[j].isAnnotationPresent(Value.class)) {
                        System.out.println("Start initialization field [" + fields[j].getName() + "]");

                        Value valueAnnotation = fields[j].getAnnotation(Value.class);

                        String value = valueAnnotation.value();

                        fields[j].setAccessible(true);
                        if (fields[j].getType() == String.class) {
                            fields[j].set(bean, value);
                        } else if (fields[j].getType() == Integer.class) {
                            fields[j].set(bean, Integer.parseInt(value));
                        }

                        System.out.println("Field [" + fields[j].getName() + "] was initialize");
                    }
                }

                map.put(annotation.name(), bean);

                System.out.println("Bean [" + classes[i].getName() + "] is created");
            }
        }
    }

    @Override
    public Object getBean(String name) {
        return map.get(name);
    }
}
