package com.creditsuisse.drawing

import spock.lang.Specification
import spock.lang.Unroll

class GraphicsSpec extends Specification{

    ResourceBundle resourceBundle
    Graphics graphics

    def setup() {
        resourceBundle = ResourceBundle.getBundle("message")
        graphics = new Graphics(resourceBundle)
    }

    @Unroll
    def "test Canvas"() {
        expect:
        graphics.setDrawing(inputCommand) == isDrawn

        where:
        inputCommand     || isDrawn
        "C 20 4"         || true
        "C -20 4"        || false
        "C 20 4 1"       || false
        "C"              || false
        "C 10 3 o"       || false
        "c 20 5"         || true
        "C 0 0"          || false
        ""               || false
    }

    @Unroll
    def "test drawings"() {
        expect:
        graphics.setDrawing(canvasCommand) == isCanvasDrawn
        graphics.setDrawing(drawingCommand) == isDrawn

        where:
        canvasCommand    | drawingCommand  || isCanvasDrawn | isDrawn
        "C 20 4"         | "L 1 2 6 2"     || true          | true
        "C 20 4 1 2"     | "L 1 2 6 2"     || false         | false
        "C 20 4"         | "L 6 3 6 4"     || true          | true
        "C 20 4"         | "R 14 1 18 3"   || true          | true
        "C 20 4"         | "B 10 3 o"      || true          | true
        "C 20 4"         | "L 1 2 6 2 1"   || true          | false
        "C 20 4"         | "R 14 1 3"      || true          | false
        "C 20 4"         | "B 10 3"        || true          | false
        "C 20 4"         | "B 10 3"        || true          | false
        "C 0 0"          | "L 1 2 6 2"     || false         | false
        "C 20 5"         | "L -1 2 -1 5"   || true          | false
        "C 20 5"         | "L 1 -2 1 -5"   || true          | false
        "C 20 5"         | "L -1 -2 -1 -5" || true          | false
    }
}
