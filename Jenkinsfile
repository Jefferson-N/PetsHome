pipeline {
    agent { label 'EXECUTORVM' }
    environment {
        MAIN_URL = credentials('MAIN_URL')
        PROJECT_PATH = credentials('PROJECT_PATH')
    }
    stages {
        stage('GIT CLONE') {
            steps {
                script {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [[$class: 'CleanCheckout']],
                        userRemoteConfigs: [[url: "${env.PROJECT_PATH}"]] // Corrige la referencia a la variable de entorno
                    ])
                }
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'py --version' // Usar 'bat' en lugar de 'sh' para Windows
                bat 'py main.py'   // Usar 'bat' en lugar de 'sh' para Windows
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
            cleanWs() 
        }
    }
}
