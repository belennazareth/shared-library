package org.nazaret

Void deployK8s(String tag) {
    String domain = "${tag}.belennazaret.org"
    Boolean restart = false

    sh "mkdir -p ${env.WORKSPACE}/.kube"
    sh "sudo cp -i /etc/kubernetes/admin.conf ${env.WORKSPACE}/.kube/config"
    sh "sudo chown \$(id -u):\$(id -g) ${env.WORKSPACE}/.kube/config"

    def namespaceExiste = sh(script: "kubectl get namespace ${tag}", returnStatus: true)

    if (namespaceExiste == 0) {
        restart = true
    }

    if (restart) { 
        sh "kubectl rollout restart deployment app-chart -n ${tag}"
    } else {
        sh "cd chart && helm upgrade app --install -f values.yaml . -n ${tag} --create-namespace --set image.tag=${tag} --set 'ingress.hosts[0].host=${domain}'"
    }
}

return this