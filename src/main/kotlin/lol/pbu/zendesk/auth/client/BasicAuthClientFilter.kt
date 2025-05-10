package lol.pbu.zendesk.auth.client

import io.micronaut.context.annotation.Property
import io.micronaut.http.HttpHeaders
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.ClientFilter
import io.micronaut.http.annotation.RequestFilter
import jakarta.inject.Singleton
import java.nio.charset.StandardCharsets.UTF_8
import java.util.Base64.getEncoder

/**
 * Add a basic auth to anything aimed at a zendesk url
 *
 * @param email user or admin email address
 * @param token api token generated from zendesk
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@BasicAuth
@Singleton
@ClientFilter("**.zendesk.com/**")
class BasicAuthClientFilter(
    @Property(name = "micronaut.http.services.zendesk.email") var email: String,
    @Property(name = "micronaut.http.services.zendesk.token") var token: String
) {
    @Override
    @RequestFilter
    fun doFilter(request: MutableHttpRequest<*>) {
        request.headers.add(HttpHeaders.AUTHORIZATION,
            "Basic ${getEncoder().encodeToString("$email/token:$token".toByteArray(UTF_8))}"
        )
        request.headers.add(HttpHeaders.USER_AGENT, "Zendesk4j Micronaut Http Client")
    }
}