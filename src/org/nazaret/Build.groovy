package org.nazaret

Void buildContainer(String tag) {
    withDockerRegistry([credentialsId: 'DOCKER_HUB', url: '']) {
        def dockerImage = docker.build("belennazareth/app:${tag}")
        dockerImage.push() 
    }
}

return this