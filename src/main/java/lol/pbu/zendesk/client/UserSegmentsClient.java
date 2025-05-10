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

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
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
    Mono<HttpResponse<Void>> deleteUserSegment(
            @PathVariable("user_segment_id") @NotNull Integer userSegmentId
    );

    /**
     * List Sections with User Segment<br>
     * Lists the sections that use the specified user segment.  This endpoint supports pagination as described in
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/help-center-api/#pagination">Pagination</a>.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param userSegmentId The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{user_segment_id}/sections")
    Mono<@Valid SectionsResponse> listUserSegmentSections(
            @PathVariable("user_segment_id") @NotNull Integer userSegmentId
    );

    /**
     * List Topics with User Segment<br>
     * Lists the topics that use the specified user segment.  This endpoint supports pagination as described in
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/help-center-api/#pagination">Pagination</a>.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers  </li></ul>
     * <h4>Pagination</h4>
     * Cursor pagination (recommended)
     * <ul>
     * <li>Offset pagination
     * <br>See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</li></li>
     * </ul>
     *
     * @param userSegmentId The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{user_segment_id}/topics")
    Mono<@Valid TopicsResponse> listUserSegmentTopics(
            @PathVariable("user_segment_id") @NotNull Integer userSegmentId
    );

    /**
     * List User Segments<br>
     * Some user segments can only be applied to sections and topics on certain Guide plans. For instance, user
     * segments with a {@code user_type} of {@code "staff"} cannot be applied to sections and topics on accounts on
     * the Guide Lite plan or the Suite Team plan. To request only user segments applicable on the account's current
     * Suite plan, use the {@code /api/v2/help_center/user_segments/applicable.json} endpoint.
     * The {@code /api/v2/help_center/users/{user_id}/user_segments.json} endpoint returns the list of user segments
     * that a particular user belongs to. This is the only list endpoint that agents have access to. When an agent
     * makes a request to this endpoint with another user's id, the response only includes user segments that the
     * requesting agent also belongs to.  These endpoints support pagination, as described in the
     * <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">pagination documentation</a>.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers s  Agents  </li></ul>
     * <h4>Pagination  </h4>:
     * <ul>
     * <li>Cursor pagination (recommended)</li>
     * <li>Offset pagination
     * <br>See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</li></li>
     * </ul>
     *
     * @param builtIn Only built_in user segments if true, only custom user segments if false 
     * @return OK response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments")
    Mono<@Valid UserSegmentsResponse> listUserSegments(
            @QueryValue("built_in") @Nullable Boolean builtIn
    );

    /**
     * Show User Segment<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers  <h4>Pagination    Cursor pagination (recommended) </h4>:
     * <ul>
     * <li>* Offset pagination<br>See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</li></li>
     * </ul>
     *
     * </ul>
     *
     * @param userSegmentId The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{user_segment_id}")
    Mono<@Valid UserSegmentResponse> showUserSegment(
            @PathVariable("user_segment_id") @NotNull Integer userSegmentId
    );

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
    Mono<@Valid UserSegmentResponse> updateUserSegment(
            @PathVariable("user_segment_id") @NotNull Integer userSegmentId
    );
}
