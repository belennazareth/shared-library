import org.nazaret.Utilities

def call() {
    // Utilities utilities = new Utilities()
    def utilities = new org.nazaret.Utilities()                   
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