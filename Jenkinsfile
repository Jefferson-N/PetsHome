pipeline {
    agent { label 'EXECUTORVM' }
    environment {
        MAIN_URL = credentials('MAIN_URL')
        PROJECT_PATH = credentials('PROJECT_PATH')
    }
    stages {
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
