package lol.pbu.zendesk.client

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import lol.pbu.zendesk.model.ListArticlesSortByParameter
import lol.pbu.zendesk.model.ListArticlesSortOrderParameter
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class ArticleClientSpec extends Specification {

    @Inject
    @Shared
    ArticlesClient articlesClient

    def "can list articles"() {
        when:
        def response = articlesClient.listArticles(
                "en-us",
                ListArticlesSortByParameter.CREATED_AT,
                ListArticlesSortOrderParameter.ASC,
                null,
                null)

        then:
        response.block().articles.size() > 0
    }
}
