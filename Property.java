package numbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Property {

    EVEN("EVEN"),
    ODD("ODD"),
    BUZZ("BUZZ"),
    DUCK("DUCK"),
    PALINDROMIC("PALINDROMIC"),
    GAPFUL("GAPFUL"),
    SPY("SPY"),
    SQUARE("SQUARE"),
    SUNNY("SUNNY"),
    JUMPING("JUMPING"),
    HAPPY("HAPPY"),
    SAD("SAD");

    String property;
    public final static Map<SignedProperty, SignedProperty> mutuallyExclusiveProperties;

    static {
        mutuallyExclusiveProperties = new HashMap<>();
        mutuallyExclusiveProperties.put(new SignedProperty(EVEN), new SignedProperty(ODD));
        mutuallyExclusiveProperties.put(new SignedProperty(EVEN, true), new SignedProperty(ODD, true));
        mutuallyExclusiveProperties.put(new SignedProperty(DUCK), new SignedProperty(SPY));
        mutuallyExclusiveProperties.put(new SignedProperty(SQUARE), new SignedProperty(SUNNY));
        mutuallyExclusiveProperties.put(new SignedProperty(HAPPY), new SignedProperty(SAD));
        mutuallyExclusiveProperties.put(new SignedProperty(HAPPY, true), new SignedProperty(SAD, true));
    }

    Property(String property) {
        this.property = property;
    }

    public String getName() {
        return this.property;
    }

    public static List<Property> getAllProperties() { return List.of(values()); }
}

