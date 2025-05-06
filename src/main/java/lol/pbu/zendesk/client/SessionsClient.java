package lol.pbu.zendesk.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import jakarta.validation.Valid;
import lol.pbu.zendesk.model.HelpCenterSessionResponse;
import reactor.core.publisher.Mono;

@Client("${micronaut.http.services.zendesk.url}")
public interface SessionsClient {

    /**
     * Show Help Center Session<br>
     * <h4>Allowed for</h4>
     * <ul>
     * <li>Anonymous users</li>
     * </ul>
     *
     * @return OK Response (status code 200)
     */
    @Get("/api/v2/help_center/sessions")
    Mono<@Valid HelpCenterSessionResponse> showHelpCenterSession();
}
