package com.creditsuisse.drawing

import spock.lang.Specification
import spock.lang.Unroll

class LineSpec extends Specification {

    Canvas canvas;
    def setup() {
        canvas = new Canvas();
        canvas.setAttributes(["20","5"]);
    }

    @Unroll
    def "test validate"() {
        Line line = new Line();
        line.setCanvas(canvas);
        expect:
        line.validate(inputParams) == isValidate

        where:
        inputParams             || isValidate
        ["1","2","6","2"]       || true
        ["1","2","6","2","1"]   || false
        ["1","2","6"]           || false
        ["1","2"]               || false
        ["6","3","6","4"]       || true
        ["1","2","21","2"]      || false
        []                      || false
        null                    || false
    }
}
