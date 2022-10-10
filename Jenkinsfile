@Library('jenkins-library')_
pipeline {
    agent any 

    stages {
        
        stage('mvn install') { 
            steps {
                sh "mvn clean install"
            }
        }
        stage('Push package to Registry') {
            steps {
                echo "mvn deploy"
            }
        }
        stage('Perform Dynamic code analysis') { 
            steps {
                script {
                    deployTomcat()
                    
                }
            }
        }
    }
}
