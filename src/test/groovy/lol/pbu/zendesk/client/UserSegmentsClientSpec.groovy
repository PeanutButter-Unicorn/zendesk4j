package lol.pbu.zendesk.client

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import lol.pbu.zendesk.model.UserSegmentObject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class UserSegmentsClientSpec extends Specification {

    @Inject
    @Shared
    UserSegmentsClient userSegmentsClient

    def "can list user segments"() {
        when:
        def response = userSegmentsClient.listUserSegments(segmentQuery)

        then:
        response.block().userSegments.size() >= 0

        and:
        noExceptionThrown()

        where:
        segmentQuery | _
        null         | _
        true         | _
        false        | _
    }

    def "can create user segment for #userSegmentString"() {
        when:
        def userSegment = new UserSegmentObject(userSegmentString)
        def response = userSegmentsClient.createUserSegment(userSegment)

        then:
        noExceptionThrown()

        and:
        response.block().body() != null

        where:
        userSegmentString | _
        "signed_in_users" | _
        "staff"           | _
    }
}
