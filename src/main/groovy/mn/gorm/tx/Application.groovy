package mn.gorm.tx

import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic

@CompileStatic
class Application {
    static void main(String[] args) {
        Micronaut.build(args)
                .packages("mn.gorm.tx")
                .mainClass(Application.class)
                .start()
    }
}