package lol.pbu.zendesk.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.ContentSubscriptionsResponse;
import lol.pbu.zendesk.model.SubscriptionResponse;
import reactor.core.publisher.Mono;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client("${micronaut.http.services.zendesk.url}")
public interface ContentSubscriptionsClient {

    /**
     * Creates a subscription to a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article</a>.
     * <b>Allowed for</b>
     * <ul>
     * <li> End users </li>
     * <li>Agents with the Help Center manager role can optionally supply a {@code user_id} value. If provided,
     *  the user associated with {@code user_id} will be subscribed to the article.</li>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return Created Response (status code 201)
     */
    @Post("/api/v2/help_center/{locale}/articles/{article_id}/subscriptions")
    Mono<HttpResponse<@Valid SubscriptionResponse>> createArticleSubscription(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Create Post Subscription
     * Creates a subscription to a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/posts">post</a>.
     * <p><b>Allowed for</b>
     * <ul>
     * <li> End users </li>
     * <li>Agents with the Help Center manager role can optionally supply a {@code subscription} object containing a
     * {@code user_id} value. If provided, the user associated with {@code user_id} will be subscribed to the post.</li>
     * </ul>
     *
     * @param postId The unique ID of the post
     * @return Created Response (status code 201)
     */
    @Post("/api/v2/community/posts/{post_id}/subscriptions")
    Mono<HttpResponse<@Valid SubscriptionResponse>> createPostSubscription(
            @PathVariable("post_id") @NotNull Integer postId
    );

    /**
     * Create Section Subscription
     * Creates a subscription to a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/sections">section</a>.
     *
     * <p><b>Allowed for</b>
     * <ul>
     * <li> End users </li>
     * <li>Agents with the Help Center manager role can optionally supply a {@code user_id} value.
     * If provided, the user associated with {@code user_id} will be subscribed to the section.</li>
     *
     * @param locale    The locale the item is displayed in
     * @param sectionId The unique ID of the section
     * @return Created Response (status code 201)
     */
    @Post("/api/v2/help_center/{locale}/sections/{section_id}/subscriptions")
    Mono<HttpResponse<@Valid SubscriptionResponse>> createSectionSubscription(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId
    );

    /**
     * Create Topic Subscription
     * Creates a subscription to a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/topics">topic</a>.
     * <p><b>Allowed for</b>
     * <ul><li> End users</li>
     * <li> Agents with the Help Center manager role can optionally supply a {@code user_id} value. If provided,
     * the user associated with {@code user_id} will be subscribed to the topic.</ul>
     *
     * @param topicId The unique ID of the topic
     * @return Created Response (status code 201)
     */
    @Post("/api/v2/community/topics/{topic_id}/subscriptions")
    Mono<HttpResponse<@Valid SubscriptionResponse>> createTopicSubscription(
            @PathVariable("topic_id") @NotNull Integer topicId
    );

    /**
     * Removes the specified subscription from the specified
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article</a>.
     *
     * <p><b>Allowed for</b>
     * <ul><li> End users </li></ul>
     *
     * @param locale         The locale the item is displayed in
     * @param articleId      The unique ID of the article
     * @param subscriptionId The unique ID of the subscription
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/help_center/{locale}/articles/{article_id}/subscriptions/{subscription_id}")
    Mono<HttpResponse<Void>> deleteArticleSubscription(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );

    /**
     * Delete Post Subscription
     * <p>Removes a subscription to a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/posts">post</a>.
     * <p><b>Allowed for</b>
     * <ul><li> End users </li></ul>
     *
     * @param postId         The unique ID of the post
     * @param subscriptionId The unique ID of the subscription
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/community/posts/{post_id}/subscriptions/{subscription_id}")
    Mono<HttpResponse<Void>> deletePostSubscription(
            @PathVariable("post_id") @NotNull Integer postId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );

    /**
     * Delete Section Subscription
     * <p>Removes the specified subscription from the specified
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/sections">section</a>.
     *
     * <p><b>Allowed for</b>
     * <ul><li> End users </li></ul>
     *
     * @param locale         The locale the item is displayed in
     * @param sectionId      The unique ID of the section
     * @param subscriptionId The unique ID of the subscription
     * @return delete body (status code 204)
     */
    @Delete("/api/v2/help_center/{locale}/sections/{section_id}/subscriptions/{subscription_id}")
    Mono<HttpResponse<Void>> deleteSectionSubscription(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );

    /**
     * Delete Topic Subscription
     * <p>Removes a subscription to a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/topics">topic</a>.
     * <p><b>Allowed for</b>
     * <ul><li> End users </li></ul>
     *
     * @param topicId        The unique ID of the topic
     * @param subscriptionId The unique ID of the subscription
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/community/topics/{topic_id}/subscriptions/{subscription_id}")
    Mono<HttpResponse<Void>> deleteTopicSubscription(
            @PathVariable("topic_id") @NotNull Integer topicId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );

    /**
     *
     * List Article Subscriptions
     * <p>Lists the subscriptions to a given article.</p>
     * <p><strong>Note</strong>: <code>{/locale}</code> is an optional parameter for admins and agents. End users and
     * anonymous users must provide the parameter.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <p>For end-users, the response will list only the subscriptions created by the
     *   requesting end-user.</p>
     * <h4 id="pagination">Pagination</h4>
     * <ul>
     *   <li>Cursor pagination (recommended)</li>
     *   <li>Offset pagination</li>
     * </ul>
     * <p>See <a href="/api-reference/introduction/pagination/">Pagination</a>.</p>
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
     *     <td>users</td>
     *   </tr>
     *   <tr>
     *     <td>articles</td>
     *     <td>articles</td>
     *   </tr>
     *   <tr>
     *     <td>sections</td>
     *     <td>sections</td>
     *   </tr>
     *   </tbody>
     * </table>
     * <p>Note that you need to specify the <code>articles</code> sideload to get the sections
     *   and translations sideloaded because these are not directly associated with the
     *   subscriptions.</p>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/articles/{article_id}/subscriptions")
    Mono<@Valid ContentSubscriptionsResponse> listArticleSubscriptions(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * List Content Subscriptions By User<br>
     * Lists the content subscriptions of a given user. To list your own subscriptions, specify {@code me} as the user id.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users  <h4>Pagination    Cursor pagination (recommended) </h4>:
     * <ul>
     * <li>* Offset pagination  See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.  <h4>Sideloads<br>The following sideloads are supported:  | Name          | Will sideload | For |---------------|---------------|---- | users         | users         | all | articles      | articles      | article subscriptions | sections      | sections      | section subscriptions | questions     | questions     | question subscriptions | topics        | topics        | topic subscriptions | translations  | translations  | article or section subscriptions</li></li>
     * </ul>
     * </h4>:
     * <ul>
     * <li>* </ul></li>
     * </ul>
     *
     * @param userId The unique ID of the user
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/users/{user_id}/subscriptions")
    Mono<@Valid ContentSubscriptionsResponse> listContentSubscriptionsByUserId(
            @PathVariable("user_id") @NotNull Integer userId
    );

    /**
     * List Post Subscriptions<br>
     * <p>Lists the subscriptions to a given post.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <p>For end-users, the response will list only the subscriptions created by the
     *   requesting end-user.</p>
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
     *     <td>users</td>
     *   </tr>
     *   <tr>
     *     <td>posts</td>
     *     <td>posts</td>
     *   </tr>
     *   </tbody>
     * </table>
     *
     * @param postId The unique ID of the post
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/posts/{post_id}/subscriptions")
    Mono<@Valid ContentSubscriptionsResponse> listPostSubscriptions(
            @PathVariable("post_id") @NotNull Integer postId
    );

    /**
     * List Section Subscriptions<br>
     * <p>Lists the subscriptions to a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/sections">section</a>.</p>
     * <p><strong>Note</strong>: <code>{/locale}</code> is an optional parameter for admins and agents. End users and
     * anonymous users must provide the parameter.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <p>For end-users, the response will list only the subscriptions created by the
     *   requesting end-user.</p>
     * <h4 id="pagination">Pagination</h4>
     * <ul>
     *   <li>Cursor pagination (recommended)</li>
     *   <li>Offset pagination</li>
     * </ul>
     * <p>See <a href="/api-reference/introduction/pagination/">Pagination</a>.</p>
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
     *     <td>users</td>
     *   </tr>
     *   <tr>
     *     <td>sections</td>
     *     <td>sections</td>
     *   </tr>
     *   <tr>
     *     <td>translations</td>
     *     <td>translations of any sideloaded articles and sections</td>
     *   </tr>
     *   </tbody>
     * </table>
     * <p>To sideload the section translations, specify the <code>translations</code> sideload in
     *   addition to <code>sections</code>.</p>
     *
     * @param locale    The locale the item is displayed in
     * @param sectionId The unique ID of the section
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/sections/{section_id}/subscriptions")
    Mono<@Valid ContentSubscriptionsResponse> listSectionSubscriptions(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId
    );

    /**
     * List Topic Subscriptions<br>
     * <p>Lists the subscriptions to a given topic.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <p>For end users, the response will list only the subscriptions created by the
     *   requesting end user.</p>
     * <h4 id="pagination">Pagination</h4>
     * <ul>
     *   <li>Cursor pagination (recommended)</li>
     *   <li>Offset pagination</li>
     * </ul>
     * <p>See <a href="/api-reference/introduction/pagination/">Pagination</a>.</p>
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
     *     <td>users</td>
     *   </tr>
     *   <tr>
     *     <td>topics</td>
     *     <td>topics</td>
     *   </tr>
     *   </tbody>
     * </table>
     *
     * @param topicId The unique ID of the topic
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/topics/{topic_id}/subscriptions")
    Mono<@Valid ContentSubscriptionsResponse> listTopicSubscriptions(
            @PathVariable("topic_id") @NotNull Integer topicId
    );

    /**
     * Show Article Subscription<br>
     * <p><strong>Note</strong>: <code>{/locale}</code> is an optional parameter for admins and agents. End users and
     * anonymous users must provide the parameter.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <p>For end-users, the response will only show a subscription created by the requesting end-user.</p>
     * <h4 id="sideloads">Sideloads</h4>
     * <p>The following sideloads are supported:</p>
     * <table>
     *   <thead>
     *   <tr>
     *     <th>Name</th>
     *     <th>Will sideload</th>
     *     <th>For</th>
     *   </tr>
     *   </thead>
     *   <tbody>
     *   <tr>
     *     <td>users</td>
     *     <td>users</td>
     *     <td>all</td>
     *   </tr>
     *   <tr>
     *     <td>articles</td>
     *     <td>articles</td>
     *     <td>article subscriptions</td>
     *   </tr>
     *   <tr>
     *     <td>sections</td>
     *     <td>sections</td>
     *     <td>section subscriptions</td>
     *   </tr>
     *   </tbody>
     * </table>
     *
     * @param locale         The locale the item is displayed in
     * @param articleId      The unique ID of the article
     * @param subscriptionId The unique ID of the subscription
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/articles/{article_id}/subscriptions/{subscription_id}")
    Mono<@Valid SubscriptionResponse> showArticleSubscription(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );

    /**
     * Show Post Subscription<br>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <p>For end users, the response will only show a subscription created by the requesting end user.</p>
     * <h4 id="sideloads">Sideloads</h4>
     * <p>The following sideloads are supported:</p>
     * <table>
     *   <thead>
     *   <tr>
     *     <th>Name</th>
     *     <th>Will sideload</th>
     *     <th>For</th>
     *   </tr>
     *   </thead>
     *   <tbody>
     *   <tr>
     *     <td>users</td>
     *     <td>users</td>
     *     <td>all</td>
     *   </tr>
     *   <tr>
     *     <td>posts</td>
     *     <td>posts</td>
     *     <td>post subscriptions</td>
     *   </tr>
     *   </tbody>
     * </table>
     *
     * @param postId         The unique ID of the post
     * @param subscriptionId The unique ID of the subscription
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/posts/{post_id}/subscriptions/{subscription_id}")
    Mono<@Valid SubscriptionResponse> showPostSubscription(
            @PathVariable("post_id") @NotNull Integer postId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );

    /**
     * Show Section Subscription<br>
     * <p><strong>Note</strong>: <code>{/locale}</code> is an optional parameter for admins and agents. End users and
     * anonymous users must provide the parameter.</p>
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
     *     <th>For</th>
     *   </tr>
     *   </thead>
     *   <tbody>
     *   <tr>
     *     <td>users</td>
     *     <td>users</td>
     *     <td>all</td>
     *   </tr>
     *   <tr>
     *     <td>sections</td>
     *     <td>sections</td>
     *     <td>section subscriptions</td>
     *   </tr>
     *   <tr>
     *     <td>translations</td>
     *     <td>translations</td>
     *     <td>article or section subscriptions</td>
     *   </tr>
     *   </tbody>
     * </table>
     *
     * @param locale         The locale the item is displayed in
     * @param sectionId      The unique ID of the section
     * @param subscriptionId The unique ID of the subscription
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/sections/{section_id}/subscriptions/{subscription_id}")
    Mono<@Valid SubscriptionResponse> showSectionSubscription(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );

    /**
     * Show Topic Subscription<br>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     * <p>For end users, the response will only show a subscription created by the requesting end user.</p>
     * <h4 id="sideloads">Sideloads</h4>
     * <p>The following sideloads are supported:</p>
     * <table>
     *   <thead>
     *   <tr>
     *     <th>Name</th>
     *     <th>Will sideload</th>
     *     <th>For</th>
     *   </tr>
     *   </thead>
     *   <tbody>
     *   <tr>
     *     <td>users</td>
     *     <td>users</td>
     *     <td>all</td>
     *   </tr>
     *   <tr>
     *     <td>topics</td>
     *     <td>topics</td>
     *     <td>topic subscriptions</td>
     *   </tr>
     *   </tbody>
     * </table>
     *
     * @param topicId        The unique ID of the topic
     * @param subscriptionId The unique ID of the subscription
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/topics/{topic_id}/subscriptions/{subscription_id}")
    Mono<@Valid SubscriptionResponse> showTopicSubscription(
            @PathVariable("topic_id") @NotNull Integer topicId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );

    /**
     * Update Topic Subscription<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users</li>
     * </ul>
     *
     * @param topicId        The unique ID of the topic
     * @param subscriptionId The unique ID of the subscription
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/community/topics/{topic_id}/subscriptions/{subscription_id}")
    Mono<@Valid SubscriptionResponse> updateTopicSubscription(
            @PathVariable("topic_id") @NotNull Integer topicId,
            @PathVariable("subscription_id") @NotNull Integer subscriptionId
    );
}
