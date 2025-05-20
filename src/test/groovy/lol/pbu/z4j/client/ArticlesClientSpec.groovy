package lol.pbu.z4j.client

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class ArticlesClientSpec extends Specification{
    @Inject
    @Shared
    ArticlesClient client

    String[] locales

    def setupSpec() {
        locales = new String[] {}
    }

    def "can list articles"() {
        given:
        client.listArticles(locale as String, null, null, null, null)

        where:
        [locale] << locales
    }

}
