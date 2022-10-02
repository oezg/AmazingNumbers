package numbers;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
    private Request request;
    public NumberList(Request request) {
        this.request = request;
        getNumbers().forEach(Number::printLine);
        System.out.println();
    }

    private List<Number> getNumbers() {
        List<Number> numberList = new ArrayList<>();
        if (this.request.getRequestedProperties().isEmpty()) {
            for (long i = this.request.getStart(); i < this.request.getStart() + this.request.getLength(); i++) {
                numberList.add(new Number(i));
            }
        } else {
            long i = this.request.getStart();
            while (numberList.size() < this.request.getLength()) {
                Number number = new Number(i);
                boolean correspondToRequest = true;
                for (SignedProperty pair: this.request.getRequestedProperties()) {
                    if (pair.isNegative() && number.getProperty(pair.getProperty()) ||
                    !(pair.isNegative() || number.getProperty(pair.getProperty()))) {
                        correspondToRequest = false;
                        break;
                    }
                }
                if (correspondToRequest) {
                    numberList.add(number);
                }
                i++;
            }
        }
        return numberList;
    }
}
