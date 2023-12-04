package org.nazaret

Void deployK8s(String tag) {
    
    sh "mkdir -p ${env.WORKSPACE}/.kube
        sudo cp -i /etc/kubernetes/admin.conf ${env.WORKSPACE}/.kube/config
        sudo chown $(id -u):$(id -g) ${env.WORKSPACE}/.kube/config"
    
    sh "cd chart &&
    helm upgrade app --install -f values.yaml . -n ${tag} --create-namespace --set image.tag=${tag}"
}

return this