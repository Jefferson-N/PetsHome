pipeline {
    agent { label 'EXECUTORVM' }
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
                echo 'Testing.....'
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
            script {
                node('EXECUTORVM') {
                    cleanWs()
                }
            }
        }
    }
}
