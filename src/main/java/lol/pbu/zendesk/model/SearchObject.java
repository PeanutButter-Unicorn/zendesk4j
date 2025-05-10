package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * SearchObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(SearchObject.JSON_PROPERTY_RESULTS)
public class SearchObject {

    public static final String JSON_PROPERTY_RESULTS = "results";

    /**
     * An array with the base articles or community posts
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_RESULTS)
    private List<@Valid SearchObjectResultsInner> results;

    public SearchObject(List<@Valid SearchObjectResultsInner> results) {
        this.results = results;
    }

    /**
     * An array with the base articles or community posts
     *
     * @return the results property value
     */
    public List<@Valid SearchObjectResultsInner> getResults() {
        return results;
    }

    /**
     * Set the results property value
     *
     * @param results property value to set
     */
    public void setResults(List<@Valid SearchObjectResultsInner> results) {
        this.results = results;
    }

    /**
     * Set results in a chainable fashion.
     *
     * @return The same instance of SearchObject for chaining.
     */
    public SearchObject results(List<@Valid SearchObjectResultsInner> results) {
        this.results = results;
        return this;
    }
    /**
     * Add an item to the results property in a chainable fashion.
     *
     * @return The same instance of SearchObject for chaining.
     */
    public SearchObject addResultsItem(SearchObjectResultsInner resultsItem) {
        results.add(resultsItem);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var searchObject = (SearchObject) o;
        return Objects.equals(results, searchObject.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "SearchObject("
            + "results: " + getResults()
            + ")";
    }

}