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
 * PostsResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(PostsResponse.JSON_PROPERTY_POSTS)
public class PostsResponse {

    public static final String JSON_PROPERTY_POSTS = "posts";

    @Nullable
    @JsonProperty(JSON_PROPERTY_POSTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid PostObject> posts;

    /**
     * @return the posts property value
     */
    public List<@Valid PostObject> getPosts() {
        return posts;
    }

    /**
     * Set the posts property value
     *
     * @param posts property value to set
     */
    public void setPosts(List<@Valid PostObject> posts) {
        this.posts = posts;
    }

    /**
     * Set posts in a chainable fashion.
     *
     * @return The same instance of PostsResponse for chaining.
     */
    public PostsResponse posts(List<@Valid PostObject> posts) {
        this.posts = posts;
        return this;
    }
    /**
     * Add an item to the posts property in a chainable fashion.
     *
     * @return The same instance of PostsResponse for chaining.
     */
    public PostsResponse addPostsItem(PostObject postsItem) {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(postsItem);
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
        var postsResponse = (PostsResponse) o;
        return Objects.equals(posts, postsResponse.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posts);
    }

    @Override
    public String toString() {
        return "PostsResponse("
            + "posts: " + getPosts()
            + ")";
    }

}