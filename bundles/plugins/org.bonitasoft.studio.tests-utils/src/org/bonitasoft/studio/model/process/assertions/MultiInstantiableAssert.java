package org.bonitasoft.studio.model.process.assertions;

import static java.lang.String.format;

import org.assertj.core.api.AbstractAssert;
import org.bonitasoft.studio.model.expression.Expression;
import org.bonitasoft.studio.model.process.Data;
import org.bonitasoft.studio.model.process.MultiInstanceType;
import org.bonitasoft.studio.model.process.MultiInstantiable;

/**
 * {@link MultiInstantiable} specific assertions - Generated by CustomAssertionGenerator.
 */
public class MultiInstantiableAssert extends AbstractAssert<MultiInstantiableAssert, MultiInstantiable> {

    /**
     * Creates a new </code>{@link MultiInstantiableAssert}</code> to make assertions on actual MultiInstantiable.
     * 
     * @param actual the MultiInstantiable we want to make assertions on.
     */
    public MultiInstantiableAssert(final MultiInstantiable actual) {
        super(actual, MultiInstantiableAssert.class);
    }

    /**
     * An entry point for MultiInstantiableAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
     * With a static import, one's can write directly : <code>assertThat(myMultiInstantiable)</code> and get specific assertion with code completion.
     * 
     * @param actual the MultiInstantiable we want to make assertions on.
     * @return a new </code>{@link MultiInstantiableAssert}</code>
     */
    public static MultiInstantiableAssert assertThat(final MultiInstantiable actual) {
        return new MultiInstantiableAssert(actual);
    }

