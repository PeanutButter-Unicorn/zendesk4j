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
 * ArticleAttachmentsResponse
 */
@Serdeable
@JsonPropertyOrder(ArticleAttachmentsResponse.JSON_PROPERTY_ARTICLE_ATTACHMENTS)
public class ArticleAttachmentsResponse {

    public static final String JSON_PROPERTY_ARTICLE_ATTACHMENTS = "article_attachments";

    @Nullable
    @JsonProperty(JSON_PROPERTY_ARTICLE_ATTACHMENTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid ArticleAttachmentObject> articleAttachments;

    /**
     * @return the articleAttachments property value
     */
    public List<@Valid ArticleAttachmentObject> getArticleAttachments() {
        return articleAttachments;
    }

    /**
     * Set the articleAttachments property value
     *
     * @param articleAttachments property value to set
     */
    public void setArticleAttachments(List<@Valid ArticleAttachmentObject> articleAttachments) {
        this.articleAttachments = articleAttachments;
    }

    /**
     * Set articleAttachments in a chainable fashion.
     *
     * @return The same instance of ArticleAttachmentsResponse for chaining.
     */
    public ArticleAttachmentsResponse articleAttachments(List<@Valid ArticleAttachmentObject> articleAttachments) {
        this.articleAttachments = articleAttachments;
        return this;
    }
    /**
     * Add an item to the articleAttachments property in a chainable fashion.
     *
     * @return The same instance of ArticleAttachmentsResponse for chaining.
     */
    public ArticleAttachmentsResponse addArticleAttachmentsItem(ArticleAttachmentObject articleAttachmentsItem) {
        if (articleAttachments == null) {
            articleAttachments = new ArrayList<>();
        }
        articleAttachments.add(articleAttachmentsItem);
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
        var articleAttachmentsResponse = (ArticleAttachmentsResponse) o;
        return Objects.equals(articleAttachments, articleAttachmentsResponse.articleAttachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleAttachments);
    }

    @Override
    public String toString() {
        return "ArticleAttachmentsResponse("
            + "articleAttachments: " + getArticleAttachments()
            + ")";
    }

}