pipeline {
    agent { label 'EXECUTORVM' }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'py --version'
                sh 'py main.py'

            }
        }
        stage('Test') {
            steps {
                echo 'Testing.....'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}