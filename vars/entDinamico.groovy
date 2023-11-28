def call(){                       
    pipeline{                      
       agent any                       
       stages {                       
          stage('Config') {                       
              steps {                       
                  script {                                            
                      println "Pipeline ejecutado!"                       
                  }                      
              }                      
          }                      
       }                       
    }       
 }