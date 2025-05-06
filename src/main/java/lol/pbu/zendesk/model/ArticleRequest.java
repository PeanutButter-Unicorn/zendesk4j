package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * ArticleRequest
 */
@Serdeable
@JsonPropertyOrder({
    ArticleRequest.JSON_PROPERTY_ARTICLE,
    ArticleRequest.JSON_PROPERTY_NOTIFY_SUBSCRIBERS,
})
public class ArticleRequest {

    public static final String JSON_PROPERTY_ARTICLE = "article";
    public static final String JSON_PROPERTY_NOTIFY_SUBSCRIBERS = "notify_subscribers";

    @NotNull
    @Valid
    @JsonProperty(JSON_PROPERTY_ARTICLE)
    private ArticleRequestArticle article;

    @Nullable
    @JsonProperty(JSON_PROPERTY_NOTIFY_SUBSCRIBERS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean notifySubscribers;

    public ArticleRequest(ArticleRequestArticle article) {
        this.article = article;
    }

    /**
     * @return the article property value
     */
    public ArticleRequestArticle getArticle() {
        return article;
    }

    /**
     * Set the article property value
     *
     * @param article property value to set
     */
    public void setArticle(ArticleRequestArticle article) {
        this.article = article;
    }

    /**
     * Set article in a chainable fashion.
     *
     * @return The same instance of ArticleRequest for chaining.
     */
    public ArticleRequest article(ArticleRequestArticle article) {
        this.article = article;
        return this;
    }

    /**
     * @return the notifySubscribers property value
     */
    public Boolean getNotifySubscribers() {
        return notifySubscribers;
    }

    /**
     * Set the notifySubscribers property value
     *
     * @param notifySubscribers property value to set
     */
    public void setNotifySubscribers(Boolean notifySubscribers) {
        this.notifySubscribers = notifySubscribers;
    }

    /**
     * Set notifySubscribers in a chainable fashion.
     *
     * @return The same instance of ArticleRequest for chaining.
     */
    public ArticleRequest notifySubscribers(Boolean notifySubscribers) {
        this.notifySubscribers = notifySubscribers;
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
        var articleRequest = (ArticleRequest) o;
        return Objects.equals(article, articleRequest.article)
            && Objects.equals(notifySubscribers, articleRequest.notifySubscribers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, notifySubscribers);
    }

    @Override
    public String toString() {
        return "ArticleRequest("
            + "article: " + getArticle() + ", "
            + "notifySubscribers: " + getNotifySubscribers()
            + ")";
    }

}