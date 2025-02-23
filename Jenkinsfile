pipeline {
    agent { label 'EXECUTORVM'}
    environment {
        MAIN_URL = credentials('MAIN_URL')
        PROJECT_PATH = credentials('PROJECT_PATH')
    }
    stages {

        stage('GIT CLONE') {
            steps{ sh 'git clone origin ${env.MAIN_URL}'
                   sh 'cd ${PROJECT_PATH}'
            }
        }

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

    post {
        always {
            script {
                node {
                    cleanWs()
                }
            }
        }
    }
}