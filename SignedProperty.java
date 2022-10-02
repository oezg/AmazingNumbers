package numbers;

import java.util.*;

public class SignedProperty {
    private Property property;
    private boolean negative;

    public SignedProperty(Property property, boolean negative) {
        this.property = property;
        this.negative = negative;
    }

    public List<SignedProperty> getMutuallyExclusives() {
        List<SignedProperty> mutuallyExclusives = List.of(new SignedProperty(getProperty(), !isNegative()));
        if (Property.mutuallyExclusiveProperties.containsKey(this)) {
            mutuallyExclusives.add(Property.mutuallyExclusiveProperties.get(this));
        }
        return mutuallyExclusives;
    }

    public SignedProperty(Property property) {
        this(property, false);
    }

    public Property getProperty() {
        return property;
    }

    public boolean isNegative() {
        return negative;
    }

    public SignedProperty getOpposite() {
        return new SignedProperty(getProperty(), !isNegative());
    }

    @Override
    public String toString() {
        String name = getProperty().getName();
        if (isNegative()) {
            name = "-" + name;
        }
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignedProperty pair = (SignedProperty) o;
        return isNegative() == pair.isNegative() && getProperty() == pair.getProperty();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProperty(), isNegative());
    }
}