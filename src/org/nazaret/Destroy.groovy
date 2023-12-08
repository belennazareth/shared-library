package org.nazaret

Void destroyEnt() {
  
    List<String> listaNoBorrar = [
        'kube-system',
        'kube-public',
        'default',
        'kube-node-lease',
        'ingress-nginx'
    ]
    
    List<String> listaAllNamespaces = sh(script: 'kubectl get namespaces -o jsonpath=\'{.items[*].metadata.name}\'', returnStdout: true).trim().split("\\s+")

    println(listaAllNamespaces)
    // listaEntornos = listaAllNamespaces - listaNoBorrar
    // def listaEntornos = 
    // llamadaApiGithub = blabala -> (branches)

    // listaBorrar = listaEntornos - listaApiGithub

    // for borar in listaBorrar

    // kubectl delete namespace $borrar

}

return this