package lol.pbu.zendesk.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.PostCommentResponse;
import lol.pbu.zendesk.model.PostCommentsResponse;
import reactor.core.publisher.Mono;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client("${micronaut.http.services.zendesk.url}")
public interface PostCommentsClient {

    /**
     * Create Post Comment<br>
     * Adds a comment to the specified post.  <h4>Allowed for</h4>
     * <ul>
     * <li>End users  Agents with the Help Center manager role can optionally supply an {@code author_id} as part of
     * the {@code comment} object. If it is provided, the comment's author will be set to the value of the
     * {@code author_id} key.<br>Supplying a {@code notify_subscribers} property with a value of false will prevent
     * subscribers to the comment's post from receiving a comment creation email notification. This can be helpful
     * when creating many comments at a time. Specify the property in the root of the JSON object,
     * not in the "comment" object.</li>
     * </ul>
     *
     * @param postId The unique ID of the post
     * @return OK Response (status code 201)
     */
    @Post("/api/v2/community/posts/{post_id}/comments")
    Mono<HttpResponse<@Valid PostCommentResponse>> createPostComment(
            @PathVariable("post_id") @NotNull Integer postId
    );

    /**
     * Delete Comment<br>
     * Deletes the specified comment.  <h4>Allowed for</h4>
     * <ul>
     * <li>Agents s<br>The end user who created the comment</li>
     * </ul>
     *
     * @param postId        The unique ID of the post
     * @param postCommentId The unique ID of the post comment
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/community/posts/{post_id}/comments/{post_comment_id}")
    Mono<HttpResponse<Void>> deletePostComment(
            @PathVariable("post_id") @NotNull Integer postId,
            @PathVariable("post_comment_id") @NotNull Integer postCommentId
    );

    /**
     * List Comments<br>
     * <p>Lists all comments on a specific post or all the comments created by a specific user.
     *   When listing comments by specific user, the comments of the user making the request
     *   can be listed by specifying <code>me</code> as the id.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <h4 id="pagination">Pagination</h4>
     * <ul>
     *   <li>Cursor pagination (recommended)</li>
     *   <li>Offset pagination</li>
     * </ul>
     * <p>See <a href="/api-reference/introduction/pagination/">Pagination</a>.</p>
     * <h4 id="sideloads">Sideloads</h4>
     * <p>You can sideload related records with the <code>include</code> query string parameter. The following
     * sideloads are supported:</p>
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
     *     <td>posts</td>
     *     <td>posts</td>
     *   </tr>
     *   </tbody>
     * </table>
     * <p>See <a href="/documentation/developer-tools/working-with-data/sideloading-related-records">Sideloading
     * related records</a>.</p>
     *
     * @param postId The unique ID of the post
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/posts/{post_id}/comments")
    Mono<@Valid PostCommentsResponse> listPostComments(
            @PathVariable("post_id") @NotNull Integer postId
    );

    /**
     * Show Comment<br>
     * <p>Shows information about the specified comment.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
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
     *     <td>The comment&#39;s author</td>
     *   </tr>
     *   <tr>
     *     <td>posts</td>
     *     <td>The comment&#39;s post</td>
     *   </tr>
     *   </tbody>
     * </table>
     *
     * @param postCommentId The unique ID of the post comment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/posts/{post_id}/comments/{post_comment_id}")
    Mono<@Valid PostCommentResponse> showPostComment(
            @PathVariable("post_id") @NotNull Integer postId,
            @PathVariable("post_comment_id") @NotNull Integer postCommentId
    );

    /**
     * Update Comment<br>
     * Updates the specified comment.  <h4>Allowed for</h4>
     * <ul>
     * <li>Agents s<br>The end user who created the comment</li>
     * </ul>
     *
     * @param postId        The unique ID of the post
     * @param postCommentId The unique ID of the post comment
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/community/posts/{post_id}/comments/{post_comment_id}")
    Mono<@Valid PostCommentResponse> updatePostComment(
            @PathVariable("post_id") @NotNull Integer postId,
            @PathVariable("post_comment_id") @NotNull Integer postCommentId
    );
}
