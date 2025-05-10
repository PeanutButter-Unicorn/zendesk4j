package lol.pbu.zendesk.client;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.ListUserSubscriptionsByUserIdTypeParameter;
import lol.pbu.zendesk.model.UserSubscriptionsResponse;
import reactor.core.publisher.Mono;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client("${micronaut.http.services.zendesk.url}")
public interface UserSubscriptionsClient {

    /**
     * List User Subscriptions By User<br>
     * Lists the user subscriptions of a given user. To list your own subscriptions, specify {@code me} as the user id.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users  
     * </ul><h4>Pagination</h4>
     * <ul><li>Cursor pagination (recommended)</li>
     * <li>Offset pagination  See
     * <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.
     * </ul>
     * <h4>Sideloads</h4>
     * The following sideloads are supported:  
     * <table>
     *   <thead>
     *     <tr>
     *       <th>Name</th>
     *       <th>Will sideload</th>
     *       <th>For</th>
     *     </tr>
     *   </thead>
     *   <tbody>
     *     <tr>
     *       <td>users</td>
     *       <td>users</td>
     *       <td>all</td>
     *     </tr>
     *   </tbody>
     * </table>
     * </li></li>
     * </ul>
     *
     * </ul>
     *
     * @param userId The unique ID of the user
     * @param type   Selects whether to find who the given user is following ("followings") or who is following
     *              the given user ("followers"). The default is "followers".  
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/users/{user_id}/user_subscriptions")
    Mono<@Valid UserSubscriptionsResponse> listUserSubscriptionsByUserId(
            @PathVariable("user_id") @NotNull Integer userId,
            @QueryValue("type") @Nullable ListUserSubscriptionsByUserIdTypeParameter type
    );
}
