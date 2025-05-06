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
 * PostCommentsResponse
 */
@Serdeable
@JsonPropertyOrder(PostCommentsResponse.JSON_PROPERTY_COMMENTS)
public class PostCommentsResponse {

    public static final String JSON_PROPERTY_COMMENTS = "comments";

    @Nullable
    @JsonProperty(JSON_PROPERTY_COMMENTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid PostCommentObject> comments;

    /**
     * @return the comments property value
     */
    public List<@Valid PostCommentObject> getComments() {
        return comments;
    }

    /**
     * Set the comments property value
     *
     * @param comments property value to set
     */
    public void setComments(List<@Valid PostCommentObject> comments) {
        this.comments = comments;
    }

    /**
     * Set comments in a chainable fashion.
     *
     * @return The same instance of PostCommentsResponse for chaining.
     */
    public PostCommentsResponse comments(List<@Valid PostCommentObject> comments) {
        this.comments = comments;
        return this;
    }
    /**
     * Add an item to the comments property in a chainable fashion.
     *
     * @return The same instance of PostCommentsResponse for chaining.
     */
    public PostCommentsResponse addCommentsItem(PostCommentObject commentsItem) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(commentsItem);
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
        var postCommentsResponse = (PostCommentsResponse) o;
        return Objects.equals(comments, postCommentsResponse.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comments);
    }

    @Override
    public String toString() {
        return "PostCommentsResponse("
            + "comments: " + getComments()
            + ")";
    }

}