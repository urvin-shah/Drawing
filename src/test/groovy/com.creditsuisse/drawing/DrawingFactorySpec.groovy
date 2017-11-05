package com.creditsuisse.drawing

import spock.lang.Specification
import spock.lang.Unroll

class DrawingFactorySpec extends Specification{

    @Unroll
    def "test Drawing instance" () {
        when:
        def output = DrawingFactory.getInstance(drawingType)

        then:
        expectedInstanceOf.isCase(output)

        where:
        drawingType    || expectedInstanceOf
        "L"            || Line
        "R"            || Rectangle
        "B"            || BucketFill
    }

    @Unroll
    def "test Non DrawingType"() {
        expect:
        output == DrawingFactory.getInstance(drawingType)

        where:
        drawingType   || output
        "A"           || null
        " "           || null
        null          || null
    }
}
