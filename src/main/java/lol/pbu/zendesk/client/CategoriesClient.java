package lol.pbu.zendesk.client;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.CategoriesResponse;
import lol.pbu.zendesk.model.CategoryResponse;
import lol.pbu.zendesk.model.ListArticlesSortOrderParameter;
import lol.pbu.zendesk.model.ListCategoriesSortByParameter;
import reactor.core.publisher.Mono;

@Client("${micronaut.http.services.zendesk.url}")
public interface CategoriesClient {

    /**
     * Create Category
     * <p>
     * You must specify a category name and locale. The locale can be omitted if it's specified in the URL. Optionally,
     * you can specify multiple <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/translations">translations</a> for
     * the category. The specified locales must be enabled for the current Help Center.
     * </p>
     * <p><strong>Allowed for</strong>: Help Center managers</p>
     *
     * @param locale The locale the item is displayed in
     * @return OK Response (status code 201)
     */
    @Post("/api/v2/help_center/{locale}/categories")
    Mono<HttpResponse<@Valid CategoryResponse>> createCategory(
            @PathVariable("locale") @NotNull String locale
    );

    /**
     * Delete Category
     * <p>
     * <strong>WARNING: Every section and all articles in the category will also be deleted.</strong>
     * </p>
     * <p><strong>Allowed for</strong>: Help Center managers</p>
     *
     * @param locale     The locale the item is displayed in
     * @param categoryId The unique ID of the category
     * @return No Content (status code 204)
     */
    @Delete("/api/v2/help_center/{locale}/categories/{category_id}")
    Mono<HttpResponse<Void>> deleteCategory(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("category_id") @NotNull Integer categoryId
    );

    /**
     * List Categories
     * <p>
     * <strong>Note</strong>: <code>{/locale}</code> is an optional parameter for admins and agents. End users and
     * anonymous users must provide the parameter.
     *
     * <p><strong>Allowed for</strong>: Anonymous users</p>
     *
     * <p>The response will list only the categories that the agent, end user, or anonymous user can view in the help center.</p>
     *
     * <p><strong>Pagination</strong>: Cursor pagination (recommended) or Offset pagination.
     * See <a href="https://developer.zendesk.com/api-reference/introduction/pagination/">Pagination</a>.</p>
     *
     * <p><strong>Sorting</strong>: You can sort the results with the <code>sort_by</code> and <code>sort_order</code>
     * query string parameters.</p>
     *
     * <p>The <code>sort_by</code> parameter can have one of the following values:</p>
     *
     * <table>
     *   <thead>
     *     <tr><th>Value</th><th>Description</th></tr>
     *   </thead>
     *   <tbody>
     *     <tr><td><code>position</code></td><td>order set manually using the Arrange Content page. Default order</td></tr>
     *     <tr><td><code>created_at</code></td><td>order by creation time</td></tr>
     *     <tr><td><code>updated_at</code></td><td>order by update time</td></tr>
     *   </tbody>
     * </table>
     *
     * <p>The <code>sort_order</code> parameter can have one of the following values:</p>
     *
     * <table>
     *   <thead>
     *     <tr><th>Value</th><th>Description</th></tr>
     *   </thead>
     *   <tbody>
     *     <tr><td><code>asc</code></td><td>ascending order</td></tr>
     *     <tr><td><code>desc</code></td><td>descending order</td></tr>
     *   </tbody>
     * </table>
     *
     * <p><strong>Sideloads</strong>: The following sideloads are supported:</p>
     *
     * <table>
     *   <thead>
     *     <tr><th>Name</th><th>Will sideload</th></tr>
     *   </thead>
     *   <tbody>
     *     <tr><td>translations</td><td>the category translations, if any</td></tr>
     *   </tbody>
     * </table>
     *
     * <p>Translations are embedded within the category because they're not shared between resources.</p>
     *
     * @param locale    The locale the item is displayed in
     * @param sortBy    Sorts the results by one of the accepted values
     * @param sortOrder Selects the order of the results.
     * @return Categories Response (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/categories")
    Mono<@Valid CategoriesResponse> listCategories(
            @PathVariable("locale") @NotNull String locale,
            @QueryValue("sort_by") @Nullable ListCategoriesSortByParameter sortBy,
            @QueryValue("sort_order") @Nullable ListArticlesSortOrderParameter sortOrder
    );

    /**
     * Show Category<br>
     * <strong>Note</strong>: {@code locale} is an optional parameter for admins and agents.
     * End users and anonymous users must provide the parameter.  <h4>Allowed for</h4>
     * <ul>
     * <li>Anonymous users
     *
     * <h4>Sideloads</h4>
     * The following sideloads are supported:
     * <table>
     *     <tr>
     *         <th>Name</td>
     *         <th>Will sideload</td>
     *
     *         </tr>
     *         <tr>
     *              <td>translations</td>
     *          <td>the category translations, if any<br>Translations are embedded within the category because
     *         they're not shared between resources.</td>
     *     </tr>
     * </table>
     * </li>
     * </ul>
     *
     * @param locale     The locale the item is displayed in
     * @param categoryId The unique ID of the category
     * @return description (status code 200)
     */
    @Get("/api/v2/help_center/{locale}/categories/{category_id}")
    Mono<@Valid CategoryResponse> showCategory(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("category_id") @NotNull Integer categoryId
    );

    /**
     * Update Category<br>
     * These endpoints only update category-level metadata such as the sorting position. They don't update
     * category translations.
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Help Center managers</li>
     * </ul>
     *
     * @param locale     The locale the item is displayed in
     * @param categoryId The unique ID of the category
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/help_center/{locale}/categories/{category_id}")
    Mono<@Valid CategoryResponse> updateCategory(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("category_id") @NotNull Integer categoryId
    );

    /**
     * Update Category Source Locale<br>
     * The endpoint updates the category {@code source_locale} property
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Agents</li>
     * </ul>
     *
     * @param locale     The locale the item is displayed in
     * @param categoryId The unique ID of the category
     * @return OK Response (status code 200)
     */
    @Put("/api/v2/help_center/{locale}/categories/{category_id}/source_locale")
    Mono<@NotNull String> updateCategorySourceLocale(
            @PathVariable("locale") @NotNull String locale,
            @PathVariable("category_id") @NotNull Integer categoryId
    );
}
