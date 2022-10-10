pipeline {
    agent any 
    stages {  
//         stage('Vadidate mavn project') { 
//             steps {
//                 sh "mvn validate"
//             }
//         }
//         stage('Run maven test') { 
//             steps {
//                 sh "mvn test"
//             }
//         }
//         stage('Run clean install') { 
//             steps {
//                 echo "Unit Test Complete"
//             }
//         }
        stage('Sonarqube test') { 
            steps {
//                 def scannerHome = tool 'SonarScanner 4.0';
//                 withSonarQubeEnv('ibt-sonarqube') { 
//                   sh "${scannerHome}/bin/sonar-scanner"
//                 }
                withSonarQubeEnv(credentialsId: 'SQ-student', installationName: 'IBT sonarqube') {
                sh 'mvn clean package sonar:sonar -Dsonar.host.url=https://sonarqube.ibtlearning.co  -Dsonar.login=sqa_bf4459be6b163e8fefe9b6bf4481e660de996459'
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
