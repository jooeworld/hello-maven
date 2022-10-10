// def scannerHome = '/var/lib/jenkins/tools/hudson.plugins.sonar.SonarRunnerInstallation/ibt-sonarqube';
def scannerHome = tool 'SonarScanner 4.0';
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
                withSonarQubeEnv(credentialsId: 'SQ-student', installationName: 'IBT sonarqube') {
                sh "${scannerHome}/bin/sonar-scanner"
              }
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
