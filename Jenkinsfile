pipeline {
    agent any 

    stages {
        
        stage('mvn install') { 
            steps {
                sh "mvn clean install"
            }
        }
        stage('Deploy code') { 
            steps {
                script {
                    def remote = [name: 'tomcat-dev', host: '137.184.219.204', user: 'root', allowAnyHosts: true]
                    withCredentials([usernamePassword(credentialsId: "vm-ssh-username-passsword", passwordVariable: 'PASSWORD')]) {
                       remote.password = PASSWORD
                       sshPut remote: remote, from: 'target/hello-maven-1.0-SNAPSHOT.war', into: '/opt/tomcat10/webapps/'
                    }
                }
            }
        }
    }
}
