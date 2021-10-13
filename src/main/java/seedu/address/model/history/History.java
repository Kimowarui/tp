package seedu.address.model.history;

import static java.util.Objects.requireNonNull;

public class History {
    public final String value;

    public  History(String history) {
        requireNonNull(history);
        value = history;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof History // instanceof handles nulls
                && value.equals(((History) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
