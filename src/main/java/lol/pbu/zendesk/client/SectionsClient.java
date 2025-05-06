package lol.pbu.zendesk.client;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.*;
import reactor.core.publisher.Mono;

@Client("${micronaut.http.services.zendesk.url}")
public interface SectionsClient {

    /**
     * Create Section<br>
     * Creates a section in a given
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/categories">category</a>.
     * You must specify a section name and locale. The locale can be omitted if it's specified in the URL. Optionally,
     * you can specify multiple
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/translations">translations</a>
     * for the section. The specified locales must be enabled for the current Help Center.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Agents</li>
     * </ul>
     *
     * @param locale     The locale the item is displayed in
     * @param categoryId The unique ID of the category
     * @return description (status code 201)
     * or Bad request Response (status code 400)
     */
    @Post("/api/v2/help_center/{locale}/categories/{category_id}/sections")
    Mono<HttpResponse<@Valid SectionResponse>> createSection(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("category_id") @NotNull Integer categoryId
    );

    /**
     * Delete Section<br>
     * **WARNING: All articles in the section will also be deleted.**
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param locale    The locale the item is displayed in
     * @param sectionId The unique ID of the section
     * @return Default success response (status code 204)
     */
    @Delete("/api/v2/help_center/{locale}/sections/{section_id}")
    Mono<HttpResponse<Void>> deleteSection(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId
    );

    /**
     * List Sections
     * <p>Lists all the sections in Help Center or in a specific
     * <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/categories">category</a>.</p>
     * <p>The <code>{locale}</code> is required only for end users and anonymous users. Admins and agents can omit it.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>Anonymous users</li>
     * </ul>
     * <p>The response will list only the sections that the requesting agent,
     *   end user, or anonymous user can view in the help center.</p>
     * <h4 id="pagination">Pagination</h4>
     * <ul>
     *   <li>Cursor pagination (recommended)</li>
     *   <li>Offset pagination</li>
     * </ul>
     * <p>See <a href="/api-reference/introduction/pagination/">Pagination</a>.</p>
     * <h4 id="sorting">Sorting</h4>
     * <p>You can sort the results with the <code>sort_by</code> and <code>sort_order</code> query string parameters.</p>
     * </code></pre><p>The <code>sort_by</code> parameter can have one of the following values:</p>
     * <table>
     *   <thead>
     *   <tr>
     *     <th>value</th>
     *     <th>description</th>
     *   </tr>
     *   </thead>
     *   <tbody>
     *   <tr>
     *     <td><code>position</code></td>
     *     <td>order set manually using the Arrange Content page. Default order</td>
     *   </tr>
     *   <tr>
     *     <td><code>created_at</code></td>
     *     <td>order by creation time</td>
     *   </tr>
     *   <tr>
     *     <td><code>updated_at</code></td>
     *     <td>order by update time</td>
     *   </tr>
     *   </tbody>
     * </table>
     * <p>The <code>sort_order</code> parameter can have one of the following values:</p>
     * <table>
     *   <thead>
     *   <tr>
     *     <th>value</th>
     *     <th>description</th>
     *   </tr>
     *   </thead>
     *   <tbody>
     *   <tr>
     *     <td><code>asc</code></td>
     *     <td>ascending order</td>
     *   </tr>
     *   <tr>
     *     <td><code>desc</code></td>
     *     <td>descending order</td>
     *   </tr>
     *   </tbody>
     * </table>
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
     *     <td>categories</td>
     *     <td>the category</td>
     *   </tr>
     *   <tr>
     *     <td>translations</td>
     *     <td>the section and category translations, if any</td>
     *   </tr>
     *   </tbody>
     * </table>
     * <p>Unlike other sideloads, translations are embedded within the section because they&#39;re
     *   not shared between resources.
     *   Category translations are only sideloaded if categories are.</p>
     *
     * @param locale    The locale the item is displayed in
     * @param sortBy    Sorts the results by one of the accepted values 
     * @param sortOrder Selects the order of the results. 
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/sections")
    Mono<@Valid SectionsResponse> listSections(
            @PathVariable("locale") @NotNull String locale,
            @QueryValue("sort_by") @Nullable ListCategoriesSortByParameter sortBy,
            @QueryValue("sort_order") @Nullable ListArticlesSortOrderParameter sortOrder
    );

    /**
     * Show Section<br>
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
     *     <td>categories</td>
     *     <td>the category</td>
     *   </tr>
     *   <tr>
     *     <td>translations</td>
     *     <td>the section and category translations, if any</td>
     *   </tr>
     *   </tbody>
     * </table>
     * <p>Unlike other sideloads, translations are embedded within the section since they&#39;re
     *   not shared between resources.
     *   <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/categories">Category</a> translations are only sideloaded
     *   if categories are.</p>
     *
     * @param sectionId The unique ID of the section
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/sections/{section_id}")
    Mono<@Valid SectionResponse> showSection(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId
    );

    /**
     * Update Section<br>
     * Update section. This endpoint updates section-level data, specifically:  * name (in the source locale) * description (in the source locale) * position * sorting * category_id * parent_section_id * theme_template  To update non-source section translations, see <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/translations">Translations</a>.  <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param locale            The locale the item is displayed in
     * @param sectionId         The unique ID of the section
     * @param sectionPutRequest 
     * @return OK Response (status code 200)
     * or Bad request Response (status code 400)
     */
    @Put("/api/v2/help_center/{locale}/sections/{section_id}")
    Mono<@Valid SectionResponse> updateSection(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId,
            @Body @Nullable @Valid SectionPutRequest sectionPutRequest
    );

    /**
     * Update Section Source Locale<br>
     * This endpoint lets you set a section's source language to something other than the default language of your Help Center. For example, if the default language of your Help Center is English but your KB has a section only for Japanese customers, you can set the section's source locale to 'ja'.  <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param locale    The locale the item is displayed in
     * @param sectionId The unique ID of the section
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/help_center/{locale}/sections/{section_id}/source_locale")
    Mono<@NotNull String> updateSectionSourceLocale(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("section_id") @NotNull Integer sectionId
    );
}
