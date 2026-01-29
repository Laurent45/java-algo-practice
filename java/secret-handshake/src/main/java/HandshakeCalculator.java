import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        if (number == 0) {
            return Collections.emptyList();
        }

        int offset = 1;
        List<Signal> signals = new ArrayList<>();
        for (Signal value : Signal.values()) {
            if ((number & offset) != 0) {
                signals.add(value);
            }
            offset <<= 1;
        }

        return (number & offset) != 0 ? signals.reversed() : signals;
    }

}
