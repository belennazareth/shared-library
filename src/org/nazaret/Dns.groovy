package org.nazaret

Void dnsK8s(String tag) {
    String domain = "${tag}.belennazaret.org"
    def node_ip = sh(script: 'kubectl get nodes -o jsonpath="{.items[?(@.metadata.labels.kubernetes\\.io/hostname==\'ubuntubn\')].status.addresses[?(@.type==\'InternalIP\')].address}"', returnStdout: true).trim()
    def isEntryExists = sh(script: "grep -q \"${domain}\" /etc/hosts && echo 'true' || echo 'false'", returnStdout: true).trim()
    if (isEntryExists != "true") {
        sh "echo \"${node_ip} ${domain}\" | sudo tee -a /etc/hosts"
        println "Dirección agregada a /etc/hosts"
    } else {
        println "La dirección ya existe en /etc/hosts"
    }    
}

Void removeDnsEntry(String tag) {
    String domain = "${tag}.belennazaret.org"
    def isEntryExists = sh(script: "grep -q \"${domain}\" /etc/hosts && echo 'true' || echo 'false'", returnStdout: true).trim()
    if (isEntryExists == "true") {
        def entryLine = sh(script: "grep \"${domain}\" /etc/hosts", returnStdout: true).trim()        
        sh "sudo sed -i \"/${domain}/d\" /etc/hosts"
        println "Dirección eliminada de /etc/hosts: ${entryLine}"
    } else {
        println "La dirección no existe en /etc/hosts"
    }
}

return this