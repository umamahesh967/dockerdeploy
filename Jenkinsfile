pipeline {
    agent { docker-compose.yml true }
    stages {
        stage('Build') {
            steps {
               echo 'hey uma stay cool'
            }
        }
   
    stage('deploy') {
            steps {
                sh 'docker-compose -f docker-compose.yml up'
            }
        }

    }
}
