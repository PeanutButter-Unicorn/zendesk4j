package lol.pbu.zendesk.client;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.*;
import reactor.core.publisher.Mono;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client("${micronaut.http.services.zendesk.url}")
public interface ArticlesClient {

    /**
     * Archive Article Archives the article. You can restore the article using the Help Center user interface.
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return Default success response (status code 204)
     * @see <a href="https://support.zendesk.com/hc/en-us/articles/235721587">Viewing and restoring archived articles</a>
     */
    @Delete("/api/v2/help_center/{locale}/articles/{article_id}")
    Mono<HttpResponse<Void>> archiveArticle(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Associate Attachments in Bulk to Article<br>
     * You can associate attachments in bulk to only one article at a time, with a maximum of 20
     * attachments per request.
     * <p><strong>Allowed for</strong>: Agents</p>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return description (status code 200)
     * @see <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/article_attachments/">
     * Create Unassociated Attachment
     * </a>
     */
    @Post("/api/v2/help_center/{locale}/articles/{article_id}/bulk_attachments")
    Mono<@NotNull String> bulkAttachmentsArticles(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Create Article<br>
     *
     * @param locale         The locale the item is displayed in
     * @param sectionId      The unique ID of the section
     * @param articleRequest The article to create
     * @return OK Response (status code 201)
     */
    @Post("/api/v2/help_center/{locale}/sections/{section_id}/articles")
    Mono<HttpResponse<@Valid ArticleResponse>> createArticle(
            @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId,
            @Body @Nullable @Valid ArticleRequest articleRequest
    );

    /**
     * List Articles
     *
     * @param locale     The locale the item is displayed in
     * @param sortBy     Sorts the articles by one of the accepted values
     * @param sortOrder  Selects the order of the results.
     * @param startTime  You can use the incremental article endpoint to list all the articles that were
     *                   updated since a certain date and time.
     * @param labelNames Only articles that have all the labels are returned.
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/articles")
    Mono<@Valid ArticlesResponse> listArticles(
            @NotNull String locale,
            @QueryValue("sort_by") @Nullable ListArticlesSortByParameter sortBy,
            @QueryValue("sort_order") @Nullable ListArticlesSortOrderParameter sortOrder,
            @QueryValue("start_time") @Nullable Integer startTime,
            @QueryValue("label_names") @Nullable String labelNames
    );

    /**
     * Show Article
     * <p>Shows the properties of an article.</p>
     * <p><strong>Note</strong>: <code>{/locale}</code> is an optional parameter for admins and agents. End users and
     * anonymous users must provide the parameter.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>Anonymous users</li>
     * </ul>
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
     *     <td>the author</td>
     *   </tr>
     *   <tr>
     *     <td>sections</td>
     *     <td>the section</td>
     *   </tr>
     *   <tr>
     *     <td>categories</td>
     *     <td>the category</td>
     *   </tr>
     *   <tr>
     *     <td>translations</td>
     *     <td>the article, section and category translations, if any</td>
     *   </tr>
     *   </tbody>
     * </table>
     * <p>Unlike other sideloads, translations are embedded within the article because they&#39;re
     *   not shared between resources.
     *   Section and category translations are only sideloaded if present.</p>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/articles/{article_id}")
    Mono<@Valid ArticleResponse> showArticle(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Update Article<br>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/help_center/{locale}/articles/{article_id}")
    Mono<@Valid ArticleResponse> updateArticle(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Update Article Source Locale<br>
     * <p>Updates the article&#39;s <code>source_locale</code> property. The source locale is the main
     *   language of the article. When you delete the article in the source locale, you delete all the
     *   article&#39;s translations.</p>
     * <p>The endpoint sets one of the article&#39;s translation as the source locale of the article. The article
     *   in the previous source locale becomes a translation, which you can delete separately.</p>
     * <p>The new source locale must be enabled in Guide. See
     *   <a href="https://support.zendesk.com/hc/en-us/articles/224857687#topic_ys2_kxh_tz">Enabling languages for your
     *     help center</a>. You can use the
     *   <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/translations/#list-enabled-locales-and-default-locale">List
     *     all enabled locales and default locale</a> endpoint to check for the enabled locales.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>Agents</li>
     * </ul>
     *
     * @param locale    The locale the item is displayed in
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/help_center/{locale}/articles/{article_id}/source_locale")
    Mono<@NotNull String> updateArticleSourceLocale(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("article_id") @NotNull Integer articleId
    );
}
