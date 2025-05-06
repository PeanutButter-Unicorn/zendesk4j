package lol.pbu.zendesk.auth

import io.micronaut.context.annotation.Property
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.ClientFilter
import io.micronaut.http.annotation.RequestFilter
import jakarta.inject.Singleton

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
class BasicAuthClientFilter(@Property(name = "micronaut.http.services.Zendesk.email") var email: String,
                            @Property(name = "micronaut.http.services.Zendesk.token") var token: String) {
    @RequestFilter
    fun doFilter(request: MutableHttpRequest<*>) {
        request.basicAuth(email, token)
    }
}