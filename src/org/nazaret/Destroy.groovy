package org.nazaret

Void destroyEnt() {
  
    sh "mkdir -p ${env.WORKSPACE}/.kube"
    sh "sudo cp -i /etc/kubernetes/admin.conf ${env.WORKSPACE}/.kube/config"
    sh "sudo chown \$(id -u):\$(id -g) ${env.WORKSPACE}/.kube/config"

    List<String> listaNoBorrar = [
        'kube-system',
        'kube-public',
        'default',
        'kube-node-lease',
        'ingress-nginx'
    ]
    
    List<String> listaAllNamespaces = sh(script: 'kubectl get namespaces -o jsonpath=\'{.items[*].metadata.name}\'', returnStdout: true).trim().split("\\s+")
    List<String> listaEntornos = listaAllNamespaces - listaNoBorrar

    List<String> listaRamasGithub = sh(
        script: 'curl -s https://api.github.com/repos/belennazareth/app/branches | jq -r \'.[] | select(.name != "main") | .name\'',
        returnStdout: true
        ).toLowerCase().replaceAll("_", "-").split('\n')
    
    List<String> listaBorrar = listaEntornos - listaRamasGithub
    println(listaBorrar)
    // for borar in listaBorrar

    // kubectl delete namespace $borrar

}

return this