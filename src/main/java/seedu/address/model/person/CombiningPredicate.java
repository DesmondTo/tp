package seedu.address.model.person;

import java.util.function.Predicate;

/**
 * Creates a new Predicate by combining the logic of two separate Predicates
 */
public class CombiningPredicate implements Predicate<Person> {

    private Predicate<Person> firstPredicate;
    private Predicate<Person> secondPredicate;

    /**
     * Creates a new predicate that combines the logic of two predicates
     *
     * @param firstPredicate Predicate number 1
     * @param secondPredicate Predicate number 2
     */
    public CombiningPredicate(Predicate<Person> firstPredicate, Predicate<Person> secondPredicate) {
        this.firstPredicate = firstPredicate;
        this.secondPredicate = secondPredicate;
    }

    @Override
    public boolean test(Person person) {
        return firstPredicate.test(person) && secondPredicate.test(person);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CombiningPredicate // instanceof handles nulls
                && firstPredicate.equals(((CombiningPredicate) other).firstPredicate)
                && secondPredicate.equals(((CombiningPredicate) other).secondPredicate)); // state check
    }

}
