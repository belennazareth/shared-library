import org.nazaret.utilities

def utilities = new org.nazaret.utilities()

def call(){                       
    pipeline{                      
       agent any                       
       stages {                       
          stage('Config') {                       
              steps {                       
                  script {                                            
                      utilities.imprimirMensaje("Pipeline ejecutado!")                       
                  }                      
              }                      
          }                      
       }                       
    }       
 }