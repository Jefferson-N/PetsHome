pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                py --version
                py main.py

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