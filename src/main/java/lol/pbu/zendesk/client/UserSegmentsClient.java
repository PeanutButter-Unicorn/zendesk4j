package lol.pbu.zendesk.client;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.SectionsResponse;
import lol.pbu.zendesk.model.TopicsResponse;
import lol.pbu.zendesk.model.UserSegmentResponse;
import lol.pbu.zendesk.model.UserSegmentsResponse;
import reactor.core.publisher.Mono;

import static io.micronaut.http.HttpHeaders.ACCEPT;

/**
 * See <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/user_segments/">User Segments</a>
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Header(name = ACCEPT, value = "application/json")
@Client("${micronaut.http.services.zendesk.url}")
public interface UserSegmentsClient {

    /**
     * Create User Segment<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @return Created response (status code 201)
     * or Bad request response (status code 400)
     */
    @Post("/api/v2/help_center/user_segments")
    Mono<HttpResponse<@Valid UserSegmentResponse>> createUserSegment();

    /**
     * Delete User Segment<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param userSegmentId The unique ID of the user segment
     * @return Response when the object was deleted (status code 204)
     */
    @Delete("/api/v2/help_center/user_segments/{user_segment_id}")
    Mono<HttpResponse<Void>> deleteUserSegment(@PathVariable("user_segment_id") @NotNull Long userSegmentId);

    /**
     * List Sections for a given user segment<br>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>Help Center managers</li>
     * </ul>
     *
     * @param userSegmentId The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{user_segment_id}/sections")
    Mono<@Valid SectionsResponse> listUserSegmentSections(@PathVariable("user_segment_id") @NotNull Long userSegmentId);

    /**
     * List Topics with User Segment<br>
     * Lists the topics that use the specified user segment.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers  </li></ul>
     *
     *
     * @param userSegmentId The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{user_segment_id}/topics")
    Mono<@Valid TopicsResponse> listUserSegmentTopics(@PathVariable("user_segment_id") @NotNull Long userSegmentId);

    /**
     * List User Segments<br>
     * Some user segments can only be applied to sections and topics on certain Guide plans. For instance, user
     * segments with a {@code user_type} of {@code "staff"} cannot be applied to sections and topics on accounts on
     * the Guide Lite plan or the Suite Team plan. To request only user segments applicable on the account's current
     * Suite plan, use the {@code /api/v2/help_center/user_segments/applicable.json} endpoint.
     * The {@code /api/v2/help_center/users/{user_id}/user_segments.json} endpoint returns the list of user segments
     * that a particular user belongs to. This is the only list endpoint that agents have access to. When an agent
     * makes a request to this endpoint with another user's id, the response only includes user segments that the
     * requesting agent also belongs to.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * <li>Agents</li></ul>
     *
     *
     * @param builtIn Only built_in user segments if true, only custom user segments if false 
     * @return OK response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments")
    Mono<@Valid UserSegmentsResponse> listUserSegments(@QueryValue("built_in") @Nullable Boolean builtIn);

    /**
     * Show User Segment<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers  </li></ul>
     *
     * @param userSegmentId The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{user_segment_id}")
    Mono<@Valid UserSegmentResponse> showUserSegment(@PathVariable("user_segment_id") @NotNull Long userSegmentId);

    /**
     * Update User Segment<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param userSegmentId The unique ID of the user segment
     * @return OK Response (status code 200)
     * or Bad request Response (status code 400)
     */
    @Put("/api/v2/help_center/user_segments/{user_segment_id}")
    Mono<@Valid UserSegmentResponse> updateUserSegment(@PathVariable("user_segment_id") @NotNull Long userSegmentId);
}
