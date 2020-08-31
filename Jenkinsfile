pipeline {
   agent any
    tools{
    maven "MavenTest"
    //jdk "JdkTest"
    git "GitTest"
    }
    stages {
        stage('Build') {
            steps {
                echo "It's Build"
                git credentialsId: '3c34ed55-4061-46f9-83d9-9e22653d6144', url: 'https://github.com/mari-kamar/final-project'
                echo "Stop build"
            }
        }
		stage('Clean') {
            steps {
                echo "tests execute"
                bat 'mvn clean'
            }
        }
		stage('Test') {
            steps {
                echo "tests run"
                bat 'mvn test'

            }
        }
	    stage('Reports') {
	        steps{
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
	    }
    }
}