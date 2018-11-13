package org.tacos

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [TacosCloudApplication])
class TacosCloudApplicationTests extends Specification {
  def 'load context'() {
    when: 'spring boot started'
    then: 'it loads context'
  }
}
