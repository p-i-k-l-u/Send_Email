pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/p-i-k-l-u/Send_Email.git'
            }
        }

        stage('Build & Test') {
            steps {
                withCredentials([string(credentialsId: 'gmail-app-password', variable: 'EMAIL_PASS')]) {
                    bat 'mvn clean test -DsuiteXmlFile=testng.xml'
                }
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'test-output/**', fingerprint: true
            }
        }
    }
}