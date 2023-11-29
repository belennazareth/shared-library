import org.nazaret.Utilities

Utilities utilities = new Utilities()

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