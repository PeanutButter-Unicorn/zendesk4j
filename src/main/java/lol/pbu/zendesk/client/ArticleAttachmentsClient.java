package lol.pbu.zendesk.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.ArticleAttachmentResponse;
import lol.pbu.zendesk.model.ArticleAttachmentsResponse;
import reactor.core.publisher.Mono;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client("${micronaut.http.services.zendesk.url}")
public interface ArticleAttachmentsClient {

    /**
     * Create Article Attachment.
     * <p>
     * <p>Creates an attachment for the specified
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article</a>. You can specify whether the
     * attachment is inline or not. The default is false.</p>
     * <p>The <code>guide_media_id</code> parameter is required and must be submitted as multipart form data. This is
     * the id of the media object to be attached to the article. See
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/guide_medias/#create-guide-media">Create guide media
     * object</a>. The &#39;inline&#39; parameter is optional.</p>
     * <p>If your integration depends on keeping the translation body in sync with an external system, create a
     * separate article attachment for each translation and set the locale in advance.
     *   Inline article attachments are automatically assigned a locale when they are embedded in a translation body.
     *   If the same attachment is inserted in multiple translations, it will create multiple article attachment
     *   records, all linked to the same file, and the references in the translation bodies will be
     *   updated accordingly.</p>
     * <p><em>Notes:</em></p>
     * <ul>
     *   <li>First create a <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/guide_medias/#create-guide-media">Guide
     *   media object</a> and then
     *   <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/article_attachments/#create-article-attachment">create
     *   an article attachment</a> with the value of the media object&#39;s <code>id</code>. When creating the
     *   attachment, use the value of the media object&#39;s <code>id</code> as the value of the attachment&#39;s
     *   <code>guide_media_id</code> property.</li>
     *   <li>Inline article attachments that are no longer embedded in the translation get deleted. However, the
     *   corresponding file is kept in the account&#39;s media library.</li>
     * </ul>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>Agents</li>
     * </ul>
     *
     * @param articleId The unique ID of the article
     * @return OK Response (status code 201)
     */
    @Post("/api/v2/help_center/articles/{article_id}/attachments")
    Mono<HttpResponse<@Valid ArticleAttachmentResponse>> createArticleAttachment(
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Create Unassociated Attachment.
     * <p>
     * You can use this endpoint for bulk imports. It lets you upload a file
     * without associating it to an article until later. See
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles#associate-attachments-in-bulk-to-article">
     * Associate Attachments in Bulk to Article</a>. If you plan on adding attachments
     * to article translations, import a separate article attachment for
     * each translation and set the locale in advance. For more information
     * on translation attachments, see
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/article_attachments/#create-article-attachment">
     * Create Article Attachment</a>.
     * </p>
     * <p>
     * <b>Notes:</b>
     * <ul>
     * <li>Zendesk recommends to first create a
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/guide_medias/#create-guide-media">Guide
     * media object</a> and then
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/article_attachments/#create-article-attachment">create
     * an article attachment</a> with the value of the media object's
     * <code>id</code>. When creating the attachment, use the value of the
     * media object's <code>id</code> as the value of the attachment's
     * <code>guide_media_id</code> property.</li>
     * <li>Associate attachments to articles as soon as possible. For
     * example, if you use the endpoint to bulk-import inline images, only
     * signed-in end users can see the images; anonymous users don't have
     * permission to view unassociated images. Also, from time to time, we
     * purge old article attachments not associated to any article. To ensure
     * you don't lose an uploaded file, associate it to an article.</li>
     * </ul>
     * </p>
     * <p><strong>Allowed for</strong>: Agents</p>
     *
     * @return Created Response (status code 201)
     */
    @Post("/api/v2/help_center/articles/attachments")
    Mono<HttpResponse<@Valid ArticleAttachmentResponse>> createAttachment();

    /**
     * Delete Article Attachment
     * <p><strong>Allowed for</strong>: Agents</p>
     *
     * @param articleAttachmentId The unique ID of the article attachment
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/help_center/articles/attachments/{article_attachment_id}")
    Mono<HttpResponse<Void>> deleteArticleAttachment(
            @PathVariable("article_attachment_id") @NotNull Integer articleAttachmentId
    );

    /**
     * List Article Attachments.
     * <p>
     * Lists all the article's attachments.
     * <p><b>Note</b>: By default the pagination returns the maximum attachments
     * per page, which is 100.
     * </p>
     * <p><strong>Allowed for</strong>: Agents, End users (as long as they can view the associated article)</p>
     * </p>
     * <p><strong>Pagination</strong>: Cursor pagination (recommended), Offset pagination
     *
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     * @see <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.
     */
    @Get("/api/v2/help_center/articles/{article_id}/attachments")
    Mono<@Valid ArticleAttachmentsResponse> listArticleAttachments(
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * List Article Block Attachments.
     * <p>
     * Lists all the article's block attachments. Block attachments are
     * those that are not inline.
     * </p>
     * <p><strong>Allowed for</strong>: Agents, End users (as long as they can view the associated article)</p>
     * </p>
     *
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/{article_id}/attachments/block")
    Mono<@Valid ArticleAttachmentsResponse> listBlockArticleAttachments(
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * List Article Inline Attachments.
     * <p>
     * Lists all the article's inline attachments.
     * </p>
     * <p><strong>Allowed for</strong>: Agents, End users (as long as they can view the associated article)</p>
     *
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/{article_id}/attachments/inline")
    Mono<@Valid ArticleAttachmentsResponse> listInlineArticleAttachments(
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Show Article Attachment.
     * <p>
     * Shows the properties of the specified attachment.
     * <p><b>Note</b>: Omit {@code article_id} to access unassociated
     * article attachments.
     * </p>
     * <p><strong>Allowed for</strong>: Agents, End users (as long as they can view the associated article)</p>
     *
     * @param articleId           The unique ID of the article
     * @param articleAttachmentId The unique ID of the article attachment
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/{article_id}/attachments/{article_attachment_id}")
    Mono<@Valid ArticleAttachmentResponse> showArticleAttachment(
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("article_attachment_id") @NotNull Integer articleAttachmentId
    );
}
