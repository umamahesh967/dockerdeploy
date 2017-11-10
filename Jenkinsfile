pipeline {
    agent { dockerfile true }
    stages {
        stage('Build') {
            steps {
                sh 'mvn build'
            }
        }
    stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    stage('deploy') {
            steps {
                sh 'docker-compose -f docker-compose.yml up'
            }
        }

    }
}
