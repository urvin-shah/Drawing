package com.creditsuisse.util

import spock.lang.Specification
import spock.lang.Unroll

class StringUtilSpec extends Specification {

    @Unroll
    def "test isNotNull"() {
        expect:
        StringUtil.isNotNull(inputString) == output

        where:
        inputString   ||  output
        "NotNullVal"  ||  true
        "dummyVal"    ||  true
        null          ||  false
        ""            ||  false
    }
}
