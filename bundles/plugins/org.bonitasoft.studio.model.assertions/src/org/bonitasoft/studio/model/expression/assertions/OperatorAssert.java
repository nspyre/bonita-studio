package org.bonitasoft.studio.model.expression.assertions;

import static java.lang.String.format;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.bonitasoft.studio.model.expression.Operator;

/**
 * {@link Operator} specific assertions - Generated by CustomAssertionGenerator.
 */
public class OperatorAssert extends AbstractAssert<OperatorAssert, Operator> {

    /**
     * Creates a new </code>{@link OperatorAssert}</code> to make assertions on actual Operator.
     * @param actual the Operator we want to make assertions on.
     */
    public OperatorAssert(Operator actual) {
        super(actual, OperatorAssert.class);
    }

    /**
     * An entry point for OperatorAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
     * With a static import, one's can write directly : <code>assertThat(myOperator)</code> and get specific assertion with code completion.
     * @param actual the Operator we want to make assertions on.
     * @return a new </code>{@link OperatorAssert}</code>
     */
    public static OperatorAssert assertThat(Operator actual) {
        return new OperatorAssert(actual);
    }

    /**
     * Verifies that the actual Operator's expression is equal to the given one.
     * @param expression the given expression to compare the actual Operator's expression to.
     * @return this assertion object.
     * @throws AssertionError - if the actual Operator's expression is not equal to the given one.
     */
    public OperatorAssert hasExpression(String expression) {
        // check that actual Operator we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        String errorMessage = format("\nExpected <%s> expression to be:\n  <%s>\n but was:\n  <%s>", actual, expression, actual.getExpression());

        // check
        if (!actual.getExpression().equals(expression)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Operator's inputTypes contains the given String elements.
     * @param inputTypes the given elements that should be contained in actual Operator's inputTypes.
     * @return this assertion object.
     * @throws AssertionError if the actual Operator's inputTypes does not contain all given String elements.
     */
    public OperatorAssert hasInputTypes(String... inputTypes) {
        // check that actual Operator we want to make assertions on is not null.
        isNotNull();

        // check that given String varargs is not null.
        if (inputTypes == null)
            throw new AssertionError("Expecting inputTypes parameter not to be null.");

        // check with standard error message (see commented below to set your own message).
        Assertions.assertThat(actual.getInputTypes()).contains(inputTypes);

        // uncomment the 4 lines below if you want to build your own error message :
        // WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
        // String errorMessage = "my error message";
        // assertionInfo.overridingErrorMessage(errorMessage);
        // Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Operator has no inputTypes.
     * @return this assertion object.
     * @throws AssertionError if the actual Operator's inputTypes is not empty.
     */
    public OperatorAssert hasNoInputTypes() {
        // check that actual Operator we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        String errorMessage = format("\nExpected :\n  <%s>\nnot to have inputTypes but had :\n  <%s>", actual, actual.getInputTypes());

        // check
        if (!actual.getInputTypes().isEmpty())
            throw new AssertionError(errorMessage);

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Operator's type is equal to the given one.
     * @param type the given type to compare the actual Operator's type to.
     * @return this assertion object.
     * @throws AssertionError - if the actual Operator's type is not equal to the given one.
     */
    public OperatorAssert hasType(String type) {
        // check that actual Operator we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        String errorMessage = format("\nExpected <%s> type to be:\n  <%s>\n but was:\n  <%s>", actual, type, actual.getType());

        // check
        if (!actual.getType().equals(type)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

}