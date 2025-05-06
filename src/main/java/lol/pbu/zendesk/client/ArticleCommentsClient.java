package lol.pbu.zendesk.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.CommentResponse;
import lol.pbu.zendesk.model.CommentsResponse;
import reactor.core.publisher.Mono;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client("${micronaut.http.services.zendesk.url}")
public interface ArticleCommentsClient {

    /**
     * Create Comment
     * <p>
     * Adds a comment to the specified
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article</a>.
     * Because comments are associated with a specific article translation, or locale, you must specify a locale.
     * <p><strong>Allowed for</strong>: Agents</p>
     * Agents with the Help Center manager role can optionally supply a {@code created_at} as part of the
     * {@code comment} object. If not provided, {@code created_at} is set to the current time. Supplying a
     * {@code notify_subscribers} property with a value of false will prevent subscribers to the comment's article
     * from receiving a comment creation email notification. This can be helpful when creating many comments at a time.
     * Specify the property in the root of the JSON object, not in the "comment" object.
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return description (status code 200)
     */
    @Post("/api/v2/help_center/{locale}/articles/{article_id}/comments")
    Mono<HttpResponse<@Valid CommentResponse>> createArticleComment(
            @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Delete Comment
     *
     * <p>
     * <p><strong>Allowed for</strong>: Agents, The end user who created the comment </p>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @param commentId The unique ID of the comment
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/help_center/{locale}/articles/{article_id}/comments/{comment_id}")
    Mono<HttpResponse<Void>> deleteComment(
            @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("comment_id") @NotNull Integer commentId
    );

    /**
     * List Comments
     * <p>
     * Lists the comments created by a specific user, or all comments made by all users on a specific article.
     * The {@code {locale}} for the article comments is required only for end users. Admins and agents can omit it.
     * </p>
     * <p><strong>Allowed for</strong>: End users</p>
     * <p>
     * End-users can only list their own comments. If listing comments by user, they must specify {@code me} as the id.
     * </p>
     * <p><strong>Pagination</strong></p>
     * <ul>
     *     <li>Cursor pagination (recommended)</li>
     *     <li>Offset pagination</li>
     * </ul>
     * See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.
     * <p><strong>Sideloads</strong></p>
     * <p>The following sideloads are supported:</p>
     * <table>
     *     <thead>
     *         <tr><th>Name</th><th>Will sideload</th></tr>
     *     </thead>
     *     <tbody>
     *         <tr><td>users</td><td>authors</td></tr>
     *         <tr><td>articles</td><td>articles</td></tr>
     *     </tbody>
     * </table>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return description (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/articles/{article_id}/comments")
    Mono<@Valid CommentsResponse> listArticleComments(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Show Comment
     * <p>
     * Shows the properties of the specified comment. The {@code {locale}} is required only for end users and anonymous
     * users. Admins and agents can omit it.
     * <p><strong>Allowed for</strong>: Anonymous users
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @param commentId The unique ID of the comment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/articles/{article_id}/comments/{comment_id}")
    Mono<@Valid CommentResponse> showComment(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("comment_id") @NotNull Integer commentId
    );

    /**
     * Update Comment<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Agents s<br>The end user who created the comment</li>
     * </ul>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @param commentId The unique ID of the comment
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/help_center/{locale}/articles/{article_id}/comments/{comment_id}")
    Mono<@Valid CommentResponse> updateComment(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("comment_id") @NotNull Integer commentId
    );
}
