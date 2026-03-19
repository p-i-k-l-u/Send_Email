pipeline{
	agent any 
	
	environment {
		EMAIL_PASS = credentials('khyodqaiqjnjbmjq')
	}
	
	tools{
		maven 'Maven3'
		jdk 'Java17'
	}
	
	stages{
		stage('Checkout Code'){
			steps{
				git 'https://github.com/p-i-k-l-u/Send_Email.git'
			}
		}
		stage('Build'){
			steps{
				bat 'mvn clean compile'
			}
		}
		stage('Run Tests'){
			steps{
				bat 'mvn clean test -DsuiteXmlFile=testng.xml'
			}
		}
		stage('Archive Reports'){
			steps{
				archiveArtifacts arctifacts: 'test-output/**', fingerprint: true
			}
		}
	}
	
	post {
		always{
			echo 'Pipeline Finished'
		}
		success{
			echo 'Build SUCCESS'
		}
		failure{
			echo 'Build FAILED'
		}
	}
	
	
	
	
	
	
	
	
}