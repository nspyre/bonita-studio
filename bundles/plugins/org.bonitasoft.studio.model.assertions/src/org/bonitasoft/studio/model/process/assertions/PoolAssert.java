package org.bonitasoft.studio.model.process.assertions;

import static java.lang.String.format;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.bonitasoft.studio.model.process.Document;
import org.bonitasoft.studio.model.process.Pool;
import org.bonitasoft.studio.model.process.SearchIndex;

/**
 * {@link Pool} specific assertions - Generated by CustomAssertionGenerator.
 */
public class PoolAssert extends AbstractAssert<PoolAssert, Pool> {

    /**
     * Creates a new </code>{@link PoolAssert}</code> to make assertions on actual Pool.
     * @param actual the Pool we want to make assertions on.
     */
    public PoolAssert(Pool actual) {
        super(actual, PoolAssert.class);
    }

    /**
     * An entry point for PoolAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
     * With a static import, one's can write directly : <code>assertThat(myPool)</code> and get specific assertion with code completion.
     * @param actual the Pool we want to make assertions on.
     * @return a new </code>{@link PoolAssert}</code>
     */
    public static PoolAssert assertThat(Pool actual) {
        return new PoolAssert(actual);
    }

    /**
     * Verifies that the actual Pool's documents contains the given Document elements.
     * @param documents the given elements that should be contained in actual Pool's documents.
     * @return this assertion object.
     * @throws AssertionError if the actual Pool's documents does not contain all given Document elements.
     */
    public PoolAssert hasDocuments(Document... documents) {
        // check that actual Pool we want to make assertions on is not null.
        isNotNull();

        // check that given Document varargs is not null.
        if (documents == null)
            throw new AssertionError("Expecting documents parameter not to be null.");

        // check with standard error message (see commented below to set your own message).
        Assertions.assertThat(actual.getDocuments()).contains(documents);

        // uncomment the 4 lines below if you want to build your own error message :
        // WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
        // String errorMessage = "my error message";
        // assertionInfo.overridingErrorMessage(errorMessage);
        // Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Pool has no documents.
     * @return this assertion object.
     * @throws AssertionError if the actual Pool's documents is not empty.
     */
    public PoolAssert hasNoDocuments() {
        // check that actual Pool we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        String errorMessage = format("\nExpected :\n  <%s>\nnot to have documents but had :\n  <%s>", actual, actual.getDocuments());

        // check
        if (!actual.getDocuments().isEmpty())
            throw new AssertionError(errorMessage);

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Pool's searchIndexes contains the given SearchIndex elements.
     * @param searchIndexes the given elements that should be contained in actual Pool's searchIndexes.
     * @return this assertion object.
     * @throws AssertionError if the actual Pool's searchIndexes does not contain all given SearchIndex elements.
     */
    public PoolAssert hasSearchIndexes(SearchIndex... searchIndexes) {
        // check that actual Pool we want to make assertions on is not null.
        isNotNull();

        // check that given SearchIndex varargs is not null.
        if (searchIndexes == null)
            throw new AssertionError("Expecting searchIndexes parameter not to be null.");

        // check with standard error message (see commented below to set your own message).
        Assertions.assertThat(actual.getSearchIndexes()).contains(searchIndexes);

        // uncomment the 4 lines below if you want to build your own error message :
        // WritableAssertionInfo assertionInfo = new WritableAssertionInfo();
        // String errorMessage = "my error message";
        // assertionInfo.overridingErrorMessage(errorMessage);
        // Iterables.instance().assertContains(assertionInfo, actual.getTeamMates(), teamMates);

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Pool has no searchIndexes.
     * @return this assertion object.
     * @throws AssertionError if the actual Pool's searchIndexes is not empty.
     */
    public PoolAssert hasNoSearchIndexes() {
        // check that actual Pool we want to make assertions on is not null.
        isNotNull();

        // we overrides the default error message with a more explicit one
        String errorMessage = format("\nExpected :\n  <%s>\nnot to have searchIndexes but had :\n  <%s>", actual, actual.getSearchIndexes());

        // check
        if (!actual.getSearchIndexes().isEmpty())
            throw new AssertionError(errorMessage);

        // return the current assertion for method chaining
        return this;
    }

}