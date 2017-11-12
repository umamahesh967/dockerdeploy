pipeline {
    agent any
    stages {
   
        stage('deploy') {
            steps {
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }

    }
}
