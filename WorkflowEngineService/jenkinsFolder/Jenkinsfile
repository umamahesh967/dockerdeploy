pipeline {
        agent { docker any }
        stages {
            steps {
              sh 'mvn build' 
              sh 'mvn compile' 
              sh 'mvn test' 
              sh 'mvn spring-boot:run' 
                       }
               }
         }
