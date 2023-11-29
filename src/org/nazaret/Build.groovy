package org.nazaret

Void buildContainer(String tag) {
    docker.build("belennazareth/app:${tag}")
}

return this