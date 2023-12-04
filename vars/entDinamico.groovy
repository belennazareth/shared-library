import org.nazaret.Utilities
import org.nazaret.Build
import org.nazaret.Deploy
import org.nazaret.Dns

def call() {
    def utilities = new org.nazaret.Utilities()
    def build = new org.nazaret.Build()
    def deploy = new org.nazaret.Deploy()
    def dns = new org.nazaret.Dns()                  
    pipeline{                      
       agent any                       
       stages {                       
          stage('Config') {                       
              steps {                       
                  script {
                        env.TAG_NAME = env.BRANCH_NAME.toLowerCase().replaceAll("_", "-")
                        String message = "Branch to use: ${env.TAG_NAME}"                     
                        utilities.printMessage(message)                       
                  }                      
              }                      
          }
          stage('Build') {                       
              steps {                       
                  script {                      
                        build.buildContainer(env.TAG_NAME)                       
                  }                      
              }                      
          }
          stage('Deploy') {
              environment {
                  HOME = "${env.WORKSPACE}"
              }                       
              steps {                       
                  script {                      
                        deploy.deployK8s(env.TAG_NAME)                       
                  }                      
              }                      
          }
          stage('Dns') {                       
              environment {
                  HOME = "${env.WORKSPACE}"
              }       
              steps {                       
                  script {                      
                        dns.dnsK8s(env.TAG_NAME)                       
                  }                      
              }                      
          }                    
       }
       post {
            always {
                script {
                    cleanWs()
                }
            }
       }                       
    }       
 }