    /**
     * Verifies that the actual MultiInstantiable's cardinalityExpression is equal to the given one.
     * 
     * @param cardinalityExpression the given cardinalityExpression to compare the actual MultiInstantiable's cardinalityExpression to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's cardinalityExpression is not equal to the given one.
     */
    public MultiInstantiableAssert hasCardinalityExpression(final Expression cardinalityExpression) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> cardinalityExpression to be:\n  <%s>\n but was:\n  <%s>", actual, cardinalityExpression,
                actual.getCardinalityExpression());

        // check
        if (!actual.getCardinalityExpression().equals(cardinalityExpression)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's collectionDataToMultiInstantiate is equal to the given one.
     * 
     * @param collectionDataToMultiInstantiate the given collectionDataToMultiInstantiate to compare the actual MultiInstantiable's
     *        collectionDataToMultiInstantiate to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's collectionDataToMultiInstantiate is not equal to the given one.
     */
    public MultiInstantiableAssert hasCollectionDataToMultiInstantiate(final Data collectionDataToMultiInstantiate) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> collectionDataToMultiInstantiate to be:\n  <%s>\n but was:\n  <%s>", actual,
                collectionDataToMultiInstantiate, actual.getCollectionDataToMultiInstantiate());

        // check
        if (!actual.getCollectionDataToMultiInstantiate().equals(collectionDataToMultiInstantiate)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's completionCondition is equal to the given one.
     * 
     * @param completionCondition the given completionCondition to compare the actual MultiInstantiable's completionCondition to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's completionCondition is not equal to the given one.
     */
    public MultiInstantiableAssert hasCompletionCondition(final Expression completionCondition) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> completionCondition to be:\n  <%s>\n but was:\n  <%s>", actual, completionCondition,
                actual.getCompletionCondition());

        // check
        if (!actual.getCompletionCondition().equals(completionCondition)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's iteratorExpression is equal to the given one.
     * 
     * @param iteratorExpression the given iteratorExpression to compare the actual MultiInstantiable's iteratorExpression to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's iteratorExpression is not equal to the given one.
     */
    public MultiInstantiableAssert hasIteratorExpression(final Expression iteratorExpression) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> iteratorExpression to be:\n  <%s>\n but was:\n  <%s>", actual, iteratorExpression,
                actual.getIteratorExpression());

        // check
        if (!actual.getIteratorExpression().equals(iteratorExpression)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's listDataContainingOutputResults is equal to the given one.
     * 
     * @param listDataContainingOutputResults the given listDataContainingOutputResults to compare the actual MultiInstantiable's
     *        listDataContainingOutputResults to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's listDataContainingOutputResults is not equal to the given one.
     */
    public MultiInstantiableAssert hasListDataContainingOutputResults(final Data listDataContainingOutputResults) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> listDataContainingOutputResults to be:\n  <%s>\n but was:\n  <%s>", actual,
                listDataContainingOutputResults, actual.getListDataContainingOutputResults());

        // check
        if (!actual.getListDataContainingOutputResults().equals(listDataContainingOutputResults)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's loopCondition is equal to the given one.
     * 
     * @param loopCondition the given loopCondition to compare the actual MultiInstantiable's loopCondition to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's loopCondition is not equal to the given one.
     */
    public MultiInstantiableAssert hasLoopCondition(final Expression loopCondition) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> loopCondition to be:\n  <%s>\n but was:\n  <%s>", actual, loopCondition, actual.getLoopCondition());

        // check
        if (!actual.getLoopCondition().equals(loopCondition)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's loopMaximum is equal to the given one.
     * 
     * @param loopMaximum the given loopMaximum to compare the actual MultiInstantiable's loopMaximum to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's loopMaximum is not equal to the given one.
     */
    public MultiInstantiableAssert hasLoopMaximum(final Expression loopMaximum) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> loopMaximum to be:\n  <%s>\n but was:\n  <%s>", actual, loopMaximum, actual.getLoopMaximum());

        // check
        if (!actual.getLoopMaximum().equals(loopMaximum)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's outputData is equal to the given one.
     * 
     * @param outputData the given outputData to compare the actual MultiInstantiable's outputData to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's outputData is not equal to the given one.
     */
    public MultiInstantiableAssert hasOutputData(final Data outputData) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> outputData to be:\n  <%s>\n but was:\n  <%s>", actual, outputData, actual.getOutputData());

        // check
        if (!actual.getOutputData().equals(outputData)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable is storeOutput.
     * 
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable is not storeOutput.
     */
    public MultiInstantiableAssert isStoreOutput() {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("Expected actual MultiInstantiable to be storeOutput but was not.", actual);

        // check
        if (!actual.isStoreOutput()) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable is not storeOutput.
     * 
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable is storeOutput.
     */
    public MultiInstantiableAssert isNotStoreOutput() {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("Expected actual MultiInstantiable not to be storeOutput but was.", actual);

        // check
        if (actual.isStoreOutput()) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's testBefore is equal to the given one.
     * 
     * @param testBefore the given testBefore to compare the actual MultiInstantiable's testBefore to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's testBefore is not equal to the given one.
     */
    public MultiInstantiableAssert hasTestBefore(final Boolean testBefore) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> testBefore to be:\n  <%s>\n but was:\n  <%s>", actual, testBefore, actual.getTestBefore());

        // check
        if (!actual.getTestBefore().equals(testBefore)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable's type is equal to the given one.
     * 
     * @param type the given type to compare the actual MultiInstantiable's type to.
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable's type is not equal to the given one.
     */
    public MultiInstantiableAssert hasType(final MultiInstanceType type) {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("\nExpected <%s> type to be:\n  <%s>\n but was:\n  <%s>", actual, type, actual.getType());

        // check
        if (!actual.getType().equals(type)) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable is useCardinality.
     * 
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable is not useCardinality.
     */
    public MultiInstantiableAssert isUseCardinality() {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("Expected actual MultiInstantiable to be useCardinality but was not.", actual);

        // check
        if (!actual.isUseCardinality()) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual MultiInstantiable is not useCardinality.
     * 
     * @return this assertion object.
     * @throws AssertionError - if the actual MultiInstantiable is useCardinality.
     */
    public MultiInstantiableAssert isNotUseCardinality() {
        // check that actual MultiInstantiable we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        final String errorMessage = format("Expected actual MultiInstantiable not to be useCardinality but was.", actual);

        // check
        if (actual.isUseCardinality()) {
            throw new AssertionError(errorMessage);
        }

        // return the current assertion for method chaining
        return this;
    }

}
