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
      steps{
        sh '''
                 set +x
                 ./pwd.sh
        '''
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }

    stage('Pushing Image') {
      environment {
               registryCredential = 'dockerhublogin'
           }
      steps{
        script {
          docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
            dockerImage.push("latest")
          }
        }
      }
    }

    stage('Deploying App to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "deploymentservice.yml", kubeconfigId: "kubernetes")
        }
      }
    }

  }

}
