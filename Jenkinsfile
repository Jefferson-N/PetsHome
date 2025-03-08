pipeline {
    agent { label 'EXECUTORVM' }
    environment {
        MAIN_URL = credentials('PROJECT_PATH')
        PROJECT_PATH = credentials('PROJECT_PATH')
    }
    stages {
        stage('PRINT URL') {
            steps {
                echo "MAIN_URL is: ${MAIN_URL}"
                echo "PROJECT_PATH is: ${PROJECT_PATH}"
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'py --version'
                bat 'py main.py'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }

}
