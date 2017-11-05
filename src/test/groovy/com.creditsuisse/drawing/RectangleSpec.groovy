package com.creditsuisse.drawing

import spock.lang.Specification
import spock.lang.Unroll

class RectangleSpec extends Specification{
    Canvas canvas;
    def setup() {
        canvas = new Canvas();
        canvas.setAttributes(["20","5"]);
    }

    @Unroll
    def "test validate"() {
        given:
        Rectangle rectangle = new Rectangle()
        rectangle.setCanvas(canvas)

        expect:
        rectangle.validate(inputParams) == isValidate

        where:
        inputParams             || isValidate
        ["14","2","18","2"]     || false
        ["14","2","14","4"]     || false
        ["1","2","6","2","1"]   || false
        ["1","2","6"]           || false
        ["1","2"]               || false
        ["6","3","16","4"]      || true
        ["1","2","21","2"]      || false
        []                      || false
        null                    || false
    }
}
