package lol.pbu.z4j.client


import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import lol.pbu.z4j.model.UserSegmentObject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class UserSegmentsClientSpec extends Specification {

    @Inject
    @Shared
    UserSegmentsClient userSegmentsClient

    @Shared
    List<Map<String, String>> userSegmentScenarios = [
            [segmentType: "signed_in_users", name: "signed in users", updatedName: "updated signed in users test"],
            [segmentType: "staff", name: "staff", updatedName: "updated staff members test"]
    ]

    def "can list user segments"() {
        when: "list user segments with query value '#segmentQuery'"
        def response = userSegmentsClient.listUserSegments(segmentQuery)

        then: "received expected 200 response"
        response.status() == HttpStatus.OK

        where:
        segmentQuery | _
        null         | _
        true         | _
        false        | _
    }

    def "can create user segments and delete them for #userSegmentString"() {
        when: "create user segment for #userSegmentString and named #userSegmentName"
        def userSegment = new UserSegmentObject(userSegmentString as String, userSegmentName as String)
        def createResponse = userSegmentsClient.createUserSegment(userSegment)

        then: "received expected 201 response"
        createResponse.status() == HttpStatus.CREATED

        and:
        Long id = createResponse.body().userSegment.id

        then: "delete user segment with id #id"
        def deleteResponse = userSegmentsClient.deleteUserSegment(id)

        then: "received expected 204 response"
        deleteResponse.status() == HttpStatus.NO_CONTENT

        where:
        [userSegmentString, userSegmentName, updatedUserSegmentName] << userSegmentScenarios.collect {
            [it.segmentType, it.name, it.updatedName]
        }
    }


    def "can create user segments and update them for #userSegmentString"() {
        when: "create user segment for #userSegmentString and named #userSegmentName"
        def userSegment = new UserSegmentObject(userSegmentString as String, userSegmentName as String)
        def createResponse = userSegmentsClient.createUserSegment(userSegment)

        then: "received expected 201 response"
        createResponse.status() == HttpStatus.CREATED

        and:
        Long id = createResponse.body().userSegment.id

        when: "update user segment with id #id and name #updatedUserSegmentName"
        def updatedUserSegment = new UserSegmentObject(userSegmentString as String, updatedUserSegmentName as String)
        def updateResponse = userSegmentsClient.updateUserSegment(id, updatedUserSegment)

        then: "received expected 200 response"
        updateResponse.status() == HttpStatus.OK

        cleanup:
        userSegmentsClient.deleteUserSegment(id)

        where:
        [userSegmentString, userSegmentName, updatedUserSegmentName] << userSegmentScenarios.collect {
            [it.segmentType, it.name, it.updatedName]
        }
    }

    def "can create user segments and show them for #userSegmentString"() {
        when: "create user segment for #userSegmentString and named #userSegmentName"
        def userSegment = new UserSegmentObject(userSegmentString as String, userSegmentName as String)
        def createResponse = userSegmentsClient.createUserSegment(userSegment)

        then: "received expected 201 response"
        createResponse.status() == HttpStatus.CREATED

        and:
        Long id = createResponse.body().userSegment.id

        when: "show user segment with id #id"
        def showResponse = userSegmentsClient.showUserSegment(id)

        then: "received expected 200 response"
        showResponse.status() == HttpStatus.OK

        cleanup:
        userSegmentsClient.deleteUserSegment(id)

        where:
        [userSegmentString, userSegmentName] << userSegmentScenarios.collect {
            [it.segmentType, it.name]
        }
    }
}