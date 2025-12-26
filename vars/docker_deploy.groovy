def call(
    String project,
    String imageTag = "latest",
    String dockerhubUser,
    String containerName,
    String portMapping,
    String envFile = ".env"
) {

    echo "Starting deployment for ${project}"

    sh """
        docker rm -f ${containerName} || true

        docker run -d \
          --name ${containerName} \
          --env-file ${envFile} \
          -p ${portMapping} \
          ${dockerhubUser}/${project}:${imageTag}
    """

    echo "Deployment completed for ${project}"
}
