package injectable;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Injector {

    private Map<String, String> injectingFields = new HashMap<>();

    public Injector(String inputStr) {
        Scanner scanner = new Scanner(inputStr);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] classNames = line.split("=");
            switch (classNames.length) {
                case 0:
                case 1:
                    throw new RuntimeException("В строке " + line + " отсутвуют '='");
                case 2:
                    injectingFields.put(classNames[0], classNames[1]);
                    break;
                default:
                    throw new RuntimeException("В строке " + line + " больше 1 '='");
            }
        }
    }

    public Injector(File file) throws FileNotFoundException {
        this(new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n")));
    }

    public <T> T inject(T object) {
        Class<?> objectClass = object.getClass();
        List<Field> fields = getFieldsWithSuperClasses(objectClass);
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                field.setAccessible(true);
                if (!setField(object, field))
                    throw new RuntimeException("Ошибка задания значения");
            }
        }
        return object;
    }

    private List<Field> getFieldsWithSuperClasses(Class<?> object){
        ArrayList<Field> fields = new ArrayList<>();
        Class<?> currClass = object;
        while(currClass!=null){
            fields.addAll(Arrays.asList(currClass.getDeclaredFields()));
            currClass = currClass.getSuperclass();
        }
        return fields;
    }

    private <T> boolean setField(T object, Field field) {
        try {
            Class<?> clazz = getClass().getClassLoader().loadClass(injectingFields.get(field.getType().getName()));
            field.set(object, inject(clazz.getConstructor().newInstance()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
