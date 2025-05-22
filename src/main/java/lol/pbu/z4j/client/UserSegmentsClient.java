package lol.pbu.z4j.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.z4j.model.*;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.CONTENT_TYPE;
import static io.micronaut.http.MediaType.APPLICATION_JSON;

/**
 * See <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/user_segments/">User Segments</a>
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Header(name = ACCEPT, value = "application/json")
@Client("${micronaut.http.services.zendesk.url}")
public interface UserSegmentsClient {

    /**
     * Create User Segment<br>
     * Allowed for Help Center managers
     *
     * @return Created response (status code 201)
     * or Bad request response (status code 400)
     */
    @Post("/api/v2/help_center/user_segments")
    @Header(name = CONTENT_TYPE, value = APPLICATION_JSON)
    HttpResponse<@Valid UserSegmentResponse> createUserSegment(
            @JsonProperty("user_segment") @Body @NotNull UserSegmentObject userSegment
    );

    /**
     * Delete User Segment<br>
     * Allowed for Help Center managers
     *
     * @param userSegmentID The unique ID of the user segment
     * @return Response when the object was deleted (status code 204)
     */
    @Delete("/api/v2/help_center/user_segments/{userSegmentID}")
    HttpResponse<HttpResponse<Void>> deleteUserSegment(@NotNull Long userSegmentID);

    /**
     * List Sections for a given user segment<br>
     * Allowed for Help Center managers
     *
     * @param userSegmentID The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{userSegmentID}/sections")
    HttpResponse<@Valid SectionsResponse> listUserSegmentSections(@NotNull Long userSegmentID);

    /**
     * List Topics with User Segment<br>
     * Lists the topics that use the specified user segment.
     * Allowed for Help Center managers
     *
     * @param userSegmentID The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{userSegmentID}/topics")
    HttpResponse<@Valid TopicsResponse> listUserSegmentTopics(@NotNull Long userSegmentID);

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
     * Allowed for Help Center managers & Agents
     *
     * @param builtIn Only built_in user segments if true, only custom user segments if false
     * @return OK response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments")
    HttpResponse<@Valid UserSegmentsResponse> listUserSegments(@QueryValue("built_in") @Nullable Boolean builtIn);

    /**
     * Show User Segment<br>
     * Allowed for Help Center managers
     *
     * @param userSegmentID The unique ID of the user segment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/user_segments/{userSegmentID}")
    HttpResponse<@Valid UserSegmentResponse> showUserSegment(@NotNull Long userSegmentID);

    /**
     * Update User Segment<br>
     * Allowed for Help Center managers
     *
     * @param userSegmentID The unique ID of the user segment
     * @return OK Response (status code 200)
     * or Bad request Response (status code 400)
     */
    @Put("/api/v2/help_center/user_segments/{userSegmentID}")
    @Header(name = CONTENT_TYPE, value = APPLICATION_JSON)
    HttpResponse<@Valid UserSegmentResponse> updateUserSegment(
            @NotNull Long userSegmentID,
            @JsonProperty("user_segment") @Body @NotNull @Valid UserSegmentObject userSegment
    );
}
