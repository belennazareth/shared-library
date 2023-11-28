def call(env){                       
    def pipelineName;                       
                           
    if(env.JOB_NAME == 'EntornoDinamico'){                  
      pipelineName = 'entDinamico'       
    }
                        
    return pipelineName       
}
