pipeline {
    agent { label 'EXECUTORVM'}
    environment {
        MAIN_URL = credentials('MAIN_URL')
        PROJECT_PATH = credentials('PROJECT_PATH')
    }
    stages {

        stage('GIT CLONE') {
            steps {
                script {
                    node {
                        checkout([
                            $class: 'GitSCM',
                            branches: [[name: '*/main']],
                            doGenerateSubmoduleConfigurations: false,
                            extensions: [[$class: 'CleanCheckout']],
                            userRemoteConfigs: [[url: '${PROJECT_PATH}']]
                        ])
                    }
                }
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