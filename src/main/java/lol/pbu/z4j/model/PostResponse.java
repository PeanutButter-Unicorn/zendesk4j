package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * PostResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(PostResponse.JSON_PROPERTY_POST)
public class PostResponse {

    public static final String JSON_PROPERTY_POST = "post";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_POST)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private PostObject post;

    /**
     * @return the post property value
     */
    public PostObject getPost() {
        return post;
    }

    /**
     * Set the post property value
     *
     * @param post property value to set
     */
    public void setPost(PostObject post) {
        this.post = post;
    }

    /**
     * Set post in a chainable fashion.
     *
     * @return The same instance of PostResponse for chaining.
     */
    public PostResponse post(PostObject post) {
        this.post = post;
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
        var postResponse = (PostResponse) o;
        return Objects.equals(post, postResponse.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post);
    }

    @Override
    public String toString() {
        return "PostResponse("
            + "post: " + getPost()
            + ")";
    }

}