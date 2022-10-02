package numbers;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Number {
    private final long number;
    private final List<Integer> digits;
    private final Map<Property, Boolean> properties;

    Number(long number) {
        this.number = number;
        this.digits = listDigits(this.number);
        this.properties = new HashMap<>();
        setProperties();
    }
    private void setProperties() {
        this.properties.put(Property.EVEN, isEven());
        this.properties.put(Property.ODD, !isEven());
        this.properties.put(Property.BUZZ, isBuzz());
        this.properties.put(Property.DUCK, isDuck());
        this.properties.put(Property.PALINDROMIC, isPalindromic());
        this.properties.put(Property.GAPFUL, isGapful());
        this.properties.put(Property.SPY, isSpy());
        this.properties.put(Property.SQUARE, isSquare(this.number));
        this.properties.put(Property.SUNNY, isSunny());
        this.properties.put(Property.JUMPING, isJumping());
        this.properties.put(Property.HAPPY, isHappy());
        this.properties.put(Property.SAD, !isHappy());
    }

    public boolean getProperty(Property property) {
        return this.properties.get(property);
    }

    private static List<Integer> listDigits(long number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, (int) (number % 10));
            number /= 10;
        }
        return digits;
    }

    private static int getSumDigitsSquared(long number) {
        return listDigits(number).stream().map(x -> x * x).reduce(0, Integer::sum);
    }

    private List<Integer> getDigits() { return this.digits; }

    private int getNumberDigits() { return getDigits().size(); }

    private int getDigit(int fromLeft) { return getDigits().get(fromLeft); }

    private boolean isHappy() {
        List<Integer> visitedDigitsSquared = new ArrayList<>();
        int sumDigitsSquared = getSumDigitsSquared(this.number);
        while(!visitedDigitsSquared.contains(sumDigitsSquared)) {
            if (sumDigitsSquared == 1) {
                return true;
            }
            visitedDigitsSquared.add(sumDigitsSquared);
            sumDigitsSquared = getSumDigitsSquared(sumDigitsSquared);
        }
        return false;
    }

    private boolean isPalindromic() {
        int numDigits = getNumberDigits();
        for (int i = 0; i < numDigits / 2; i++) {
            int left = getDigit(i);
            int right = getDigit(numDigits - 1 - i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    private boolean isJumping() {
        for (int i = 1; i < getNumberDigits(); i++) {
            int difference = Math.abs(getDigit(i) - getDigit(i - 1));
            if (difference != 1) {
                return false;
            }
        }
        return true;
    }
    private boolean isDuck() { return getDigits().contains(0); }

    private boolean isBuzz() { return this.number % 7 == 0 || this.number % 10 == 7; }

    private boolean isEven() {
        return this.number % 2 == 0;
    }

    private boolean isGapful() {
        if (getNumberDigits() < 3) {
            return false;
        }
        int gap = 10 * getDigit(0) + getDigit(getNumberDigits() - 1);
        return this.number % gap == 0;
    }

    private boolean isSpy() {
        int sumOfDigits = getDigits().stream().reduce(0, Integer::sum);
        int productOfDigits = getDigits().stream().reduce(1, (a, b) -> a * b);
        return sumOfDigits == productOfDigits;
    }

    private static boolean isSquare(long number) { return Math.sqrt(number) == Math.floor(Math.sqrt(number)); }

    private boolean isSunny() { return isSquare(this.number + 1); }

    public void printCard() {
        System.out.printf("Properties of %d\n", this.number);
        for (Map.Entry<Property, Boolean> entry: this.properties.entrySet()) {
            System.out.printf("%12s: %s\n", entry.getKey().getName().toLowerCase(), entry.getValue().toString());
        }
    }

    private List<String> getNamesPropertiesNumberHas() {
        return this.properties.entrySet().stream().filter(Map.Entry::getValue)
                .map(propertyBooleanEntry -> propertyBooleanEntry.getKey().getName().toLowerCase())
                .collect(Collectors.toList());
    }
    public void printLine() {
        System.out.printf("%16s is %s\n",
                NumberFormat.getIntegerInstance().format(this.number),
                String.join(", ", getNamesPropertiesNumberHas()));
    }
}