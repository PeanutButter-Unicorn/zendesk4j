package lol.pbu.zendesk.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.VoteResponse;
import lol.pbu.zendesk.model.VotesResponse;
import reactor.core.publisher.Mono;

@Client("${micronaut.http.services.zendesk.url}")
public interface VotesClient {

    /**
     * Create Vote<br>
     * Creates an up or down vote for a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article</a>,
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/article_comments/">
     * article comment</a>,
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/posts">post</a>, or
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/post_comments">post comment
     * </a>. If a vote already exists for the source object, it's updated.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users</li>
     * </ul>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     */
    @Post("/api/v2/help_center/{locale}/articles/{article_id}/up")
    Mono<HttpResponse<@Valid VoteResponse>> createArticleUpVote(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Delete Vote<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users</li>
     * </ul>
     *
     * @param voteId The unique ID of the vote
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/help_center/votes/{vote_id}")
    Mono<HttpResponse<Void>> deleteVote(
            @PathVariable("vote_id") @NotNull Integer voteId
    );

    /**
     * List Votes<br>
     * Lists all votes cast by a given user, or all votes cast by all users for a given article, article comment, post,
     * or post comment.  To list only your own votes, specify {@code me} as the user id.  The {@code locale} for
     * article and article comment votes is required only for end users. Admins and agents can omit it.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users  </ul>
     * <h4>Pagination</h4>
     * <ul>
     *     <li>Cursor pagination (recommended)</li>
     *
     * <li>Offset pagination<br>See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</li></li>
     * </ul>
     *
     * @param userId The unique ID of the user
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/users/{user_id}/votes")
    Mono<@Valid VotesResponse> listUserVotes(
            @PathVariable("user_id") @NotNull Integer userId
    );

    /**
     * Show Vote<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users  <h4>Sideloads The following sideloads are supported:
     * <table>
     *   <thead>
     *     <tr>
     *       <th>Name</th>
     *       <th>Will sideload</th>
     *     </tr>
     *   </thead>
     *   <tbody>
     *     <tr>
     *       <td>users</td>
     *       <td>authors</td>
     *     </tr>
     *     <tr>
     *       <td>articles</td>
     *       <td>articles</td>
     *     </tr>
     *     <tr>
     *       <td>translations</td>
     *       <td>translations of any sideloaded articles</td>
     *     </tr>
     *     <tr>
     *       <td>posts</td>
     *       <td>posts</td>
     *     </tr>
     *     <tr>
     *       <td>comments</td>
     *       <td>comments</td>
     *     </tr>
     *   </tbody>
     * </table>
     * <p>Note that you must sideload <code>articles</code> in order to sideload <code>translations</code>.</p>
     * </ul>
     * @param voteId The unique ID of the vote</li>
     *
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/votes/{vote_id}")
    Mono<@Valid VoteResponse> showVote(
            @PathVariable("vote_id") @NotNull Integer voteId
    );
}
