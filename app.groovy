package app

@Grab('org.springframework.boot:spring-boot-starter-web:2.0.3.RELEASE')
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@RequestMapping('/')
class App {

    @RequestMapping('')
    def hello() {
        'hello'
    }
}