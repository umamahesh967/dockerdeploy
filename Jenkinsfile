pipeline {
    agent any
    stages {
        
        stage('Test'){
            steps{
                sh 'mvn test'
            }
        }
        
        stage('Build') {
            steps {
               echo 'mvn package'
            }
        }
   
        stage('deploy') {
            steps {
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }

    }
}
