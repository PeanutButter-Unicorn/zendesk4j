package lol.pbu.zendesk.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.LabelResponse;
import lol.pbu.zendesk.model.LabelsResponse;
import reactor.core.publisher.Mono;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client("${micronaut.http.services.zendesk.url}")
public interface ArticleLabelsClient {

    /**
     * Create Label
     * <p><strong>Allowed for</strong>: Agents</p>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return Created Response (status code 201)
     */
    @Post("/api/v2/help_center/{locale}/articles/{article_id}/labels")
    Mono<HttpResponse<@Valid LabelResponse>> createArticleLabel(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Delete Label from Article
     * <p>Removes the label from the specified article's list of labels.
     * <p><strong>Allowed for</strong>: Agents</p>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @param labelId   The unique ID of the label
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/help_center/{locale}/articles/{article_id}/labels/{label_id}")
    Mono<HttpResponse<Void>> deleteArticleLabel(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("label_id") @NotNull Integer labelId
    );

    /**
     * Delete Label
     * <p>Removes the label from all articles and deletes it.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Agents</li>
     * </ul>
     *
     * @param labelId The unique ID of the label
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/help_center/articles/labels/{label_id}")
    Mono<HttpResponse<Void>> deleteLabel(
            @PathVariable("label_id") @NotNull Integer labelId
    );

    /**
     * Lists all the labels in the articles in Help Center.
     *
     * <p><strong>Allowed for</strong>: Agents</p>
     *
     * <p><strong>Pagination</strong>: Cursor pagination (recommended), Offset pagination.
     * See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</p>
     *
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/labels")
    Mono<@Valid LabelsResponse> listAllArticleLabels();

    /**
     * Lists all the labels in a given article.
     *
     * <p><strong>Allowed for:</strong> Agents</p>
     *
     * <p><strong>Pagination:</strong> Cursor pagination (recommended), Offset pagination.
     * See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</p>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return description (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/articles/{article_id}/labels")
    Mono<@Valid LabelsResponse> listArticleLabels(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Show Label
     * <p>Shows the properties of the specified label.
     * <p><strong>Allowed for:</strong> Agents</p>
     *
     * @param labelId The unique ID of the label
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/labels/{label_id}")
    Mono<@Valid LabelResponse> showLabel(
            @PathVariable("label_id") @NotNull Integer labelId
    );
}
