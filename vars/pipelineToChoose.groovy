def call(env){                       
    def pipelineName;                       
                           
    if(env.JOB_NAME.contains('EntornoDinamico')){                  
      pipelineName = 'entDinamico'       
    }
                        
    return pipelineName       
}
