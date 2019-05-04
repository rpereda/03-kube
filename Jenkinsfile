pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        withCredentials([
          [$class: 'UsernamePasswordMultiBinding',
            credentialsId: 'docker_registry_credentials',
            usernameVariable: 'CONTAINER_REGISTRY_USERNAME',
            passwordVariable: 'CONTAINER_REGISTRY_PASSWORD']
          ]) {
            sh './buildImage.sh'
            sh 'echo Hola'
          }
        }
      }
      stage('deploy') {
        when {
          branch 'master'
        }
        steps {
          withCredentials([
            file(credentialsId: 'minikube_kubeconfig', variable: 'KUBECONFIG'),
            file(credentialsId: 'minikube_ca', variable: 'CA'),
            file(credentialsId: 'minikube_client_cert', variable: 'CERT'),
            file(credentialsId: 'minikube_client_key', variable: 'KEY')
          ]) {
            sh './k8s_deploy.sh'
          }
        }
      }
    s}
}