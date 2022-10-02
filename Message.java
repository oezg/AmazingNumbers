package numbers;

import java.util.List;
import java.util.stream.Collectors;

public enum Message {

    FIRST("The first parameter should be a natural number or zero."),
    SECOND("The second parameter should be a natural number."),
    AVAILABLE(String.format("Available properties: [%s]", getAllProperties())),
    IS_WRONG("The property [%s] is wrong.\n"),
    ARE_WRONG("The properties [%s] are wrong.\n"),
    MUTUALLY("The request contains mutually exclusive properties: [%s, %s]\n"),
    NO_NUMBERS("There are no numbers with these properties.");

    String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    private static String getAllProperties() {
        List<String> names = Property.getAllProperties().stream().map(Property::getName).collect(Collectors.toList());
        return String.join(", ", names);
    }
}