pipeline {
    agent any
    stages {
        // validate the code
        stage('Build maven project') {
            steps {
              sh 'mvn validate'
            }
        }
        // Run unit test
        stage('Build maven project') {
            steps {
              sh 'mvn test'
            }
        }
        // Build the code
        stage('Build maven project') {
            steps {
              sh 'mvn clean install'
            }
        }
        // run sonarqube test
        stage('Build maven project') {
            environment {
                scannerHome = tool 'ibt-sonarqube';
            }
            steps {
              withSonarQubeEnv(credentialsId: 'SQ-student', installationName: 'IBT sonarqube') {
                sh "${scannerHome}/bin/sonar-scanner"
              }
            }
        }
        // Dependency check
        stage('Run Dependency check') {
            steps {
                dependencyCheck additionalArguments: '''
                    -o "./"
                    -s "./"
                    -f "ALL"
                    --prettyPrint''', odcInstallation: 'dependency-check'

                dependencyCheckPublisher pattern: 'dependency-check-report.xml'
            }
        }
        // push the code to jfrog
        stage('Push to Artifactory (Jfrog)') {
            steps{
                configFileProvider([configFile(fileId: '5d0920bc-97c5-4877-8aa4-2f61975fa9fc', variable: 'MAVEN_SETTINGS_XML')]) {
                    sh 'mvn -U --batch-mode -s $MAVEN_SETTINGS_XML clean deploy'
                }
            }
        }
    }
}