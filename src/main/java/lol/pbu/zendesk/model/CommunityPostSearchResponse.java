package lol.pbu.zendesk.model;

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
 * CommunityPostSearchResponse
 */
@Serdeable
@JsonPropertyOrder(CommunityPostSearchResponse.JSON_PROPERTY_RESULTS)
public class CommunityPostSearchResponse {

    public static final String JSON_PROPERTY_RESULTS = "results";

    @Nullable
    @JsonProperty(JSON_PROPERTY_RESULTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid PostObject> results;

    /**
     * @return the results property value
     */
    public List<@Valid PostObject> getResults() {
        return results;
    }

    /**
     * Set the results property value
     *
     * @param results property value to set
     */
    public void setResults(List<@Valid PostObject> results) {
        this.results = results;
    }

    /**
     * Set results in a chainable fashion.
     *
     * @return The same instance of CommunityPostSearchResponse for chaining.
     */
    public CommunityPostSearchResponse results(List<@Valid PostObject> results) {
        this.results = results;
        return this;
    }
    /**
     * Add an item to the results property in a chainable fashion.
     *
     * @return The same instance of CommunityPostSearchResponse for chaining.
     */
    public CommunityPostSearchResponse addResultsItem(PostObject resultsItem) {
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
        var communityPostSearchResponse = (CommunityPostSearchResponse) o;
        return Objects.equals(results, communityPostSearchResponse.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "CommunityPostSearchResponse("
            + "results: " + getResults()
            + ")";
    }

}