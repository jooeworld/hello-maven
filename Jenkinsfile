pipeline {
    agent any
    stages {
        // validate the code
        stage('Validate maven project') {
            steps {
              sh 'mvn validate'
            }
        }
        // Run unit test
        stage('Run Unit Test') {
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
        stage('Run Sonarqube') {
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
        stage('Configure our VM(s)') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    ansiblePlaybook(
                        playbook: 'ansible/tomcat.yaml',
                        inventory: 'ansible/hosts',
                        credentialsId: 'vm-ssh',
                        colorized: true
                        )
                    }
                }
            }
        }
    }
}