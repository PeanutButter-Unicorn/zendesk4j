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
 * ArticlesResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(ArticlesResponse.JSON_PROPERTY_ARTICLES)
public class ArticlesResponse {

    public static final String JSON_PROPERTY_ARTICLES = "articles";

    @Nullable
    @JsonProperty(JSON_PROPERTY_ARTICLES)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid ArticleObject> articles;

    /**
     * @return the articles property value
     */
    public List<@Valid ArticleObject> getArticles() {
        return articles;
    }

    /**
     * Set the articles property value
     *
     * @param articles property value to set
     */
    public void setArticles(List<@Valid ArticleObject> articles) {
        this.articles = articles;
    }

    /**
     * Set articles in a chainable fashion.
     *
     * @return The same instance of ArticlesResponse for chaining.
     */
    public ArticlesResponse articles(List<@Valid ArticleObject> articles) {
        this.articles = articles;
        return this;
    }
    /**
     * Add an item to the articles property in a chainable fashion.
     *
     * @return The same instance of ArticlesResponse for chaining.
     */
    public ArticlesResponse addArticlesItem(ArticleObject articlesItem) {
        if (articles == null) {
            articles = new ArrayList<>();
        }
        articles.add(articlesItem);
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
        var articlesResponse = (ArticlesResponse) o;
        return Objects.equals(articles, articlesResponse.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articles);
    }

    @Override
    public String toString() {
        return "ArticlesResponse("
            + "articles: " + getArticles()
            + ")";
    }

}