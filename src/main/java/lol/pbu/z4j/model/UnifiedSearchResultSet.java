package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UnifiedSearchResultSet
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    UnifiedSearchResultSet.JSON_PROPERTY_META,
    UnifiedSearchResultSet.JSON_PROPERTY_RESULTS,
})
public class UnifiedSearchResultSet {

    public static final String JSON_PROPERTY_META = "meta";
    public static final String JSON_PROPERTY_RESULTS = "results";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private UnifiedSearchResultSetMeta meta;

    @Nullable
    @JsonProperty(JSON_PROPERTY_RESULTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid UnifiedSearchResult> results;

    /**
     * @return the meta property value
     */
    public UnifiedSearchResultSetMeta getMeta() {
        return meta;
    }

    /**
     * Set the meta property value
     *
     * @param meta property value to set
     */
    public void setMeta(UnifiedSearchResultSetMeta meta) {
        this.meta = meta;
    }

    /**
     * Set meta in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResultSet for chaining.
     */
    public UnifiedSearchResultSet meta(UnifiedSearchResultSetMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * @return the results property value
     */
    public List<@Valid UnifiedSearchResult> getResults() {
        return results;
    }

    /**
     * Set the results property value
     *
     * @param results property value to set
     */
    public void setResults(List<@Valid UnifiedSearchResult> results) {
        this.results = results;
    }

    /**
     * Set results in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResultSet for chaining.
     */
    public UnifiedSearchResultSet results(List<@Valid UnifiedSearchResult> results) {
        this.results = results;
        return this;
    }
    /**
     * Add an item to the results property in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResultSet for chaining.
     */
    public UnifiedSearchResultSet addResultsItem(UnifiedSearchResult resultsItem) {
        if (results == null) {
            results = new ArrayList<>();
        }
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
        var unifiedSearchResultSet = (UnifiedSearchResultSet) o;
        return Objects.equals(meta, unifiedSearchResultSet.meta)
            && Objects.equals(results, unifiedSearchResultSet.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meta, results);
    }

    @Override
    public String toString() {
        return "UnifiedSearchResultSet("
            + "meta: " + getMeta() + ", "
            + "results: " + getResults()
            + ")";
    }

}