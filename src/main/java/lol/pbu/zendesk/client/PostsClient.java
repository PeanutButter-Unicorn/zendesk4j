package lol.pbu.zendesk.client;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.ListPostsFilterByParameter;
import lol.pbu.zendesk.model.ListPostsSortByParameter;
import lol.pbu.zendesk.model.PostResponse;
import lol.pbu.zendesk.model.PostsResponse;
import reactor.core.publisher.Mono;

@Client("${micronaut.http.services.zendesk.url}")
public interface PostsClient {

    /**
     * Create Post<br>
     * <p>Adds a post to the specified <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/topics">topic</a>.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <p>Agents with the Help Center manager role can optionally supply an
     *   <code>author_id</code> as part of the <code>post</code> object. If it is provided, the post&#39;s
     *   author will be set to the value of the <code>author_id</code> key.</p>
     * <p>Agents with the Help Center manager role can optionally supply a <code>created_at</code> as part of the
     * <code>post</code> object. If it is not provided <code>created_at</code> is set to the current time.</p>
     * <p>Supplying a <code>notify_subscribers</code> property with a value of false will prevent subscribers to the
     * post&#39;s topic from receiving a post creation email notification. This can be helpful when creating many posts
     * at a time. Specify the property in the root of the JSON object, not in the &quot;post&quot; object.
     *   Optionally, you can attach existing <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/content_tags">content
     *   tags</a> by specifying their ids.</p>
     *
     * @return Created Response (status code 201)
     */
    @Post("/api/v2/community/posts")
    Mono<HttpResponse<@Valid PostResponse>> createPost();

    /**
     * Delete Post<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Agents s<br>The end user who created the post</li>
     * </ul>
     *
     * @param postId The unique ID of the post
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/community/posts/{post_id}")
    Mono<HttpResponse<Void>> deletePost(
            @PathVariable("post_id") @NotNull Integer postId
    );

    /**
     * List Posts<br>
     *
     * @param filterBy Filter the results using the provided value 
     * @param sortBy   Sorts the results using the provided value 
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/posts")
    Mono<@Valid PostsResponse> listPosts(
            @QueryValue("filter_by") @Nullable ListPostsFilterByParameter filterBy,
            @QueryValue("sort_by") @Nullable ListPostsSortByParameter sortBy
    );

    /**
     * Show Post<br>
     * <p>Gets information about a given post.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>Anonymous users</li>
     * </ul>
     * <h4 id="sideloads">Sideloads</h4>
     * <p>The following sideloads are supported:</p>
     * <table>
     *   <thead>
     *   <tr>
     *     <th>Name</th>
     *     <th>Will sideload</th>
     *   </tr>
     *   </thead>
     *   <tbody>
     *   <tr>
     *     <td>users</td>
     *     <td>authors</td>
     *   </tr>
     *   <tr>
     *     <td>topics</td>
     *     <td>topics</td>
     *   </tr>
     *   </tbody>
     * </table>
     *
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/posts/{post_id}")
    Mono<@Valid PostResponse> showPost(
            @PathVariable("post_id") @NotNull Integer postId
    );

    /**
     * Update Post<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Agents s<br>The end user who created the post</li>
     * </ul>
     *
     * @param postId The unique ID of the post
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/community/posts/{post_id}")
    Mono<@Valid PostResponse> updatePost(
            @PathVariable("post_id") @NotNull Integer postId
    );
}
