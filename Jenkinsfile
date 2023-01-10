pipeline {

  environment {
    dockerimagename = "demo"
    dockerImage = ""
    tools {
      <...>
      'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }
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
        script {
          docker.withTool('docker'){
              dockerImage = docker.build("demo")
          }
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
