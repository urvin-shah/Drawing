package com.creditsuisse.drawing

import spock.lang.Specification
import spock.lang.Unroll

class CanvasSpec extends Specification{
    Canvas canvas
    def setup() {
        canvas = new Canvas()
    }

    @Unroll
    def "test validate"() {
        expect:
        canvas.validate(inputParams) == isValidate

        where:
        inputParams             || isValidate
        ["20","5"]              || true
        ["20"]                  || false
        ["-20","5"]             || false
        ["20","-5"]             || false
        ["20","5","2"]          || false
        ["0","0"]               || false
    }
}
