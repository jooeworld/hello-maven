def remote = [name: 'tomcat-dev', host: '68.183.51.116', user: 'root', allowAnyHosts: true]
pipeline {
    agent any 

    stages {
        
        stage('mvn install') { 
            steps {
                echo "mvn clean install"
            }
        }
        stage('Push package to Registry') {
//             def remote = [:]
//             remote.name = "tomcat-dev"
//             remote.host = "68.183.51.116"
//             remote.allowAnyHosts = true
            steps {
                echo "mvn deploy"
            }
        }
        stage('Perform Dynamic code analysis') { 
            steps {
//                 withCredentials([sshUserPrivateKey(credentialsId: "yourkeyid", keyFileVariable: 'keyfile')]) {
                   sshPut remote: $remote, from: 'target/*.war', into: '/opt/tomcat10/webapps/'
//                 }
            }
        }
    }
}
