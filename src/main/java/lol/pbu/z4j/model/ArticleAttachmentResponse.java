package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * ArticleAttachmentResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(ArticleAttachmentResponse.JSON_PROPERTY_ARTICLE_ATTACHMENT)
public class ArticleAttachmentResponse {

    public static final String JSON_PROPERTY_ARTICLE_ATTACHMENT = "article_attachment";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_ARTICLE_ATTACHMENT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ArticleAttachmentObject articleAttachment;

    /**
     * @return the articleAttachment property value
     */
    public ArticleAttachmentObject getArticleAttachment() {
        return articleAttachment;
    }

    /**
     * Set the articleAttachment property value
     *
     * @param articleAttachment property value to set
     */
    public void setArticleAttachment(ArticleAttachmentObject articleAttachment) {
        this.articleAttachment = articleAttachment;
    }

    /**
     * Set articleAttachment in a chainable fashion.
     *
     * @return The same instance of ArticleAttachmentResponse for chaining.
     */
    public ArticleAttachmentResponse articleAttachment(ArticleAttachmentObject articleAttachment) {
        this.articleAttachment = articleAttachment;
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
        var articleAttachmentResponse = (ArticleAttachmentResponse) o;
        return Objects.equals(articleAttachment, articleAttachmentResponse.articleAttachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleAttachment);
    }

    @Override
    public String toString() {
        return "ArticleAttachmentResponse("
            + "articleAttachment: " + getArticleAttachment()
            + ")";
    }

}