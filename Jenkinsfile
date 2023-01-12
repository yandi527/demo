pipeline {

    environment {
        dockerimagename = "demo"
        dockerImage = ""
    }

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout([
                        $class                           : 'GitSCM',
                        branches                         : [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false
                ])
            }
        }

        stage('Build image') {
            steps {
                sh '''
                 set +x
                 ./gen-img.sh'''
            }
        }

        stage('Pushing Image') {
            steps {
                sh '''
                       set +x
                       ./push.sh
              '''
            }
        }

        stage('Deploying App to Kubernetes') {
            steps {
                sh '''
                               set +x
                               ./deploy.sh
                      '''
            }
        }

    }

}
