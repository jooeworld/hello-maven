def remote = [name: 'tomcat-dev', host: '68.183.51.116', allowAnyHosts: true]
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
//                 withCredentials([sshUserPrivateKey(credentialsId: "vm-ssh")]) {
                   sshPut remote: remote, from: 'target/hello-maven-1.0-SNAPSHOT.war', into: '/opt/tomcat10/webapps/'
//                 }
            }
        }
    }
}
