pipeline {
    agent any 
    stages {  
        stage('Vadidate mavn project') { 
            steps {
                sh "mvn validate"
            }
        }
        stage('Run maven test') { 
            steps {
                sh "mvn test"
            }
        }
        stage('Run clean install') { 
            steps {
                echo "Unit Test Complete"
            }
        }
        stage('Sonarqube test') { 
            steps {
                def scannerHome = tool 'SonarScanner 4.0';
    withSonarQubeEnv(ibt-sonarqube') { // If you have configured more than one global server connection, you can specify its name
      sh "${scannerHome}/bin/sonar-scanner"
            }
        }
        stage('Push package to Registry') { 
            steps {
                echo "Code Pushed to Registry"
            }
        }
        stage('Perform Dynamic code analysis') { 
            steps {
                echo "Perform Dynamic code analysis"
            }
        }
    }
}
