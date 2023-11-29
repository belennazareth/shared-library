import org.nazaret.Utilities
import org.nazaret.Build

def call() {
    def utilities = new org.nazaret.Utilities()
    def build = new org.nazaret.Build()                   
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
       }                       
    }       
 }