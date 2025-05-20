package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * ArticleResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(ArticleResponse.JSON_PROPERTY_ARTICLE)
public class ArticleResponse {

    public static final String JSON_PROPERTY_ARTICLE = "article";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_ARTICLE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ArticleObject article;

    /**
     * @return the article property value
     */
    public ArticleObject getArticle() {
        return article;
    }

    /**
     * Set the article property value
     *
     * @param article property value to set
     */
    public void setArticle(ArticleObject article) {
        this.article = article;
    }

    /**
     * Set article in a chainable fashion.
     *
     * @return The same instance of ArticleResponse for chaining.
     */
    public ArticleResponse article(ArticleObject article) {
        this.article = article;
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
        var articleResponse = (ArticleResponse) o;
        return Objects.equals(article, articleResponse.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article);
    }

    @Override
    public String toString() {
        return "ArticleResponse("
            + "article: " + getArticle()
            + ")";
    }

}