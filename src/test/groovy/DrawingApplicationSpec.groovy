import com.creditsuisse.DrawingApplication
import spock.lang.Specification

class DrawingApplicationSpec extends Specification{

    def drawingApplication = Mock(DrawingApplication)

    def "test drawGraphics"() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("C 20 4".getBytes())
        System.setIn(byteArrayInputStream)
        when:
        drawingApplication.drawGrphics()

        then:
        "Canvas shuld be created"
    }

    def "test main"() {
        given:
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("C 20 4".getBytes())
        System.setIn(byteArrayInputStream)
        when:
        drawingApplication.main(null)

        then:
        "Initial messages should be printed"
        "Canvas should be created"
        NoSuchElementException noSuchElementException = thrown()
    }

    def "test Quit command"() {
        given:
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Q".getBytes())
        System.setIn(byteArrayInputStream)

        when:
        drawingApplication.drawGrphics()

        then:
        "System must exit."
    }
}
