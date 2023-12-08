@Library('shared-library') _

import org.nazaret.Destroy


def destroy = new org.nazaret.Destroy()                  
pipeline{                      
    agent any                       
    stages {                       
        stage('Destroy') {                       
            steps {                       
                script {
                    destroy.destroyEnt()                     
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