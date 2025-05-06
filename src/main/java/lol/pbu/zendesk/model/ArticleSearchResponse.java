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
 * ArticleSearchResponse
 */
@Serdeable
@JsonPropertyOrder({
    ArticleSearchResponse.JSON_PROPERTY_RESULT_TYPE,
    ArticleSearchResponse.JSON_PROPERTY_RESULTS,
    ArticleSearchResponse.JSON_PROPERTY_SNIPPET,
})
public class ArticleSearchResponse {

    public static final String JSON_PROPERTY_RESULT_TYPE = "result_type";
    public static final String JSON_PROPERTY_RESULTS = "results";
    public static final String JSON_PROPERTY_SNIPPET = "snippet";

    /**
     * For articles, always the string &#x60;article&#x60;
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_RESULT_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String resultType = "article";

    @Nullable
    @JsonProperty(JSON_PROPERTY_RESULTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid ArticleObject> results;

    /**
     * The portion of an article that is relevant to the search query, with matching words or phrases delimited by &lt;em&gt;&lt;/em&gt; tags. Example: a query for &#x60;carrot potato&#x60; might return the snippet &#x60;...don&#39;t confuse &lt;em&gt;carrots&lt;/em&gt; with &lt;em&gt;potatoes&lt;/em&gt;...&#x60;
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SNIPPET)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String snippet;

    /**
     * For articles, always the string &#x60;article&#x60;
     *
     * @return the resultType property value
     */
    public String getResultType() {
        return resultType;
    }

    /**
     * Set the resultType property value
     *
     * @param resultType property value to set
     */
    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    /**
     * @return the results property value
     */
    public List<@Valid ArticleObject> getResults() {
        return results;
    }

    /**
     * Set the results property value
     *
     * @param results property value to set
     */
    public void setResults(List<@Valid ArticleObject> results) {
        this.results = results;
    }

    /**
     * Set results in a chainable fashion.
     *
     * @return The same instance of ArticleSearchResponse for chaining.
     */
    public ArticleSearchResponse results(List<@Valid ArticleObject> results) {
        this.results = results;
        return this;
    }
    /**
     * Add an item to the results property in a chainable fashion.
     *
     * @return The same instance of ArticleSearchResponse for chaining.
     */
    public ArticleSearchResponse addResultsItem(ArticleObject resultsItem) {
        if (results == null) {
            results = new ArrayList<>();
        }
        results.add(resultsItem);
        return this;
    }

    /**
     * The portion of an article that is relevant to the search query, with matching words or phrases delimited by &lt;em&gt;&lt;/em&gt; tags. Example: a query for &#x60;carrot potato&#x60; might return the snippet &#x60;...don&#39;t confuse &lt;em&gt;carrots&lt;/em&gt; with &lt;em&gt;potatoes&lt;/em&gt;...&#x60;
     *
     * @return the snippet property value
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * Set the snippet property value
     *
     * @param snippet property value to set
     */
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var articleSearchResponse = (ArticleSearchResponse) o;
        return Objects.equals(resultType, articleSearchResponse.resultType)
            && Objects.equals(results, articleSearchResponse.results)
            && Objects.equals(snippet, articleSearchResponse.snippet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultType, results, snippet);
    }

    @Override
    public String toString() {
        return "ArticleSearchResponse("
            + "resultType: " + getResultType() + ", "
            + "results: " + getResults() + ", "
            + "snippet: " + getSnippet()
            + ")";
    }

}