package app

@Grab('org.springframework.boot:spring-boot-starter-web:2.0.3.RELEASE')
import groovy.util.logging.Slf4j
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

@Slf4j
@SpringBootApplication
@EnableScheduling
@RestController
@RequestMapping('/')
class App {

    @RequestMapping('')
    def hello() {
        'hello'
    }

    @RequestMapping('{scriptName}')
    def runScript(@PathVariable String scriptName, HttpServletResponse response) {
        if (! new File("scripts/${scriptName}.groovy").exists()) {
            response.setStatus(404)
            return "scripts/${scriptName}.groovyはありません"
        }

        def process = "groovy scripts/${scriptName}.groovy".execute()
        def exitCode = process.waitFor()

        def logString = "scripts/${scriptName}.groovyを実行しました。exitCode: ${exitCode}, ${process.text}"
        log.info(logString)

        logString
    }

    @Scheduled(cron = "* * * * * *")
    def sampleTask() {
        def p = 'groovy scripts/sample-task.groovy'.execute()
        p.waitFor()
        log.info(p.text)
    }
}