package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * CommentResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(CommentResponse.JSON_PROPERTY_COMMENT)
public class CommentResponse {

    public static final String JSON_PROPERTY_COMMENT = "comment";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_COMMENT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private CommentObject comment;

    /**
     * @return the comment property value
     */
    public CommentObject getComment() {
        return comment;
    }

    /**
     * Set the comment property value
     *
     * @param comment property value to set
     */
    public void setComment(CommentObject comment) {
        this.comment = comment;
    }

    /**
     * Set comment in a chainable fashion.
     *
     * @return The same instance of CommentResponse for chaining.
     */
    public CommentResponse comment(CommentObject comment) {
        this.comment = comment;
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
        var commentResponse = (CommentResponse) o;
        return Objects.equals(comment, commentResponse.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }

    @Override
    public String toString() {
        return "CommentResponse("
            + "comment: " + getComment()
            + ")";
    }

}