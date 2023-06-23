package com.rohit.optional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalPatterns {
    /**
     *
     * Optional - How to use it when to use it.
     *
     *
     * Rule #1 : Never , ever, use null for an optional variable or return value
     * Rule #2: Never use Optional.get() unless you can prove that the Optional is present.
     * Rule #3: Prefer alternative to Optional.isPresent() and Optional.get().
     * Rule #4: It’s generally a bad idea to create an Optional for the specific purpose of chaining methods from it to get a value.
     * Rule #5: If an Optional chain is nested or has an intermediate result of Optional<Optional<T>>, it’s probably too complex.
     * Rule #6: Avoid using Optional in fields, method parameters, and collections.
     * Rule #7: Avoid using identity-sensitive operations on Optionals.
     */

    private static final String EMPTY_STRING = "";

    public static void main(String[] args) {
        OptionalExample nonNullObject = new OptionalExample("text",List.of(""));

        // if you know the object not null, but we want an optional chain in that case
        // use Optional.of(T)
        Optional<OptionalExample> nonNullOptionalChain = Optional.of(nonNullObject);
        OptionalExample nullObject= null;

        //  Optional<T> and T may or may not be present in that case use
        //  Optional.ofNullable(T)
        // creating an optional chain using null as a parameter not recommended
        Optional<OptionalExample> optionalChainOnNullObject =
                Optional.ofNullable(nullObject);

        // don't do this
        Optional.ofNullable(null);

        // if you wanted to extract value from the optional chain in that case, use
        String text = nonNullOptionalChain
                .map(OptionalExample::getText) // extract the text from the optional chain
                .orElse(EMPTY_STRING); // providing default value if one of the value in the chain
        // is missing

        String text1 = nonNullOptionalChain
                .map(OptionalExample::getText)
                .orElseGet(() -> EMPTY_STRING);
        // another option for returning default values

        String text2 = nonNullOptionalChain
                .map(OptionalExample::getText)
                .orElseThrow();
        // if you don't want to return default value instead throw exception default exceptions: NOSuchElementException


        String missingValue = nonNullOptionalChain
                .map(OptionalExample::getText)
                .orElseThrow(() -> new RuntimeException("missing value"));
        // if you wanted to throw some specific exceptions when any value in the chain is null in that case, use OrElseThrow


        List<String> upperCaseList = nonNullOptionalChain
                .flatMap(obj -> Optional.ofNullable(obj.getLists()))// we can also use flatMap on optional chain// we can also create a stream pipeline from the optional
                .stream()
                .flatMap(List::stream)
                .toList();

       List<OptionalExample> dummyExampleList = new ArrayList<>();
       // suppose dummyExampleList coming from the database call it may be null, or it has a lot of elements
       // way 1 . this is one way to handle with a null list
        List<String> strings = Optional.of(dummyExampleList)
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(OptionalExample::getText)
                .toList();
        // way 2. another way to deal with a null list, we can directly apply stream on
        // the optional chain and then use a flat map to a flatted list
        List<String> strings3 = Optional.of(dummyExampleList)
                .stream()
                .flatMap(Collection::stream)
                .map(OptionalExample::getText)
                .toList();


        // getting value from the Stream<Optional<String>>
        // way 1.
        List<String> allText = dummyExampleList.stream()
                .map(obj -> Optional.ofNullable(obj.getText()))
                .filter(Optional::isPresent)
                .map(Optional::get).toList();
        // way 2.
        List<String> stringList = dummyExampleList.stream()
                .map(obj -> Optional.ofNullable(obj.getText()))
                .flatMap(Optional::stream)
                .toList();


    }

    private static class OptionalExample {
        private final String text;
        private final List<String> lists;

        public OptionalExample(String text,List<String> lists) {
            this.text = text;
            this.lists = lists;
        }

        public String getText() {
            return text;
        }

        public List<String> getLists() {
            return lists;
        }
    }
}
