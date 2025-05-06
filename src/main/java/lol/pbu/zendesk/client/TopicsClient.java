package lol.pbu.zendesk.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.TopicResponse;
import lol.pbu.zendesk.model.TopicsResponse;
import reactor.core.publisher.Mono;

@Client("${micronaut.http.services.zendesk.url}")
public interface TopicsClient {

    /**
     * Create Topic<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers<br>Agents with the Help Center Manager role can optionally supply a {@code created_at} as part of the {@code topic} object. If it is not provided {@code created_at} is set to the current time.</li>
     * </ul>
     *
     * @return Created Response (status code 201)
     */
    @Post("/api/v2/community/topics")
    Mono<HttpResponse<@Valid TopicResponse>> createTopic();

    /**
     * Delete Topic<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param topicId The unique ID of the topic
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/community/topics/{topic_id}")
    Mono<HttpResponse<Void>> deleteTopic(
            @PathVariable("topic_id") @NotNull Integer topicId
    );

    /**
     * List Topics<br>
     * Lists all topics.  <h4>Allowed for</h4>
     * <ul>
     * <li>Anonymous users  <h4>Pagination    Cursor pagination (recommended) </h4>:
     * <ul>
     * <li>* Offset pagination<br>See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</li></li>
     * </ul>
     *
     * </ul>
     *
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/topics")
    Mono<@Valid TopicsResponse> listTopics();

    /**
     * Show Topic<br>
     * Shows information about a single topic.  <h4>Allowed for</h4>
     * <ul>
     * <li>Anonymous users</li>
     * </ul>
     *
     * @param topicId The unique ID of the topic
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/community/topics/{topic_id}")
    Mono<@Valid TopicResponse> showTopic(
            @PathVariable("topic_id") @NotNull Integer topicId
    );

    /**
     * Update Topic<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param topicId The unique ID of the topic
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/community/topics/{topic_id}")
    Mono<@Valid TopicResponse> updateTopic(
            @PathVariable("topic_id") @NotNull Integer topicId
    );
}
