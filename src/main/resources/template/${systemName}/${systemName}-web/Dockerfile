FROM openjdk:8-jre
VOLUME /tmp
ADD springcloud-provider.jar springcloud-provider.jar
RUN bash -c 'touch /springcloud-provider.jar'
EXPOSE ${port}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xms100m","-Xmx100m","-jar","/${systemName}-web.jar"]