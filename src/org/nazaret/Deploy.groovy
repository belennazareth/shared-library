package org.nazaret

Void deployK8s(String tag) {
    sh "helm upgrade --install -f values.yaml . -n ${tag} --create-namespace --set image.tag=${tag}"
}

return this