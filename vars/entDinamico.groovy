import org.nazaret.utilities

def utilities = new org.nazaret.utilities()

def call(){                       
    pipeline{                      
       agent any                       
       stages {                       
          stage('Config') {                       
              steps {                       
                  script {
                        String mensaje = "Pipeline ejecutado!"                       
                        utilities.imprimirMensaje(mensaje)                       
                  }                      
              }                      
          }                      
       }                       
    }       
 }