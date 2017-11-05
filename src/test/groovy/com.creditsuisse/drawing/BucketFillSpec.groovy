package com.creditsuisse.drawing

import spock.lang.Specification
import spock.lang.Unroll

class BucketFillSpec extends Specification {
    Canvas canvas
    def setup() {
        canvas = new Canvas()
        canvas.setAttributes(["20","10"])
    }

    @Unroll
    def "test validate"() {
        given:
        BucketFill bucketFill = new BucketFill()
        bucketFill.setCanvas(canvas)

        expect:
        bucketFill.validate(inputParams) == isValidate

        where:
        inputParams             || isValidate
        ["14","2","o"]          || true
        ["14","2","14","o"]     || false
        ["1","o"]               || false
        ["o"]                   || false
        ["11","9","o"]          || true
        ["21","9","o"]          || false
        ["1","11","o"]          || false
        []                      || false
        null                    || false
    }
}
