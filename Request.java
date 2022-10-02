package numbers;

import java.util.ArrayList;
import java.util.List;

public class Request {
    private final String[] parts;
    private final long start;
    private long length;
    private List<SignedProperty> requestedProperties;
    private List<String> illegalRequests;


    public Request(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("The string you have entered is blank.");
        }
        this.parts = input.split("\\s+");
        this.start = getNumber(this.parts[0]);
        if (this.start < 0) {
            printErrorMessage(1);
            return;
        }
        this.requestedProperties = new ArrayList<>();
        makeRequest();
    }
    
    private void makeRequest() {
        if (this.parts.length == 1) {
            new Number(this.start).printCard();
            return;
        }
        this.length = getNumber(this.parts[1]);
        if (this.length <= 0) {
            printErrorMessage(2);
            return;
        }
        this.illegalRequests = new ArrayList<>();
        for (int i = 2; i < this.parts.length; i++) {
            boolean negated = false;
            String name = this.parts[i];
            if (this.parts[i].charAt(0) == '-') {
                negated = true;
                name = name.substring(1);
            }
            try {
                Property property = Property.valueOf(name);
                this.requestedProperties.add(new SignedProperty(property, negated));
            } catch (IllegalArgumentException e) {
                this.illegalRequests.add(this.parts[i]);
            }
        }
        if (!this.illegalRequests.isEmpty()) {
            if (this.illegalRequests.size() == 1) {
                printErrorMessage(3);
            } else {
                printErrorMessage(4);
            }
            return;
        }
        if (areAnyPropertiesMutuallyExclusive()) {
            return;
        }
        new NumberList(this);
    }

    public List<SignedProperty> getRequestedProperties() {
        return this.requestedProperties;
    }

    public long getStart() {
        return this.start;
    }

    public long getLength() {
        return this.length;
    }

    private boolean areAnyPropertiesMutuallyExclusive() {
        for (SignedProperty signedProperty: this.requestedProperties) {
            if (this.requestedProperties.contains(signedProperty.getOpposite())) {
                printErrorMessage(5, signedProperty, signedProperty.getOpposite());
                return true;
            }
            if (Property.mutuallyExclusiveProperties.containsKey(signedProperty) &&
                    this.requestedProperties.contains(Property.mutuallyExclusiveProperties.get(signedProperty))) {
                printErrorMessage(5, signedProperty, Property.mutuallyExclusiveProperties.get(signedProperty));
                return true;
            }
        }
        return false;
    }

    private long getNumber(String part) {
        try {
            return Long.parseLong(part);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void printErrorMessage(int level, SignedProperty... pair) {
        switch (level) {
            case 1 -> {
                System.out.println(Message.FIRST.getMessage());
            }
            case 2 -> {
                System.out.println(Message.SECOND.getMessage());
            }
            case 3 -> {
                System.out.printf(Message.IS_WRONG.getMessage(), this.illegalRequests.get(0));
                System.out.println(Message.AVAILABLE.getMessage());
            }
            case 4 -> {
                System.out.printf(Message.ARE_WRONG.getMessage(), String.join(", ", this.illegalRequests));
                System.out.println(Message.AVAILABLE.getMessage());
            }
            case 5 -> {
                System.out.printf(Message.MUTUALLY.getMessage(), pair[0].toString(),
                        pair[1].toString());
                System.out.println(Message.NO_NUMBERS.getMessage());
            }
        }
        System.out.println();
    }

}
