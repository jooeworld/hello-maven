def remote = [name: 'tomcat-dev', host: '68.183.51.116', user: 'root', allowAnyHosts: true]
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
                sh "mvn deploy"
            }
        }
        stage('Perform Dynamic code analysis') { 
            steps {
//                 withCredentials([sshUserPrivateKey(credentialsId: "yourkeyid", keyFileVariable: 'keyfile')]) {
                   sshPut remote: remote, from: 'target/*.war', into: '/opt/tomcat10/webapps/'
//                 }
            }
        }
    }
}
