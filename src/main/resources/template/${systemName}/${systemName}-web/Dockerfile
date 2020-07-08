FROM openjdk:8-jre
VOLUME /tmp
ADD ${systemName}-web.jar ${systemName}-web.jar
RUN bash -c 'touch /${systemName}-web.jar'
EXPOSE ${port}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xms768m -Xmx768m","-jar","/${systemName}-web.jar"]