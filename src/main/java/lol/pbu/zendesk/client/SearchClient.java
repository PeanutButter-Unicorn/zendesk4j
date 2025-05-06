package lol.pbu.zendesk.client;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lol.pbu.zendesk.model.ArticleSearchResponse;
import lol.pbu.zendesk.model.CommunityPostSearchResponse;
import lol.pbu.zendesk.model.UnifiedSearchResultSet;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.List;

@Client("${micronaut.http.services.zendesk.url}")
public interface SearchClient {

    /**
     * Search Articles
     * <p>Returns a default number of 25 articles per page, up to a maximum of 1000 results.
     * See <a href="/api-reference/introduction/pagination/">Pagination</a>. The <code>per_page</code> parameter,
     * if provided, must be an integer between 1 and 100.</p>
     * <p>The <code>page</code> parameter, if provided, must be an integer greater than 0.</p>
     * <p>The results are sorted by relevance by default. You can also sort the results by <code>created_at</code>
     * or <code>updated_at</code>.</p>
     * <p>The <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/articles">article objects</a> returned by the search
     * endpoint contain two additional properties:</p>
     * <table>
     *   <thead>
     *   <tr>
     *     <th>Name</th>
     *     <th>Type</th>
     *     <th>Read-only</th>
     *     <th>Mandatory</th>
     *     <th>Comment</th>
     *   </tr>
     *   </thead>
     *   <tbody>
     *   <tr>
     *     <td>result_type</td>
     *     <td>string</td>
     *     <td>yes</td>
     *     <td>no</td>
     *     <td>For articles, always the string &quot;article&quot;</td>
     *   </tr>
     *   <tr>
     *     <td>snippet</td>
     *     <td>string</td>
     *     <td>yes</td>
     *     <td>no</td>
     *     <td>The portion of an article that is relevant to the search query, with matching words or phrases delimited
     *     by <code>&lt;em&gt;&lt;/em&gt;</code> tags. Example: a query for &quot;carrot potato&quot; might return the
     *     snippet &quot;...don&#39;t confuse <code>&lt;em&gt;</code>carrots<code>&lt;/em&gt;</code> with
     *     <code>&lt;em&gt;</code>potatoes<code>&lt;/em&gt;</code>...&quot;</td>
     *   </tr>
     *   </tbody>
     * </table>
     * <p>You must specify at least one of the following parameters in your request:</p>
     * <ul>
     *   <li>query</li>
     *   <li>category</li>
     *   <li>section</li>
     *   <li>label_names</li>
     * </ul>
     * <h4 id="pagination">Pagination</h4>
     * <ul>
     *   <li>Offset pagination only</li>
     * </ul>
     * <p>See <a href="/api-reference/introduction/pagination/">Pagination</a>.</p>
     * <p>Returns a maximum of 100 articles per page.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>Anonymous users</li>
     * </ul>
     *
     * @param category      Limit the search to this category id. See <a href="#filtering-by-category">Filtering by Category</a> 
     * @param section       Limit the search to this section id. See <a href="#filtering-by-section">Filtering by Section</a> 
     * @param labelNames    A comma-separated list of label names. See <a href="#filtering-by-labels">Filtering by Labels</a> 
     * @param locale        Search for articles in the specified locale. See <a href="#filtering-by-locale">Filtering by Locale</a> 
     * @param multibrand    Enable search across all brands if true. Defaults to false if omitted.  
     * @param brandId       Search for articles in the specified brand.  
     * @param createdBefore Limit the search to articles created before a given date (format YYYY-MM-DD).  
     * @param createdAfter  Limit the search to articles created after a given date (format YYYY-MM-DD).  
     * @param createdAt     Limit the search to articles created on a given date (format YYYY-MM-DD).  
     * @param updatedBefore Limit the search to articles updated before a given date (format YYYY-MM-DD).  
     * @param updatedAfter  Limit the search to articles updated after a given date (format YYYY-MM-DD).  
     * @param updatedAt     Limit the search to articles updated on a given date (format YYYY-MM-DD).  
     * @param sortBy        One of created_at or updated_at. Defaults to sorting by relevance 
     * @param sortOrder     One of asc or desc. Defaults to desc 
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/articles/search")
    Mono<@Valid ArticleSearchResponse> articleSearch(
            @QueryValue("query") @Nullable String query,
            @QueryValue("category") @Nullable Integer category,
            @QueryValue("section") @Nullable Integer section,
            @QueryValue("label_names") @Nullable String labelNames,
            @QueryValue("locale") @Nullable String locale,
            @QueryValue("multibrand") @Nullable Boolean multibrand,
            @QueryValue("brand_id") @Nullable Integer brandId,
            @QueryValue("created_before") @Nullable ZonedDateTime createdBefore,
            @QueryValue("created_after") @Nullable ZonedDateTime createdAfter,
            @QueryValue("created_at") @Nullable ZonedDateTime createdAt,
            @QueryValue("updated_before") @Nullable ZonedDateTime updatedBefore,
            @QueryValue("updated_after") @Nullable ZonedDateTime updatedAfter,
            @QueryValue("updated_at") @Nullable ZonedDateTime updatedAt,
            @QueryValue("sort_by") @Nullable String sortBy,
            @QueryValue("sort_order") @Nullable String sortOrder
    );

    /**
     * Search Posts<br>
     * <p>Returns a maximum of 25 posts per page, up to a maximum of 1000 results.
     * See <a href="/api-reference/introduction/pagination/">Pagination</a>.</p>
     * <p>The results are sorted by relevance by default. You can also sort the results by <code>created_at</code> or
     * <code>updated_at</code>.</p>
     * <h4 id="pagination">Pagination</h4>
     * <ul>
     *   <li>Offset pagination only</li>
     * </ul>
     * <p>See <a href="/api-reference/introduction/pagination/">Pagination</a>.</p>
     * <p>Returns a maximum of 100 articles per page.</p>
     * <h4 id="allowed-for">Allowed for</h4>
     * <ul>
     *   <li>End users</li>
     * </ul>
     *
     * @param topic         Search by topic ID. See <a href="#filtering-by-topic">Filtering by Topic</a> 
     * @param createdBefore the search to posts created before a given date (format YYYY-MM-DD) 
     * @param createdAfter  Search  posts created after a given date (format YYYY-MM-DD)
     * @param createdAt     Search posts created on a given date (format YYYY-MM-DD) 
     * @param updatedBefore Search posts updated before a given date (format YYYY-MM-DD) 
     * @param updatedAfter  Search posts updated after a given date (format YYYY-MM-DD) 
     * @param updatedAt     Search posts updated on a given date (format YYYY-MM-DD) 
     * @param sortBy        Sort by {@code created_at} or {@code updated_at}. Defaults to sorting by relevance 
     * @param sortOrder     Sort in ascending or descending order. Default is descending order. 
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/community_posts/search")
    Mono<@Valid CommunityPostSearchResponse> communityPostSearch(
            @QueryValue("query") @NotNull String query,
            @QueryValue("topic") @Nullable Integer topic,
            @QueryValue("created_before") @Nullable ZonedDateTime createdBefore,
            @QueryValue("created_after") @Nullable ZonedDateTime createdAfter,
            @QueryValue("created_at") @Nullable ZonedDateTime createdAt,
            @QueryValue("updated_before") @Nullable ZonedDateTime updatedBefore,
            @QueryValue("updated_after") @Nullable ZonedDateTime updatedAfter,
            @QueryValue("updated_at") @Nullable ZonedDateTime updatedAt,
            @QueryValue("sort_by") @Nullable String sortBy,
            @QueryValue("sort_order") @Nullable String sortOrder
    );

    /**
     * Unified Search<br>
     *
     * @param filterLocales           Limit the search to these locales. 
     *                                See <a href="#filtering-by-locale">Filtering by Locale</a>
     * @param query                   The search text to be matched or a search string  
     * @param filterCategoryIds       Limit the search to articles in these categories. See
     *                                <a href="#filtering-by-category">Filtering by Category</a> 
     * @param filterSectionIds        Limit the search to articles in these sections. See 
     *                                <a href="#filtering-by-section">Filtering by Section</a> 
     * @param filterTopicIds          Limit the search to posts in these topics. See 
     *                                <a href="#filtering-by-topic">Filtering by Topic</a> 
     * @param filterExternalSourceIds Use this parameter to scope the result of your search to a specific external 
     *                                source or external sources.  If no external source is given, results are returned 
     *                                across all sources  
     * @param filterBrandIds          Limit the search to articles or posts within these brands. If no brand is 
     *                                specified, results are returned across all brands.  If you want to scope the 
     *                                result of your search with multiple brands, separate each value with a comma  
     * @param filterContentTypes      Limit the search to one of these content types: ARTICLE, POST.  At present, 
     *                                it is not possible to specify {@code EXTERNAL_RECORD}.  Instead, use the 
     *                                {@code filter[external_source_id]} parameter above  
     * @param pageAfter               A string representing the cursor to the next page.  
     * @param pageSize                A numeric value that indicates the maximum number of items that can be included 
     *                                in a response. The value of this parameter has an upper limit of 50. The default 
     *                                value is 10.  
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/guide/search")
    Mono<@Valid UnifiedSearchResultSet> unifiedSearch(
            @QueryValue("filter[locales]") @NotNull String filterLocales,
            @QueryValue("query") @Nullable String query,
            @QueryValue("filter[category_ids]") @Nullable String filterCategoryIds,
            @QueryValue("filter[section_ids]") @Nullable String filterSectionIds,
            @QueryValue("filter[topic_ids]") @Nullable String filterTopicIds,
            @QueryValue("filter[external_source_ids]") @Nullable String filterExternalSourceIds,
            @QueryValue("filter[brand_ids]") @Nullable List<@NotNull String> filterBrandIds,
            @QueryValue("filter[content_types]") @Nullable String filterContentTypes,
            @QueryValue("page[after]") @Nullable String pageAfter,
            @QueryValue("page[size]") @Nullable Integer pageSize
    );
}
