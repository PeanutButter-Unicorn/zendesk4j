package lol.pbu.zendesk.auth

import io.micronaut.http.annotation.FilterMatcher
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.VALUE_PARAMETER

/**
 * Annotation that identifies a class that employs a basic authentication strategy with an email and token
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@FilterMatcher
@MustBeDocumented
@Retention(RUNTIME)
@Target(CLASS, VALUE_PARAMETER)
annotation class BasicAuth