package lol.pbu.zendesk.client;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.HelpCenterLocalesResponse;
import lol.pbu.zendesk.model.LocalesWithDefaultResponse;
import lol.pbu.zendesk.model.TranslationResponse;
import lol.pbu.zendesk.model.TranslationsResponse;
import reactor.core.publisher.Mono;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Client("${micronaut.http.services.zendesk.url}")
public interface TranslationsClient {

    /**
     * Create Translation<br>
     * Creates a translation for a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article</a>,
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/sections">section</a>,
     * or <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/categories">category</a>.
     * Any locale that you specify must be enabled for the current Help Center.
     * The locale must also be different from that of any existing translation associated with the source object.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center Managers </li>
     * <li>Agents (article translations only)<br>The requesting agent can create an article translation only if they
     * can edit the article in Help Center.</li>
     * </ul>
     *
     * @param articleId The unique ID of the article
     * @return description (status code 201)
     */
    @Post("/api/v2/help_center/articles/{article_id}/translations")
    Mono<HttpResponse<@Valid TranslationResponse>> createTranslation(
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * Delete Translation<br>
     * Deletes a translation, provided it's not the only translation for the source object.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Agents</li>
     * </ul>
     *
     * @param translationId The unique ID of the translation
     * @return Delete response (status code 204)
     */
    @Delete("/api/v2/help_center/translations/{translation_id}")
    Mono<HttpResponse<Void>> deleteTranslation(
            @PathVariable("translation_id") @NotNull Integer translationId
    );

    /**
     * List Enabled Locales and Default Locale<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users</li>
     * </ul>
     *
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/locales")
    Mono<@Valid LocalesWithDefaultResponse> listLocales();

    /**
     * List Missing Translations<br>
     * Lists the locales that don't have a translation for a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article</a>,
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/sections">section</a>, or
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/categories">category</a>.
     * <h4>Allowed for</h4>
     * <ul>
     * Agents
     * </ul>
     * <h4>Pagination</h4>
     * <ul>
     * <li>Cursor pagination (recommended) </li>
     * <li>Offset pagination<br>See
     * <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</li></li>
     * </ul>
     *
     * @param articleId The unique ID of the article
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/{article_id}/translations/missing")
    Mono<@Valid HelpCenterLocalesResponse> listMissingTranslations(
            @PathVariable("article_id") @NotNull Integer articleId
    );

    /**
     * List Translations<br>
     * Lists all translations for a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article</a>,
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/sections">section</a>, or
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/categories">category</a>.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users  <p>For end users, the response will list only the translations for articles, sections, or
     * categories that they can view in Help Center.  </ul>
     * </ul>
     * <h4>Pagination</h4>
     * <ul>
     * <li>Cursor pagination (recommended) </li>
     * <li>Offset pagination<br>
     * See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</li></li>
     * </ul>
     *
     * @param articleId The unique ID of the article
     * @param locales   The value given is a comma-separated list of locale names;
     *                  only return translations in those locales  
     * @param outdated  Only return translations with the given outdated status 
     * @param draft     Only return translations with the given draft status 
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/{article_id}/translations")
    Mono<@Valid TranslationsResponse> listTranslations(
            @PathVariable("article_id") @NotNull Integer articleId,
            @QueryValue("locales") @Nullable String locales,
            @QueryValue("outdated") @Nullable Boolean outdated,
            @QueryValue("draft") @Nullable Boolean draft
    );

    /**
     * Show Translation<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>End users</li>
     * </ul>
     *
     * @param articleId The unique ID of the article
     * @param locale    Mandatory locale parameter
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/{article_id}/translations/{locale}")
    Mono<@Valid TranslationResponse> showTranslation(
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("locale") @NotNull String locale
    );

    /**
     * Update Translation<br>
     * When updating a translation, any locale that you specify must be enabled for the current help center.
     * If you change the translation locale, it must be different from that of any existing translation associated
     * with the same source object.  The PUT request does not update the translation's {@code updated_at} value if the
     * data in the request body matches the data in the translation.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Agents (only articles)</li>
     * </ul>
     *
     * @param articleId The unique ID of the article
     * @param locale    Mandatory locale parameter
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/help_center/articles/{article_id}/translations/{locale}")
    Mono<@Valid TranslationResponse> updateTranslation(
            @PathVariable("article_id") @NotNull Integer articleId,
            @PathVariable("locale") @NotNull String locale
    );
}
