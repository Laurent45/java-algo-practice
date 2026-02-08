import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class Flattener {

    private final List<Object> flattenedList = new ArrayList<>();

    List<Object> flatten(List<?> list) {
        if (list == null) {
            return Collections.emptyList();
        }

        return list.stream()
                .filter(Objects::nonNull)
                .flatMap(item -> (item instanceof List<?> nestedList) ?
                        flatten(nestedList).stream()
                        : Stream.of(item))
                .toList();
    }

}